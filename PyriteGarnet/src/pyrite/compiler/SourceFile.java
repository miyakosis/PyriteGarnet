package pyrite.compiler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import pyrite.compiler.FQCNParser.FQCN;
import pyrite.compiler.antlr.PyriteLexer;
import pyrite.compiler.antlr.PyriteParser;
import pyrite.compiler.type.MethodType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarTypeName;

public class SourceFile
{
//	public final String	_srcFilePathName;

//	public final String	_srcPath;

	private ParseTree	_tree;

	private ClassResolver	_cr;
	private ConstantPoolManager	_cpm;

	private String	_srcFilePathName;
	private String	_classFilePathName;

	public SourceFile(String srcFilePathName, ClassResolver cr) throws IOException
	{
		_srcFilePathName = srcFilePathName;
		_cr = cr;

		File	f = new File(srcFilePathName);
		InputStream	is = new FileInputStream(f);

		ANTLRInputStream input = new ANTLRInputStream(is);
		PyriteLexer lexer = new PyriteLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PyriteParser parser = new PyriteParser(tokens);
		_tree = parser.compilationUnit(); // parse

		// create needed constants
		_cpm = new ConstantPoolManager();

		_cpm.getClassRef("java/lang/Object");
		_cpm.getUtf8("<init>");
		_cpm.getUtf8("()V");
		_cpm.getUtf8("Code");
		_cpm.getUtf8("main");
		_cpm.getUtf8("([Ljava/lang/String;)V");
		_cpm.getMethodRef("java/lang/Object", "<init>", "()V");
	}

	private FQCN	_fqcn;

	/**
	 *
	 * @return	true:コンパイル対象 false:それ以外
	 */
	public boolean	parseClassName()
	{
		// クラス名の解析
		ClassNameVisitor	classNameVisitor = new ClassNameVisitor();
		classNameVisitor.visit(_tree);
		_fqcn = classNameVisitor.getClassName();

		File	f = new File(_srcFilePathName);
		File	srcPathFile = f.getParentFile();
		String	srcPath = srcPathFile.getName();
		_classFilePathName = srcPath + "/" + _fqcn + ".class";

		File	classFile = new File(_classFilePathName);
		if (f.lastModified() < classFile.lastModified())
		{	// ソースファイルが前回コンパイル時から更新されていないため、コンパイル対象外
			return	false;
		}

		// コンパイルソースファイルのクラス情報をリゾルバに追加
		_cr.addSourceFileClass(_fqcn, _srcFilePathName, f.lastModified());
		return	true;
	}


	private ImportDeclarationManager	_idm;
	private ClassResolver.ClassFieldMember	_declaredMember;

	private MethodDeclationVisitor	_methodDeclationVisitor;
	private MethodCodeDeclation	_defaultConstractor = null;
	public void	parseMethodDeclaration()
	{
		_idm = new ImportDeclarationManager(_cr);
		// メソッド定義の解析
		MethodDeclationVisitor	methodDeclationVisitor = new MethodDeclationVisitor(_cr, _cpm, _idm, _fqcn);
		methodDeclationVisitor.visit(_tree);

		_declaredMember = methodDeclationVisitor.getDeclaredMember();

		if (_declaredMember._constructorMap.size() == 0)
		{	// コンストラクタが定義されていないため、コンストラクタを作成して登録しておく
			VarType[]	inParamType = new VarType[0];
			VarType[]	outParamType = new VarType[]{ObjectType.getType(_fqcn._className)};

			MethodType	constructorType = (MethodType)MethodType.getType(_fqcn._fqcnStr, _fqcn._className, inParamType, outParamType, false);
			_declaredMember._constructorMap.put(constructorType._methodSignature, constructorType);

			// コンストラクタの実装も作成しておく
			_defaultConstractor = createDefaultConstractor(_cpm, _fqcn);
		}

		// TODO:インターフェースのメソッド実装チェック


		_cr.putClassFieldMember(_fqcn._fqcnStr, _declaredMember);	// このクラスのメンバーを登録

		// 定義されているメソッドのコンスタントプールを作成
		createConstructorConstantPool(_declaredMember._constructorMap.values(), _cpm);
		createMethodConstantPool(_declaredMember._classMethodMap.values(), _cpm);
		createMethodConstantPool(_declaredMember._instanceMethodMap.values(), _cpm);

		_methodDeclationVisitor = methodDeclationVisitor;
	}

	private List<MethodCodeDeclation>	_methodCodeDeclationList;
	public void	parseCodeGeneration()
	{
		// コード生成
		CodeGenerationVisitor visitor = new CodeGenerationVisitor(_cpm, _cr, _fqcn, _idm, _declaredMember);
		visitor.visit(_tree);	// parse
		List<MethodCodeDeclation>	methodCodeDeclationList = visitor.getMethodCodeDeclationList();
		if (_defaultConstractor != null)
		{
			methodCodeDeclationList.add(_defaultConstractor);
		}
		_methodCodeDeclationList = methodCodeDeclationList;
	}

	// ファイル出力
	public void	createClassFile() throws IOException
	{
		_cpm.setFrozen(true);
		ClassFileOutputStream	os = new ClassFileOutputStream(new BufferedOutputStream(new FileOutputStream(_classFilePathName)));
		createClassFile(os,
				_fqcn,
				_methodDeclationVisitor.getSuperClass(),
				_methodDeclationVisitor.getInterfaceTypeList(),
				_cpm,
				_declaredMember,
				_methodCodeDeclationList);
		os.close();
	}



	private static MethodCodeDeclation createDefaultConstractor(ConstantPoolManager cpm, String className)
	{
		MethodCodeDeclation	defaultConstractor = new MethodCodeDeclation();

		defaultConstractor.setClassName(className);
		defaultConstractor.setMethodName("<init>");
		defaultConstractor.setStatic(false);
		defaultConstractor.setInParamList(new ArrayList<VarTypeName>());
		defaultConstractor.setOutParamList(new ArrayList<VarTypeName>());

		defaultConstractor.addCodeOp(BC.ALOAD_0);
		defaultConstractor.addCodeOp(BC.INVOKESPECIAL);
		defaultConstractor.addCodeU2(cpm.getMethodRef("java/lang/Object", "<init>", "()V"));
		defaultConstractor.addCodeOp(BC.RETURN);

		return	defaultConstractor;
	}


	// 定義されているコンストラクタのコンスタントプールを作成
	private static void createConstructorConstantPool(Collection<MethodType> methodTypes, ConstantPoolManager cpm)
	{
		for (MethodType method : methodTypes)
		{	// 定義されているメソッドのコンスタントプールを作成
			String	methodClassName = method._packageClassName.replace('.', '/');
			String	methodName = method._methodName;
			String	paramStr = method.createConstructorJvmMethodParamExpression();
			cpm.getMethodRef(methodClassName, methodName, paramStr);
		}
	}

	// 定義されているメソッドのコンスタントプールを作成
	private static void createMethodConstantPool(Collection<MethodType> methodTypes, ConstantPoolManager cpm)
	{
		for (MethodType method : methodTypes)
		{	// 定義されているメソッドのコンスタントプールを作成
			String	methodClassName = method._packageClassName.replace('.', '/');
			String	methodName = method._methodName;
			String	paramStr = method.getParamStr();
			cpm.getMethodRef(methodClassName, methodName, paramStr);
		}
	}

	public final static byte[]	MAGIC = {(byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE,};
	public final static byte[]	MINOR_VERSION = {(byte)0x00, (byte)0x00,};
	public final static byte[]	MAJOR_VERSION = {(byte)0x00, (byte)0x31,};	// 0x31 -> J2SE 5.0 0x33 -> J2SE 7

	private static void createClassFile(
			ClassFileOutputStream os,
			String className,
			VarType superClassType,
			List<VarType> interfaceTypeList,
			ConstantPoolManager cpm,
			ClassResolver.ClassFieldMember declaredMember,
			List<MethodCodeDeclation> methodCodeDeclationList) throws IOException
	{
//		u4 magic;
		os.write(MAGIC);
//		u2 minor_version;
		os.write(MINOR_VERSION);
//		u2 major_version;
		os.write(MAJOR_VERSION);

//		u2 constant_pool_count;
		os.write2(cpm.size() + 1);

//		cp_info constant_pool[constant_pool_count-1];
		os.write(cpm.toByteArray());

//		u2 access_flags;
		os.write2(0x0020);

//		u2 this_class;
		os.write2(cpm.getClassRef(className));

//		u2 super_class;
		String	superClassName = ((ObjectType)superClassType)._packageClassName;
		os.write2(cpm.getClassRef(superClassName));

//		u2 interfaces_count;
		os.write2(interfaceTypeList.size());
//		u2 interfaces[interfaces_count];
		for (VarType interfaceType : interfaceTypeList)
		{
			String	interfaceClassName = ((ObjectType)interfaceType)._packageClassName;
			os.write2(cpm.getClassRef(interfaceClassName));
		}

//		u2 fields_count;
		os.write2(declaredMember._instanceFieldMap.size() + declaredMember._classFieldMap.size());

//		field_info fields[fields_count];
//		field_info {
//			u2			   access_flags;
//			u2			   name_index;
//			u2			   descriptor_index;
//			u2			   attributes_count;
//			attribute_info attributes[attributes_count];
//		}
		writeFieldInfo(os, cpm, declaredMember._classFieldMap, true);
		writeFieldInfo(os, cpm, declaredMember._instanceFieldMap, false);
		// none

//		u2 methods_count;
		os.write2(methodCodeDeclationList.size());

//		method_info methods[methods_count];
		for (MethodCodeDeclation method : methodCodeDeclationList)
		{
			// public static final void main(java.lang.String[]);
			//		method_info {
			//			u2			   access_flags;
			//			u2			   name_index;
			//			u2			   descriptor_index;
			//			u2			   attributes_count;
			//			attribute_info attributes[attributes_count];
			//		}
			os.write2(method.getAccessFlag());
			os.write2(cpm.getUtf8(method._methodName));
			os.write2(cpm.getUtf8(method.getJvmMethodParamExpression().replace('.', '/')));
			os.write2(1);
			{
			//Code_attribute {
			//	u2 attribute_name_index;   //<= 前述の00 09(Code)
			//	u4 attribute_length;	   //<= 前述の00 00 00 25(37)
			//	u2 max_stack;			   //<= 00 02(2)
			//	u2 max_locals;			   //<= 00 01(1)
			//	u4 code_length;			   //<= 00 00 00 09(9)
			//	u1 code[code_length];	   //<= b2 00 02 12 03 b6 00 04 b1
			//	u2 exception_table_length; //<= 00 00
			//	{ u2 start_pc;
			//		u2 end_pc;
			//		u2	handler_pc;
			//		u2	catch_type;
			//	} exception_table[exception_table_length];
			//	u2 attributes_count;	   //<= 00 01
			//	attribute_info attributes[attributes_count];
			//}
				byte[]	code = method.getCodeByteArray();
				os.write2(cpm.getUtf8("Code"));
				os.write4(2 + 2 + 4 + code.length + 2 + 0 + 2 + 0);	// max_stack 以降の長さ
				os.write2(method.getMaxStack());
				os.write2(method.getMaxLocal());
				os.write4(code.length);
				os.write(code);
				os.write2(0);	// exception_table_length
				os.write2(0);	// attributes_count
			}
		}

//		u2 attributes_count;
		os.write2(0);
//		attribute_info attributes[attributes_count];
		// none
	}


//	field_info {
//	  u2			 access_flags;
//	  u2			 name_index;
//	  u2			 descriptor_index;
//	  u2			 attributes_count;
//	  attribute_info attributes[attributes_count];
//}
	private static void writeFieldInfo(ClassFileOutputStream os, ConstantPoolManager cpm,
			Map<String, VarType> fieldMap, boolean isStatic) throws IOException
	{
		for (String name : fieldMap.keySet())
		{
			VarType	type = fieldMap.get(name);
			int	acc = BC.ACC_PUBLIC;	// TODO
			if (isStatic)
			{
				acc |= BC.ACC_STATIC;
			}
			os.write2(acc);
			os.write2(cpm.getUtf8(name));
			os.write2(cpm.getUtf8(type._jvmExpression));
			os.write2(0);
		}
	}

}
