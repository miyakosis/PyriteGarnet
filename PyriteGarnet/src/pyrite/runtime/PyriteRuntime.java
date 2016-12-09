package pyrite.runtime;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * 実行時型変換などの機能を提供するクラス
 */
public class PyriteRuntime
{
	public final static String	CLASS_NAME = "pyrite.runtime.PyriteRuntime";


//	private final static pyrite.lang.Boolean.CompilerAccessor	__zca = new pyrite.lang.Boolean.CompilerAccessor();
//	private final static pyrite.lang.Integer.CompilerAccessor	__ica = new pyrite.lang.Integer.CompilerAccessor();
//	private final static pyrite.lang.Decimal.CompilerAccessor	__dca = new pyrite.lang.Decimal.CompilerAccessor();
//	private final static pyrite.lang.String.CompilerAccessor	__sca = new pyrite.lang.String.CompilerAccessor();
//	private final static pyrite.lang.Character.CompilerAccessor	__cca = new pyrite.lang.Character.CompilerAccessor();
//	private final static pyrite.lang.Byte.CompilerAccessor	__bca = new pyrite.lang.Byte.CompilerAccessor();
//
//	private final static pyrite.lang.MultipleValue.CompilerAccessor	__mvca = new pyrite.lang.MultipleValue.CompilerAccessor();


	// to java
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


	// to pyrite
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


	// multiple value
	public static pyrite.lang.MultipleValue	createMultipleValue(int size)
	{
		return	__mvca.createInstance(size);
	}

	public static pyrite.lang.MultipleValue	setValue(pyrite.lang.MultipleValue mv, int n, java.lang.Object obj)
	{
		return	__mvca.setValue(mv, n, obj);
	}

	public static pyrite.lang.MultipleValue	setValueForReturn(java.lang.Object obj, pyrite.lang.MultipleValue mv, int n)
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


	// array
	public static Object	toJVMArray(pyrite.lang.Array arr, Class<?> pyriteArrayClass, Class<?> jvmArrayClass, int dimension)
	{
		// 配列のそれぞれの次元の要素数を取得する
		int[]	size = new int[dimension];
		getJVMArraySize(arr, dimension, 0, size);

		// 変換後の配列オブジェクト生成
		Object	result = Array.newInstance(jvmArrayClass, size);

		// 配列に値設定
		setJVMArrayValue(arr, pyriteArrayClass, jvmArrayClass, dimension, size, 0, result);

		return	result;
	}

	protected static void	getJVMArraySize(pyrite.lang.Array arr, int dimension, int currentDimension, int[] size)
	{
		if (arr.size() > size[currentDimension])
		{
			size[currentDimension] = arr.size();
		}

		if (currentDimension + 1 < dimension)
		{	// 次の次元がある場合、要素すべてについて、次の次元の要素数を数える
			for (int i = 0; i < arr.size(); ++i)
			{
				getJVMArraySize((pyrite.lang.Array)arr.get(toPyriteInteger(i)), dimension, currentDimension + 1, size);
			}
		}
	}

	protected static void setJVMArrayValue(pyrite.lang.Array arr, Class<?> pyriteArrayClass, Class<?> jvmArrayClass, int dimension, int[] size, int currentDimension, Object result)
	{
		if (currentDimension == dimension - 1)
		{	// 末端要素なので値を設定する
			for (int i = 0; i < arr.size(); ++i)
			{
				Object	src = arr.get(toPyriteInteger(i));
				// 入力パラメータの型と、解決されたメソッド引数の型を比べて、必要があれば(Javaのメソッド呼び出しならば)型変換する。
				if (pyriteArrayClass == pyrite.lang.Integer.class)
				{
					if (jvmArrayClass == int.class)
					{
						int	iv = toJavaInt((pyrite.lang.Integer)src);
						Array.setInt(result, i, iv);
					}
					else if (jvmArrayClass == long.class)
					{
						long	lv = toJavaLong((pyrite.lang.Integer)src);
						Array.setLong(result, i, lv);
					}
					else if (jvmArrayClass == short.class)
					{
						short	sv = toJavaShort((pyrite.lang.Integer)src);
						Array.setShort(result, i, sv);
					}
					else
					{
						throw new RuntimeException("assertion");
					}
				}
				else if (pyriteArrayClass == pyrite.lang.Decimal.class)
				{
					if (jvmArrayClass == double.class)
					{
						double	dv = toJavaDouble((pyrite.lang.Decimal)src);
						Array.setDouble(result, i, dv);
					}
					else if (jvmArrayClass == float.class)
					{
						float	fv = toJavaFloat((pyrite.lang.Decimal)src);
						Array.setFloat(result, i, fv);
					}
					else
					{
						throw new RuntimeException("assertion");
					}
				}
				else if (pyriteArrayClass == pyrite.lang.String.class)
				{
					if (jvmArrayClass == String.class)
					{
						String	sv = toJavaString((pyrite.lang.String)src);
						Array.set(result, i, sv);
					}
					else
					{
						throw new RuntimeException("assertion");
					}
				}
				else if (pyriteArrayClass == pyrite.lang.Character.class)
				{
					if (jvmArrayClass == char.class)
					{
						char	cv = toJavaChar((pyrite.lang.Character)src);
						Array.setChar(result, i, cv);
					}
					else
					{
						throw new RuntimeException("assertion");
					}
				}
				else if (pyriteArrayClass == pyrite.lang.Boolean.class)
				{
					if (jvmArrayClass == boolean.class)
					{
						boolean	bolv = toJavaBoolean((pyrite.lang.Boolean)src);
						Array.setBoolean(result, i, bolv);
					}
					else
					{
						throw new RuntimeException("assertion");
					}
				}
				else if (pyriteArrayClass == pyrite.lang.Byte.class)
				{
					if (jvmArrayClass == byte.class)
					{
						byte	bv = toJavaByte((pyrite.lang.Byte)src);
						Array.setByte(result, i, bv);
					}
					else
					{
						throw new RuntimeException("assertion");
					}
				}
				else
				{
					// オブジェクトとして値設定
					Array.set(result, i, src);
				}
			}
		}
		else
		{
			// 次の配列要素に値を設定する
			for (int i = 0; i < arr.size(); ++i)
			{
				pyrite.lang.Array	nextArr = (pyrite.lang.Array)arr.get(toPyriteInteger(i));
				Object	nextResult = Array.get(result, i);

				setJVMArrayValue(nextArr, pyriteArrayClass, jvmArrayClass, dimension, size, currentDimension + 1, nextResult);
			}
		}
	}

	public static pyrite.lang.Array	toPyriteArray(Object arr, Class<?> jvmArrayClass, int dimension)
	{
		return	setPyriteArrayValue(arr, jvmArrayClass, dimension, 0);
	}

	protected static pyrite.lang.Array	setPyriteArrayValue(Object arr, Class<?> jvmArrayClass, int dimension, int currentDimension)
	{
		pyrite.lang.Array	result = new pyrite.lang.Array();
		int	len = Array.getLength(arr);

		if (currentDimension == dimension - 1)
		{	// 末端要素なので値を設定する
			for (int i = 0; i < len; ++i)
			{
				Object	target;
				if (jvmArrayClass == int.class)
				{
					target = toPyriteInteger(Array.getInt(arr, i));
				}
				else if (jvmArrayClass == long.class)
				{
					target = toPyriteInteger(Array.getLong(arr, i));
				}
				else if (jvmArrayClass == short.class)
				{
					target = toPyriteInteger(Array.getShort(arr, i));
				}
				else if (jvmArrayClass == double.class)
				{
					target = toPyriteDecimal(Array.getDouble(arr, i));
				}
				else if (jvmArrayClass == float.class)
				{
					target = toPyriteDecimal(Array.getFloat(arr, i));
				}
				else if (jvmArrayClass == String.class)
				{
					target = Array.get(arr, i);
					target = toPyriteString((java.lang.String)target);
				}
				else if (jvmArrayClass == char.class)
				{
					target = toPyriteCharacter(Array.getChar(arr, i));
				}
				else if (jvmArrayClass == boolean.class)
				{
					target = toPyriteBoolean(Array.getBoolean(arr, i));
				}
				else if (jvmArrayClass == byte.class)
				{
					target = toPyriteByte(Array.getByte(arr, i));
				}
				else
				{
					target = Array.get(arr, i);
				}

				result.set(toPyriteInteger(i), target);
			}
		}
		else
		{	// 再帰的にArrayを取得する
			for (int i = 0; i < len; ++i)
			{
				Object	nextArr = Array.get(arr, i);
				pyrite.lang.Array	nextResult = setPyriteArrayValue(nextArr, jvmArrayClass, dimension, currentDimension + 1);
				result.set(toPyriteInteger(i), nextResult);
			}
		}
		return	result;
	}

	private final static BooleanCompilerAccessor	__zca = new BooleanCompilerAccessor();
	private final static IntegerCompilerAccessor	__ica = new IntegerCompilerAccessor();
	private final static DecimalCompilerAccessor	__dca = new DecimalCompilerAccessor();
	private final static StringCompilerAccessor	__sca = new StringCompilerAccessor();
	private final static CharacterCompilerAccessor	__cca = new CharacterCompilerAccessor();
	private final static ByteCompilerAccessor	__bca = new ByteCompilerAccessor();

	private final static MultipleValueCompilerAccessor	__mvca = new MultipleValueCompilerAccessor();

	private static class BooleanCompilerAccessor extends pyrite.lang.Boolean.CompilerAccessor{}
	private static class IntegerCompilerAccessor extends pyrite.lang.Integer.CompilerAccessor{}
	private static class DecimalCompilerAccessor extends pyrite.lang.Decimal.CompilerAccessor{}
	private static class StringCompilerAccessor extends pyrite.lang.String.CompilerAccessor{}
	private static class CharacterCompilerAccessor extends pyrite.lang.Character.CompilerAccessor{}
	private static class ByteCompilerAccessor extends pyrite.lang.Byte.CompilerAccessor{}
	private static class MultipleValueCompilerAccessor extends pyrite.lang.MultipleValue.CompilerAccessor{}
}
