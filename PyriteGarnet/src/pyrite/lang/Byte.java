package pyrite.lang;

public class Byte extends pyrite.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Byte";

	private final byte	_v;

	public Byte(byte val)
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
