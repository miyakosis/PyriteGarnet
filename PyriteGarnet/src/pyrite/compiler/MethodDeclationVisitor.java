package pyrite.compiler;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import pyrite.compiler.ClassResolver.ClassFieldMember;
import pyrite.compiler.antlr.PyriteParser;
import pyrite.compiler.type.MethodType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarTypeName;
import pyrite.compiler.util.StringUtil;

public class MethodDeclationVisitor extends GrammarCommonVisitor
{
	private ConstantPoolManager _cpm;
	private ClassResolver	_cr;

	// このファイルで定義しているメンバー
	private ClassFieldMember	_declaredMember = new ClassFieldMember();

	public String	_packageName;
	public String	_className;
	private VarType	_superClass;
	private List<VarType>	_interfaceTypeList;


	public MethodDeclationVisitor(ConstantPoolManager cpm, ClassResolver cr)
	{
		super(new ImportDeclarationManager(cr));
		_cpm = cpm;
		_cr = cr;
	}

	public ImportDeclarationManager	getImportDeclarationManager()
	{
		return	_idm;
	}

	public ClassFieldMember getDeclaredMember()
	{
		return	_declaredMember;
	}

	public VarType	getSuperClass()
	{
		return	_superClass;
	}

	public  List<VarType>	getInterfaceTypeList()
	{
		return	_interfaceTypeList;
	}

	public String getFQCN()
	{
		if (_packageName != null)
		{
			return	_packageName + "." + _className;
		}
		else
		{
			return	_className;
		}
	}


	// packageDeclaration? importDeclaration* classDeclaration EOF
	@Override
	public Object visitCompilationUnit(@NotNull PyriteParser.CompilationUnitContext ctx)
	{
		// package
		if (ctx.packageDeclaration() != null)
		{
			visit(ctx.packageDeclaration());
		}

		// import
		List<String>	importDeclartionStrList = new ArrayList<String>();
		importDeclartionStrList.add("java.lang.*");		// デフォルトでインポートされる型
// TODO		importDeclartionStrList.add("pyrite.lang.*");	// デフォルトでインポートされる型
		for (PyriteParser.ImportDeclarationContext idctx : ctx.importDeclaration())
		{
			importDeclartionStrList.add((String)visit(idctx));
		}

		_idm.checkImportDeclaretion(importDeclartionStrList);

		// class
		visit(ctx.classDeclaration());

		return	null;
	}

	// 'package' qualifiedName ';'
	@Override
	public Object visitPackageDeclaration(@NotNull PyriteParser.PackageDeclarationContext ctx)
	{
		_packageName = ctx.qualifiedName().getText();
		return	null;
	}


	// 'import' qualifiedName ('.' '*')? ';'
	@Override
	public Object visitImportDeclaration(@NotNull PyriteParser.ImportDeclarationContext ctx)
	{
		String	packageClassName = ctx.qualifiedName().getText();
		String	astStr = (ctx.ast != null) ? ".*" : "";
		return	packageClassName + astStr;
	}

	// 'class' Identifier ('extends' type)? ('implements' typeList)? classBody
	@Override
	public Object visitClassDeclaration(@NotNull PyriteParser.ClassDeclarationContext ctx)
	{
		_className = ctx.Identifier().getText();
		_declaredMember._fqcn = _className;	// TODO:public access を修正
		if (ctx.type() != null)
		{
			_superClass = (VarType)visit(ctx.type());
		}
		else
		{
			_superClass = ObjectType.getType("java.lang.Object");
		}

		if (ctx.typeList() != null)
		{
			_interfaceTypeList = (List<VarType>)visit(ctx.typeList());
		}
		else
		{
			_interfaceTypeList = new ArrayList<VarType>();
		}

		visit(ctx.classBody());

		return	null;
	}


	//fieldDeclaration
    //	:   classInstanceModifier? type Identifier ('=' variableInitializer)? ';'
    //	;
	@Override
	public Object visitFieldDeclaration(@NotNull PyriteParser.FieldDeclarationContext ctx)
	{
		boolean	isStatic = (ctx.classInstanceModifier() != null);

		VarType	type = (VarType)visit(ctx.type());
		String	name = ctx.Identifier().getText();

		_declaredMember.addFieldType(new VarTypeName(type, name), isStatic);

		return	null;
	}

	//	constructorDeclaration
	//    :   Identifier inputParameters
	//        methodBody
	//    ;
	@Override
	public Object visitConstructorDeclaration(@NotNull PyriteParser.ConstructorDeclarationContext ctx)
	{
		String id = ctx.Identifier().getText();
		String[]	element = StringUtil.splitLastElement(id, '.');
		String	packageName = element[0];
		String	className = element[1];

		if (packageName.equals("") == false && packageName.equals(_packageName) == false)
		{	// コンストラクタのパッケージ部分と、ファイルのパッケージ宣言に食い違いがある
			throw new PyriteSyntaxException("constructor name is not matched to package name.");
		}
		else if (className.equals(_className) == false)
		{
			throw new PyriteSyntaxException("constructor name is not matched to class name.");
		}

		List<VarTypeName>	inParamList = (List<VarTypeName>)visit(ctx.inputParameters());

		VarType[] paramTypes = new VarType[inParamList.size()];

		for (int i = 0; i < inParamList.size(); ++i)
		{
			paramTypes[i] = inParamList.get(i)._type;
		}

		VarType[] returnTypes = {ObjectType.getType(_className)};

		// メソッド定義を作成
		 MethodType	type = (MethodType)MethodType.getType(_className, className, paramTypes, returnTypes , false);

		if (_declaredMember._constructorMap.containsKey(type._methodSignature))
		{	// 同じ定義のメソッドがすでに登録されている
			throw new RuntimeException("method declation duplicated");
		}

		// メソッド定義を追加
		_declaredMember.addConstructorType(type);

		return	null;
	}


	//methodDeclaration
	//	:	classInstanceModifier? Identifier inputParameters outputParameters
	//		methodBody
	//		;
	@Override
	public Object visitMethodDeclaration(@NotNull PyriteParser.MethodDeclarationContext ctx)
	{
		boolean	isStatic = (ctx.classInstanceModifier() != null);

		String id = ctx.Identifier().getText();
		List<VarTypeName>	inParamList = (List<VarTypeName>)visit(ctx.inputParameters());
		List<VarTypeName>	outParamList = (List<VarTypeName>)visit(ctx.outputParameters());

		VarType[] paramTypes = new VarType[inParamList.size()];
		VarType[] returnTypes = new VarType[outParamList.size()];

		for (int i = 0; i < inParamList.size(); ++i)
		{
			paramTypes[i] = inParamList.get(i)._type;
		}
		for (int i = 0; i < outParamList.size(); ++i)
		{
			returnTypes[i] = outParamList.get(i)._type;
		}

		// メソッド定義を作成
		 MethodType	type = (MethodType)MethodType.getType(_className, id, paramTypes, returnTypes, isStatic);

		if (_declaredMember._classMethodMap.containsKey(type._methodSignature) || _declaredMember._instanceMethodMap.containsKey(type._methodSignature))
		{	// 同じ定義のメソッドがすでに登録されている
			throw new RuntimeException("method declation duplicated");
		}

		// メソッド定義を追加
		_declaredMember.addMethodType(type);

		return	null;
	}


	@Override
	public Object visitInputParameters(@NotNull PyriteParser.InputParametersContext ctx)
	{
		return	super.visitInputParameters(ctx);
	}

	@Override
	public Object visitInputParameter(@NotNull PyriteParser.InputParameterContext ctx)
	{
		return	super.visitInputParameter(ctx);
	}

	@Override
	public Object visitOutputParameters(@NotNull PyriteParser.OutputParametersContext ctx)
	{
		return	super.visitOutputParameters(ctx);
	}

	@Override
	public Object visitOutputParameter(@NotNull PyriteParser.OutputParameterContext ctx)
	{
		return	super.visitOutputParameter(ctx);
	}

	@Override
	public Object visitTypePrimitiveType(@NotNull PyriteParser.TypePrimitiveTypeContext ctx)
	{
		return	super.visitTypePrimitiveType(ctx);
	}

	@Override
	public Object visitTypeClassType(@NotNull PyriteParser.TypeClassTypeContext ctx)
	{
		return	super.visitTypeClassType(ctx);
	}


}
