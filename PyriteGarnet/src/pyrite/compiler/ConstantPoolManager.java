package pyrite.compiler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * コンスタントプールを管理するクラス
 */
public class ConstantPoolManager
{
	private List<Constant>	_constantList = new ArrayList<Constant>();
	private Map<String, Integer> _constantNumberMap = new HashMap<String, Integer>();

	private boolean	_isFrozen = false;
	public void	setFrozen(boolean isFrozen)
	{
		_isFrozen = isFrozen;
	}

	public int	getIntergaceMethodRef(String className, String methodName, String type)
	{
		className = className.replace('.', '/');

		String	tag = "B";
		String	key = tag + ":" + className + ":" + type;
		Integer	num = _constantNumberMap.get(key);
		if (num == null)
		{	// create constant
			if (_isFrozen)
			{
				throw new RuntimeException("ConstantPool is frozen. :" + className + " " + methodName + " " + type);
			}
			int	classNum = getClassRef(className);
			int	nameAndTypeNum = getNameAndTypeRef(methodName, type);
			Constant	constant = new Constant(0x0B, new int[]{classNum, nameAndTypeNum});
			_constantList.add(constant);
			num = _constantList.size();
			_constantNumberMap.put(key, num);
		}

		return	num;
	}

	public int	getMethodRef(String className, String methodName, String type)
	{
		className = className.replace('.', '/');

		String	tag = "A";
		String	key = tag + ":" + className + ":" + methodName + ":" + type;
		Integer	num = _constantNumberMap.get(key);
		if (num == null)
		{	// create constant
			if (_isFrozen)
			{
				throw new RuntimeException("ConstantPool is frozen. :" + className + " " + methodName + " " + type);
			}
			int	classNum = getClassRef(className);
			int	nameAndTypeNum = getNameAndTypeRef(methodName, type);
			Constant	constant = new Constant(0x0A, new int[]{classNum, nameAndTypeNum});
			_constantList.add(constant);
			num = _constantList.size();
			_constantNumberMap.put(key, num);
		}

		return	num;
	}

	public int	getFieldRef(String className, String fieldName, String type)
	{
		className = className.replace('.', '/');

		String	tag = "9";
		String	key = tag + ":" + className + ":" + fieldName + ":" + type;
		Integer	num = _constantNumberMap.get(key);
		if (num == null)
		{	// create constant
			if (_isFrozen)
			{
				throw new RuntimeException("ConstantPool is frozen. :" + className + " " + fieldName + " " + type);
			}
			int	classNum = getClassRef(className);
			int	nameAndTypeNum = getNameAndTypeRef(fieldName, type);
			Constant	constant = new Constant(0x09, new int[]{classNum, nameAndTypeNum});
			_constantList.add(constant);
			num = _constantList.size();
			_constantNumberMap.put(key, num);
		}

		return	num;
	}

	private int getNameAndTypeRef(String name, String type)
	{
		type = type.replace('.', '/');

		String	tag = "C";
		String	key = tag + ":" + name + ":" + type;
		Integer	num = _constantNumberMap.get(key);
		if (num == null)
		{	// create constant
			if (_isFrozen)
			{
				throw new RuntimeException("ConstantPool is frozen. :" + name + " " + type);
			}
			int	nameNum = getUtf8(name);
			int	typeNum = getUtf8(type);
			Constant	constant = new Constant(0x0C, new int[]{nameNum, typeNum});
			_constantList.add(constant);
			num = _constantList.size();
			_constantNumberMap.put(key, num);
		}

		return	num;
	}

	public int getClassRef(String className)
	{
		className = className.replace('.', '/');

		String	tag = "7";
		String	key = tag + ":" + className;
		Integer	num = _constantNumberMap.get(key);
		if (num == null)
		{	// create constant
			if (_isFrozen)
			{
				throw new RuntimeException("ConstantPool is frozen. :" + className);
			}
			int	utf8Num = getUtf8(className);
			Constant	constant = new Constant(0x07, new int[]{utf8Num});
			_constantList.add(constant);
			num = _constantList.size();
			_constantNumberMap.put(key, num);
		}

		return	num;
	}

	public int getUtf8(String s)
	{
		String	tag = "1";
		String	key = tag + ":" + s;
		Integer	num = _constantNumberMap.get(key);
		if (num == null)
		{	// create constant
			if (_isFrozen)
			{
				throw new RuntimeException("ConstantPool is frozen. :" + s);
			}
			Constant	constant = new Constant(0x01, s);
			_constantList.add(constant);
			num = _constantList.size();
			_constantNumberMap.put(key, num);
		}

		return	num;
	}

	public int getString(String s)
	{
		String	tag = "8";
		String	key = tag + ":" + s;
		Integer	num = _constantNumberMap.get(key);
		if (num == null)
		{	// create constant
			if (_isFrozen)
			{
				throw new RuntimeException("ConstantPool is frozen. :" + s);
			}
			int	utf8Num = getUtf8(s);
			Constant	constant = new Constant(0x08, new int[]{utf8Num});
			_constantList.add(constant);
			num = _constantList.size();
			_constantNumberMap.put(key, num);
		}

		return	num;
	}

	public static class Constant
	{
		private int	_tag;
		private int[]	_info;

		private String	_strContents;	// for ConstantPool - UTF-8

		private byte[]	_ba;

		public Constant(int tag, int[] info)
		{
			_tag = tag;
			_info = info;

			_ba = new byte[1 + info.length * 2];
			int	pos = 0;
			_ba[pos++] = (byte)tag;
			for (int i : info)
			{
				_ba[pos++] = (byte)(i >> 8);
				_ba[pos++] = (byte)(i);
			}
		}

		public Constant(int tag, String s)
		{
			_tag = tag;
			_strContents = s;

			byte[]	utf8ba = s.getBytes(BC.UTF8);
			int	len = utf8ba.length;

			_ba = new byte[1 + 2 + len];
			int	pos = 0;
			_ba[pos++] = (byte)tag;
			_ba[pos++] = (byte)(len >> 8);
			_ba[pos++] = (byte)(len);
			System.arraycopy(utf8ba, 0, _ba, pos, len);
		}
	}

	public int size()
	{
		return	_constantList.size();
	}

	public byte[] toByteArray()
	{
		int	totalLen = 0;
		for (Constant c : _constantList)
		{
			totalLen += c._ba.length;
		}

		byte[]	ba = new byte[totalLen];
		int	pos = 0;
		for (Constant c : _constantList)
		{
			System.arraycopy(c._ba, 0, ba, pos, c._ba.length);
			pos += c._ba.length;
		}

		return	ba;
	}
}
