package pyrite.lang;

public class Character extends pyrite.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Character";

	private final char	_v;

	public Character(char val)
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
