package pyrite.compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import pyrite.compiler.FQCNParser.FQCN;
import pyrite.compiler.antlr.PyriteParser;
import pyrite.compiler.type.ArrayType;
import pyrite.compiler.type.AssocType;
import pyrite.compiler.type.ClassType;
import pyrite.compiler.type.ExpressionListType;
import pyrite.compiler.type.LValueType;
import pyrite.compiler.type.MethodNameType;
import pyrite.compiler.type.MethodType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.PackageType;
import pyrite.compiler.type.SwitchBlock;
import pyrite.compiler.type.SwitchCase;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarType.TYPE;
import pyrite.compiler.type.VarTypeName;
import pyrite.compiler.util.StringUtil;
import pyrite.lang.Array;
import pyrite.lang.Assoc;


public class CodeGenerationVisitor extends GrammarCommonVisitor
{
	public final ConstantPoolManager _cpm;
	public final FQCN	_fqcn;

//	// 現在解析中のメソッド。visitClassBodyDeclarationMethodDeclaration()で切り替わる。
//	private MethodDeclation	_currentMethodDeclation;

	// このクラスで定義しているメソッド・フィールド
	public final ClassResolver.ClassFieldMember	_thisClassFieldMember;

//	// このファイルで定義しているメソッドのマップ
//	private Map<MethodDeclation, MethodDeclation>	_methodDeclationMap;
//
//	// このファイルで定義しているインスタンス変数のマップ
//	private Map<String, VarType>	_instanceValMap;
//
//	// このファイルで定義しているクラス変数のマップ
//	private Map<String, VarType>	_classValMap;

	// このクラスで呼び出しているメソッドのマップ
//	private Map<PyriteParser.ExpressionInvokeMethodContext, MethodType>	_methodCallMap = new HashMap<PyriteParser.ExpressionInvokeMethodContext, MethodType>();

	// メソッドの定義＋コード
	private List<MethodCodeDeclation>	_methodCodeDeclationList = new ArrayList<MethodCodeDeclation>();

	// 現在解析中のメソッド
	public MethodCodeDeclation	_currentMethodCodeDeclation;

	// 現在解析中のメソッドのジャンプ制御オブジェクト
	private ControlBlockManager	_controlBlockManager;

	public CodeGenerationVisitor(
			ClassResolver cr,
			ConstantPoolManager cpm,
			ImportDeclarationManager idm,
			FQCN fqcn,
			ClassResolver.ClassFieldMember thisClassFieldMember)
	{
		super(cr, idm);
		_cpm = cpm;
		_fqcn = fqcn;
		_thisClassFieldMember = thisClassFieldMember;
	}

	public List<MethodCodeDeclation>	getMethodCodeDeclationList()
	{
		return	_methodCodeDeclationList;
	}

//	public GrammarCheckVisitor(
//			ConstantPoolManager cpm,
//			ClassResolver cd,
//			Map<MethodDeclation, MethodDeclation> methodDeclationMap,
//			Map<String, VarType> instanceValMap,
//			Map<String, VarType> classValMap)
//	{
//		_cpm = cpm;
//		_cd = cd;
//		_methodDeclationMap = methodDeclationMap;
//		_instanceValMap = instanceValMap;
//		_classValMap = classValMap;
//	}


//	public Map<PyriteParser.ExpressionInvokeMethodContext, MethodType>	getMethodCallMap()
//	{
//		return	_methodCallMap;
//	}

//	// 呼び出しているメソッドのうち、定義されていないメソッドを返す
//	public Set<MethodDeclation>	getUndeclaredMethodSet()
//	{
//		Set<MethodDeclation>	undeclaredMethodSet = new HashSet<MethodDeclation>(_methodCallSet);
//		undeclaredMethodSet.removeAll(_methodDeclationMap.values());
//		return	undeclaredMethodSet;
//	}


	//fieldDeclaration
    //	:   classInstanceModifier? 'var' variableDeclarationStatement ';'
    //	;
	@Override
	public Object visitFieldDeclaration(@NotNull PyriteParser.FieldDeclarationContext ctx)
	{
		boolean	isStatic = (ctx.classInstanceModifier() != null);

		VarType	type = (VarType)visit(ctx.variableDeclarationStatement());

		// TODO: コードをコンストラクタ/static初期化ブロックに追加するような仕組みが必要
		return	null;
	}


	// variableDeclarationStatement
    //	:   Identifier (':' typeOrArray)? ('=' expression)?
    //	;
	@Override
	public Object visitVariableDeclarationStatement(@NotNull PyriteParser.VariableDeclarationStatementContext ctx)
	{
		String	id = ctx.Identifier().getText();
		VarType	type = (VarType)visit(ctx.typeOrArray());

		if (ctx.expression() != null)
		{
			// TODO:コードをコンストラクタ/static初期化ブロックに追加するような仕組みが必要
			VarType	rightExpressionType = (VarType)visit(ctx.expression());
			throw new RuntimeException("not implemented.");
		}

		return	new VarTypeName(type, id);
	}


	//	constructorDeclaration
	//    :   Identifier inputParameters
	//        constructorBody
	//    ;
	@Override
	public Object visitConstructorDeclaration(@NotNull PyriteParser.ConstructorDeclarationContext ctx)
	{
		String id = ctx.Identifier().getText();

		_currentMethodCodeDeclation = new MethodCodeDeclation();
		_currentMethodCodeDeclation.setStatic(false);
		_currentMethodCodeDeclation.setClassName(_fqcn._className);
		_currentMethodCodeDeclation.setMethodName("<init>");									// コード上では "<init>";

		List<VarTypeName>	inParamList = (List<VarTypeName>)visit(ctx.inputParameters());
		List<VarTypeName>	outParamList = new ArrayList<VarTypeName>();						// コード上では返り値なし
		_currentMethodCodeDeclation.setInParamList(inParamList);
		_currentMethodCodeDeclation.setOutParamList(outParamList);

		// TODO:スーパークラスの呼び出し
		_currentMethodCodeDeclation.addCodeOp(BC.ALOAD_0);
		_currentMethodCodeDeclation.addCodeOp(BC.INVOKESPECIAL);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef("java/lang/Object", "<init>", "()V"));	// 暫定的に

		_controlBlockManager = new ControlBlockManager();	// 制御構文ジャンプ位置管理オブジェクト

		// メソッド本体
		visit(ctx.constructorBody());

		// TODO自動でRETURNを入れる必要がある
//		_currentMethodCodeDeclation.addCodeOp(BC.RETURN);

		_methodCodeDeclationList.add(_currentMethodCodeDeclation);
		return	null;
	}

	// method
	//methodDeclaration
	//	:	classInstanceModifier? Identifier inputParameters outputParameters
	//		methodBody
	//		;
	public Object visitMethodDeclaration(@NotNull PyriteParser.MethodDeclarationContext ctx)
	{
		boolean	isStatic = (ctx.classInstanceModifier() != null);
		String id = ctx.Identifier().getText();

		_currentMethodCodeDeclation = new MethodCodeDeclation();
		_currentMethodCodeDeclation.setStatic(isStatic);
		_currentMethodCodeDeclation.setClassName(_fqcn._className);
		_currentMethodCodeDeclation.setMethodName(id);

		List<VarTypeName>	inParamList = (List<VarTypeName>)visit(ctx.inputParameters());
		List<VarTypeName>	outParamList = (List<VarTypeName>)visit(ctx.outputParameters());
		// パラメータ名称重複チェック
		for (VarTypeName varTypeName : inParamList)
		{
			if (_currentMethodCodeDeclation.isDuplicatedLocalVar(varTypeName._name))
			{
				throw new PyriteSyntaxException("duplicated local variable");
			}
			_currentMethodCodeDeclation.putLocalVar(varTypeName._name, varTypeName._type);

		}
		for (VarTypeName varTypeName : outParamList)
		{
			if (varTypeName._name != null)
			{
				if (_currentMethodCodeDeclation.isDuplicatedLocalVar(varTypeName._name))
				{
					throw new PyriteSyntaxException("duplicated local variable");
				}
				_currentMethodCodeDeclation.putLocalVar(varTypeName._name, varTypeName._type);
			}
		}

		_currentMethodCodeDeclation.setInParamList(inParamList);
		_currentMethodCodeDeclation.setOutParamList(outParamList);

		_controlBlockManager = new ControlBlockManager();	// 制御構文ジャンプ位置管理オブジェクト

		// メソッド本体
		visit(ctx.methodBody());

		// TODO自動でRETURNを入れる必要がある
//		_currentMethodCodeDeclation.addCodeOp(BC.RETURN);

		_methodCodeDeclationList.add(_currentMethodCodeDeclation);
		return	null;
	}

	// block
	// '{' blockStatement* '}'
	@Override
	public Object visitBlock(@NotNull PyriteParser.BlockContext ctx)
	{
		_currentMethodCodeDeclation.pushLocalVarStack();
//		System.out.println(ctx.getText());
//		List	l = ctx.blockStatement();
//		System.out.println(l.size());
		visitChildren(ctx);
		_currentMethodCodeDeclation.popLocalVarStack();
		return	null;
	}


	// expression
	//  expression ';'
	public Object visitStatementExpression(PyriteParser.StatementExpressionContext ctx)
	{
		visit(ctx.expression());
		return	null;
	}

	// expression '.' Identifier
	@Override
	public Object visitExpressionClassFieldRef(@NotNull PyriteParser.ExpressionClassFieldRefContext ctx)
	{
		VarType	expressionVarType = (VarType)visit(ctx.expression());

		VarType	varType;	// result var type
		TerminalNode	idNode = ctx.Identifier();
		String	id = idNode.getText();

		if (isLValueExpressionElement(ctx))
		{	// assign
			switch (expressionVarType._type)
			{
			case PACKAGE:
				throw new PyriteSyntaxException("id is not declared." + id);

			case CLASS:
				//   Class.Class			// inner class. not implemented.
				//   Class.Class field
				//   Class.Class method
				ClassType	classType = (ClassType)expressionVarType;
				varType = _cr.dispatchVariableC(classType._fqcn, id);
				if (varType != null)
				{	// クラス変数
					// code
					// assign()で値設定するため、ここでコードは作成しない。
					return	new LValueType(LValueType.TYPE.CLASS, varType, _cpm.getFieldRef(classType._fqcn._fqcnStr, id, varType._jvmExpression));
						// 代わりに setLeftExpressionVarType() を呼び出し、設定情報を保持しておく。
//						cgv.setLeftExpressionVarType(3, -1, packageClassName, id);
//						return	new AssignLeftExpressionType(varType, 3, -1, classType._fqcn._fqcnStr, id);
				}

				// 不明なIdentifier
				throw new PyriteSyntaxException("id is not declared. " + id);

			case OBJ:
				//   Object.Instance field
				//   Object.Instance method
				//   Class.Class field
				//   Object.Class method
				ObjectType	objectType = (ObjectType)expressionVarType;
				// assign()で値設定するため、ここでコードは作成しない。
				varType = _cr.dispatchVariableI(objectType._fqcn, id);
				if (varType != null)
				{
					return	new LValueType(LValueType.TYPE.INSTANCE, varType, _cpm.getFieldRef(objectType._fqcn._fqcnStr, id, varType._jvmExpression));
//						cgv.setLeftExpressionVarType(2, -1, _fqcn._fqcnStr, id);
//						return	varType;
//						return	new AssignLeftExpressionType(varType, 2, -1, objectType._fqcn._fqcnStr, id);
				}

				varType = _cr.dispatchVariableC(objectType._fqcn, id);
				if (varType != null)
				{
					return	new LValueType(LValueType.TYPE.CLASS, varType, _cpm.getFieldRef(objectType._fqcn._fqcnStr, id, varType._jvmExpression));
//						cgv.setLeftExpressionVarType(3, -1, _fqcn._fqcnStr, id);
//						return	varType;
//						return	new AssignLeftExpressionType(varType, 3, -1, objectType._fqcn._fqcnStr, id);
				}

				// 不明なIdentifier
				throw new PyriteSyntaxException("id is not declared. " + id);

			case ARRAY:
			case ASSOC:
				throw new PyriteSyntaxException("id is not declared." + id);

			default:
				// それ以外の型では、.による識別子連鎖は許容されていない
				throw new PyriteSyntaxException("id is not declared. " + id);
			}
		}
		else
		{	// refer
			switch (expressionVarType._type)
			{
			case PACKAGE:
				//   Package.Package
				//   Package.Class
				PackageType	packageType = (PackageType)expressionVarType;
				FQCN	fqcn = FQCNParser.getFQCN(packageType._fqcn._fqcnStr, id);

				if (_cr.isClass(fqcn))
				{	// class name
					return	ClassType.getType(fqcn);
				}

				if (_cr.isPackage(fqcn))
				{
					return	PackageType.getType(fqcn);
				}

				throw new PyriteSyntaxException("id is not declared." + id);

			case CLASS:
				//   Class.Class			// inner class. not implemented.
				//   Class.Class field
				//   Class.Class method
				varType = _cr.dispatchVariableC(expressionVarType._fqcn, id);
				if (varType != null)
				{	// クラス変数
					// code
					_currentMethodCodeDeclation.addCodeOp(BC.GETSTATIC);
					_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(expressionVarType._fqcn._fqcnStr, id, varType._jvmExpression));
					return	varType;
				}

				if (_cr.existsMethodC(expressionVarType._fqcn, id))
				{	// クラスメソッド
					return	MethodNameType.getType(expressionVarType._fqcn, id, true);
				}

				// TODO:クラス.クラスはとりあえず未サポート
				throw new PyriteSyntaxException("id is not declared. " + id);

			case OBJ:
			case ARRAY:
			case ASSOC:
				//   Object.Instance field
				//   Object.Instance method
				//   Object.Class field
				//   Object.Class method
				varType = _cr.dispatchVariableI(expressionVarType._fqcn, id);
				if (varType != null)
				{	// インスタンスフィールド
					_currentMethodCodeDeclation.addCodeOp(BC.GETFIELD);
					_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(expressionVarType._fqcn._fqcnStr, id, varType._jvmExpression));

					return	varType;
				}

				varType = _cr.dispatchVariableC(expressionVarType._fqcn, id);
				if (varType != null)
				{	// クラスフィールド
					_currentMethodCodeDeclation.addCodeOp(BC.GETSTATIC);
					_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(expressionVarType._fqcn._fqcnStr, id, varType._jvmExpression));

					return	varType;
				}

				if (_cr.existsMethodIC(expressionVarType._fqcn, id))
				{	// クラスメソッド/インスタンスメソッド
					return	MethodNameType.getType(expressionVarType._fqcn, id, false);
				}

				// 不明なIdentifier
				throw new PyriteSyntaxException("id is not declared. " + id);

			default:
				// それ以外の型では、.による識別子連鎖は許容されていない
				throw new PyriteSyntaxException("id is not declared. " + id);
			}
		}
	}


	// expression
	//   : expression arguments
	//
	// メソッド呼び出しでは、以下の順にコードを設定する必要がある。
	//	1. expressionの解決(メソッドを起動するオブジェクトや、オブジェクトのフィールド参照をスタックに詰むコード)
	//	2. expressionListの解決(引数オブジェクトをスタックに詰むコード)
	//	3. expressionに含まれるメソッド呼び出しコード
	//	しかし、expressionに含まれるメソッドがインスタンスメソッドなのかクラスメソッドなのかは expressionList を解決しないと確定しない。
	//	そこで、現在のコード位置を記録しておき、先に2.を解決する。
	//	その情報を用いてexpressionを解決、メソッドを確定する。
	//	メソッドのレシーバインスタンスやフィールド参照コード(1.)を、記録しておいたコード位置に挿入する。
	//	最後にメソッド呼び出しコード(3.)を追記する。
	//  例.
	//    v.x.m1(y).m2(m3(), z)
	//	    load v
	//	    field x
	//	    load y
	//	    invoke m1
	//	    invoke m3
	//	    load z
	//	    invoke m2
	//
	@Override
	public Object visitExpressionInvokeMethod(@NotNull PyriteParser.ExpressionInvokeMethodContext ctx)
	{
		if (isLValueExpressionElement(ctx))
		{
			throw new PyriteSyntaxException("LValue must be a variable or field.");
		}
			// expression
		int	expressionCodePosFrom = _currentMethodCodeDeclation.getCodePos();	// レシーバのコード開始位置
		VarType	expressionVarType = (VarType)visit(ctx.expression());
		int	expressionCodePosTo = _currentMethodCodeDeclation.getCodePos();	// レシーバのコード終了位置
		if (expressionVarType._type != TYPE.METHOD)
		{
			throw new PyriteSyntaxException("no such method");
		}
		MethodNameType	methodNameType = (MethodNameType)expressionVarType;

		// methodParameter
		ExpressionListType	expressionListType = (ExpressionListType)visit(ctx.arguments());
		List<VarType>	inputParamTypeList = expressionListType._paramTypeList;

		// メソッド定義・出力パラメータを解決
		MethodType	methodType = _cr.resolveMethodVarType(methodNameType, inputParamTypeList);
		if (methodType == null)
		{
			throw new PyriteSyntaxException("no such method");
		}

		// メソッド呼び出しリストに追加
//		_methodCallMap.put(ctx, methodType);

		// コード生成
		if (methodType._isStatic)
		{	// クラスメソッドの場合は、レシーバの解析中に追加されたオブジェクトをスタックに詰むコードを除外する。
			// (メソッド引数にてメソッド呼び出しがある場合、余分なオブジェクトがスタックにあると引数がずれてしまうため、適正なオブジェクトのみをスタックに残さなければならない)
			// (引数の解析が終わらないと呼び出しメソッドがクラスメソッドかインスタンスメソッドかわからない)
			_currentMethodCodeDeclation.removeCode(expressionCodePosFrom, expressionCodePosTo);
		}
		byte	opCode = methodType._isStatic ? BC.INVOKESTATIC : BC.INVOKEVIRTUAL;
		_currentMethodCodeDeclation.addCodeOp(opCode, -1 * methodType._paramTypes.length);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(methodType._fqcn._fqcnStr, methodType._methodName, methodType._jvmMethodParamExpression));

		if (isRemainStackValue(ctx) == false && methodType._returnTypes.length > 0)
		{	//
			_currentMethodCodeDeclation.addCodeOp(BC.POP);
		}


		// 返り値
		// TODO:とりあえず暫定で。要複数パラメータ対応
		if (methodType._returnTypes.length == 0)
		{
			return	VarType.VOID;
		}
		else
		{
			return	methodType._returnTypes[0];
		}

		// TODO:	Java メソッド呼び出し/型変換




/*
//		// メソッド定義・出力パラメータを解決
//		MethodDeclation	methodDeclation = dispatchMethodVarType(expressionVarType, dispachedParamTypeList);

//		boolean	isStaticOnly = (status == 3);		// true:かならずstaticメソッドでないといけない false:staticでもinstanceでもよい
//		String	methodName = ids[ids.length - 1];
//
//		MethodDeclation	methodDeclationCalled = new MethodDeclation();
//		methodDeclationCalled.setClassName(varType._className);
//		methodDeclationCalled.setMethodName(methodName);
//		methodDeclationCalled.setInParamList(dispachedParamTypeList);
//
//		MethodDeclation	methodDeclation = _methodDeclationMap.get(methodDeclationCalled);
//		if (methodDeclation != null)
//		{	// このファイルで定義されている
//			if (isStaticOnly && methodDeclation._isStatic == false)
//			{
//				throw new RuntimeException("no such static method.");
//			}
//			return	methodDeclation;
//		}
//		else
//		{	// メソッド参照をチェックする
//			return	_cd.dispatchMethodDeclation(varType._className, methodName, dispachedParamTypeList, isStaticOnly);
//		}


//		if (methodDeclation == null)
//		{
//			throw new RuntimeException("no such method");
//		}

//		// メソッド呼び出しリストに追加
//		_methodCallMap.put(ctx, expressionVarType);
//
//		// TODO:とりあえず暫定で。要複数パラメータ対応
//		if (methodDeclation._outParamList.size() == 0)
//		{
//			return	VarType.VOID;
//		}
//		else
//		{
//			return	methodDeclation._outParamList.get(0);
//		}
 *
 */
	}

	//	arguments
	//    :   '(' expressionList? ')'
	//    ;
	@Override
	public Object visitArguments(@NotNull PyriteParser.ArgumentsContext ctx)
	{
		ExpressionListType	expressionListType;
		PyriteParser.ExpressionListContext	expressionListContext = ctx.expressionList();
		if (expressionListContext != null)
		{
			expressionListType = (ExpressionListType)visit(expressionListContext);
		}
		else
		{
			expressionListType = new ExpressionListType();
		}
		return	expressionListType;


//		// 入力パラメータを解決
//		// メソッド解決のために参照する入力パラメータの型情報
//
//		for (int i = 0; i < expressionListType._paramTypeList.size(); ++i)
//		{
////			VarType	inputParamType = type.resolveType(this);
//
//			switch (expressionListType._paramTypeList.get(i)._type)
//			{
//			case NULL:
//				// どのオブジェクト型にも合うようにオブジェクト参照に差し替える
//				expressionListType._paramTypeList.set(i, ObjectType.getType("java.lang.Object"));
//				break;
//			case OBJ:
//			case NUM:
//			case INT:
//			case DEC:
//			case FLT:
//			case STR:
//			case CHR:
//			case BOL:
//			case BYT:
//			case ARRAY:
//			case ASSOC:
//				// OK
//				break;
//			default:
//				throw new RuntimeException("method parameter unsuitable.");
//			}
//		}
//
//		return	expressionListType;
	}



	// expression (',' expression)*
	@Override
	public Object visitExpressionList(@NotNull PyriteParser.ExpressionListContext ctx)
	{
		ExpressionListType	expressionListType = new ExpressionListType();
		List<PyriteParser.ExpressionContext>	exprs = ctx.expression();

		for (PyriteParser.ExpressionContext expr : exprs)
		{
			expressionListType._paramTypeList.add((VarType)visit(expr));
			expressionListType._paramCodePosList.add(_currentMethodCodeDeclation.getCodePos());
		}

		return	expressionListType;
	}

	// 'new' creator
	@Override
	public Object visitExpressionNew(@NotNull PyriteParser.ExpressionNewContext ctx)
	{
		if (isLValueExpressionElement(ctx))
		{
			throw new PyriteSyntaxException("LValue must be a variable or field.");
		}
		return visit(ctx.creator());
	}

	// qualifiedName arguments	# CreatorClass
	@Override
	public Object visitCreatorClass(@NotNull PyriteParser.CreatorClassContext ctx)
	{
		String	id = ctx.qualifiedName().getText();
		FQCN	fqcn = _idm.resolveClassName(id);
		if (fqcn == null)
		{
			throw new PyriteSyntaxException("class not found.");
		}
		ClassType	classType = (ClassType)ClassType.getType(fqcn);

		// code
		// パラメータの解析の前に、レシーバとなるオブジェクトを生成しておく必要がある
		_currentMethodCodeDeclation.addCodeOp(BC.NEW);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(fqcn._fqcnStr));
		_currentMethodCodeDeclation.addCodeOp(BC.DUP);

		// メソッド引数を解析し、スタックに積む
		// methodParameter
		List<VarType>	inputParamTypeList = (List<VarType>)visit(ctx.arguments());

		MethodType	methodType = _cr.dispatchConstructor(classType, inputParamTypeList);
		if (methodType == null)
		{
			throw new PyriteSyntaxException("constructor not found.");
		}

		// code
		_currentMethodCodeDeclation.addCodeOp(BC.INVOKESPECIAL);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(methodType._fqcn._fqcnStr, "<init>", methodType.createConstructorJvmMethodParamExpression()));

		assert (methodType._returnTypes.length == 1);
		return	methodType._returnTypes[0];
	}

	// array '(' ')'			# CreatorArray
	@Override
	public Object visitCreatorArray(@NotNull PyriteParser.CreatorArrayContext ctx)
	{
		VarType	varType = (VarType)visit(ctx.array());
		String	className;

		switch (varType._type)
		{
		case ARRAY:
			className = Array.CLASS_NAME;
			break;
		case ASSOC:
			className = Assoc.CLASS_NAME;
			break;
		default:
			throw new RuntimeException("assert");
		}

		// オブジェクト生成
		_currentMethodCodeDeclation.addCodeOp(BC.NEW);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(className));
		_currentMethodCodeDeclation.addCodeOp(BC.DUP);

		// methodParameter
		//   -> none

		// invoke constructor
		_currentMethodCodeDeclation.addCodeOp(BC.INVOKESPECIAL);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(className, "<init>", "()V"));

		return	varType;
	}

/*
	// creator
    //	:   createdName (arrayCreatorRest | methodParameter)
    //	;
	@Override
	public Object visitCreator(@NotNull PyriteParser.CreatorContext ctx)
	{
		VarType	varType = (VarType)visit(ctx.createdName());

		if (ctx.arrayCreatorRest() != null)
		{
			int dimension = (int)visit(ctx.arrayCreatorRest());

			// code
			ArrayType	arrayType = null;
			switch (varType._type)
			{
			case INT:
			case STR:
			case CLASS:
				arrayType = (ArrayType)ArrayType.getType(varType, dimension);
				break;
			default:
				assert false : "class is not supported array.";
				break;
			}

			if (dimension == 1)
			{
				if (varType._type == VarType.TYPE.INT)
				{
					_currentMethodCodeDeclation.addCodeOp(BC.NEWARRAY);
					_currentMethodCodeDeclation.addCodeU2(10);		// TODO: 10はint型の意味。to constantに変更しないと。
				}
				else
				{
					// 一次元配列の要素は、型のみ、クラス指定 "L(.);" のLおよび;を除去したクラス名本体のみを指定する。
					VarType	createArrayType = arrayType._arrayVarType;
					String	jvmExpression = StringUtil.stripEndChar(createArrayType._jvmExpression);
					_currentMethodCodeDeclation.addCodeOp(BC.ANEWARRAY);
//					_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(createArrayType._jvmExpression));
					_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(jvmExpression));
				}
			}
			else
			{
				// 二次元以上の配列は、配列型をそのまま指定する。
				_currentMethodCodeDeclation.addCodeOp(BC.MULTIANEWARRAY);
				_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(arrayType._jvmExpression));
				_currentMethodCodeDeclation.addCodeU1(dimension);
			}

			return	arrayType;
		}
		else
		{
			if (varType._type != VarType.TYPE.CLASS)
			{
				throw new RuntimeException("class not found.");
			}
			ClassType	classType = (ClassType)varType;

			// code
			// パラメータの解析の前に、レシーバとなるオブジェクトを生成しておく必要がある
			_currentMethodCodeDeclation.addCodeOp(BC.NEW);
			_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(classType._packageClassName));
			_currentMethodCodeDeclation.addCodeOp(BC.DUP);

			// メソッド引数を解析し、スタックに積む
			// methodParameter
			List<VarType>	inputParamTypeList = (List<VarType>)visit(ctx.arguments());

			MethodType	methodType = _cr.dispatchConstractor(classType, inputParamTypeList);
			if (methodType == null)
			{
				throw new RuntimeException("construcor not found.");
			}

			// code
			_currentMethodCodeDeclation.addCodeOp(BC.INVOKESPECIAL);
			_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(methodType._packageClassName, "<init>", methodType.createConstructorJvmMethodParamExpression()));

			assert (methodType._returnTypes.length == 1);
			return	methodType._returnTypes[0];
		}
	}


	// createdName
	// 	Identifier ('.' Identifier)*
	@Override
	public Object visitCreatedNameIdentifer(@NotNull PyriteParser.CreatedNameIdentiferContext ctx)
	{
		List<TerminalNode>	idList = ctx.Identifier();
		String	packageName;
		String	className;

//		String	packageClassName = ctx.getText();	// こちらを使う方針でもいいはず
		if (idList.size() > 1)
		{
			StringBuilder	sb = new StringBuilder();
			sb.append(idList.get(0).getText());
			for (int i = 1; i < idList.size() - 1; ++i)
			{
				sb.append(".").append(idList.get(i).getText());
			}

			packageName = sb.toString();
			className = idList.get(idList.size() - 1).getText();
		}
		else
		{
			packageName = "";
			className = idList.get(0).getText();
		}
		String[]	packageClassName = _idm.resolveClassName(packageName, className);
		if (packageClassName == null)
		{
			throw new PyriteSyntaxException(String.format("class not found. packageName=%s className=%s", packageName, className));
		}

		return	ClassType.getType(packageClassName[0], packageClassName[1]);
	}

	// createdName
	// 	primitiveType
	@Override
	public Object visitCreatedNamePrimitiveType(@NotNull PyriteParser.CreatedNamePrimitiveTypeContext ctx)
	{
		return	visit(ctx.primitiveType());
	}

	//	arrayCreatorRest
	//    :   '['
	//        (   ']' ('[' ']')* arrayInitializer
	//        |   expression ']' ('[' expression ']')* ('[' ']')*
	//        )
	//    ;
	@Override
	public Object visitArrayCreatorRest(@NotNull PyriteParser.ArrayCreatorRestContext ctx)
	{
		int	dimension = 0;
		if (ctx.arrayInitializer() != null)
		{	// TODO
			throw new RuntimeException("not supported yet");
		}
		else
		{
//			ctx.getTokens(arg0)
			int	n = ctx.getChildCount();
			for (ParseTree t : ctx.children)
			{
//				System.out.println(t.getText());
				String	tx = t.getText();
				if (tx.equals("[") == false && tx.equals("]") == false)
				{	// expression
					VarType varType = (VarType)visit(t);
					varType = varType.resolveType(this);
					if (varType != VarType.INT)
					{
						throw new RuntimeException("array indexer must integer.");
					}
				}
				else if (tx.equals("["))
				{
					dimension += 1;
				}
			}
			return	dimension;
		}
	}
*/


	// expression '[' expression ']'
	@Override
	public Object visitExpressionArrayAccess(@NotNull PyriteParser.ExpressionArrayAccessContext ctx)
	{
		// debug:
		String s = ctx.getText() + " " + ctx.expression(0).getText() + " + " + ctx.expression(1).getText();

		VarType	expressionType = (VarType)visit(ctx.expression(0));
		VarType	indexType = (VarType)visit(ctx.expression(1));

		if (expressionType._type == TYPE.ARRAY)
		{
			ArrayType	arrayType = (ArrayType)expressionType;
			if (_cr.isInherited(indexType._fqcn, VarType.INT._fqcn) == false)
			{	// indexTypeのクラスが、Integerを継承していない
				throw new PyriteSyntaxException("array indexer must integer.");
			}

			if (isLValueExpressionElement(ctx))
			{	// assign
				return	new LValueType(LValueType.TYPE.ARRAY, expressionType, _cpm.getMethodRef(arrayType._fqcn._fqcnStr, "set", "(Lpyrite.lang.Integer;Ljava.lang.Object;)Ljava.lang.Object;"));
			}
			else
			{	// refer
				_currentMethodCodeDeclation.addCodeOp(BC.INVOKEVIRTUAL, -1);
				_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(Array.CLASS_NAME, "get", "(Lpyrite.lang.Integer;)Ljava.lang.Object;"));
			}
			return	arrayType._arrayVarType;
		}
		else if (expressionType._type == TYPE.ASSOC)
		{
			AssocType	assocType = (AssocType)expressionType;
			if (_cr.isInherited(indexType._fqcn, assocType._keyVarType._fqcn) == false)
			{	// indexTypeのクラスが、連想配列キーのクラスと継承関係にない
				throw new PyriteSyntaxException("assoc indexer type unmatch.");
			}

			if (isLValueExpressionElement(ctx))
			{	// assign
				return	new LValueType(LValueType.TYPE.ASSOC, expressionType, _cpm.getMethodRef(assocType._fqcn._fqcnStr, "set", "(Lpyrite.lang.Object;Ljava.lang.Object;)Ljava.lang.Object;"));
			}
			else
			{	// refer
				_currentMethodCodeDeclation.addCodeOp(BC.INVOKEVIRTUAL, -1);
				_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(Assoc.CLASS_NAME, "get", "(Ljava.lang.Object;)Ljava.lang.Object;"));
			}
			return	assocType._valVarType;
		}
		else
		{
			throw new RuntimeException("assertion:expression must array or assoc.");
		}

/*
		VarType	retType = arrayType.getType(-1);

		// code
		if (isParentAssignLeftExpression(ctx))
		{	// assign
			return	new AssignLeftExpressionType(retType, 4, -1, null, null);
		}
		else
		{	// refer
			if (arrayType._nArrayLevel == 1)
			{
				switch (arrayType._type)
				{
				case INT:
					_currentMethodCodeDeclation.addCodeOp(BC.IALOAD);
					break;

				case BOL:
					_currentMethodCodeDeclation.addCodeOp(BC.BALOAD);
					break;

				default:
					_currentMethodCodeDeclation.addCodeOp(BC.AALOAD);
					break;
				}
			}
			else
			{
				_currentMethodCodeDeclation.addCodeOp(BC.AALOAD);
			}

			return	retType;
		}
		*/

//		System.out.println(arrayType._jvmExpression + " " + ctx.expression(0).getText() + " "
//				+ (ctx.parent instanceof PyriteParser.ExpressionAssignContext));

//		if (ctx.parent instanceof PyriteParser.ExpressionAssignContext)
//		{
//			System.out.println(arrayType._jvmExpression + " " + ctx.expression(0).getText());
//		}
//		else
//		{
//
//		}
//		if (isAssignLeftExpressionElement(_id))
//		{	// left expression
//
//		}
//		else
//		{
//
//		}
//
//		switch (arrayType._type)
//		{
//		case INT:
//		case BOL:
//			_currentMethodCodeDeclation.addCodeOp(BC.IRETURN);
//			break;
//		case STR:
//		case OBJECT:
//			_currentMethodCodeDeclation.addCodeOp(BC.ARETURN);
//			break;
//		default:
//			throw new RuntimeException("method parameter unsuitable.");
//		}
	}



	// expression op=('*'|'/') expression
	@Override
	public Object visitExpressionMulDiv(PyriteParser.ExpressionMulDivContext ctx)
	{
		if (isLValueExpressionElement(ctx))
		{
			throw new PyriteSyntaxException("LValue must be a variable or field.");
		}

		VarType	lType = (VarType)visit(ctx.expression(0));	// get value of left subexpression
//		lType = lType.resolveType(this);
		VarType	rType = (VarType)visit(ctx.expression(1));	// get value of right subexpression
//		rType = rType.resolveType(this);

		if (lType._type != rType._type)
		{
			throw new RuntimeException("type different.");
		}

		switch (lType._type)
		{
		case INT:
			if ( ctx.op.getType() == PyriteParser.MUL )
			{
				_currentMethodCodeDeclation.addCodeOp(BC.IMUL);
			}
			else
			{
				_currentMethodCodeDeclation.addCodeOp(BC.IDIV);
			}
			break;

		default:
			throw new RuntimeException("unsupported operation.");
		}

		return	lType;
	}

	// expression op=('+'|'-') expression
	public Object visitExpressionAddSub(PyriteParser.ExpressionAddSubContext ctx)
	{
		if (isLValueExpressionElement(ctx))
		{
			throw new PyriteSyntaxException("LValue must be a variable or field.");
		}

		VarType	lType = (VarType)visit(ctx.expression(0));	// get value of left subexpression
//		lType = lType.resolveType(this);
		VarType	rType = (VarType)visit(ctx.expression(1));	// get value of right subexpression
//		rType = rType.resolveType(this);

		if (lType._type != rType._type)
		{
			throw new RuntimeException("type different.");
		}

		switch (lType._type)
		{
		case INT:
			if ( ctx.op.getType() == PyriteParser.ADD )
			{
				_currentMethodCodeDeclation.addCodeOp(BC.IADD);
			}
			else
			{
				_currentMethodCodeDeclation.addCodeOp(BC.ISUB);
			}
			break;

		default:
			throw new RuntimeException("unsupported operation.");
		}

		return	lType;
	}


	// expression op=('<=' | '>=' | '>' | '<') expression
	@Override
	public Object visitExpressionCompare(@NotNull PyriteParser.ExpressionCompareContext ctx)
	{
		VarType	lType = (VarType)visit(ctx.expression(0));	// get value of left subexpression
//		lType = lType.resolveType(this);
		VarType	rType = (VarType)visit(ctx.expression(1));	// get value of right subexpression
//		rType = rType.resolveType(this);

		if (lType._type != rType._type)
		{
			throw new RuntimeException("type different.");
		}

		byte op = 0x00;
		switch (lType._type)
		{
		case INT:
			switch (ctx.op.getType())
			{
			case PyriteParser.LT:	// -> GE
				op = BC.IF_ICMPGE;
				break;
			case PyriteParser.LE:	// -> GT
				op = BC.IF_ICMPGT;
				break;
			case PyriteParser.GT:	// -> LE
				op = BC.IF_ICMPLE;
				break;
			case PyriteParser.GE:	// -> LT
				op = BC.IF_ICMPLT;
				break;
			}
			break;

		default:
			throw new RuntimeException("unsupported operation.");
		}

		_currentMethodCodeDeclation.addCodeOp(op);
		_currentMethodCodeDeclation.addCodeU2(7);
		_currentMethodCodeDeclation.addCodeOp(BC.ICONST_1);
		_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
		_currentMethodCodeDeclation.addCodeU2(4);
		_currentMethodCodeDeclation.addCodeOp(BC.ICONST_0);

		return	VarType.BOL;
	}

	// expression op=('==' | '!=') expression
	@Override
	public Object visitExpressionEqual(@NotNull PyriteParser.ExpressionEqualContext ctx)
	{
		VarType	lType = (VarType)visit(ctx.expression(0));	// get value of left subexpression
//		lType = lType.resolveType(this);
		VarType	rType = (VarType)visit(ctx.expression(1));	// get value of right subexpression
//		rType = rType.resolveType(this);

		// 型チェック
		if (lType._type == VarType.TYPE.NULL || rType._type == VarType.TYPE.NULL)
		{	// 片方が null なら、比較可能
			;
		}
		else if (lType._type != rType._type)
		{
			throw new PyriteSyntaxException("type different.");
		}

		byte op = 0x00;
		switch (lType._type)
		{
		case NULL:
		case OBJ:
		case ARRAY:
		case ASSOC:
			switch (ctx.op.getType())
			{
			case PyriteParser.EQUAL:	// -> NOTEQUAL
				op = BC.IF_ACMPNE;
				break;
			case PyriteParser.NOTEQUAL:	// -> EQUAL
				op = BC.IF_ACMPEQ;
				break;
			}
			break;

		case NUM:
		case INT:
		case DEC:
		case FLT:
		case STR:
		case CHR:
		case BOL:
		case BYT:
			// TODO:左辺要素と右辺要素それぞれに変換メソッドを差し込む必要がある
			throw new RuntimeException("unsupported operation.");

		default:
			throw new RuntimeException("assertion");
		}

		_currentMethodCodeDeclation.addCodeOp(op);
		_currentMethodCodeDeclation.addCodeU2(9);				// FALSEの位置
		_currentMethodCodeDeclation.addCodeOp(BC.GETSTATIC);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(VarType.BOL._fqcn._fqcnStr, "TRUE", VarType.BOL._jvmExpression));
		_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
		_currentMethodCodeDeclation.addCodeU2(6);				// この文の末尾位置
		_currentMethodCodeDeclation.addCodeOp(BC.GETSTATIC);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(VarType.BOL._fqcn._fqcnStr, "FALSE", VarType.BOL._jvmExpression));

		return	VarType.BOL;
	}


/*
	// 自分が代入要素の左辺式かどうかを返す
	public boolean	isParentAssignLeftExpression(RuleContext ctx)
	{
		return	_isLValueExpression && isParentAssignExpression(ctx);
	}

	protected boolean	_isLValueExpression = false;	// true:左辺値の解析中 false:それ以外。右結合なので、状態は一つで管理できる。
	// 左辺値の場合は、式の最後の要素がローカル変数またはフィールドでなければならない。
	// また左辺値かどうかによって、式の最後の要素の式解析が異なる
	// ローカル変数参照が
	//   左辺値にある場合：ローカル変数への値設定(ローカル変数インデクスの取得) 右辺値にある場合：ローカル変数参照をスタックに積む
	// フィールド参照が
	//   左辺値にある場合：フィールドへの値設定(スタックにオブジェクト参照を残したままにする) 右辺値にある場合：フィールド参照をスタックに詰む
	protected ParseTree	_lValueExpressionElement;	// 左辺値の右端の要素

	public boolean	isLValueExpressionElement(ParseTree ctx)
	{
		return	_isLValueExpression && ctx == _lValueExpressionElement;
	}
*/

	// 親要素を参照し、スタックに値を残す必要があるかどうかを返す。
	// 親要素が StatementExpression の場合は、スタックに値を残してはいけない。
	// c.f. StatementExpression
	// statement : expression ';'
	public static boolean	isRemainStackValue(RuleContext ctx)
	{
		return	!(ctx.parent instanceof PyriteParser.StatementExpressionContext);
	}

	// expressionが左辺値かどうかによって、式の最後の要素の式解析が異なる
	// ローカル変数参照が
	//   左辺値にある場合：ローカル変数への値設定(ローカル変数インデクスの取得) 右辺値にある場合：ローカル変数参照をスタックに積む
	// フィールド参照が
	//   左辺値にある場合：フィールドへの値設定(スタックにオブジェクト参照を残したままにする) 右辺値にある場合：フィールド参照をスタックに詰む
	// 左辺値の場合は、式の最後の要素がローカル変数またはフィールドでなければならない。
	public boolean	isLValueExpressionElement(ParseTree ctx)
	{
		return	(ctx.getParent() instanceof PyriteParser.ExpressionAssignContext);
//		if (ctx.getParent() instanceof PyriteParser.ExpressionAssignContext)
//		{
//			PyriteParser.ExpressionAssignContext	parent = (PyriteParser.ExpressionAssignContext)ctx.getParent();
//			// PyriteParser.ExpressionAssignContext は
//			// <assoc=right> expression '=' expression
//
//			ParserRuleContext	leftExpression = parent.expression(0);
//			ParseTree	lValueExpressionElement = leftExpression.getChild(leftExpression.getChildCount() - 1);
//
//			if (ctx == lValueExpressionElement)
//			{
//				return	true;
//			}
//		}
//		return	false;
	}


	// <assoc=right> expression '=' expression
	@Override
	public Object visitExpressionAssign(PyriteParser.ExpressionAssignContext ctx)
	{
		// 左辺値
//		_isLValueExpression = true;
		Object	lType = visit(ctx.expression(0));	// get value of left subexpression
		if (lType instanceof LValueType == false)
		{
			throw new PyriteSyntaxException("Left expression is not left value type.");
		}
		LValueType	lValueType = (LValueType)lType;

		switch (ctx.op.getType())
		{
		case PyriteParser.ASSIGN:
			// ok
			break;
		default:
			// 演算代入自体が左辺要素であるかを調べる
			if (isLValueExpressionElement(ctx))
			{	// 演算代入自体は、左辺要素にはならない
				throw new PyriteSyntaxException("LValue must be a variable or field.");
			}

			// 左辺値への参照をスタックに積む
			CodeGenerateOperationalAssignmentVisitor visitor = new CodeGenerateOperationalAssignmentVisitor(_cr, _cpm, _idm, _fqcn, _thisClassFieldMember);
			visitor.visit(ctx.expression(0));	// parse
		}

		// 右辺値
		VarType	rType = (VarType)visit(ctx.expression(1));	// get value of right subexpression

		// 演算を行う
		// TODO
		switch (ctx.op.getType())
		{
		case PyriteParser.ASSIGN:
			break;
		case PyriteParser.ADD_ASSIGN:
		case PyriteParser.SUB_ASSIGN:
		case PyriteParser.MUL_ASSIGN:
		case PyriteParser.DIV_ASSIGN:
		case PyriteParser.AND_ASSIGN:
		case PyriteParser.OR_ASSIGN:
		case PyriteParser.XOR_ASSIGN:
		case PyriteParser.MOD_ASSIGN:
		case PyriteParser.LSHIFT_ASSIGN:
		case PyriteParser.RSHIFT_ASSIGN:
		case PyriteParser.URSHIFT_ASSIGN:
			throw new RuntimeException("not implemented");
		default:
			throw new RuntimeException("assert");
		}

		// assign
		createAssignCode(lValueType, rType, isRemainStackValue(ctx));

		return	lValueType._type;
	}



	// 代入のバイトコードを作成する
	public void	createAssignCode(LValueType lValueType, VarType rType, boolean isRemainStackValue)
	{
		// 代入チェック
		VarType lType = lValueType._type;
		if (rType == VarType.NULL)
		{	// nullは常に代入可
			;
		}
		else if (_cr.isInherited(lType._fqcn, rType._fqcn) == false)
		{	// 型が違うので代入不可
			throw new PyriteSyntaxException("assign type unmached.");
		}
		else if (lType._type == VarType.TYPE.ARRAY)
		{	// 要素の型が一致しているかをチェックする
			VarType	lElementType = ((ArrayType)lType)._arrayVarType;
			VarType	rElementType = ((ArrayType)rType)._arrayVarType;
			if (lElementType.equals(rElementType) == false)
			{
				throw new PyriteSyntaxException("assign type unmached.");
			}
		}
		else if (lType._type == VarType.TYPE.ASSOC)
		{
			VarType	lKeyType = ((AssocType)lType)._keyVarType;
			VarType	rKeyType = ((AssocType)rType)._keyVarType;
			VarType	lValType = ((AssocType)lType)._valVarType;
			VarType	rValType = ((AssocType)rType)._valVarType;
			if (lKeyType.equals(rKeyType) == false || lValType.equals(rValType) == false)
			{
				throw new PyriteSyntaxException("assign type unmached.");
			}
		}
		// precond:lType._fqcnは、Array と Assoc の両方を継承することはない

		// 代入
		switch (lValueType._lValueType)
		{
		case LOCAL:
			if (isRemainStackValue)
			{
				// 値設定後にスタック上から設定値が消えてしまうが、式の値として設定値を返すために、スタック上の値を複製しておく
				_currentMethodCodeDeclation.addCodeOp(BC.DUP);
			}

			switch (lType._type)
			{
			case INT:
			case BOL:
				_currentMethodCodeDeclation.addCodeOpISTORE(lValueType._refNum);
				break;

			default:
				_currentMethodCodeDeclation.addCodeOpASTORE(lValueType._refNum);
				break;
			}
			break;

		case INSTANCE:
			if (isRemainStackValue)
			{
				// 値設定後にスタック上から設定値が消えてしまうが、式の値として設定値を返すために、スタック上の値を複製しておく
				_currentMethodCodeDeclation.addCodeOp(BC.DUP_X1);
			}

			_currentMethodCodeDeclation.addCodeOp(BC.PUTFIELD);
			_currentMethodCodeDeclation.addCodeU2(lValueType._refNum);
			break;

		case CLASS:
			if (isRemainStackValue)
			{
				// 値設定後にスタック上から設定値が消えてしまうが、式の値として設定値を返すために、スタック上の値を複製しておく
				_currentMethodCodeDeclation.addCodeOp(BC.DUP);
			}

			_currentMethodCodeDeclation.addCodeOp(BC.PUTSTATIC);
			_currentMethodCodeDeclation.addCodeU2(lValueType._refNum);
			break;

		case ARRAY:
			_currentMethodCodeDeclation.addCodeOp(BC.INVOKEVIRTUAL, -1);
			_currentMethodCodeDeclation.addCodeU2(lValueType._refNum);

			if (isRemainStackValue == false)
			{	// 代入ではない場合は、メソッド戻り値である、設定した値をスタックから除去する
				_currentMethodCodeDeclation.addCodeOp(BC.POP);
			}
			break;

		case ASSOC:
			_currentMethodCodeDeclation.addCodeOp(BC.INVOKEVIRTUAL, -1);
			_currentMethodCodeDeclation.addCodeU2(lValueType._refNum);

			if (isRemainStackValue == false)
			{	// 代入ではない場合は、メソッド戻り値である、設定した値をスタックから除去する
				_currentMethodCodeDeclation.addCodeOp(BC.POP);
			}
			break;
		}
	}


	// 'return' expressionList? ';'
	@Override
	public Object visitStatementReturn(@NotNull PyriteParser.StatementReturnContext ctx)
	{
		// 宣言された返り値
		List<VarTypeName>	decTypeList = _currentMethodCodeDeclation._outParamList;

		List<VarType>	paramTypeList;
		PyriteParser.ExpressionListContext	expressionListContext = ctx.expressionList();
		if (expressionListContext != null)
		{
			paramTypeList = (List<VarType>)visit(expressionListContext);
		}
		else
		{
			paramTypeList = new ArrayList<VarType>();
		}

		if (paramTypeList.size() != decTypeList.size())
		{
			throw new RuntimeException("method parameter is different.");
		}
		// メソッド定義と一致しているか型チェック
		// 入力パラメータを解決
		// paramTypeList は PartialIdType の可能性があるため、型解決する
		// メソッド解決のために参照する入力パラメータの型情報
		List<VarType>	inputParamTypeList = new ArrayList<VarType>();
		for (VarType inputParamType : paramTypeList)
		{
//			VarType	inputParamType = type.resolveType(this);

			switch (inputParamType._type)
			{
			case NULL:
				// どのオブジェクト型にも合うようにオブジェクト参照に差し替える
				inputParamType = ObjectType.getType("java.lang.Object");
				break;
			case INT:
			case STR:
			case BOL:
			case OBJ:
				// OK
				break;
			default:
				throw new RuntimeException("method parameter unsuitable.");
			}

			inputParamTypeList.add(inputParamType);
		}

		for (int i = 0; i < inputParamTypeList.size(); ++i)
		{
			if (inputParamTypeList.get(i) != decTypeList.get(i)._type)
			{
				throw new RuntimeException("method parameter is different.");
			}
		}

		// コード生成

		if (decTypeList.size() == 0)
		{
			_currentMethodCodeDeclation.addCodeOp(BC.RETURN);
		}
		else if (decTypeList.size() > 1)
		{
			throw new RuntimeException("not supported yet");	// TODO
		}
		else
		{
			switch (inputParamTypeList.get(0)._type)
			{
			case INT:
			case BOL:
				_currentMethodCodeDeclation.addCodeOp(BC.IRETURN);
				break;
			case STR:
			case OBJ:
				_currentMethodCodeDeclation.addCodeOp(BC.ARETURN);
				break;
			default:
				throw new RuntimeException("method parameter unsuitable.");
			}
		}

		return	null;
	}

/*
	// type Identifier ('=' variableInitializer)?
	@Override
	public Object visitLocalVariableDeclaration(@NotNull PyriteParser.LocalVariableDeclarationContext ctx)
	{
		VarType	type = (VarType)visit(ctx.type());
		String	id = ctx.Identifier().getText();

		if (_currentMethodCodeDeclation.isDuplicatedLocalVar(id))
		{
			throw new RuntimeException("duplicated local variable");
		}
		VarTypeName	lTypeName = _currentMethodCodeDeclation.putLocalVar(id, type);

		if (ctx.variableInitializer() != null)
		{
			VarType	rType = (VarType)visit(ctx.variableInitializer());

			AssignLeftExpressionType	assignLeftType = new AssignLeftExpressionType(type, 1, lTypeName._localVarNum, null, null);

//			setLeftExpressionVarType(1, lTypeName._localVarNum, null, null);
			// assign
			createAssignCode(assignLeftType, rType, false);
		}

		return	null;
	}
*/



	// 'if' parExpression block ('else' (ifStatement | block))?
	// 'if' parExpression fulfillmentBlock=block ('else' (ifStatement | elseBlock=block))?
	@Override
	public Object visitIfStatement(@NotNull PyriteParser.IfStatementContext ctx)
	{
		// 条件節
		VarType	varType = (VarType)visit(ctx.parExpression());
		if (varType != VarType.BOL)
		{
			throw new PyriteSyntaxException("condition must be boolean.");
		}
		// true -> 1, false -> 0 をスタックに積む
		// 現時点で、pyrite.lang.Boolean がスタックに積まれているので、IFEQ のために値を取得するメソッドを呼び出す
		_currentMethodCodeDeclation.addCodeOp(BC.INVOKEVIRTUAL);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(pyrite.lang.Boolean.CLASS_NAME, "getPyrcVal", "()I"));


		int	condBranchPos = _currentMethodCodeDeclation.getCodePos();	// 分岐命令バイト位置
		_currentMethodCodeDeclation.addCodeOp(BC.IFEQ);
		_currentMethodCodeDeclation.addCodeU2(0);	// プレースホルダで置いておく

		// 条件を満たす場合のブロック
		visit(ctx.fulfillmentBlock);

		ParserRuleContext	elseContext = null;
		if (ctx.ifStatement() != null)
		{	// else if 節
			elseContext = ctx.ifStatement();
		}
		else if (ctx.elseBlock != null)
		{	// else 節
			elseContext = ctx.elseBlock;
		}

		if (elseContext == null)
		{	// else 節が無い
			int	condBlockEndPos = _currentMethodCodeDeclation.getCodePos();	// ブロックのコード終了バイト位置
			int	condBlockCodeSize = condBlockEndPos - condBranchPos;

			_currentMethodCodeDeclation.replaceCodeU2(condBlockCodeSize, condBranchPos + 1);	// 分岐条件を満たさない場合の飛び先オフセットを設定
		}
		else
		{	// else 節
			int	fulfillmentBlockEndPos = _currentMethodCodeDeclation.getCodePos();	// fulfillmentBlock節終了時のJMP命令位置

			// else 条件節が存在する場合は、条件を満たす場合のブロックの最後にジャンプ命令を追加
			_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
			_currentMethodCodeDeclation.addCodeU2(0);	// プレースホルダで置いておく

			int	condBlockEndPos = _currentMethodCodeDeclation.getCodePos();	// ブロックのコード終了バイト位置
			int	condBlockCodeSize = condBlockEndPos - condBranchPos;

			_currentMethodCodeDeclation.replaceCodeU2(condBlockCodeSize, condBranchPos + 1);	// 分岐条件を満たさない場合の飛び先オフセットを設定

			// else 節
			visit(elseContext);

			int elsedBlockEndPos = _currentMethodCodeDeclation.getCodePos();	// ブロックのコード終了バイト位置
			int	elseBlockCodeSize = elsedBlockEndPos - fulfillmentBlockEndPos;
			_currentMethodCodeDeclation.replaceCodeU2(elseBlockCodeSize, fulfillmentBlockEndPos + 1);	// fulfillmentBlock節終了時の飛び先オフセットを設定

		}

		return	null;
	}

	// label
    // :    Identifier?
	@Override
	public Object visitLabel(PyriteParser.LabelContext ctx)
	{
		return	(ctx.Identifier() != null) ? ctx.Identifier().getText() : null;
	}

	// 'break' label ';'
	@Override
	public Object visitStatementBreak(@NotNull PyriteParser.StatementBreakContext ctx)
	{
		String	label = (String)visit(ctx.label());

		int	currentPos = _currentMethodCodeDeclation.getCodePos();	   // 現在の命令バイト位置
		_controlBlockManager.setBreakPos(label, currentPos);
		_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
		_currentMethodCodeDeclation.addCodeU2(0);	// プレースホルダ

		return	null;
	}

	// 'continue' label ';'
	@Override
	public Object visitStatementContinue(@NotNull PyriteParser.StatementContinueContext ctx)
	{
		String	label = (String)visit(ctx.label());

		int	currentPos = _currentMethodCodeDeclation.getCodePos();	   // 現在の命令バイト位置
		_controlBlockManager.setContinuePos(label, currentPos);
		_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
		_currentMethodCodeDeclation.addCodeU2(0);	// プレースホルダ

		return	null;
	}

	// label 'while' parExpression block
	@Override
	public Object visitStatementWhile(@NotNull PyriteParser.StatementWhileContext ctx)
	{
		String	label = (String)visit(ctx.label());
		_controlBlockManager.push(ControlBlockManager.TYPE.WHILE, label);	// ラベルの有効範囲を設定(制御構文位置を一レベル深くする)

		// 条件節
		int	condPos = _currentMethodCodeDeclation.getCodePos();			  // 条件式バイト位置
		VarType	varType = (VarType)visit(ctx.parExpression());
		if (varType != VarType.BOL)
		{
			throw new PyriteSyntaxException("condition must be boolean.");
		}

		int	condBranchPos = _currentMethodCodeDeclation.getCodePos();	  // 分岐命令バイト位置
		// true -> 1, false -> 0 をスタックに積む
		// 現時点で、pyrite.lang.Boolean がスタックに積まれているので、IFEQ のために値を取得するメソッドを呼び出す
		_currentMethodCodeDeclation.addCodeOp(BC.INVOKEVIRTUAL);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(pyrite.lang.Boolean.CLASS_NAME, "getPyrcVal", "()I"));
		_currentMethodCodeDeclation.addCodeOp(BC.IFEQ);
		_currentMethodCodeDeclation.addCodeU2(0);  // プレースホルダで置いておく

		visit(ctx.block());
		// ブロック末尾に、条件判定に戻るジャンプ命令を追加する
		int	blockEndPos = _currentMethodCodeDeclation.getCodePos();	   // ブロック終了バイト位置
		int	jmpDistance = condPos - blockEndPos;
		_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
		_currentMethodCodeDeclation.addCodeU2(jmpDistance);

		// 条件が満たされない場合のとび先を設定する
		blockEndPos = _currentMethodCodeDeclation.getCodePos();
		jmpDistance = blockEndPos - condBranchPos;
		_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, condBranchPos + 1 + 4);

		// labelに対応する break 文のとび先を設定する
		for (int breakPos : _controlBlockManager.getBreakPosList())
		{
			jmpDistance = blockEndPos - breakPos;
			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, breakPos + 1);
		}

		// labelに対応する continue 文のとび先を設定する
		for (int continuePos : _controlBlockManager.getContinuePosList())
		{
			jmpDistance = condPos - continuePos;	// 条件節に飛ぶ
			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, continuePos + 1);
		}

		_controlBlockManager.pop();	// 制御構文位置を一レベル浅くする
		return	null;
	}

	// for文のブロック (すぐにforControlで一度だけ参照されるため、グローバルに一つ保持するだけでよい)
	private PyriteParser.BlockContext	_forBlockContext;
	// label 'for' '(' forControl ')' block
	@Override
	public Object visitStatementFor(@NotNull PyriteParser.StatementForContext ctx)
	{
		String	label = (String)visit(ctx.label());
		_controlBlockManager.push(ControlBlockManager.TYPE.FOR, label);	// ラベルの有効範囲を設定(制御構文位置を一レベル深くする)

		_forBlockContext = ctx.block();	// ブロック本体をあとで解析する必要があるため、保持
		visit(ctx.forControl());

		_controlBlockManager.pop();	// 制御構文位置を一レベル浅くする
		return	null;
	}


	// forInit? ';' expression? ';' forUpdate?
	@Override
	public Object visitForControlICU(@NotNull PyriteParser.ForControlICUContext ctx)
	{
		// forInitで定義した変数を for 文の有効範囲で生かす
		_currentMethodCodeDeclation.pushLocalVarStack();
		visit(ctx.forInit());

		// 条件節
		int	condPos = _currentMethodCodeDeclation.getCodePos();			// 条件式バイト位置
		VarType	 expressionType = (VarType)visit(ctx.expression());
		int	condBranchPos = -1;			// 条件が満たされない場合のジャンプ命令位置。条件が無い場合は -1
		if (expressionType != null)
		{
			if (expressionType != VarType.BOL)
			{
				throw new PyriteSyntaxException("condition must be boolean.");
			}
			condBranchPos = _currentMethodCodeDeclation.getCodePos();	  // 条件が満たされない場合のジャンプ命令
			// 現時点で、pyrite.lang.Boolean がスタックに積まれているので、IFEQ のために値を取得するメソッドを呼び出す
			_currentMethodCodeDeclation.addCodeOp(BC.INVOKEVIRTUAL);
			_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(pyrite.lang.Boolean.CLASS_NAME, "getPyrcVal", "()I"));
			_currentMethodCodeDeclation.addCodeOp(BC.IFEQ);
			_currentMethodCodeDeclation.addCodeU2(0);	 // プレースホルダで置いておく
		}

		// ブロック本体
		visit(_forBlockContext);
		int	forUpdatePos = _currentMethodCodeDeclation.getCodePos();			// forUpdateバイト位置
		visit(ctx.forUpdate());
		// ブロック末尾に、条件判定に戻るジャンプ命令を追加する
		int	blockEndPos = _currentMethodCodeDeclation.getCodePos();	   // ブロック終了バイト位置
		int	jmpDistance = condPos - blockEndPos;
		_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
		_currentMethodCodeDeclation.addCodeU2(jmpDistance);

		if (expressionType != null)
		{	// 条件がある場合は、条件が満たされない場合のとび先を設定する
			blockEndPos = _currentMethodCodeDeclation.getCodePos();
			jmpDistance = blockEndPos - condBranchPos;
			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, condBranchPos + 1);
		}

		// labelに対応する break 文のとび先を設定する
		for (int breakPos : _controlBlockManager.getBreakPosList())
		{
			jmpDistance = blockEndPos - breakPos;
			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, breakPos + 1);
		}

		// labelに対応する continue 文のとび先を設定する
		for (int continuePos : _controlBlockManager.getContinuePosList())
		{
			jmpDistance = forUpdatePos - continuePos;	// forUpdatePosに飛ぶ
			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, continuePos + 1);
		}

		// stackをpopして終了
		_currentMethodCodeDeclation.popLocalVarStack();
		return	null;
	}

	// 'var' Identifier ':' typeOrArray 'in' expression
	@Override
	public Object visitForControlIterator(@NotNull PyriteParser.ForControlIteratorContext ctx)
	{
		// 定義した変数を for 文の有効範囲で生かす
		_currentMethodCodeDeclation.pushLocalVarStack();

		// 変数定義
		String	id = ctx.Identifier().getText();
		VarType	type = (VarType)visit(ctx.typeOrArray());

		if (_currentMethodCodeDeclation.isDuplicatedLocalVar(id))
		{
			throw new RuntimeException("duplicated local variable");
		}
		VarTypeName	lTypeName = _currentMethodCodeDeclation.putLocalVar(id, type);

		// 集合要素
		VarType	expressionType = (VarType)visit(ctx.expression());
//		expressionType = expressionType.resolveType(this);

		// 型チェック
		switch (expressionType._type)
		{
		case ARRAY:
			ArrayType	arrayType = (ArrayType)lTypeName._type;
			if (_cr.isInherited(arrayType._arrayVarType._fqcn, type._fqcn) == false)
			{	// 代入不可
				throw new PyriteSyntaxException("assign type unmached.");
			}
			break;

		case ASSOC:
			// TODO:Map.Entry が iterator() で返るが、これをなんとかして型チェックできないか。
			// 現時点では、代入で型変換ができない場合、実行時エラーになる
			break;

		case OBJ:
			if (_cr.hasInterface(expressionType._fqcn, FQCNParser.getFQCN("java.lang.Iterable")) == false)
			{
				throw new PyriteSyntaxException("enumlation target is not collection");
			}
			// 現時点では、代入で型変換ができない場合、実行時エラーになる
			break;

		default:
			throw new PyriteSyntaxException("enumlation target is not collection");
		}

		 // iterator()
		_currentMethodCodeDeclation.addCodeOp(BC.INVOKEINTERFACE);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getIntergaceMethodRef("java.lang.Iterable", "iterator", "()Ljava.util.Iterator;"));

		// iterator をローカルに保存
		String	iteratorName = "$it" + ctx.hashCode();	// Pyriteコードでは定義できない名称
		VarTypeName	iteratorTypeName = _currentMethodCodeDeclation.putLocalVar(iteratorName, ObjectType.getType("java.util.Iterator"));
		_currentMethodCodeDeclation.addCodeOpASTORE(iteratorTypeName._localVarNum);

		// iterator.hasNext()
		int	condPos = _currentMethodCodeDeclation.getCodePos();			// 条件式バイト位置
		_currentMethodCodeDeclation.addCodeOp(BC.ALOAD);
		_currentMethodCodeDeclation.addCodeU2(iteratorTypeName._localVarNum);
		_currentMethodCodeDeclation.addCodeOp(BC.INVOKEINTERFACE);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getIntergaceMethodRef("java.util.Iterator", "hasNext", "()Z"));
		int	condBranchPos = _currentMethodCodeDeclation.getCodePos();	  // 分岐命令バイト位置
		_currentMethodCodeDeclation.addCodeOp(BC.IFEQ);
		_currentMethodCodeDeclation.addCodeU2(0);	 // プレースホルダで置いておく

		// iterator.next()
		_currentMethodCodeDeclation.addCodeOpALOAD(iteratorTypeName._localVarNum);
		_currentMethodCodeDeclation.addCodeOp(BC.INVOKEINTERFACE);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getIntergaceMethodRef("java.util.Iterator", "next", "()Ljava/lang/Object;"));

		// 変数に代入
		_currentMethodCodeDeclation.addCodeOp(BC.CHECKCAST);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(((ObjectType)type)._fqcn._fqcnStr));
		_currentMethodCodeDeclation.addCodeOpASTORE(lTypeName._localVarNum);

		// ブロック内の処理
		visit(_forBlockContext);

		// ブロック末尾に、条件判定に戻るジャンプ命令を追加する
		int	blockEndPos = _currentMethodCodeDeclation.getCodePos();	   // ブロック終了バイト位置
		int	jmpDistance = condPos - blockEndPos;
		_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
		_currentMethodCodeDeclation.addCodeU2(jmpDistance);

		// 条件が満たされない場合のとび先を設定する
		blockEndPos = _currentMethodCodeDeclation.getCodePos();
		jmpDistance = blockEndPos - condBranchPos;
		_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, condBranchPos + 1);

		// labelに対応する break 文のとび先を設定する
		for (int breakPos : _controlBlockManager.getBreakPosList())
		{
			jmpDistance = blockEndPos - breakPos;
			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, breakPos + 1);
		}

		// labelに対応する continue 文のとび先を設定する
		for (int continuePos : _controlBlockManager.getContinuePosList())
		{
			jmpDistance = condPos - continuePos;	// ループ条件判定に飛ぶ
			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, continuePos + 1);
		}


//		if (expressionType._type == VarType.TYPE.ARRAY)
//		{	// 集合要素は配列
//			if (type._type != expressionType._type)
//			{
//				throw new PyriteSyntaxException("type is unmatched.");
//			}
//
//			// 集合要素を一度ローカル変数に保持
//			String	collectionName = "$" + ctx.hashCode();	// Pyriteコードで定義できない名称
//			VarTypeName	collectionTypeName = _currentMethodCodeDeclation.putLocalVar(collectionName, expressionType);
////			AssignLeftExpressionType	assignCollectionType = new AssignLeftExpressionType(expressionType, collectionTypeName._localVarNum);
//			LValueType	lValueType = new LValueType(LValueType.TYPE.LOCAL, expressionType, collectionTypeName._localVarNum);
//			createAssignCode(lValueType, expressionType, false);
//
//			// 集合要素の長さを取得、ローカル変数に保持
//			String	collectionLengthName = "$l" + ctx.hashCode();	// Pyriteコードで定義できない名称
//			VarTypeName	collectionLengthTypeName = _currentMethodCodeDeclation.putLocalVar(collectionLengthName, VarType.INT);
//			_currentMethodCodeDeclation.addCodeOpALOAD(collectionTypeName._localVarNum);
//			_currentMethodCodeDeclation.addCodeOp(BC.ARRAYLENGTH);
//			_currentMethodCodeDeclation.addCodeOpISTORE(collectionLengthTypeName._localVarNum);
//
//			// インデクス変数を定義し、0で初期化する
//			String	indexName = "$i" + ctx.hashCode();	// Pyriteコードで定義できない名称
//			VarTypeName	indexTypeName = _currentMethodCodeDeclation.putLocalVar(indexName, VarType.INT);
//			_currentMethodCodeDeclation.addCodeOp(BC.ICONST_0);
//			_currentMethodCodeDeclation.addCodeOpISTORE(indexTypeName._localVarNum);
//
//			// インデクスと配列長の比較を行う
//			int	condPos = _currentMethodCodeDeclation.getCodePos();			// 条件式バイト位置
//			_controlBlockManager.setContinuePos(condPos);					// continue で戻る位置を記憶
//			_currentMethodCodeDeclation.addCodeOpILOAD(indexTypeName._localVarNum);
//			_currentMethodCodeDeclation.addCodeOpILOAD(collectionLengthTypeName._localVarNum);
//			int	condBranchPos = _currentMethodCodeDeclation.getCodePos();	  // 分岐命令バイト位置
//			_currentMethodCodeDeclation.addCodeOp(BC.IF_ICMPGE);
//			_currentMethodCodeDeclation.addCodeU2(0);	 // プレースホルダで置いておく
//
//			// 変数に代入
//			_currentMethodCodeDeclation.addCodeOpALOAD(collectionTypeName._localVarNum);	// 配列をロード
//			_currentMethodCodeDeclation.addCodeOpILOAD(indexTypeName._localVarNum);
//			switch (type._type)
//			{
//			case STR:
//			case OBJ:
//				_currentMethodCodeDeclation.addCodeOp(BC.AALOAD);							// 要素をロード
//				_currentMethodCodeDeclation.addCodeOpASTORE(lTypeName._localVarNum);		// 変数に代入
//				break;
//			case INT:
//				_currentMethodCodeDeclation.addCodeOp(BC.IALOAD);							// 要素をロード
//				_currentMethodCodeDeclation.addCodeOpISTORE(lTypeName._localVarNum);		// 変数に代入
//				break;
//			default:
//				throw new RuntimeException("other?");
//			}
//
//			// ブロック内の処理
//			visit(_forBlockContext);
//			// インデクスのインクリメント
//			_currentMethodCodeDeclation.addCodeOp(BC.IINC);
//			_currentMethodCodeDeclation.addCodeU1(indexTypeName._localVarNum);
//			_currentMethodCodeDeclation.addCodeU1(1);
//
//			// ブロック末尾に、条件判定に戻るジャンプ命令を追加する
//			int	blockEndPos = _currentMethodCodeDeclation.getCodePos();	   // ブロック終了バイト位置
//			int	jmpDistance = condPos - blockEndPos;
//			_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
//			_currentMethodCodeDeclation.addCodeU2(jmpDistance);
//
//			// 条件が満たされない場合のとび先を設定する
//			blockEndPos = _currentMethodCodeDeclation.getCodePos();
//			jmpDistance = blockEndPos - condBranchPos;
//			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, condBranchPos + 1);
//
//			// ブロック内の break 文のとび先を設定する
//			for (int breakPos : _controlBlockManager.getBreakPoss())
//			{
//				jmpDistance = blockEndPos - breakPos;
//				_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, breakPos + 1);
//			}
//		}
//		else if (expressionType._type == VarType.TYPE.OBJ && _cr.hasInterface(((ObjectType)expressionType)._fqcn, FQCNParser.getFQCN("java.lang.Iterable")))
//		{	// 集合要素はCollection
//			 // iterator()
//			_currentMethodCodeDeclation.addCodeOp(BC.INVOKEINTERFACE);
//			_currentMethodCodeDeclation.addCodeU2(_cpm.getIntergaceMethodRef("java.lang.Iterable", "iterator", "()Ljava.util.Iterator;"));
//
//			// iterator をローカルに保存
//			String	iteratorName = "$it" + ctx.hashCode();	// Pyriteコードで定義できない名称
//			VarTypeName	iteratorTypeName = _currentMethodCodeDeclation.putLocalVar(iteratorName, ObjectType.getType("java.util.Iterator"));
//			_currentMethodCodeDeclation.addCodeOpASTORE(iteratorTypeName._localVarNum);
//
//			// iterator.hasnext
//			int	condPos = _currentMethodCodeDeclation.getCodePos();			// 条件式バイト位置
//			_controlBlockManager.setContinuePos(condPos);					// continue で戻る位置を記憶
//			_currentMethodCodeDeclation.addCodeOp(BC.ALOAD);
//			_currentMethodCodeDeclation.addCodeU2(iteratorTypeName._localVarNum);
//			_currentMethodCodeDeclation.addCodeOp(BC.INVOKEINTERFACE);
//			_currentMethodCodeDeclation.addCodeU2(_cpm.getIntergaceMethodRef("java.util.Iterator", "hasNext", "()Z"));
//			int	condBranchPos = _currentMethodCodeDeclation.getCodePos();	  // 分岐命令バイト位置
//			_currentMethodCodeDeclation.addCodeOp(BC.IFEQ);
//			_currentMethodCodeDeclation.addCodeU2(0);	 // プレースホルダで置いておく
//
//			// iterator.next
//			_currentMethodCodeDeclation.addCodeOpALOAD(iteratorTypeName._localVarNum);
//			_currentMethodCodeDeclation.addCodeOp(BC.INVOKEINTERFACE);
//			_currentMethodCodeDeclation.addCodeU2(_cpm.getIntergaceMethodRef("java.util.Iterator", "next", "()Ljava/lang/Object;"));
//
//			// 変数に代入
//			_currentMethodCodeDeclation.addCodeOp(BC.CHECKCAST);
//			if (type._type != VarType.TYPE.OBJ)
//			{
//				// TODO:インターフェースや配列も許容？
//				throw new RuntimeException("checkcast");
//			}
//			_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(((ObjectType)type)._fqcn._fqcnStr));
//			_currentMethodCodeDeclation.addCodeOpASTORE(lTypeName._localVarNum);
//
//			// ブロック内の処理
//			visit(_forBlockContext);
//
//			// ブロック末尾に、条件判定に戻るジャンプ命令を追加する
//			int	blockEndPos = _currentMethodCodeDeclation.getCodePos();	   // ブロック終了バイト位置
//			int	jmpDistance = condPos - blockEndPos;
//			_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
//			_currentMethodCodeDeclation.addCodeU2(jmpDistance);
//
//			// 条件が満たされない場合のとび先を設定する
//			blockEndPos = _currentMethodCodeDeclation.getCodePos();
//			jmpDistance = blockEndPos - condBranchPos;
//			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, condBranchPos + 1);
//
//			// ブロック内の break 文のとび先を設定する
//			for (int breakPos : _controlBlockManager.getBreakPoss())
//			{
//				jmpDistance = blockEndPos - breakPos;
//				_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, breakPos + 1);
//			}
//		}
//		else
//		{
//			throw new PyriteSyntaxException("enumlation target is not collection");
//		}

		// stackをpopして終了
		_currentMethodCodeDeclation.popLocalVarStack();
		return	null;
	}





	// 'switch' parExpression '{' switchBlockStatementGroup* switchLabel* '}'
	@Override
	public Object visitStatementSwitch(@NotNull PyriteParser.StatementSwitchContext ctx)
	{
		_controlBlockManager.push(ControlBlockManager.TYPE.SWITCH, null);	// ラベルの有効範囲を設定(制御構文位置を一レベル深くする)

		// parExpression
		VarType	varType = (VarType)visit(ctx.parExpression());
		// type は int か str
		switch (varType._type)
		{
		case INT:
			break;
		case STR:
			throw new RuntimeException("not supported yet.");	// とりあえず未実装
		default:
			throw new PyriteSyntaxException("switch type unmatched.");
		}

		List<PyriteParser.SwitchBlockStatementGroupContext>	sbCtxList = ctx.switchBlockStatementGroup();
		if (sbCtxList.size() == 0)
		{	// ブロックコードが無い場合
			// stack に残っている parExpression の戻り値を除去して終了
			_currentMethodCodeDeclation.addCodeOp(BC.POP);
			_controlBlockManager.pop();	// 制御構文位置を一レベル浅く
			return	null;
		}


		// switchBlockStatementGroup
		List<SwitchBlock>	sbList = new ArrayList<SwitchBlock>();
		int	condBranchPos = _currentMethodCodeDeclation.getCodePos();	  // 分岐命令バイト位置
		_currentMethodCodeDeclation.addCodeOp(BC.LOOKUPSWITCH);
		_currentMethodCodeDeclation.addCodePadding();
		int	jumpTablePos = _currentMethodCodeDeclation.getCodePos();	// ジャンプテーブルバイト位置
		for (PyriteParser.SwitchBlockStatementGroupContext sbCtx : sbCtxList)
		{	// ブロック内のコード生成
			sbList.add((SwitchBlock)visit(sbCtx));
		}
		// 最後のcaseブロックの不要なジャンプコードを除去
		if (sbList.get(sbList.size() - 1)._isFallthrough == false)
		{
			_currentMethodCodeDeclation.removeCodeEnd(1 + 2);
		}
		int	switchEndPos = _currentMethodCodeDeclation.getCodePos();	// ここがcaseブロック最後のとび先
		// caseブロックのジャンプとび先を設定する (最後のcaseブロックには設定しない)
		for (int i = 0; i < sbList.size() - 1; ++i)
		{
			SwitchBlock	sblock = sbList.get(i);
			if (sblock._isFallthrough == false)
			{
				int	jmpDistance = switchEndPos - sblock._blockEndPos;
				_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, sblock._blockEndPos + 1);
			}
		}

		// switchLabel
		// ブロック末尾ラベル部分の解析
		List<SwitchCase>	caseList = new ArrayList<SwitchCase>();
		for (PyriteParser.SwitchLabelContext slctx : ctx.switchLabel())
		{
			caseList.add((SwitchCase)visit(slctx));
		}

		// ラベルの型・重複チェック
		Map<SwitchCase, SwitchBlock>	scMap = new HashMap<SwitchCase, SwitchBlock>();
		for (SwitchCase scase : caseList)
		{
			if (scase != SwitchCase.DEFAULT && scase._type != varType)
			{
				throw new PyriteSyntaxException("switch type unmatched.");
			}

			if (scMap.containsKey(scase))
			{	// 同じcase条件が存在する場合はエラー
				throw new PyriteSyntaxException("switch case duplicated.");
			}
			scMap.put(scase, null);
		}
		for (SwitchBlock sblock : sbList)
		{
			for (SwitchCase scase : sblock._caseList)
			{
				if (scase != SwitchCase.DEFAULT && scase._type != varType)
				{
					throw new PyriteSyntaxException("switch type unmatched.");
				}

				if (scMap.containsKey(scase))
				{	// 同じcase条件が存在する場合はエラー
					throw new PyriteSyntaxException("switch case duplicated.");
				}
				scMap.put(scase, sblock);
			}
		}

		// DEFAULT
		SwitchBlock	defaultBlock = scMap.remove(SwitchCase.DEFAULT);
		SwitchCase[]	cases = scMap.keySet().toArray(new SwitchCase[0]);
		int	jumpTableSize = 4 + 4 + cases.length * 4 * 2;
		Arrays.sort(cases);
		int[]	jumpTable = new int[jumpTableSize / 4];
		// DEFAULTのテーブル設定
		int	jumpDistinationPos = (defaultBlock != null) ? defaultBlock._blockStartPos : switchEndPos;
		int	jumpDistance = jumpDistinationPos + jumpTableSize - condBranchPos;
		jumpTable[0] = jumpDistance;
		jumpTable[1] = cases.length;
		// case のテーブル設定
		for (int i = 0; i < cases.length; ++i)
		{
			SwitchBlock	sblock = scMap.get(cases[i]);
			jumpDistinationPos = (sblock != null) ? sblock._blockStartPos : switchEndPos;
			jumpDistance = jumpDistinationPos + cases.length * 4 - condBranchPos;

			jumpTable[2 + i * 2] = cases[i]._n;
			jumpTable[2 + i * 2 + 1] = jumpDistance;
		}

		// ジャンプテーブルの挿入
		_currentMethodCodeDeclation.addCodeBlock(StringUtil.toByteList(jumpTable), jumpTablePos);

		_controlBlockManager.pop();	// 制御構文位置を一レベル浅く
		return	null;
	}

	// switchLabel+ statement+ (fallthrough='fallthrough' ';')?
	// return:SwitchBlock
	@Override
	public Object visitSwitchBlockStatementGroup(@NotNull PyriteParser.SwitchBlockStatementGroupContext ctx)
	{
		List<SwitchCase>	caseList = new ArrayList<SwitchCase>();
		for (PyriteParser.SwitchLabelContext slctx : ctx.switchLabel())
		{
			caseList.add((SwitchCase)visit(slctx));
		}

		int	blockStartPos = _currentMethodCodeDeclation.getCodePos();
		_currentMethodCodeDeclation.pushLocalVarStack();
		for (PyriteParser.StatementContext sctx : ctx.statement())
		{
			visit(sctx);
		}
		_currentMethodCodeDeclation.popLocalVarStack();

		// fallthrough
		boolean	isFallthrough = ctx.fallthrough != null;

		// switchの最後に飛ぶジャンプ命令
		int	blockEndPos = _currentMethodCodeDeclation.getCodePos();
		if (isFallthrough == false)
		{
			_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
			_currentMethodCodeDeclation.addCodeU2(0);	// プレースホルダで置いておく
		}

		return	new SwitchBlock(blockStartPos, blockEndPos, caseList, isFallthrough);
	}

	// 'case' integerLiteral ':'
	// return:SwitchCase
	@Override
	public Object visitSwitchLabelCaseInt(@NotNull PyriteParser.SwitchLabelCaseIntContext ctx)
	{
		String	literal = ctx.integerLiteral().getText();
		int	value = StringUtil.intLiteral(literal);
		// TODO:Hexなどにも対応する

		return	new SwitchCase(value);
	}

	// 'case' StringLiteral ':'
	// return:SwitchCase
	@Override
	public Object visitSwitchLabelCaseStr(@NotNull PyriteParser.SwitchLabelCaseStrContext ctx)
	{
		String	literal = ctx.stringLiteral().getText();
		literal = StringUtil.strLiteral(literal);

		return	new SwitchCase(literal);
	}


	// 'default' ':'
	@Override
	public Object visitSwitchLabelDefault(@NotNull PyriteParser.SwitchLabelDefaultContext ctx)
	{
		return	SwitchCase.DEFAULT;
	}



	// '(' expression ')'
	@Override
	public Object visitParExpression(@NotNull PyriteParser.ParExpressionContext ctx)
	{
		VarType	varType = (VarType)visit(ctx.expression());
//		varType = varType.resolveType(this);

		return	varType;
	}



	// Identifier
	@Override
	public Object visitPrimaryIdentifier(@NotNull PyriteParser.PrimaryIdentifierContext ctx)
	{
		ParseTree idNode = ctx.Identifier();
		String id = idNode.getText();
		VarType	varType;

		if (isLValueExpressionElement(ctx))
		{	// left expression
			// assign()で値設定するため、ここでコードは作成しない。
			// 代わりに設定情報を保持しておく。

			VarTypeName	varTypeName = _currentMethodCodeDeclation.getLocalVar(id);
			if (varTypeName != null)
			{	// local variable
				switch (varTypeName._type._type)
				{
				case INT:
					break;
				case BOL:
					break;
				case STR:
					break;
				case OBJ:
					break;
				default:
					throw new RuntimeException("assert:");
				}
				return	new LValueType(LValueType.TYPE.LOCAL, varTypeName._type, varTypeName._localVarNum);

//				cgv.setLeftExpressionVarType(1, varTypeName._localVarNum, null, null);
//				return	varTypeName._type;
//				return	new AssignLeftExpressionType(varTypeName._type, 1, varTypeName._localVarNum, null, null);
			}

			varType = _thisClassFieldMember._instanceFieldMap.get(id);
			if (varType != null)
			{	// instance field
				if (_currentMethodCodeDeclation._isStatic)
				{	// static メソッドで インスタンス変数は使用できない
					throw new PyriteSyntaxException("instance field is not usable at static context. ");
				}
				_currentMethodCodeDeclation.addCodeOp(BC.ALOAD_0);
				return	new LValueType(LValueType.TYPE.INSTANCE, varType, _cpm.getFieldRef(_fqcn._fqcnStr, id, varType._jvmExpression));

				//				cgv.setLeftExpressionVarType(2, -1, className, _id);
//				return	varType;
//				return	new AssignLeftExpressionType(varType, 2, -1, _fqcn._fqcnStr, id);
			}

			varType = _thisClassFieldMember._classFieldMap.get(id);
			if (varType != null)
			{	// class field
				return	new LValueType(LValueType.TYPE.CLASS, varType, _cpm.getFieldRef(_fqcn._fqcnStr, id, varType._jvmExpression));
//				cgv.setLeftExpressionVarType(3, -1, className, _id);
//				return	varType;
//				return	new AssignLeftExpressionType(varType, 3, -1, _fqcn._fqcnStr, id);
			}
		}
		else
		{
			if (id.equals("this"))
			{	// this
				if (_currentMethodCodeDeclation._isStatic)
				{	// static コンテキストで this キーワードは使用できない
					throw new PyriteSyntaxException("'this' is not usable at static context. ");
				}
				_currentMethodCodeDeclation.addCodeOp(BC.ALOAD_0);

				return	ObjectType.getType(_fqcn._fqcnStr);
			}

			// local variable
			VarTypeName	varTypeName = _currentMethodCodeDeclation.getLocalVar(id);
			if (varTypeName != null)
			{
				switch (varTypeName._type._type)
				{
				case OBJ:
				case NUM:
				case INT:
				case FLT:
				case STR:
				case CHR:
				case ARRAY:
				case ASSOC:
					_currentMethodCodeDeclation.addCodeOpALOAD(varTypeName._localVarNum);
					break;
				case BOL:
					_currentMethodCodeDeclation.addCodeOpILOAD(varTypeName._localVarNum);
					break;
				case BYT:
					throw new RuntimeException("not implemented.");
				default:
					throw new RuntimeException("assert:");
					}
				return	varTypeName._type;
			}

			if (_currentMethodCodeDeclation._isStatic)
			{
				// class field
				varType = _thisClassFieldMember._classFieldMap.get(id);
				if (varType != null)
				{
					_currentMethodCodeDeclation.addCodeOp(BC.GETSTATIC);
					_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(_fqcn._fqcnStr, id, varType._jvmExpression));
					return	varType;
				}

				// class method
				if (_thisClassFieldMember._classMethodNameSet.contains(id))
				{
					return	MethodNameType.getType(_fqcn, id, false);
				}

				// instance field / instance method
				varType = _thisClassFieldMember._instanceFieldMap.get(id);
				if (varType != null || _thisClassFieldMember._instanceMethodNameSet.contains(id))
				{
					throw new PyriteSyntaxException("instance field / method is not usable at static context. ");
				}
			}
			else
			{
				// instance field
				varType = _thisClassFieldMember._instanceFieldMap.get(id);
				if (varType != null)
				{
					_currentMethodCodeDeclation.addCodeOp(BC.ALOAD_0);
					_currentMethodCodeDeclation.addCodeOp(BC.GETFIELD);
					_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(_fqcn._fqcnStr, id, varType._jvmExpression));
					return	varType;
				}

				// instance method
				if (_thisClassFieldMember._instanceMethodNameSet.contains(id))
				{
					return	MethodNameType.getType(_fqcn, id, false);
				}

				// class field
				varType = _thisClassFieldMember._classFieldMap.get(id);
				if (varType != null)
				{
					_currentMethodCodeDeclation.addCodeOp(BC.GETSTATIC);
					_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(_fqcn._fqcnStr, id, varType._jvmExpression));
					return	varType;
				}

				// class method
				if (_thisClassFieldMember._classMethodNameSet.contains(id))
				{
					return	MethodNameType.getType(_fqcn, id, false);
				}
			}

			// class name
			FQCN	fqcn =  _idm.resolveClassName(id);
			if (fqcn != null)
			{
				return	ClassType.getType(fqcn);
			}

			// package name
			fqcn = FQCNParser.getFQCN("", id);
			if (_cr.isPackage(fqcn))
			{
				return	PackageType.getType(fqcn);
			}
		}

		throw new PyriteSyntaxException("id is not declared. id:" + id);
	}

	// IntegerLiteral
	@Override
	public Object visitIntegerLiteralDecimal(@NotNull PyriteParser.IntegerLiteralDecimalContext ctx)
	{
		String	literal = ctx.DecimalNumeral().getText();
		literal = StringUtil.removeUnderscore(literal);

		return	procInt(literal, 10);
	}

	@Override
	public Object visitIntegerLiteralHex(@NotNull PyriteParser.IntegerLiteralHexContext ctx)
	{
		String	literal = ctx.HexNumeral().getText();
		literal = StringUtil.removeUnderscore(literal);
		literal = literal.substring(2);	// 0xを除去

		return	procInt(literal, 16);
	}

	@Override
	public Object visitIntegerLiteralOctal(@NotNull PyriteParser.IntegerLiteralOctalContext ctx)
	{
		String	literal = ctx.OctalNumeral().getText();
		literal = StringUtil.removeUnderscore(literal);
		literal = literal.substring(2);	// 0cを除去

		return	procInt(literal, 8);
	}

	@Override
	public Object visitIntegerLiteralBinary(@NotNull PyriteParser.IntegerLiteralBinaryContext ctx)
	{
		String	literal = ctx.BinaryNumeral().getText();
		literal = StringUtil.removeUnderscore(literal);
		literal = literal.substring(2);	// 0bを除去

		return	procInt(literal, 2);
	}

	protected Object	procInt(String value, int radix)
	{
		// オブジェクト生成
		_currentMethodCodeDeclation.addCodeOp(BC.NEW);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(VarType.INT._fqcn._fqcnStr));
		_currentMethodCodeDeclation.addCodeOp(BC.DUP);

		// methodParameter
		addCodeLDC(value);
		assert (radix == 2 || radix == 8 || radix == 10 || radix == 16);
		_currentMethodCodeDeclation.addCodeOpBIPUSH(radix);

		// invoke constructor
		_currentMethodCodeDeclation.addCodeOp(BC.INVOKESPECIAL);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(VarType.INT._fqcn._fqcnStr, "<init>", "Ljava.lang.String;I"));

		return	VarType.INT;
	}

	// floatingPointLiteral   :   Digits? '.' Digits
	@Override
	public Object visitFloatingPointLiteral(@NotNull PyriteParser.FloatingPointLiteralContext ctx)
	{
		/*
		List<TerminalNode>	list = ctx.Digits();
		String	num;
		String	numUnderPoint;
		if (list.size() > 1)
		{
			num = list.get(0).getText();
			numUnderPoint = list.get(1).getText();
		}
		else
		{
			num = "0";
			numUnderPoint = list.get(0).getText();
		}
		num = StringUtil.removeUnderscore(num);
		numUnderPoint = StringUtil.removeUnderscore(numUnderPoint);
		 */
		String	literal = ctx.getText();
		literal = StringUtil.removeUnderscore(literal);

		// オブジェクト生成
		_currentMethodCodeDeclation.addCodeOp(BC.NEW);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(VarType.DEC._fqcn._fqcnStr));
		_currentMethodCodeDeclation.addCodeOp(BC.DUP);

		// methodParameter
		addCodeLDC(literal);

		// invoke constructor
		_currentMethodCodeDeclation.addCodeOp(BC.INVOKESPECIAL);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(VarType.DEC._fqcn._fqcnStr, "<init>", "Ljava.lang.String;"));

		return	VarType.DEC;
	}


	//	CharacterLiteral
    //	:   '\'' SingleCharacter '\''
    //	|   '\'' EscapeSequence '\''
	@Override
	public Object visitCharacterLiteral(@NotNull PyriteParser.CharacterLiteralContext ctx)
	{
		String	literal = ctx.getText();
		literal = StringUtil.stripEndChar(literal);

		assert(literal.length() >= 1);
		char	c = literal.charAt(0);
		if (c == '\\')
		{	// escape sequence
			// TODO
			throw new RuntimeException("not implemented");
		}
		else
		{
			// 直値の場合
//			addCodeIPush(c);

			// オブジェクト生成
			_currentMethodCodeDeclation.addCodeOp(BC.NEW);
			_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(VarType.CHR._fqcn._fqcnStr));
			_currentMethodCodeDeclation.addCodeOp(BC.DUP);

			// methodParameter
			addCodeIPush(c);

			// invoke constructor
			_currentMethodCodeDeclation.addCodeOp(BC.INVOKESPECIAL);
			_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(VarType.CHR._fqcn._fqcnStr, "<init>", "(C)V"));
		}

		return	VarType.CHR;
	}

	// StringLiteral
	@Override
	public Object visitStringLiteral(@NotNull PyriteParser.StringLiteralContext ctx)
	{
		String	literal = ctx.StringLiteral().getText();
		literal = StringUtil.strLiteral(literal);

		// 直値の場合
//		addCodeLDC(literal);

		// オブジェクト生成
		_currentMethodCodeDeclation.addCodeOp(BC.NEW);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(VarType.STR._fqcn._fqcnStr));
		_currentMethodCodeDeclation.addCodeOp(BC.DUP);

		// methodParameter
		addCodeLDC(literal);

		// invoke constructor
		_currentMethodCodeDeclation.addCodeOp(BC.INVOKESPECIAL);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(VarType.STR._fqcn._fqcnStr, "<init>", "(Ljava.lang.String;)V"));

		return	VarType.STR;
	}

	// BooleanLiteral
	@Override
	public Object visitBooleanLiteral(@NotNull PyriteParser.BooleanLiteralContext ctx)
	{
		String	fieldName;

		String	text = ctx.getText();
		if (text.equals("true"))
		{
			fieldName = "TRUE";		// pyrite.lang.Boolean.TRUE;
//			_currentMethodCodeDeclation.addCodeOp(BC.ICONST_1);
		}
		else if (text.equals("false"))
		{
			fieldName = "FALSE";	// pyrite.lang.Boolean.FALSE;
//			_currentMethodCodeDeclation.addCodeOp(BC.ICONST_0);
		}
		else
		{
			throw new RuntimeException("assert");
		}

		_currentMethodCodeDeclation.addCodeOp(BC.GETSTATIC);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(VarType.BOL._fqcn._fqcnStr, fieldName, VarType.BOL._jvmExpression));

		return	VarType.BOL;
	}

	// 'null'
	@Override
	public Object visitNullLiteral(@NotNull PyriteParser.NullLiteralContext ctx)
	{
		_currentMethodCodeDeclation.addCodeOp(BC.ACONST_NULL);

		return	VarType.NULL;
	}


	protected void	addCodeLDC(String literal)
	{
		int	num = _cpm.getString(literal);
		if (num <= 0xff)
		{
			_currentMethodCodeDeclation.addCodeOp(BC.LDC);
			_currentMethodCodeDeclation.addCodeU1(num);
		}
		else
		{
			_currentMethodCodeDeclation.addCodeOp(BC.LDC_W);
			_currentMethodCodeDeclation.addCodeU2(num);
		}
	}

	// memo
	// _currentMethodCodeDeclation に当メソッドを定義しない
	// ldc を使う場合、_cpm へのアクセスが発生するため
	protected void	addCodeIPush(int value)
	{
		// int をスタックに積む
		if (-128 <= value && value <= 127)
		{
			_currentMethodCodeDeclation.addCodeOpBIPUSH(value);
		}
		else if (-32768 <= value && value <= 32767)
		{
			_currentMethodCodeDeclation.addCodeOp(BC.SIPUSH);
			_currentMethodCodeDeclation.addCodeU2(value);
		}
		else
		{	// ldcを使う
			throw new RuntimeException("only small number supported.");
		}
	}


////	// Identifier '(' expressionList? ')'
////	@Override
////	public Object visitExprInvokeMethod(@NotNull PyriteParser.ExprInvokeMethodContext ctx)
////	{
////		// load System.out
////		int	fieldNum = _cpm.getFieldRef("java/lang/System", "out", "Ljava/io/PrintStream;");
////		_code.add(BC.GETSTATIC);
////		_code.add((byte)(fieldNum >> 8));
////		_code.add((byte)fieldNum);
////		_maxStack.push();
////
////		PyriteParser.ExpressionListContext	expressionListContext = ctx.expressionList();
////		if (expressionListContext == null)
////		{
////			// call System.out.println
////			int	methodNum = _cpm.getMethodRef("java/io/PrintStream", "println", "()V");
////			_code.add(BC.INVOKEVIRTUAL);
////			_code.add((byte)(methodNum >> 8));
////			_code.add((byte)methodNum);
////			_maxStack.pop();
////		}
////		else
////		{
////			List<Type> typeList = (List<Type>)visit(expressionListContext); // evaluate the expr child
////			if (typeList.size() > 1)
////			{
////				throw new RuntimeException("unsupported operation.");
////			}
////			Type	type = typeList.get(0);
////			String	param = "";
////			switch (type)
////			{
////			case Integer:
////				param = "(I)V";
////				break;
////
////			case String:
////				param = "(Ljava/lang/String;)V";
////				break;
////			}
////			// call System.out.println
////			int	methodNum = _cpm.getMethodRef("java/io/PrintStream", "println", param);
////			_code.add(BC.INVOKEVIRTUAL);
////			_code.add((byte)(methodNum >> 8));
////			_code.add((byte)methodNum);
////			_maxStack.pop();
////			_maxStack.pop();
////		}
////
////		return	null;
////	}
////
////	// expr (',' expr)*
////	@Override
////	public Object visitExpressionList(@NotNull PyriteParser.ExpressionListContext ctx)
////	{
////		List<Type>	typeList = new ArrayList<Type>();
////		List<ExprContext>	exprs = ctx.expr();
////
////		for (PyriteParser.ExprContext expr : exprs)
////		{
////			typeList.add((Type)visit(expr));
////		}
////
////		return	typeList;
////	}
//
//	/** stat+ */
//	@Override
//	public Object visitProgMain(PyriteParser.ProgMainContext ctx)
//	{
//		List<PyriteParser.StatContext>	stats = ctx.stat();
//
//		for (PyriteParser.StatContext stat : stats)
//		{
//			visit(stat);
//		}
//		_code.add(BC.RETURN);
//
//		return	null;
//	}
//
//
//
//
}
