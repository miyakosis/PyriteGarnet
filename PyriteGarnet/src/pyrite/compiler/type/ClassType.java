package pyrite.compiler.type;

import pyrite.compiler.FQCNParser.FQCN;


public class ClassType extends VarType
{
	public final FQCN	_fqcn;

	public static VarType	getType(FQCN fqcn)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("CLASS:").append(fqcn._fqcnStr);

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			varType = new ClassType(typeId, fqcn);
		}

		return	varType;
	}

	protected ClassType(String typeId, FQCN fqcn)
	{
		super(TYPE.CLASS, typeId, null);

		_fqcn = fqcn;
	}

	/*
	// (自分の型, 続く型)
	//       (変数, そのクラスのインスタンス変数 | クラス変数 | インスタンスメソッド | クラスメソッド)
	//       (クラス, クラス変数 | クラスメソッド),
	//       (クラス, クラス),
	//       (パッケージ, クラス)
	//       (パッケージ, パッケージ)
	@Override
	public VarType	resolveTrailerType(CodeGenerationVisitor cgv, String id)
	{
		ClassResolver	cr = cgv._cr;
		ConstantPoolManager	cpm = cgv._cpm;
		MethodCodeDeclation	methodDeclaretion = cgv._currentMethodCodeDeclation;

		VarType	varType;
		String	packageClassName = StringUtil.concat(_packageName, _className);

		varType = cr.dispatchVariableC(packageClassName, id);
		if (varType != null)
		{	// クラス変数

			// code
			if (cgv.isAssignLeftExpressionElement(id))
			{	// assign
				// assign()で値設定するため、ここでコードは作成しない。
				// 代わりに setLeftExpressionVarType() を呼び出し、設定情報を保持しておく。
//				cgv.setLeftExpressionVarType(3, -1, packageClassName, id);

				return	new AssignLeftExpressionType(varType, 3, -1, packageClassName, id);
			}
			else
			{
				methodDeclaretion.addCodeOp(BC.GETSTATIC);
				methodDeclaretion.addCodeU2(cpm.getFieldRef(packageClassName, id, varType._jvmExpression));
			}

			return	varType;
		}

		varType = cr.dispatchMethodC(packageClassName, id);
		if (varType != null)
		{	// クラスメソッド
			return	varType;
		}

		// TODO:クラス.クラスはとりあえず未サポート
		throw new RuntimeException("id is not declared. " + id);
	}
	*/

//	// TODO:メソッドの存在を確認する
//	// 配列次元数の差分の型を返す
//	@Override
//	public VarType	getArrayType(int addNArrayLevel)
//	{
//		assert (_nArrayLevel + addNArrayLevel >= 0);
//		return	getType(_packageName, _className, _nArrayLevel + addNArrayLevel);
//	}
}
