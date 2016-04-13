package pyrite.compiler.type;

public class LValueType
{
	// local value, instance field, class field, array
	public enum	TYPE {LOCAL, INSTANCE, CLASS, ARRAY, ASSOC};

	public final TYPE	_lValueType;
	public final VarType	_type;
	public final int	_refNum;	// 参照番号。LOCAL:ローカル変数番号 INSTANCE/CLASS:ConstantPool番号 ARRAY/ASSOC:Method ConstantPool番号

	public LValueType(TYPE lValueType, VarType type, int refNum)
	{
		_lValueType = lValueType;
		_type = type;
		_refNum = refNum;
	}

}
