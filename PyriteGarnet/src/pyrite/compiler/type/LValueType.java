package pyrite.compiler.type;

// 左辺値を保持する型
// VarTypeと同義に扱うため継承している
public class LValueType extends VarType
{
	// 代入の種類。ローカル変数への代入や、instance field への代入
	// local value, instance field, class field, array 要素への代入, assoc 要素への代入
	public static enum	TYPE {LOCAL, INSTANCE, CLASS, ARRAY, ASSOC};

	public final TYPE	_lValueType;
	public final VarType	_lValueVarType;
	public final int	_refNum;	// 参照番号。LOCAL:ローカル変数番号 INSTANCE/CLASS:Field ConstantPool番号 ARRAY/ASSOC:Method ConstantPool番号

	public LValueType(TYPE lValueType, VarType varType, int refNum)
	{
		_lValueType = lValueType;
		_lValueVarType = varType;
		_refNum = refNum;
	}
}
