package pyrite.compiler;

import java.lang.reflect.Modifier;
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

// メソッド定義を解析するVisitor
public class MethodDeclationVisitor extends GrammarCommonVisitor
{
	public final ConstantPoolManager _cpm;
	public final FQCN	_fqcn;

	// このファイルで定義しているメンバー
	private ClassFieldMember	_declaredMember;
	private FQCN	_superClassFQCN;

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

	public ClassFieldMember getDeclaredMember()
	{
		return	_declaredMember;
	}

	public FQCN getSuperClassFQCN()
	{
		return	_superClassFQCN;
	}


	// packageDeclaration? importDeclaration* classDeclaration EOF
	@Override
	public Object visitCompilationUnit(@NotNull PyriteParser.CompilationUnitContext ctx)
	{
		// import
		_idm.addImportDeclaretionStr("java.lang.*");		// ソースに記述が無くてもインポートされる型

		// importDeclaration から取得した文字列を追加保持
		for (PyriteParser.ImportDeclarationContext idctx : ctx.importDeclaration())
		{
			_idm.addImportDeclaretionStr((String)visit(idctx));
		}

		// import文を展開し、指定されたクラスの存在チェック
		_idm.checkImportDeclaretion();

		// 自パッケージと、pyrite.lang のクラスは優先してインポートする
		_idm.overridePackage(_fqcn._packageName);
		_idm.overridePackage("pyrite.lang");

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
			VarType	superClassVarType = (VarType)visit(ctx.type());
			if (_cr.existsFQCN(superClassVarType._fqcn) == false)
			{
				throw new PyriteSyntaxException("super class not exist.");
			}
			_superClassFQCN = superClassVarType._fqcn;
		}
		else
		{
			_superClassFQCN = FQCNParser.getFQCN("pyrite.lang.Object");
		}

		if (ctx.typeList() != null)
		{
			List<VarType>	interfaceTypeList = (List<VarType>)visit(ctx.typeList());
			for (VarType interfaceVarType : interfaceTypeList)
			{
				if (_cr.existsFQCN(interfaceVarType._fqcn) == false)
				{
					throw new PyriteSyntaxException("interface not exist.");
				}
				_declaredMember._interfaceSet.add(interfaceVarType._fqcn);
			}
		}

		// メソッド定義解析中は FQCN の存在チェックはできるが、中の定義情報のチェックはできないため、
		// _superClass や _interfaceTypeList で指定されたクラスの存在チェックのみを行う。
		// それらが適切にクラス/インターフェースであるかは、次のフェーズでチェックする。

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

	// variableDeclarationStatement
	//	:  variableDeclaration (',' variableDeclaration)* ('=' expression)?
	@Override
	public Object visitVariableDeclarationStatement(@NotNull PyriteParser.VariableDeclarationStatementContext ctx)
	{
		List<VarTypeName>	varTypeNameList = new ArrayList<VarTypeName>();
		for (PyriteParser.VariableDeclarationContext varCtx : ctx.variableDeclaration())
		{
			varTypeNameList.add((VarTypeName)visit(varCtx));
		}

		if (varTypeNameList.size() > 1)
		{
			// TODO:複数フィールドの同時定義を許容するか。
			// 仕様的には複数許容してもいいが、可読性を考えると一つに制限した方がよいかもしれない。
			// 一つに制限する場合、expression で複数値が返る場合、二番目以降の値を取得できないが、よいのか？
			throw new PyriteSyntaxException("field must be single value");
		}

		VarTypeName	varTypeName = varTypeNameList.get(0);
		if (varTypeName._type == null)
		{
			throw new PyriteSyntaxException("field needs type.");
		}

		return	varTypeName;
	}

	// variableDeclaration
	//	:   Identifier (':' typeOrArray)?
	@Override
	public Object visitVariableDeclaration(PyriteParser.VariableDeclarationContext ctx)
	{
		String	id = ctx.Identifier().getText();
		VarType	type;
		if (ctx.typeOrArray() != null)
		{
			type = (VarType)visit(ctx.typeOrArray());
		}
		else
		{
			type = null;
		}
		return	new VarTypeName(type, id);
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
		 MethodType	type = (MethodType)MethodType.getType(_fqcn, "<init>", paramTypes, returnTypes, Modifier.PUBLIC);	// TODO:暫定で public で作成する

		if (_declaredMember._constructorMap.containsKey(type._methodSignature))
		{	// 同じ定義のメソッドがすでに登録されている
			throw new PyriteSyntaxException("method declation duplicated");
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
		int	modifier = (ctx.classInstanceModifier() != null) ? Modifier.STATIC : 0x00;
		modifier |= Modifier.PUBLIC;		// TODO:暫定で public で作成する

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
		MethodType	type = (MethodType)MethodType.getType(_fqcn, id, paramTypes, returnTypes, modifier);

		if (_declaredMember._classMethodMap.containsKey(type._methodSignature) || _declaredMember._instanceMethodMap.containsKey(type._methodSignature))
		{	// 同じ定義のメソッドがすでに登録されている
			throw new PyriteSyntaxException("method declation duplicated");
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
