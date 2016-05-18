package pyrite.lang;

import java.math.BigDecimal;
import java.math.BigInteger;

import pyrite.runtime.PyriteRuntime;

public class Integer extends pyrite.lang.Number
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Integer";

	private final BigInteger	_v;

	public Integer(Integer val)
	{
		_v = val._v;
	}

	private Integer(BigInteger val)
	{
		_v = val;
	}


	public Integer	toInt()
	{
		return	this;
	}

	public Decimal	toDec()
	{
		return	PyriteRuntime.toPyriteDecimal(new BigDecimal(_v));
	}

	public Float	toFlt()
	{
		throw new RuntimeException("not implemented");
	}

	public String	toStr()
	{
		return	PyriteRuntime.toPyriteString(_v.toString());
	}

	@Override
	public int	hashCode()
	{
		return	_v.hashCode();
	}

	@Override
	public boolean	equals(java.lang.Object o)
	{
		return (o instanceof Integer) && _v.equals(((Integer)o)._v);
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

		public Integer pyriteValue(BigInteger bi)
		{
			return	new Integer(bi);
		}
	}
}
