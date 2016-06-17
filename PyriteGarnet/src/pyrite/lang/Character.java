package pyrite.lang;

import pyrite.runtime.PyriteRuntime;

public class Character extends pyrite.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Character";

	private final char	_v;

	public Character(Character c)
	{
		_v = c._v;
	}

	public Character(Integer code)
	{
		_v = (char)PyriteRuntime.toJavaInt(code);
	}

	private Character(char val)
	{
		_v = val;
	}

	// convert
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
		return (o instanceof Character) && _v == ((Character)o)._v;
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

		public char	javaValue(Character c)
		{
			return	c._v;
		}

		public Character	pyriteValue(char c)
		{
			return	new Character(c);
		}
	}
}
