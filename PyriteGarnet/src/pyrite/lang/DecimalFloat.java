package pyrite.lang;

import java.math.BigDecimal;

public class DecimalFloat extends pyrite.lang.Float
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.DecimalFloat";

	private final BigDecimal	_v;

	public DecimalFloat(java.lang.String val)
	{
		_v = new BigDecimal(val);
	}
}
