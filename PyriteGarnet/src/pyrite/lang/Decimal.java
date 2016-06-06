package pyrite.lang;

import java.math.BigDecimal;
import java.math.RoundingMode;

import pyrite.runtime.PyriteRuntime;

public class Decimal extends pyrite.lang.Number
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Decimal";

	public final static RoundingMode	ROUND_MODE = RoundingMode.DOWN;
	public final static int	scale = 15;

	private final BigDecimal	_v;

	public Decimal(Decimal val)
	{
		_v = val._v;
	}

	private Decimal(BigDecimal val)
	{
		_v = val;
	}


	// methods
	public Decimal	add(Decimal o)
	{
		return	new Decimal(_v.add(o._v));
	}

	public Decimal	sub(Decimal o)
	{
		return	new Decimal(_v.subtract(o._v));
	}

	public Decimal	mul(Decimal o)
	{
		return	new Decimal(_v.multiply(o._v));
	}

	public Decimal	div(Decimal o)
	{
		return	new Decimal(_v.divide(o._v));
	}

	public Integer	compareTo(Decimal o)
	{
		return	PyriteRuntime.toPyriteInteger(_v.compareTo(o._v));
	}


	// cast
	public Integer	toInt()
	{
		return	PyriteRuntime.toPyriteInteger(_v.toBigInteger());
	}

	public Decimal	toDec()
	{
		return	this;
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
		return (o instanceof Decimal) && _v.equals(((Decimal)o)._v);
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

		public double	javaDoubleValue(Decimal d)
		{
			return	d._v.doubleValue();
		}

		public float	javaFloatValue(Decimal d)
		{
			return	d._v.floatValue();
		}

		public Decimal	pyriteValue(double d)
		{
			return	new Decimal(BigDecimal.valueOf(d));
		}

		public Decimal	pyriteValue(BigDecimal bd)
		{
			return	new Decimal(bd);
		}

		public Decimal	pyriteValue(java.lang.String val)
		{
			return	new Decimal(new BigDecimal(val));
		}
	}
}
