package pyrite.compiler.type;

// VarTypeと同義に扱うため継承している
public class LValueType extends VarType
{
	// local value, instance field, class field, array
	public static enum	TYPE {LOCAL, INSTANCE, CLASS, ARRAY, ASSOC};

	public final TYPE	_lValueType;
	public final VarType	_lValueVarType;
	public final int	_refNum;	// 参照番号。LOCAL:ローカル変数番号 INSTANCE/CLASS:Field ConstantPool番号 ARRAY/ASSOC:Method ConstantPool番号

	public LValueType(TYPE lValueType, VarType varType, int refNum)
	{
//		super(type._type, null, type._fqcn, null);	// 基底クラスに保持する情報としては、型情報とFQCNのみが必要。このオブジェクトをキャッシュにしなために、typeIdはnull
		_lValueType = lValueType;
		_lValueVarType = varType;
		_refNum = refNum;


	}

}
