package pyrite.compiler.type;

/*
 * Switch文のcase情報を保持するクラス
 */
public class SwitchCase implements Comparable
{
	public final VarType	_type;	// null : default VarType.INT: 数値リテラルの case VarType.STR: 文字列リテラルの case

	// ラベル定数
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

	@Override
	public boolean	equals(Object o)
	{
		return	((o instanceof SwitchCase) && _hashCode == ((SwitchCase)o)._hashCode);
	}

	@Override
	public int	hashCode()
	{
		return	_hashCode;
	}

	@Override
	public int compareTo(Object o)
	{
		SwitchCase	other = (SwitchCase)o;
		if (_n != other._n)
		{
			return	_n - other._n;
		}
		else
		{
			return	_s.compareTo(other._s);
		}
	}
}
