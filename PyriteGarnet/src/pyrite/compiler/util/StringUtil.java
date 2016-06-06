package pyrite.compiler.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil
{
	public static String	concat(String s1, String s2)
	{
		return (s1.equals("") == false) ? new StringBuilder(s1).append(".").append(s2).toString() : s2;
	}

	public static String	getClassName(String packageClassName)
	{
		int	periodPos = packageClassName.lastIndexOf('.');
		if (periodPos >= 0)
		{
			return	packageClassName.substring(periodPos + 1);
		}
		else
		{
			return	packageClassName;
		}
	}

	// 両端の文字を除去した文字列を返す
	public static String	stripEndChar(String s)
	{
		assert(s.length() >= 2);
		return	s.substring(1, s.length() - 1);
	}

	// 両端のダブルクォーテーションを除去する
	public static String	strLiteral(String s)
	{
		return	stripEndChar(s);
	}

	// s に含まれる最後の splitChar で分離した前半と後半を返す。
	// s に splitChar が含まれない場合、前半は空文字列を返す。
	public static String[]	splitLastElement(String s, char splitChar)
	{
		String[]	result = new String[2];

		int	fileNamePos = s.lastIndexOf(splitChar);
		if (fileNamePos >= 0)
		{
			result[0] = s.substring(0, fileNamePos);
			result[1] = s.substring(fileNamePos + 1);
		}
		else
		{
			result[0] = "";
			result[1] = s;
		}

		return	result;
	}



	public static int	intLiteral(String s)
	{
		return	Integer.valueOf(removeUnderscore(s));
	}

	public static String	removeUnderscore(String s)
	{
		return	s.replace("_", "");
	}

	public static List<Byte>	toByteList(int[] ia)
	{
		List<Byte>	byteList = new ArrayList<Byte>(ia.length * 4);

		for (int i : ia)
		{
			byteList.add((byte)(i >> 24));
			byteList.add((byte)(i >> 16));
			byteList.add((byte)(i >> 8));
			byteList.add((byte)(i));
		}

		return	byteList;
	}

	public static byte[]	toByteArray(List<Byte> byteList)
	{
		byte[]	ba = new byte[byteList.size()];
		int	pos = 0;
		for (Byte b : byteList)
		{
			ba[pos++] = b;
		}
		return	ba;
	}
}
