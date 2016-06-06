package pyrite.lang;

import pyrite.runtime.PyriteRuntime;

public class Byte extends pyrite.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Byte";

	private final byte	_v;

	public Byte(Byte val)
	{
		_v = val._v;
	}

	public Byte(Integer val)
	{
		_v = (byte)PyriteRuntime.toJavaInt(val);
	}

	private Byte(byte val)
	{
		_v = val;
	}

	// cast
	public Integer	toInt()
	{
		return	PyriteRuntime.toPyriteInteger(_v);
	}

	public String	toStr()
	{
		return	PyriteRuntime.toPyriteString(java.lang.String.valueOf(_v));
	}


	@Override
	public int	hashCode()
	{
		return	_v;
	}

	@Override
	public boolean	equals(java.lang.Object o)
	{
		return (o instanceof Byte) && _v == ((Byte)o)._v;
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

		public byte	javaValue(Byte b)
		{
			return	b._v;
		}

		public Byte	pyriteValue(byte b)
		{
			return	new Byte(b);
		}
	}
}
