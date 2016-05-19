package pyrite.runtime;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PyriteRuntime
{
	public final static String	CLASS_NAME = "pyrite.runtime.PyriteRuntime";

	private final static pyrite.lang.Boolean.CompilerAccessor	__zca = new pyrite.lang.Boolean.CompilerAccessor();
	private final static pyrite.lang.Integer.CompilerAccessor	__ica = new pyrite.lang.Integer.CompilerAccessor();
	private final static pyrite.lang.Decimal.CompilerAccessor	__dca = new pyrite.lang.Decimal.CompilerAccessor();
	private final static pyrite.lang.String.CompilerAccessor	__sca = new pyrite.lang.String.CompilerAccessor();
	private final static pyrite.lang.Character.CompilerAccessor	__cca = new pyrite.lang.Character.CompilerAccessor();
	private final static pyrite.lang.Byte.CompilerAccessor	__bca = new pyrite.lang.Byte.CompilerAccessor();

	private final static pyrite.lang.MultipleValue.CompilerAccessor	__mvca = new pyrite.lang.MultipleValue.CompilerAccessor();

	public static int	toJVMValue(pyrite.lang.Boolean b)
	{
		return	__zca.javaValue(b) ? 1 : 0;
	}

	public static boolean	toJavaBoolean(pyrite.lang.Boolean b)
	{
		return	__zca.javaValue(b);
	}

	public static int	toJavaInt(pyrite.lang.Integer i)
	{
		return	__ica.javaIntValue(i);
	}

	public static long	toJavaLong(pyrite.lang.Integer i)
	{
		return	__ica.javaLongValue(i);
	}

	public static short	toJavaShort(pyrite.lang.Integer i)
	{
		return	__ica.javaShortValue(i);
	}

	public static double	toJavaDouble(pyrite.lang.Decimal d)
	{
		return	__dca.javaDoubleValue(d);
	}

	public static float	toJavaFloat(pyrite.lang.Decimal d)
	{
		return	__dca.javaFloatValue(d);
	}

	public static String	toJavaString(pyrite.lang.String s)
	{
		return	__sca.javaString(s);
	}

	public static char	toJavaChar(pyrite.lang.Character c)
	{
		return	__cca.javaValue(c);
	}

	public static byte	toJavaByte(pyrite.lang.Byte b)
	{
		return	__bca.javaValue(b);
	}



	public static pyrite.lang.Boolean	toPyriteBoolean(boolean b)
	{
		return	__zca.pyriteValue(b);
	}

	public static pyrite.lang.Integer	toPyriteInteger(int i)
	{
		return	__ica.pyriteValue(i);
	}

	public static pyrite.lang.Integer	toPyriteInteger(long l)
	{
		return	__ica.pyriteValue(l);
	}

	public static pyrite.lang.Integer	toPyriteInteger(short s)
	{
		return	__ica.pyriteValue(s);
	}

	public static pyrite.lang.Integer	toPyriteInteger(BigInteger bi)
	{
		return	__ica.pyriteValue(bi);
	}

	public static pyrite.lang.Integer	toPyriteInteger(java.lang.String val, int radix)
	{
		return	__ica.pyriteValue(new BigInteger(val, radix));
	}


	public static pyrite.lang.Decimal	toPyriteDecimal(double d)
	{
		return	__dca.pyriteValue(d);
	}

	public static pyrite.lang.Decimal	toPyriteDecimal(float f)
	{
		return	__dca.pyriteValue(f);
	}

	public static pyrite.lang.Decimal	toPyriteDecimal(BigDecimal bd)
	{
		return	__dca.pyriteValue(bd);
	}

	public static pyrite.lang.Decimal	toPyriteDecimal(java.lang.String val)
	{
		return	__dca.pyriteValue(val);
	}

	public static pyrite.lang.String	toPyriteString(String s)
	{
		return	__sca.pyriteString(s);
	}

	public static pyrite.lang.Character	toPyriteCharacter(char c)
	{
		return	__cca.pyriteValue(c);
	}

	public static pyrite.lang.Byte	toPyriteByte(byte b)
	{
		return	__bca.pyriteValue(b);
	}


	public static pyrite.lang.MultipleValue	createMultipleValue(int size)
	{
		return	__mvca.createInstance(size);
	}

	public static pyrite.lang.MultipleValue	setValue(pyrite.lang.MultipleValue mv, int n, java.lang.Object obj)
	{
		return	__mvca.setValue(mv, n, obj);
	}

	public static java.lang.Object	toSingleValue(pyrite.lang.MultipleValue mv)
	{
		return	__mvca.getValue(mv, 0);
	}

	public static java.lang.Object	getValue(pyrite.lang.MultipleValue mv, int n)
	{
		return	__mvca.getValue(mv, n);
	}
}
