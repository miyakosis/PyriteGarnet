package pyrite.lang;

import java.io.Serializable;

public class String extends pyrite.lang.Object implements Serializable, CharSequence
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.String";

	private final java.lang.String	_v;

	public String(String val)
	{
		_v = val._v;
	}

	private String(java.lang.String val)
	{
		_v = val;
	}

	// methods
	public String	add(String o)
	{
		return	new String(_v + o._v);
	}

	// cast
	public String	toStr()
	{
		return	this;
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
		return (o instanceof String) && _v.equals(((String)o)._v);
	}

	@Override
	public char charAt(int i)
	{
		return _v.charAt(i);
	}

	@Override
	public int length()
	{
		return _v.length();
	}

	@Override
	public CharSequence subSequence(int beginIndex, int endIndex)
	{
		return _v.subSequence(beginIndex, endIndex);
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

		public java.lang.String	javaString(String s)
		{
			return	s._v;
		}

		public String	pyriteString(java.lang.String s)
		{
			return	new String(s);
		}

	}
}
