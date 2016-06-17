package pyrite.compiler.util;

import java.util.ArrayList;
import java.util.List;

import pyrite.compiler.PyriteSyntaxException;

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

	// エスケープシーケンスを考慮して文字列を変換する
	public static String	strLiteral(String s)
	{
		// 両端のダブルクォーテーションを除去する
		StringBuilder	sb = new StringBuilder(stripEndChar(s));

		for (int i = 0; i < sb.length(); i += 1)
		{
			char c = sb.charAt(i);
			if (c == '\\')
			{
				if (i + 1 >= sb.length())
				{
					throw new PyriteSyntaxException("invalid escape sequence.");
				}
				c = sb.charAt(i + 1);
				char	newC;
				switch (c)
				{
				case 'b':	newC = '\b';	break;
				case 't':	newC = '\t';	break;
				case 'n':	newC = '\n';	break;
				case 'r':	newC = '\r';	break;
				case 'f':	newC = '\f';	break;
				case '\'':	newC = '\'';	break;
				case '"':	newC = '"';		break;
				case '\\':	newC = '\\';	break;
				case 'u':	// uHHHH
					if ((i + 1) + 4 >= sb.length())
					{
						throw new PyriteSyntaxException("invalid escape sequence.");
					}
					int	start = i + 2;
					int	end = start + 4;
					newC = (char)Integer.parseInt(sb.substring(start, end), 16);
					sb.delete(start, end);
					break;

				default:
					throw new RuntimeException("assertion");
				}
				sb.setCharAt(i, newC);
				sb.deleteCharAt(i + 1);
			}
		}

		return	sb.toString();
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

	public static int	toInt(byte b1, byte b2, byte b3, byte b4)
	{
		return	((b1 << 24) & 0xff000000)
				| ((b2 << 16) & 0x00ff0000)
				| ((b3 << 8) & 0x0000ff00)
				| (b4 & 0x000000ff);
	}
	/*
	public static int	toInt(byte[] ba, int pos)
	{
		return	((ba[pos] << 24) & 0xff000000)
				| ((ba[pos + 1] << 16) & 0x00ff0000)
				| ((ba[pos + 2] << 8) & 0x0000ff00)
				| (ba[pos + 3] & 0x000000ff);
	}
	*/
}
