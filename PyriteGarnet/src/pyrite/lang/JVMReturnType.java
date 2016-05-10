package pyrite.lang;

public class JVMReturnType
{
	public final Object[]	values;

	private JVMReturnType(Object[] values)
	{
		this.values = values;
	}

	public static class	CompilerAccessor
	{
		public CompilerAccessor()
		{
			if (this.getClass().getName().startsWith("pyrite.runtime.") == false)
			{
				throw new RuntimeException();
			}
		}

		public JVMReturnType	createInstance(Object[] values)
		{
			return	new JVMReturnType(values);
		}
	}
}
