package pyrite.lang;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Decimal extends pyrite.lang.Number
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Decimal";

	public final static RoundingMode	ROUND_MODE = RoundingMode.DOWN;
	public final static int	scale = 15;

	private final BigDecimal	_v;

	public Decimal(java.lang.String val)
	{
		_v = new BigDecimal(val);
	}

	private Decimal(BigDecimal val)
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

	}
}
