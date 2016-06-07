package pyrite.compiler.type;

import pyrite.compiler.FQCNParser.FQCN;

// メソッド解決のため、メソッド名称の存在のみを保持するクラス
public class MethodNameType extends VarType
{
//	public final FQCN	_fqcn;		// メソッドが所属するクラス
	public final String	_methodName;
	public final boolean	_isStatic;	// true:class method のみ有効 false:class method/instance method のどちらでもよい

	public static VarType	getType(FQCN fqcn, String methodName, boolean isStatic)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("METHOD_NAME:").append(fqcn._fqcnStr).append(".").append(methodName).append(":").append(isStatic);

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			varType = new MethodNameType(typeId, fqcn, methodName, isStatic);
		}

		return	varType;
	}

	protected MethodNameType(String typeId, FQCN fqcn, String methodName, boolean isStatic)
	{
		super(TYPE.METHOD_NAME, typeId, fqcn, null);

//		_fqcn = fqcn;
		_methodName = methodName;
		_isStatic = isStatic;
	}
}
