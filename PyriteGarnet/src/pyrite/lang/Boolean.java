package pyrite.lang;

public class Boolean extends pyrite.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Boolean";

	public final static Boolean	TRUE = new Boolean(true);
	public final static Boolean	FALSE = new Boolean(false);

	public final boolean	_value;
	public Boolean (boolean value)
	{
		_value = value;
	}

	public Boolean	valueOf(boolean b)
	{
		return	b ? TRUE : FALSE;
	}


	// pyrite コンパイラが参照する値
	public int	getPyrcVal()
	{
		return	_value ? 1 : 0;
	}
}
