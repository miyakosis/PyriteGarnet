package pyrite.lang;

public class String extends pyrite.lang.Object implements CharSequence
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.String";

	private final java.lang.String	_v;

	public String(java.lang.String val)
	{
		_v = val;
	}

	public java.lang.String	to_s()
	{
		return	_v;
	}

	public int	hashCode()
	{
		return	_v.hashCode();
	}

	public boolean	equals(java.lang.Object o)
	{
		return	this.hashCode() == o.hashCode();
	}


	@Override
	public char charAt(int i)
	{
		return _v.charAt(i);
	}

	@Override
	public int length()
	{
		return _v.length();
	}

	@Override
	public CharSequence subSequence(int beginIndex, int endIndex)
	{
		return _v.subSequence(beginIndex, endIndex);
	}
}
