package pyrite.lang;

import java.math.BigInteger;

public class Integer extends pyrite.lang.Number
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Integer";

	private final BigInteger	_v;

	public Integer(java.lang.String val, int radix)
	{
		_v = new BigInteger(val, radix);
	}

	public int	to_i()
	{
		return	_v.intValue();
	}

	public long	to_l()
	{
		return	_v.longValue();
	}
}
