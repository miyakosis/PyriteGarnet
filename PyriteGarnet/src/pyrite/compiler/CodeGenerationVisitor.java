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
import pyrite.compiler.type.AssignLeftExpressionType;
import pyrite.compiler.type.ClassType;
import pyrite.compiler.type.MethodType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.PackageType;
import pyrite.compiler.type.SwitchBlock;
import pyrite.compiler.type.SwitchCase;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarType.TYPE;
import pyrite.compiler.type.VarTypeName;
import pyrite.compiler.util.StringUtil;


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
		_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef("java/lang/Object", "<init>", "()V"));

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
				throw new RuntimeException("duplicated local variable");
			}
			_currentMethodCodeDeclation.putLocalVar(varTypeName._name, varTypeName._type);

		}
		for (VarTypeName varTypeName : outParamList)
		{
			if (varTypeName._name != null)
			{
				if (_currentMethodCodeDeclation.isDuplicatedLocalVar(varTypeName._name))
				{
					throw new RuntimeException("duplicated local variable");
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
	// expression '.' Identifier
	@Override
	public Object visitExpressionClassFieldRef(@NotNull PyriteParser.ExpressionClassFieldRefContext ctx)
	{
		VarType	expressionVarType = (VarType)visit(ctx.expression());
		String id = ctx.Identifier().getText();

		// 続く要素を解決する
		return	expressionVarType.resolveTrailerType(this, id);
	}


	// expression arguments
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
		// expression
		int	expressionCodePosFrom = _currentMethodCodeDeclation.getCodePos();	// レシーバのコード開始位置
		VarType	expressionVarType = (VarType)visit(ctx.expression());
		int	expressionCodePosTo = _currentMethodCodeDeclation.getCodePos();	// レシーバのコード終了位置
		// expressionVarType は PartialIdType の可能性があるため、型解決する
		expressionVarType = expressionVarType.resolveType(this);
		if (expressionVarType._type != TYPE.METHOD)
		{
			throw new RuntimeException("no such method");
		}
		MethodType	methodType = (MethodType)expressionVarType;

		// methodParameter
		List<VarType>	inputParamTypeList = (List<VarType>)visit(ctx.arguments());

		// メソッド定義・出力パラメータを解決
		methodType = _cr.dispatchMethodVarType(methodType, inputParamTypeList);
		if (methodType == null)
		{
			throw new RuntimeException("no such method");
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
		_currentMethodCodeDeclation.addCodeOp(opCode, methodType._paramTypes.length);
		_currentMethodCodeDeclation.addCodeU2(_cpm.getMethodRef(methodType._packageClassName, methodType._methodName, methodType._jvmMethodParamExpression));

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

		// 入力パラメータを解決
		// paramTypeList は PartialIdType の可能性があるため、型解決する
		// メソッド解決のために参照する入力パラメータの型情報
		List<VarType>	inputParamTypeList = new ArrayList<VarType>();
		for (VarType type : paramTypeList)
		{
			VarType	inputParamType = type.resolveType(this);

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

		return	inputParamTypeList;
	}




	// expression (',' expression)*
	@Override
	public Object visitExpressionList(@NotNull PyriteParser.ExpressionListContext ctx)
	{
		List<VarType>	typeList = new ArrayList<VarType>();
		List<PyriteParser.ExpressionContext>	exprs = ctx.expression();

		for (PyriteParser.ExpressionContext expr : exprs)
		{
			typeList.add((VarType)visit(expr));
		}

		return	typeList;
	}

	// 'new' creator
	@Override
	public Object visitExpressionNew(@NotNull PyriteParser.ExpressionNewContext ctx)
	{
		return visit(ctx.creator());
	}

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



	// expression '[' expression ']'
	@Override
	public Object visitExpressionArrayAccess(@NotNull PyriteParser.ExpressionArrayAccessContext ctx)
	{
		String s = ctx.getText() + " " + ctx.expression(0).getText() + " + " + ctx.expression(1).getText();

		VarType	expressionType = (VarType)visit(ctx.expression(0));
		expressionType = expressionType.resolveType(this);

		if (expressionType._type != TYPE.ARRAY)
		{
			throw new RuntimeException("expression must array.");
		}
		ArrayType	arrayType = (ArrayType)expressionType;

		VarType	indexType = (VarType)visit(ctx.expression(1));
		indexType = indexType.resolveType(this);

		if (indexType != VarType.INT)
		{
			throw new RuntimeException("array indexer must integer.");
		}

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


	// 親要素が代入かどうかを返す
	public static boolean	isParentAssignExpression(RuleContext ctx)
	{
		// 親要素が代入か、条件判定の場合は値を残す必要がある
		return	(ctx.parent instanceof PyriteParser.ExpressionAssignContext)
				|| (ctx.parent instanceof PyriteParser.ParExpressionContext );
	}

	// 自分が代入要素の左辺式かどうかを返す
	public boolean	isParentAssignLeftExpression(RuleContext ctx)
	{
		return	_isLeftExpression && isParentAssignExpression(ctx);
	}

	// expression op=('*'|'/') expression
	@Override
	public Object visitExpressionMulDiv(PyriteParser.ExpressionMulDivContext ctx)
	{
		VarType	lType = (VarType)visit(ctx.expression(0));	// get value of left subexpression
		lType = lType.resolveType(this);
		VarType	rType = (VarType)visit(ctx.expression(1));	// get value of right subexpression
		rType = rType.resolveType(this);

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
		VarType	lType = (VarType)visit(ctx.expression(0));	// get value of left subexpression
		lType = lType.resolveType(this);
		VarType	rType = (VarType)visit(ctx.expression(1));	// get value of right subexpression
		rType = rType.resolveType(this);

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
		lType = lType.resolveType(this);
		VarType	rType = (VarType)visit(ctx.expression(1));	// get value of right subexpression
		rType = rType.resolveType(this);

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
		lType = lType.resolveType(this);
		VarType	rType = (VarType)visit(ctx.expression(1));	// get value of right subexpression
		rType = rType.resolveType(this);

		if (lType._type != rType._type)
		{
			throw new RuntimeException("type different.");
		}

		byte op = 0x00;
		switch (lType._type)
		{
		case INT:
		case BOL:
			switch (ctx.op.getType())
			{
			case PyriteParser.EQUAL:	// -> NOTEQUAL
				op = BC.IF_ICMPNE;
				break;
			case PyriteParser.NOTEQUAL:	// -> EQUAL
				op = BC.IF_ICMPEQ;
				break;
			}
			break;

		default:
			throw new RuntimeException("unsupported operation.");
		}

		_currentMethodCodeDeclation.addCodeOp(op);
		_currentMethodCodeDeclation.addCodeU2(7);				// この文の末尾位置
		_currentMethodCodeDeclation.addCodeOp(BC.ICONST_1);
		_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
		_currentMethodCodeDeclation.addCodeU2(4);				// この文の末尾位置
		_currentMethodCodeDeclation.addCodeOp(BC.ICONST_0);

		return	VarType.BOL;
	}


	protected boolean	_isLeftExpression = false;	// true:左辺値の解析中 false:それ以外。右結合なので、状態は一つで管理できる。
	// 左辺値の場合は、式の最後の要素がローカル変数またはフィールドでなければならない。
	// また左辺値かどうかによって、式の最後の要素の式解析が異なる
	// ローカル変数参照
	//   左：ローカル変数への値設定(ローカル変数インデクスの取得) 右：ローカル変数参照(ローカル変数をスタックに積む)
	// フィールド参照
	//   左：フィールドへの値設定(スタックにオブジェクト参照を残したままにする) 右：ローカル変数参照(フィールドをスタックに詰む)
	protected String	_leftExpressionElement;	// 左辺値の右端の要素

	public boolean	isAssignLeftExpressionElement(String name)
	{
		return	_isLeftExpression && name.equals(_leftExpressionElement);
	}

//	// _isLeftExpression==true の際に、左辺値の型の情報を保持しておく
//	protected int	_assignType;	// 0:not assigned 1:local 2:instance field 3:class field 4:array
//	protected int	_assignLocalNum;	// _assignType = 1
//	protected String	_assignClassName;	// _assignType = 2, 3
//	protected String	_assignFieldName;	// _assignType = 2, 3
//
//	public void	setLeftExpressionVarType(int assignType, int localNum, String className, String fieldName)
//	{
//		_assignType = assignType;
//		_assignLocalNum = localNum;
//		_assignClassName = className;
//		_assignFieldName = fieldName;
//	}

	public void	createAssignCode(AssignLeftExpressionType assignLeftType, VarType rType, boolean isParentAssignExpression)
	{
		VarType lType = assignLeftType._type;
		if (lType._type != rType._type)
		{
			throw new RuntimeException("assign type unmached.");
		}

		switch (assignLeftType._assignType)
		{
		case 0:
			throw new RuntimeException("left variable is not suitable.");
		case 1:
			if (isParentAssignExpression)
			{
				// 値設定後にスタック上から設定値が消えてしまうが、式の値として設定値を返すために、スタック上の値を複製しておく
				_currentMethodCodeDeclation.addCodeOp(BC.DUP);
			}

			switch (lType._type)
			{
			case INT:
			case BOL:
				_currentMethodCodeDeclation.addCodeOpISTORE(assignLeftType._assignLocalNum);
				break;

			default:
				_currentMethodCodeDeclation.addCodeOpASTORE(assignLeftType._assignLocalNum);
				break;
			}
			break;

		case 2:
			if (isParentAssignExpression)
			{
				// 値設定後にスタック上から設定値が消えてしまうが、式の値として設定値を返すために、スタック上の値を複製しておく
				_currentMethodCodeDeclation.addCodeOp(BC.DUP_X1);
			}

			_currentMethodCodeDeclation.addCodeOp(BC.PUTFIELD);
			_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(assignLeftType._assignClassName, assignLeftType._assignFieldName, lType._jvmExpression));
			break;

		case 3:
			if (isParentAssignExpression)
			{
				// 値設定後にスタック上から設定値が消えてしまうが、式の値として設定値を返すために、スタック上の値を複製しておく
				_currentMethodCodeDeclation.addCodeOp(BC.DUP);
			}

			_currentMethodCodeDeclation.addCodeOp(BC.PUTSTATIC);
			_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(assignLeftType._assignClassName, assignLeftType._assignFieldName, lType._jvmExpression));
			break;

		case 4:
			if (isParentAssignExpression)
			{
				// 値設定後にスタック上から設定値が消えてしまうが、式の値として設定値を返すために、スタック上の値を複製しておく
				_currentMethodCodeDeclation.addCodeOp(BC.DUP_X2);
			}

			switch (lType._type)
			{
			case INT:
				_currentMethodCodeDeclation.addCodeOp(BC.IASTORE);
				break;

			case BOL:
				_currentMethodCodeDeclation.addCodeOp(BC.BASTORE);
				break;

			default:
				_currentMethodCodeDeclation.addCodeOp(BC.AASTORE);
				break;
			}
			break;
		}
	}

	// <assoc=right> expression '=' expression
	@Override
	public Object visitExpressionAssign(PyriteParser.ExpressionAssignContext ctx)
	{
		MethodCodeDeclation	methodDeclaretion = _currentMethodCodeDeclation;

		// 左辺値
		_isLeftExpression = true;
//		_assignType = 0;
		// 識別子最後の要素を取得しておく
		String	leftExpressionText = ctx.expression(0).getText();
		int	lastElementPos = leftExpressionText.lastIndexOf('.');
		_leftExpressionElement = leftExpressionText.substring(lastElementPos + 1);
		VarType	lType = (VarType)visit(ctx.expression(0));	// get value of left subexpression

		AssignLeftExpressionType	assignLeftType = (AssignLeftExpressionType)lType.resolveType(this);
//		lType._type = lType._type.resolveType(this);
		_isLeftExpression = false;

		// 右辺値
		VarType	rType = (VarType)visit(ctx.expression(1));	// get value of right subexpression
		rType = rType.resolveType(this);

		// assign
		createAssignCode(assignLeftType, rType, isParentAssignExpression(ctx));

		return	assignLeftType._type;
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
		for (VarType type : paramTypeList)
		{
			VarType	inputParamType = type.resolveType(this);

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


	// label 'while' parExpression block
	@Override
	public Object visitStatementWhile(@NotNull PyriteParser.StatementWhileContext ctx)
	{
		String	label = (String)visit(ctx.label());
		_controlBlockManager.push(ControlBlockManager.TYPE.LOOP, label);	// 制御構文位置を一レベル深くする

		// 条件節
		int	condPos = _currentMethodCodeDeclation.getCodePos();			  // 条件式バイト位置
		VarType	varType = (VarType)visit(ctx.parExpression());
		if (varType != VarType.BOL)
		{
			throw new PyriteSyntaxException("condition must be boolean.");
		}

		int	condBranchPos = _currentMethodCodeDeclation.getCodePos();	  // 分岐命令バイト位置
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
		_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, condBranchPos + 1);

		// ブロック内の break 文のとび先を設定する
		for (int breakPos : _controlBlockManager.getBreakPoss())
		{
			jmpDistance = blockEndPos - breakPos;
			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, breakPos + 1);
		}

		_controlBlockManager.pop();	// 制御構文位置を一レベル浅く
		return	null;
	}

	// for文のブロック
	private PyriteParser.BlockContext	_forBlockContext;
	// label 'for' '(' forControl ')' block
	@Override
	public Object visitStatementFor(@NotNull PyriteParser.StatementForContext ctx)
	{
		String	label = (String)visit(ctx.label());
		_controlBlockManager.push(ControlBlockManager.TYPE.LOOP, label);	// 制御構文位置を一レベル深くする

		_forBlockContext = ctx.block();
		visit(ctx.forControl());

		_controlBlockManager.pop();	// 制御構文位置を一レベル浅く
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
		_controlBlockManager.setContinuePos(condPos);					// continue で戻る位置を記憶
		VarType	 expressionType = (VarType)visit(ctx.expression());
		int	condBranchPos = -1;			// 条件が満たされない場合のジャンプ命令位置。条件が無い場合は -1
		if (expressionType != null)
		{
			if (expressionType != VarType.BOL)
			{
				throw new PyriteSyntaxException("condition must be boolean.");
			}
			condBranchPos = _currentMethodCodeDeclation.getCodePos();	  // 条件が満たされない場合のジャンプ命令
			_currentMethodCodeDeclation.addCodeOp(BC.IFEQ);
			_currentMethodCodeDeclation.addCodeU2(0);	 // プレースホルダで置いておく
		}

		// ブロック本体
		visit(_forBlockContext);
		visit(ctx.forUpdate());
		// ブロック末尾に、条件判定に戻るジャンプ命令を追加する
		int	blockEndPos = _currentMethodCodeDeclation.getCodePos();	   // ブロック終了バイト位置
		int	jmpDistance = condPos - blockEndPos;
		_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
		_currentMethodCodeDeclation.addCodeU2(jmpDistance);

		if (condBranchPos >= 0)
		{	// 条件がある場合は、条件が満たされない場合のとび先を設定する
			blockEndPos = _currentMethodCodeDeclation.getCodePos();
			jmpDistance = blockEndPos - condBranchPos;
			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, condBranchPos + 1);
		}

		// ブロック内の break 文のとび先を設定する
		for (int breakPos : _controlBlockManager.getBreakPoss())
		{
			jmpDistance = blockEndPos - breakPos;
			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, breakPos + 1);
		}

		// stackをpopして終了
		_currentMethodCodeDeclation.popLocalVarStack();
		return	null;
	}

	// type Identifier ':' expression
	@Override
	public Object visitForControlIterator(@NotNull PyriteParser.ForControlIteratorContext ctx)
	{
		// 定義した変数を for 文の有効範囲で生かす
		_currentMethodCodeDeclation.pushLocalVarStack();

		// 変数定義
		VarType	type = (VarType)visit(ctx.type());
		String	id = ctx.Identifier().getText();

		if (_currentMethodCodeDeclation.isDuplicatedLocalVar(id))
		{
			throw new RuntimeException("duplicated local variable");
		}
		VarTypeName	lTypeName = _currentMethodCodeDeclation.putLocalVar(id, type);

		// 集合要素
		VarType	expressionType = (VarType)visit(ctx.expression());
		expressionType = expressionType.resolveType(this);

		if (expressionType._type == VarType.TYPE.ARRAY)
		{	// 集合要素は配列
			if (type._type != expressionType._type)
			{
				throw new PyriteSyntaxException("type is unmatched.");
			}

			// 集合要素を一度ローカル変数に保持
			String	collectionName = "$" + ctx.hashCode();	// Pyriteコードで定義できない名称
			VarTypeName	collectionTypeName = _currentMethodCodeDeclation.putLocalVar(collectionName, expressionType);
			AssignLeftExpressionType	assignCollectionType = new AssignLeftExpressionType(expressionType, collectionTypeName._localVarNum);
			createAssignCode(assignCollectionType, expressionType, false);

			// 集合要素の長さを取得、ローカル変数に保持
			String	collectionLengthName = "$l" + ctx.hashCode();	// Pyriteコードで定義できない名称
			VarTypeName	collectionLengthTypeName = _currentMethodCodeDeclation.putLocalVar(collectionLengthName, VarType.INT);
			_currentMethodCodeDeclation.addCodeOpALOAD(collectionTypeName._localVarNum);
			_currentMethodCodeDeclation.addCodeOp(BC.ARRAYLENGTH);
			_currentMethodCodeDeclation.addCodeOpISTORE(collectionLengthTypeName._localVarNum);

			// インデクス変数を定義し、0で初期化する
			String	indexName = "$i" + ctx.hashCode();	// Pyriteコードで定義できない名称
			VarTypeName	indexTypeName = _currentMethodCodeDeclation.putLocalVar(indexName, VarType.INT);
			_currentMethodCodeDeclation.addCodeOp(BC.ICONST_0);
			_currentMethodCodeDeclation.addCodeOpISTORE(indexTypeName._localVarNum);

			// インデクスと配列長の比較を行う
			int	condPos = _currentMethodCodeDeclation.getCodePos();			// 条件式バイト位置
			_controlBlockManager.setContinuePos(condPos);					// continue で戻る位置を記憶
			_currentMethodCodeDeclation.addCodeOpILOAD(indexTypeName._localVarNum);
			_currentMethodCodeDeclation.addCodeOpILOAD(collectionLengthTypeName._localVarNum);
			int	condBranchPos = _currentMethodCodeDeclation.getCodePos();	  // 分岐命令バイト位置
			_currentMethodCodeDeclation.addCodeOp(BC.IF_ICMPGE);
			_currentMethodCodeDeclation.addCodeU2(0);	 // プレースホルダで置いておく

			// 変数に代入
			_currentMethodCodeDeclation.addCodeOpALOAD(collectionTypeName._localVarNum);	// 配列をロード
			_currentMethodCodeDeclation.addCodeOpILOAD(indexTypeName._localVarNum);
			switch (type._type)
			{
			case STR:
			case OBJ:
				_currentMethodCodeDeclation.addCodeOp(BC.AALOAD);							// 要素をロード
				_currentMethodCodeDeclation.addCodeOpASTORE(lTypeName._localVarNum);		// 変数に代入
				break;
			case INT:
				_currentMethodCodeDeclation.addCodeOp(BC.IALOAD);							// 要素をロード
				_currentMethodCodeDeclation.addCodeOpISTORE(lTypeName._localVarNum);		// 変数に代入
				break;
			default:
				throw new RuntimeException("other?");
			}

			// ブロック内の処理
			visit(_forBlockContext);
			// インデクスのインクリメント
			_currentMethodCodeDeclation.addCodeOp(BC.IINC);
			_currentMethodCodeDeclation.addCodeU1(indexTypeName._localVarNum);
			_currentMethodCodeDeclation.addCodeU1(1);

			// ブロック末尾に、条件判定に戻るジャンプ命令を追加する
			int	blockEndPos = _currentMethodCodeDeclation.getCodePos();	   // ブロック終了バイト位置
			int	jmpDistance = condPos - blockEndPos;
			_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
			_currentMethodCodeDeclation.addCodeU2(jmpDistance);

			// 条件が満たされない場合のとび先を設定する
			blockEndPos = _currentMethodCodeDeclation.getCodePos();
			jmpDistance = blockEndPos - condBranchPos;
			_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, condBranchPos + 1);

			// ブロック内の break 文のとび先を設定する
			for (int breakPos : _controlBlockManager.getBreakPoss())
			{
				jmpDistance = blockEndPos - breakPos;
				_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, breakPos + 1);
			}
		}
		else if (expressionType._type == VarType.TYPE.OBJ && _cr.hasInterface(((ObjectType)expressionType)._packageClassName, "java.lang.Iterable"))
		{	// 集合要素はCollection
			 // iterator()
			_currentMethodCodeDeclation.addCodeOp(BC.INVOKEINTERFACE);
			_currentMethodCodeDeclation.addCodeU2(_cpm.getIntergaceMethodRef("java.lang.Iterable", "iterator", "()Ljava.util.Iterator;"));

			// iterator をローカルに保存
			String	iteratorName = "$it" + ctx.hashCode();	// Pyriteコードで定義できない名称
			VarTypeName	iteratorTypeName = _currentMethodCodeDeclation.putLocalVar(iteratorName, ObjectType.getType("java.util.Iterator"));
			_currentMethodCodeDeclation.addCodeOpASTORE(iteratorTypeName._localVarNum);

			// iterator.hasnext
			int	condPos = _currentMethodCodeDeclation.getCodePos();			// 条件式バイト位置
			_controlBlockManager.setContinuePos(condPos);					// continue で戻る位置を記憶
			_currentMethodCodeDeclation.addCodeOp(BC.ALOAD);
			_currentMethodCodeDeclation.addCodeU2(iteratorTypeName._localVarNum);
			_currentMethodCodeDeclation.addCodeOp(BC.INVOKEINTERFACE);
			_currentMethodCodeDeclation.addCodeU2(_cpm.getIntergaceMethodRef("java.util.Iterator", "hasNext", "()Z"));
			int	condBranchPos = _currentMethodCodeDeclation.getCodePos();	  // 分岐命令バイト位置
			_currentMethodCodeDeclation.addCodeOp(BC.IFEQ);
			_currentMethodCodeDeclation.addCodeU2(0);	 // プレースホルダで置いておく

			// iterator.next
			_currentMethodCodeDeclation.addCodeOpALOAD(iteratorTypeName._localVarNum);
			_currentMethodCodeDeclation.addCodeOp(BC.INVOKEINTERFACE);
			_currentMethodCodeDeclation.addCodeU2(_cpm.getIntergaceMethodRef("java.util.Iterator", "next", "()Ljava/lang/Object;"));

			// 変数に代入
			_currentMethodCodeDeclation.addCodeOp(BC.CHECKCAST);
			if (type._type != VarType.TYPE.OBJ)
			{
				// TODO:インターフェースや配列も許容？
				throw new RuntimeException("checkcast");
			}
			_currentMethodCodeDeclation.addCodeU2(_cpm.getClassRef(((ObjectType)type)._packageClassName));
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

			// ブロック内の break 文のとび先を設定する
			for (int breakPos : _controlBlockManager.getBreakPoss())
			{
				jmpDistance = blockEndPos - breakPos;
				_currentMethodCodeDeclation.replaceCodeU2(jmpDistance, breakPos + 1);
			}
		}
		else
		{
			throw new PyriteSyntaxException("enumlation target is not collection");
		}

		// stackをpopして終了
		_currentMethodCodeDeclation.popLocalVarStack();
		return	null;
	}





	// 'switch' parExpression '{' switchBlockStatementGroup* switchLabel* '}'
	@Override
	public Object visitStatementSwitch(@NotNull PyriteParser.StatementSwitchContext ctx)
	{
		_controlBlockManager.push(ControlBlockManager.TYPE.SWITCH, null);	// 制御構文位置を一レベル深くする

		VarType	varType = (VarType)visit(ctx.parExpression());
		// type は int か str
		switch (varType._type)
		{
		case INT:
			break;
		case STR:
			throw new RuntimeException("not supported yet.");	// Expressionを許可するかもしれないので、とりあえず未実装
		default:
			throw new PyriteSyntaxException("switch type unmatched.");
		}

		List<PyriteParser.SwitchBlockStatementGroupContext>	sbCtxList = ctx.switchBlockStatementGroup();
		if (sbCtxList.size() == 0)
		{	// ブロックコードが無い場合
			// stack に残っている parExpression の戻り値を除去して終了
			_currentMethodCodeDeclation.addCodeOp(BC.POP);
			return	null;
		}

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

	// switchLabel+ blockStatement+ ('fallthrough' ';')?
	// return:SwitchCase
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
		for (PyriteParser.BlockStatementContext bsctx : ctx.blockStatement())
		{
			visit(bsctx);
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



	// 'break' label ';'
	@Override
	public Object visitStatementBreak(@NotNull PyriteParser.StatementBreakContext ctx)
	{
		String	label = (String)visit(ctx.label());

		int	blockEndPos = _currentMethodCodeDeclation.getCodePos();	   // 現在の命令バイト位置
		_controlBlockManager.setBreakPos(label, blockEndPos);
		_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
		_currentMethodCodeDeclation.addCodeU2(0);	// プレースホルダ

		return	null;
	}

	// 'continue' Identifier? ';'
	@Override
	public Object visitStatementContinue(@NotNull PyriteParser.StatementContinueContext ctx)
	{
		String	label = (String)visit(ctx.label());

		int	blockEndPos = _currentMethodCodeDeclation.getCodePos();	   // 現在の命令バイト位置
		int	condPos = _controlBlockManager.getContinuePos(label);
		int	jmpDistance = condPos - blockEndPos;
		_currentMethodCodeDeclation.addCodeOp(BC.GOTO);
		_currentMethodCodeDeclation.addCodeU2(jmpDistance);

		return	null;
	}


	// '(' expression ')'
	@Override
	public Object visitParExpression(@NotNull PyriteParser.ParExpressionContext ctx)
	{
		VarType	varType = (VarType)visit(ctx.expression());
		varType = varType.resolveType(this);

		return	varType;
	}



	// Identifier
	@Override
	public Object visitPrimaryIdentifier(@NotNull PyriteParser.PrimaryIdentifierContext ctx)
	{
		String id = ctx.Identifier().getText();
		VarType	varType;

		if (isAssignLeftExpressionElement(id))
		{	// left expression
			// assign()で値設定するため、ここでコードは作成しない。
			// 代わりに setLeftExpressionVarType() を呼び出し、設定情報を保持しておく。

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

//				cgv.setLeftExpressionVarType(1, varTypeName._localVarNum, null, null);
//				return	varTypeName._type;

				return	new AssignLeftExpressionType(varTypeName._type, 1, varTypeName._localVarNum, null, null);
			}

			varType = _thisClassFieldMember._instanceFieldMap.get(id);
			if (varType != null)
			{	// instance field
				if (_currentMethodCodeDeclation._isStatic)
				{	// static メソッドで インスタンス変数は使用できない
					throw new PyriteSyntaxException("'this' is not usable at static context. ");
				}
				_currentMethodCodeDeclation.addCodeOp(BC.ALOAD_0);
//				cgv.setLeftExpressionVarType(2, -1, className, _id);
//				return	varType;

				return	new AssignLeftExpressionType(varType, 2, -1, _fqcn._fqcnStr, id);
			}

			varType = _thisClassFieldMember._classFieldMap.get(id);
			if (varType != null)
			{	// class field
//				cgv.setLeftExpressionVarType(3, -1, className, _id);
//				return	varType;

				return	new AssignLeftExpressionType(varType, 3, -1, _fqcn._fqcnStr, id);
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

			VarTypeName	varTypeName = _currentMethodCodeDeclation.getLocalVar(id);
			if (varTypeName != null)
			{	// local variable
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

			varType = _thisClassFieldMember._instanceFieldMap.get(id);
			if (varType != null)
			{	// instance field
				if (_currentMethodCodeDeclation._isStatic)
				{	// static メソッドで インスタンス変数は使用できない
					throw new PyriteSyntaxException("'this' is not usable at static context. ");
				}

				_currentMethodCodeDeclation.addCodeOp(BC.ALOAD_0);
				_currentMethodCodeDeclation.addCodeOp(BC.GETFIELD);
				_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(_fqcn._fqcnStr, id, varType._jvmExpression));

				return	varType;
			}

			varType = _thisClassFieldMember._classFieldMap.get(id);
			if (varType != null)
			{	// class field
				_currentMethodCodeDeclation.addCodeOp(BC.GETSTATIC);
				_currentMethodCodeDeclation.addCodeU2(_cpm.getFieldRef(_fqcn._fqcnStr, id, varType._jvmExpression));
				return	varType;
			}

			String[]	packageClassName = _idm.resolveClassName("", id);
			if (packageClassName != null)
			{	// class name
				return	ClassType.getType(packageClassName[0], packageClassName[1]);
			}

			if (_cr.isPackage("", id))
			{	// package name
				return	PackageType.getType("", id);
			}

			// 同名のクラスメソッド・インスタンスメソッドが存在しないので、順不同
			varType = _thisClassFieldMember._classMethodNameMap.get(id);
			if (varType != null)
			{	// class method
				return	varType;
			}

			varType = _thisClassFieldMember._instanceMethodNameMap.get(id);
			if (varType != null)
			{	// instance method
				if (_currentMethodCodeDeclation._isStatic)
				{	// static メソッドで インスタンスメソッドは使用できない
					throw new RuntimeException("this is not usable at static context. ");
				}
				_currentMethodCodeDeclation.addCodeOp(BC.ALOAD_0);
				return	varType;
			}
		}

		throw new PyriteSyntaxException("id is not declared. id:" + id);
	}

	// IntegerLiteral
	@Override
	public Object visitIntegerLiteralDecimal(@NotNull PyriteParser.IntegerLiteralDecimalContext ctx)
	{
		String	literal = ctx.DecimalNumeral().getText();
		int	value = StringUtil.intLiteral(literal);
		return	procInt(value);
	}

	@Override
	public Object visitIntegerLiteralHex(@NotNull PyriteParser.IntegerLiteralHexContext ctx)
	{
		String	literal = ctx.HexNumeral().getText();
		literal = StringUtil.removeUnderscore(literal);
		literal = literal.substring(2);	// 0xを除去

		int	value = Integer.parseInt(literal, 16);
		return	procInt(value);
	}

	@Override
	public Object visitIntegerLiteralOctal(@NotNull PyriteParser.IntegerLiteralOctalContext ctx)
	{
		String	literal = ctx.OctalNumeral().getText();
		literal = StringUtil.removeUnderscore(literal);
		literal = literal.substring(2);	// 0cを除去

		int	value = Integer.parseInt(literal, 8);
		return	procInt(value);
	}

	@Override
	public Object visitIntegerLiteralBinary(@NotNull PyriteParser.IntegerLiteralBinaryContext ctx)
	{
		String	literal = ctx.BinaryNumeral().getText();
		literal = StringUtil.removeUnderscore(literal);
		literal = literal.substring(2);	// 0bを除去

		int	value = Integer.parseInt(literal, 2);
		return	procInt(value);
	}

	protected Object	procInt(int value)
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

		return	VarType.INT;
	}

	// floatingPointLiteral   :   Digits? '.' Digits
	@Override
	public Object visitFloatingPointLiteral(@NotNull PyriteParser.FloatingPointLiteralContext ctx)
	{
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

		// TODO
		throw new RuntimeException("not implemented");
	}


	//	CharacterLiteral
    //	:   '\'' SingleCharacter '\''
    //	|   '\'' EscapeSequence '\''
	@Override
	public Object visitCharacterLiteral(@NotNull PyriteParser.CharacterLiteralContext ctx)
	{
		// TODO
		throw new RuntimeException("not implemented");
	}

	// StringLiteral
	@Override
	public Object visitStringLiteral(@NotNull PyriteParser.StringLiteralContext ctx)
	{
		String	literal = ctx.StringLiteral().getText();
		literal = StringUtil.strLiteral(literal);

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

		return	VarType.STR;
	}

	// BooleanLiteral
	@Override
	public Object visitBooleanLiteral(@NotNull PyriteParser.BooleanLiteralContext ctx)
	{
		String	text = ctx.getText();
		if (text.equals("true"))
		{
			_currentMethodCodeDeclation.addCodeOp(BC.ICONST_1);
		}
		else
		{
			_currentMethodCodeDeclation.addCodeOp(BC.ICONST_0);
		}

		return	VarType.BOL;
	}

	// 'null'
	@Override
	public Object visitNullLiteral(@NotNull PyriteParser.NullLiteralContext ctx)
	{
		_currentMethodCodeDeclation.addCodeOp(BC.ACONST_NULL);

		return	VarType.NULL;
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
