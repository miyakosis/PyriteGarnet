package pyrite.compiler.type;

import pyrite.compiler.CodeGenerationVisitor;

// Javaとのインターフェースをとるためのクラス
// jvmExpression : pyriteType = N : 1 の関係である。
// そのため、jvmExpression でhashCode を決定することができる。
public class JVMType extends VarType
{
	private final VarType	_pyriteType;

	public static VarType	getType(VarType pyriteType, String jvmExpression)
	{
		int	hashCode = createHashCode(TYPE.JVM_TYPE, jvmExpression);
		VarType	varType = __varTypeMap.get(hashCode);
		if (varType == null)
		{
			varType = new JVMType(TYPE.JVM_TYPE, pyriteType, jvmExpression);
			__varTypeMap.put(hashCode, varType);
		}

		return	varType;
	}

	protected JVMType(TYPE type, VarType pyriteType, String jvmExpression)
	{
		super._type = type;
		super._hashCode = createHashCode(type, jvmExpression);
		super._jvmExpression = jvmExpression;

		_pyriteType = pyriteType;
	}

	// (自分の型, 続く型)
	//       (変数, そのクラスのインスタンス変数 | クラス変数 | インスタンスメソッド | クラスメソッド)
	//       (クラス, クラス変数 | クラスメソッド),
	//       (クラス, クラス),
	//       (パッケージ, クラス)
	//       (パッケージ, パッケージ)
	@Override
	public VarType	resolveTrailerType(CodeGenerationVisitor cgv, String id)
	{
		return	_pyriteType.resolveTrailerType(cgv, id);
	}
}
