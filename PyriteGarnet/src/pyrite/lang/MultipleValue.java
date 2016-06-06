package pyrite.lang;

public class MultipleValue extends pyrite.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.MultipleValue";

	public final java.lang.Object[]	values;

	private MultipleValue(int size)
	{
		this.values = new java.lang.Object[size];
	}

	public static class	CompilerAccessor
	{
		protected CompilerAccessor()
		{
			if (this.getClass().getName().startsWith("pyrite.runtime.") == false)
			{
				throw new RuntimeException();
			}
		}

		public MultipleValue	createInstance(int size)
		{
			return	new MultipleValue(size);
		}

		public MultipleValue	setValue(MultipleValue mv, int n, java.lang.Object obj)
		{
			mv.values[n] = obj;
			return	mv;
		}

		public java.lang.Object	getValue(MultipleValue mv, int n)
		{
			return	mv.values[n];
		}
	}
}
