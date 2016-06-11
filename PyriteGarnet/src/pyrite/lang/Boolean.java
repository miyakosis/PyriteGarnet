package pyrite.lang;

import pyrite.runtime.PyriteRuntime;

public class Boolean extends pyrite.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Boolean";

	public final static Boolean	TRUE = new Boolean(true);
	public final static Boolean	FALSE = new Boolean(false);

	private final boolean	_value;
	private Boolean (boolean value)
	{
		_value = value;
	}

	public static Boolean	valueOf(boolean b)
	{
		return	b ? TRUE : FALSE;
	}

	public String	toStr()
	{
		return	PyriteRuntime.toPyriteString(java.lang.Boolean.toString(_value));
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

		public boolean	javaValue(Boolean b)
		{
			return	b._value;
		}

		public Boolean	pyriteValue(boolean b)
		{
			return	Boolean.valueOf(b);
		}
	}
}
