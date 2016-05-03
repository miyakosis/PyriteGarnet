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


	private Integer(BigInteger val)
	{
		_v = val;
	}


	public final static class CompilerAccessor
	{
		public CompilerAccessor()
		{
			if (this.getClass().getName().startsWith("pyrite.runtime.") == false)
			{
				throw new RuntimeException();
			}
		}

		public int	javaIntValue(Integer i)
		{
			return	i._v.intValue();
		}

		public long	javaLongValue(Integer i)
		{
			return	i._v.longValue();
		}

		public short	javaShortValue(Integer i)
		{
			return	i._v.shortValue();
		}

		public Integer	pyriteValue(long i)
		{
			return	new Integer(BigInteger.valueOf(i));
		}
	}
}
