package pyrite.compiler;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import pyrite.compiler.ClassResolver.ClassFieldMember;
import pyrite.compiler.FQCNParser.FQCN;
import pyrite.compiler.antlr.PyriteParser;
import pyrite.compiler.type.MethodType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarTypeName;

public class MethodDeclationVisitor extends GrammarCommonVisitor
{
	public final ConstantPoolManager _cpm;
	public final FQCN	_fqcn;

	// このファイルで定義しているメンバー
	private ClassFieldMember	_declaredMember;
	private VarType	_superClass;
	private List<VarType>	_interfaceTypeList;


	public MethodDeclationVisitor(
			ClassResolver cr,
			ConstantPoolManager cpm,
			ImportDeclarationManager idm,
			FQCN fqcn)
	{
		super(cr, idm);
		_cpm = cpm;
		_fqcn = fqcn;
		_declaredMember = new ClassFieldMember(fqcn);
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

	// packageDeclaration? importDeclaration* classDeclaration EOF
	@Override
	public Object visitCompilationUnit(@NotNull PyriteParser.CompilationUnitContext ctx)
	{
		// import
		_idm.addImportDeclaretionStr("java.lang.*");		// デフォルトでインポートされる型
// TODO		_idm.addImportDeclaretionStr("pyrite.lang.*");		// デフォルトでインポートされる型
		for (PyriteParser.ImportDeclarationContext idctx : ctx.importDeclaration())
		{	// とりあえず文字列を収集
			_idm.addImportDeclaretionStr((String)visit(idctx));
		}

		// import文で指定されたクラスの存在チェック
		_idm.checkImportDeclaretion();

		// class
		visit(ctx.classDeclaration());

		return	null;
	}

	// 'import' qualifiedName ('.' '*')? ';'
	@Override
	public Object visitImportDeclaration(@NotNull PyriteParser.ImportDeclarationContext ctx)
	{
		// 文字列を返す
		String	packageClassName = ctx.qualifiedName().getText();
		String	astStr = (ctx.ast != null) ? ".*" : "";
		return	packageClassName + astStr;
	}

	// 'class' Identifier ('extends' type)? ('implements' typeList)? classBody
	@Override
	public Object visitClassDeclaration(@NotNull PyriteParser.ClassDeclarationContext ctx)
	{
		if (ctx.type() != null)
		{
			_superClass = (VarType)visit(ctx.type());
		}
		else
		{
			_superClass = ObjectType.getType("pyrite.lang.Object");
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
    //	:   classInstanceModifier? 'var' variableDeclarationStatement ';'
    //	;
	@Override
	public Object visitFieldDeclaration(@NotNull PyriteParser.FieldDeclarationContext ctx)
	{
		boolean	isStatic = (ctx.classInstanceModifier() != null);

		VarTypeName	varTypeName = (VarTypeName)visit(ctx.variableDeclarationStatement());
		if (_declaredMember._classFieldMap.containsKey(varTypeName._name) ||
				_declaredMember._instanceFieldMap.containsKey(varTypeName._name))
		{
			throw new PyriteSyntaxException("field declation duplicated.");
		}
		_declaredMember.addFieldType(varTypeName, isStatic);

		return	null;
	}

	// Identifier (':' typeOrArray)? ('=' expression)?
	@Override
	public Object visitVariableDeclarationStatement(@NotNull PyriteParser.VariableDeclarationStatementContext ctx)
	{
		String	name = ctx.Identifier().getText();
		VarType	type = (VarType)visit(ctx.typeOrArray());

		return	new VarTypeName(type, name);
	}


	//	constructorDeclaration
	//    :   Identifier inputParameters
	//        methodBody
	//    ;
	@Override
	public Object visitConstructorDeclaration(@NotNull PyriteParser.ConstructorDeclarationContext ctx)
	{
		String className = ctx.Identifier().getText();

		if (className.equals(_fqcn._className) == false)
		{
			throw new PyriteSyntaxException("constructor name is not matched to class name.");
		}

		List<VarTypeName>	inParamList = (List<VarTypeName>)visit(ctx.inputParameters());

		VarType[] paramTypes = new VarType[inParamList.size()];

		for (int i = 0; i < inParamList.size(); ++i)
		{
			paramTypes[i] = inParamList.get(i)._type;
		}

		VarType[] returnTypes = {ObjectType.getType(className)};

		// メソッド定義を作成
		 MethodType	type = (MethodType)MethodType.getType(_fqcn, className, paramTypes, returnTypes , false);

		if (_declaredMember._constructorMap.containsKey(type._typeId))
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
		MethodType	type = (MethodType)MethodType.getType(_fqcn, id, paramTypes, returnTypes, isStatic);

		if (_declaredMember._classMethodMap.containsKey(type._typeId) || _declaredMember._instanceMethodMap.containsKey(type._typeId))
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
}
