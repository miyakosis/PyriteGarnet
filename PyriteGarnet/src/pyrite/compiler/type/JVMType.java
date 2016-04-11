package pyrite.compiler.type;

// Javaとのインターフェースをとるためのクラス
// jvmExpression : pyriteType = N : 1 の関係である。
// そのため、jvmExpression でhashCode を決定することができる。
public class JVMType extends VarType
{

	protected JVMType(TYPE type, String typeId, String jvmExpression)
	{
		super(type, typeId, jvmExpression);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	// TODO:必要かどうか、見直す必要あり

//	private final VarType	_pyriteType;
//
//	public static VarType	getType(VarType pyriteType, String jvmExpression)
//	{
//		int	hashCode = createHashCode(TYPE.JVM_TYPE, jvmExpression);
//		VarType	varType = __varTypeMap.get(hashCode);
//		if (varType == null)
//		{
//			varType = new JVMType(TYPE.JVM_TYPE, pyriteType, jvmExpression);
//			__varTypeMap.put(hashCode, varType);
//		}
//
//		return	varType;
//	}
//
//	protected JVMType(TYPE type, VarType pyriteType, String jvmExpression)
//	{
//		super._type = type;
//		super._hashCode = createHashCode(type, jvmExpression);
//		super._jvmExpression = jvmExpression;
//
//		_pyriteType = pyriteType;
//	}
//
}
