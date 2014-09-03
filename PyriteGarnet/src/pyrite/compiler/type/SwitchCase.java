package pyrite.compiler.type;

public class SwitchCase
{
	public final VarType	_type;	// null は default
	public final int	_n;
	public final String	_s;

	public final int	_hashCode;

	public final static SwitchCase	DEFAULT = new SwitchCase();

	public SwitchCase(int n)
	{
		_type = VarType.INT;
		_n = n;
		_s = "";

		_hashCode = createHashCode();
	}

	public SwitchCase(String s)
	{
		_type = VarType.STR;
		_n = 0;
		_s = s;

		_hashCode = createHashCode();
	}

	protected SwitchCase()
	{
		_type = null;
		_n = 0;
		_s = "";

		_hashCode = createHashCode();
	}

	private int	createHashCode()
	{
		StringBuilder	sb = new StringBuilder();
		sb.append(_type);
		sb.append(_n);
		sb.append(_s);

		return	sb.toString().hashCode();
	}

	public int	hashCode()
	{
		return	_hashCode;
	}
}
