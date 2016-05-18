package pyrite.lang;

public class Character extends pyrite.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Character";

	private final char	_v;

	public Character(Character c)
	{
		_v = c._v;
	}

	private Character(char val)
	{
		_v = val;
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



	public final static class CompilerAccessor
	{
		public CompilerAccessor()
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
