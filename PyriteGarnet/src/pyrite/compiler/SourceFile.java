package pyrite.compiler;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import pyrite.compiler.ClassResolver.ClassFieldMember;
import pyrite.compiler.FQCNParser.FQCN;
import pyrite.compiler.MethodCodeDeclation.ExceptionTableEntry;
import pyrite.compiler.antlr.PyriteLexer;
import pyrite.compiler.antlr.PyriteParser;
import pyrite.compiler.type.MethodType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.util.StringUtil;

/**
 * ソースファイルを保持するクラス
 *
 * ソースファイルに含まれるクラス名が異なっている場合は、
 * 「クラス名.class」が作成される。
 *
 * FQCNはクラス名を保持する。
 *
 *  とりあえずは、１ソース１クラスの前提
 */
public class SourceFile extends ClassRelatedFile
{
//	public final String	_srcFilePathName;

//	public final String	_srcPath;

	private ParseTree	_tree;

	private ClassResolver	_cr;
	private ConstantPoolManager	_cpm;	// コンスタントプールはクラス単位に保持する

	// パス込みソースファイル名
	private String	_srcFilePathName;

	// パス込みクラスファイル名
	private String	_classFilePathName;
	private String	_pyriteClassFilePathName;


	public SourceFile(String srcFilePathName, ClassResolver cr)
	{
		// ソースファイルに含まれるクラス名のみ解析して取得しておく
		try
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

			// クラス名の解析
			ClassNameVisitor	classNameVisitor = new ClassNameVisitor();
			classNameVisitor.visit(_tree);
			_fqcn = classNameVisitor.getFQCN();

			String	fileClassName = f.getName();
			fileClassName = fileClassName.substring(0, fileClassName.indexOf('.'));
			if (fileClassName.equals(_fqcn._className) == false)
			{
				Logger.getGlobal().warning("source file and class name is unmatched.");
			}

			File	srcPathFile = f.getParentFile();
			String	srcPath = srcPathFile.getAbsolutePath();
			_classFilePathName = srcPath + "/" + _fqcn._className + ".class";
			_pyriteClassFilePathName = srcPath + "/" + _fqcn._className + ".pyrc";

			// create needed constants
			_cpm = new ConstantPoolManager();

			_cpm.getClassRef("java/lang/Object");
			_cpm.getUtf8("<init>");
			_cpm.getUtf8("()V");
			_cpm.getUtf8("Code");
			_cpm.getUtf8("main");
			_cpm.getUtf8("([Ljava/lang/String;)V");
			_cpm.getMethodRef("java/lang/Object", "<init>", "()V");
			_cpm.getUtf8("<clinit>");
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	public FQCN	getFQCN()
	{
		return	_fqcn;
	}


	private ImportDeclarationManager	_idm;
	private ClassResolver.ClassFieldMember	_declaredMember;
	private FQCN	_superClassFQCN;

	private boolean	_isDefaultConstructorCreation = false;

	/**
	 * ソースファイルに含まれるメソッド定義を解析する
	 */
	public void	parseMethodDeclaration()
	{
		_idm = new ImportDeclarationManager(_cr);
		// メソッド定義の解析
		MethodDeclationVisitor	methodDeclationVisitor = new MethodDeclationVisitor(_cr, _cpm, _idm, _fqcn);
		methodDeclationVisitor.visit(_tree);

		_declaredMember = methodDeclationVisitor.getDeclaredMember();	// この時点でソースファイルのメソッドしか解析完了していないため、_declaredMember._superCFM は null
		_superClassFQCN = methodDeclationVisitor.getSuperClassFQCN();	// 代わりに super class の FQCN を保存しておく

		if (_declaredMember._constructorMap.size() == 0)
		{	// コンストラクタが定義されていない場合は、デフォルトコンストラクタの宣言を作成して登録しておく
			VarType[]	inParamType = new VarType[0];
			VarType[]	outParamType = new VarType[]{ObjectType.getType(_fqcn._className)};

			MethodType	constructorType = (MethodType)MethodType.getType(_fqcn, "<init>", inParamType, outParamType, 0);
			_declaredMember._constructorMap.put(constructorType._methodSignature, constructorType);

			_isDefaultConstructorCreation = true;
		}

		_cr.putClassFieldMember(_fqcn._fqcnStr, _declaredMember);	// このクラスのメンバーを登録

		// 定義されているメソッド/フィールドのコンスタントプールを作成
		createConstructorConstantPool(_declaredMember._constructorMap.values(), _cpm);
		createMethodConstantPool(_declaredMember._classMethodMap.values(), _cpm);
		createMethodConstantPool(_declaredMember._instanceMethodMap.values(), _cpm);
		createFieldConstantPool(_declaredMember._classFieldMap.values(), _cpm);
		createFieldConstantPool(_declaredMember._instanceFieldMap.values(), _cpm);
	}



	private List<MethodCodeDeclation>	_methodCodeDeclationList;
	/**
	 * メソッド本体を解析し、コードを生成する
	 */
	public void	parseCodeGeneration()
	{
		// _superClassFQCN より、_declaredMember._superCFM を設定する
		_declaredMember.setSuperCFM(_superClassFQCN, _cr);

		// コード生成
		CodeGenerationVisitor visitor = new CodeGenerationVisitor(_cr, _cpm, _idm, _fqcn, _declaredMember);
		visitor.visit(_tree);	// parse

		// 解析後の処理
		if (_isDefaultConstructorCreation)
		{	// デフォルトコンストラクタの実装を作成する
			visitor.createDefaultConstractor();
		}
		// フィールド初期化コードを設定する
		visitor.setFieldInitializationCode();
		// static main(var args : [str])() がある場合に、JVMから起動できる public static void main(String[] args) を作成する
		visitor.createMainMethod();

		_methodCodeDeclationList = visitor.getAllMethodCodeDeclationList();
	}


	// ファイル出力
	public void	createClassFile() throws IOException
	{
		_cpm.setFrozen(true);
		// .class
		try (ClassFileOutputStream	os = new ClassFileOutputStream(new BufferedOutputStream(new FileOutputStream(_classFilePathName))))
		{
			createClassFile(os,
					_cpm,
					_declaredMember,
					_methodCodeDeclationList);
		}
		// .pyrc
		try (BufferedWriter	writer = new BufferedWriter(new FileWriter(_pyriteClassFilePathName)))
		{
			createPyriteClassFile(writer, _declaredMember);
		}
	}





	// 定義されているコンストラクタのコンスタントプールを作成
	private static void createConstructorConstantPool(Collection<MethodType> methodTypes, ConstantPoolManager cpm)
	{
		for (MethodType method : methodTypes)
		{	// 定義されているメソッドのコンスタントプールを作成
			String	methodClassName = method._fqcn._fqcnStr.replace('.', '/');
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
			String	methodClassName = method._fqcn._fqcnStr.replace('.', '/');
			String	methodName = method._methodName;
			String	paramStr = MethodType.createJvmMethodParamExpression(method._paramTypes, method._returnTypes);
			cpm.getMethodRef(methodClassName, methodName, paramStr);
		}
	}

	// 定義されているフィールドのコンスタントプールを作成
	private static void createFieldConstantPool(Collection<VarType> varTypes, ConstantPoolManager cpm)
	{
		for (VarType varType : varTypes)
		{
			cpm.getUtf8(varType._jvmExpression.replace('.', '/'));
		}
	}

	public final static byte[]	MAGIC = {(byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE,};
	public final static byte[]	MINOR_VERSION = {(byte)0x00, (byte)0x00,};
	public final static byte[]	MAJOR_VERSION = {(byte)0x00, (byte)0x31,};	// 0x31 -> J2SE 5.0 0x33 -> J2SE 7

	private static void createClassFile(
			ClassFileOutputStream os,
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
		os.write2(cpm.getClassRef(declaredMember._fqcn._fqcnStr));

//		u2 super_class;
		os.write2(cpm.getClassRef(declaredMember._superCFM._fqcn._fqcnStr));

//		u2 interfaces_count;
		os.write2(declaredMember._interfaceSet.size());
//		u2 interfaces[interfaces_count];
		for (FQCN interfaceFQCN : declaredMember._interfaceSet)
		{
			os.write2(cpm.getClassRef(interfaceFQCN._fqcnStr));
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
				byte[]	code = StringUtil.toByteArray(method._code.getCodeList());
				os.write2(cpm.getUtf8("Code"));
				os.write4(2 + 2 + 4 + code.length + 2 + 0 + 2 + 0);	// max_stack 以降の長さ
				os.write2(method.getMaxStack());
				os.write2(method.getMaxLocal());
				os.write4(code.length);
				os.write(code);

				List<ExceptionTableEntry>	exceptionTableEntryList = method.getExceptionTableList();
				os.write2(exceptionTableEntryList.size());	// exception_table_length
				for (ExceptionTableEntry entry : exceptionTableEntryList)
				{
					os.write2(entry._startPc);
					os.write2(entry._endPc);
					os.write2(entry._handlerPc);
					os.write2(entry._catchType);
				}

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
			int	acc = BC.ACC_PUBLIC;	// TODO メソッド公開子対応
			if (isStatic)
			{
				acc |= BC.ACC_STATIC;
			}
			os.write2(acc);
			os.write2(cpm.getUtf8(name));
			os.write2(cpm.getUtf8(type._jvmExpression.replace('.', '/')));
			os.write2(0);
		}
	}

	private void createPyriteClassFile(BufferedWriter writer, ClassFieldMember cfm) throws IOException
	{
		for (MethodType m : cfm._classMethodMap.values())
		{
			if (m._returnTypes.length > 1)
			{
				writer.write(m._methodSignature);
				writer.write('\t');
				writer.write(m._returnTypes[0]._jvmExpression);
				for (int i = 1; i < m._returnTypes.length; ++i)
				{
					writer.write('\t');
					writer.write(m._returnTypes[i]._jvmExpression);
				}
				writer.newLine();
			}
		}
		for (MethodType m : cfm._instanceMethodMap.values())
		{
			if (m._returnTypes.length > 1)
			{
				writer.write(m._methodSignature);
				writer.write('\t');
				writer.write(m._returnTypes[0]._jvmExpression);
				for (int i = 1; i < m._returnTypes.length; ++i)
				{
					writer.write('\t');
					writer.write(m._returnTypes[i]._jvmExpression);
				}
				writer.newLine();
			}
		}
	}


}
