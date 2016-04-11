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

// CodeGenerationVisitor に移動
//	// この型に続く識別子の型を解決する。
//	//   Class.Class	// inner class。not implemented.
//	//   Class.Class field
//	//   Class.Class method
//	@Override
//	public VarType	resolveTrailerType(CodeGenerationVisitor cgv, ParseTree idNode)
//	{
//		ClassResolver	cr = cgv._cr;
//		ConstantPoolManager	cpm = cgv._cpm;
//		MethodCodeDeclation	methodDeclaretion = cgv._currentMethodCodeDeclation;
//
//		String	id = idNode.getText();
//		VarType	varType;
//		varType = cr.dispatchVariableC(_fqcn, id);
//		if (varType != null)
//		{	// クラス変数
//
//			// code
//			if (cgv.isAssignLeftExpressionElement(idNode))
//			{	// assign
//				// assign()で値設定するため、ここでコードは作成しない。
//				// 代わりに setLeftExpressionVarType() を呼び出し、設定情報を保持しておく。
////				cgv.setLeftExpressionVarType(3, -1, packageClassName, id);
//
//				return	new AssignLeftExpressionType(varType, 3, -1, _fqcn._fqcnStr, id);
//			}
//			else
//			{
//				methodDeclaretion.addCodeOp(BC.GETSTATIC);
//				methodDeclaretion.addCodeU2(cpm.getFieldRef(_fqcn._fqcnStr, id, varType._jvmExpression));
//			}
//
//			return	varType;
//		}
//
//		if (cr.existsMethodC(_fqcn, id))
//		{	// クラスメソッド
//			return	MethodNameType.getType(_fqcn, id, true);
//		}
//
//		// TODO:クラス.クラスはとりあえず未サポート
//		throw new RuntimeException("id is not declared. " + id);
//	}

//	// TODO:メソッドの存在を確認する
//	// 配列次元数の差分の型を返す
//	@Override
//	public VarType	getArrayType(int addNArrayLevel)
//	{
//		assert (_nArrayLevel + addNArrayLevel >= 0);
//		return	getType(_packageName, _className, _nArrayLevel + addNArrayLevel);
//	}
}
