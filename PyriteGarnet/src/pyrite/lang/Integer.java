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

	// methods
	public Integer	add(Integer o)
	{
		return	new Integer(_v.add(o._v));
	}

	public Integer	sub(Integer o)
	{
		return	new Integer(_v.subtract(o._v));
	}

	public Integer	mul(Integer o)
	{
		return	new Integer(_v.multiply(o._v));
	}

	public MultipleValue	div(Integer o)
	{
		BigInteger	divValue = _v.divide(o._v);
		BigInteger	modValue = _v.mod(o._v);

		MultipleValue	result = PyriteRuntime.createMultipleValue(2);
		PyriteRuntime.setValue(result, 0, new Integer(divValue));
		PyriteRuntime.setValue(result, 1, new Integer(modValue));

		return	result;
	}

	public Integer	mod(Integer o)
	{
		return	new Integer(_v.mod(o._v));
	}

	public Integer	compareTo(Integer o)
	{
		return	PyriteRuntime.toPyriteInteger(_v.compareTo(o._v));
	}

	public Integer	shiftLeft(Integer o)
	{
		return	new Integer(_v.shiftLeft(PyriteRuntime.toJavaInt(o)));
	}

	public Integer	shiftRight(Integer o)
	{
		return	new Integer(_v.shiftRight(PyriteRuntime.toJavaInt(o)));
	}

	public Integer	shiftLogicalRight(Integer o)
	{
		throw new RuntimeException("not implemented.");
	}

	public Integer	and(Integer o)
	{
		return	new Integer(_v.and(o._v));
	}

	public Integer	or(Integer o)
	{
		return	new Integer(_v.or(o._v));
	}

	public Integer	xor(Integer o)
	{
		return	new Integer(_v.xor(o._v));
	}

	// cast
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

	// override
	@Override
	public int	hashCode()
	{
		return	_v.hashCode();
	}

	@Override
	public boolean	equals(java.lang.Object o)
	{
		boolean	cnd1 = (o instanceof Integer);
		boolean	cnd2 = cnd1 && _v.equals(((Integer)o)._v);
		return (o instanceof Integer) && _v.equals(((Integer)o)._v);
	}


	public static class CompilerAccessor
	{
		protected CompilerAccessor()
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
