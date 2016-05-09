package pyrite.runtime;

public class PyriteRuntime
{
	public final static String	CLASS_NAME = "pyrite.runtime.PyriteRuntime";

	private final static pyrite.lang.Boolean.CompilerAccessor	__zca = new pyrite.lang.Boolean.CompilerAccessor();
	private final static pyrite.lang.Integer.CompilerAccessor	__ica = new pyrite.lang.Integer.CompilerAccessor();
	private final static pyrite.lang.Decimal.CompilerAccessor	__dca = new pyrite.lang.Decimal.CompilerAccessor();
	private final static pyrite.lang.String.CompilerAccessor	__sca = new pyrite.lang.String.CompilerAccessor();
	private final static pyrite.lang.Character.CompilerAccessor	__cca = new pyrite.lang.Character.CompilerAccessor();
	private final static pyrite.lang.Byte.CompilerAccessor	__bca = new pyrite.lang.Byte.CompilerAccessor();

	public static int	cnvJVMValue(pyrite.lang.Boolean b)
	{
		return	__zca.javaValue(b) ? 1 : 0;
	}

	public static boolean	cnvJavaBoolean(pyrite.lang.Boolean b)
	{
		return	__zca.javaValue(b);
	}

	public static int	cnvJavaInt(pyrite.lang.Integer i)
	{
		return	__ica.javaIntValue(i);
	}

	public static long	cnvJavaLong(pyrite.lang.Integer i)
	{
		return	__ica.javaLongValue(i);
	}

	public static short	cnvJavaShort(pyrite.lang.Integer i)
	{
		return	__ica.javaShortValue(i);
	}

	public static double	cnvJavaDouble(pyrite.lang.Decimal d)
	{
		return	__dca.javaDoubleValue(d);
	}

	public static float	cnvJavaFloat(pyrite.lang.Decimal d)
	{
		return	__dca.javaFloatValue(d);
	}

	public static String	cnvJavaString(pyrite.lang.String s)
	{
		return	__sca.javaString(s);
	}

	public static char	cnvJavaChar(pyrite.lang.Character c)
	{
		return	__cca.javaValue(c);
	}

	public static byte	cnvJavaByte(pyrite.lang.Byte b)
	{
		return	__bca.javaValue(b);
	}



	public static pyrite.lang.Boolean	cnvPyriteBoolean(boolean b)
	{
		return	__zca.pyriteValue(b);
	}

	public static pyrite.lang.Integer	cnvPyriteInt(int i)
	{
		return	__ica.pyriteValue(i);
	}

	public static pyrite.lang.Integer	cnvPyriteInt(long l)
	{
		return	__ica.pyriteValue(l);
	}

	public static pyrite.lang.Integer	cnvPyriteInt(short s)
	{
		return	__ica.pyriteValue(s);
	}

	public static pyrite.lang.Decimal	cnvPyriteDecimal(double d)
	{
		return	__dca.pyriteValue(d);
	}

	public static pyrite.lang.Decimal	cnvPyriteDecimal(float f)
	{
		return	__dca.pyriteValue(f);
	}

	public static pyrite.lang.String	cnvPyriteString(String s)
	{
		return	__sca.pyriteString(s);
	}

	public static pyrite.lang.Character	cnvPyriteChar(char c)
	{
		return	__cca.pyriteValue(c);
	}

	public static pyrite.lang.Byte	cnvPyriteByte(byte b)
	{
		return	__bca.pyriteValue(b);
	}

}
