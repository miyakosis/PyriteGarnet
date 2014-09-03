package pyrite.compiler.type;

// Javaとのインターフェースをとるためのクラス
// jvmExpression : pyriteType = N : 1 の関係である。
// そのため、jvmExpression でhashCode を決定することができる。
public class JVMType extends VarType
{
	private final VarType	_pyriteType;

	public static VarType	getType(VarType pyriteType, String jvmExpression)
	{
		int	hashCode = createHashCode(TYPE.JVM_TYPE, jvmExpression);
		VarType	varType = __varTypeMap.get(hashCode);
		if (varType == null)
		{
			varType = new JVMType(TYPE.JVM_TYPE, pyriteType, jvmExpression);
			__varTypeMap.put(hashCode, varType);
		}

		return	varType;
	}

	protected JVMType(TYPE type, VarType pyriteType, String jvmExpression)
	{
		super._type = type;
		super._hashCode = createHashCode(type, jvmExpression);
		super._jvmExpression = jvmExpression;

		_pyriteType = pyriteType;
	}


	// Javaのインターフェース定義からPyriteコンパイル時の型を作成する
	public static VarType	parseJavaTypeName(String typeStr)
	{
		int	nArrayLevel = 0;
		for (nArrayLevel = 0; nArrayLevel < typeStr.length(); ++nArrayLevel)
		{
			if (typeStr.charAt(nArrayLevel) != '[')
			{
				break;
			}
		}

		typeStr = typeStr.substring(nArrayLevel);	// 配列指定部分を除外

		VarType	type;
		if (typeStr.equals("void") || typeStr.charAt(0) == 'V')
		{
			type = VarType.VOID;
		}
		else if (typeStr.equals("int") || typeStr.charAt(0) == 'I')
		{
			type = JVMType.getType(VarType.INT, "I");
		}
		else if (typeStr.equals("byte") || typeStr.charAt(0) == 'B')
		{
			type = JVMType.getType(VarType.BYT, "B");
		}
		else if (typeStr.equals("char") || typeStr.charAt(0) == 'C')
		{
			type = JVMType.getType(VarType.CHR, "C");
		}
		else if (typeStr.equals("double") || typeStr.charAt(0) == 'D')
		{
			type = JVMType.getType(VarType.FLT, "D");
		}
		else if (typeStr.equals("float") || typeStr.charAt(0) == 'F')
		{
			type = JVMType.getType(VarType.FLT, "F");
		}
		else if (typeStr.equals("long") || typeStr.charAt(0) == 'J')
		{
			type = JVMType.getType(VarType.INT, "J");
		}
		else if (typeStr.equals("short") || typeStr.charAt(0) == 'S')
		{
			type = JVMType.getType(VarType.INT, "S");
		}
		else if (typeStr.equals("boolean") || typeStr.charAt(0) == 'Z')
		{
			type = JVMType.getType(VarType.BOL, "Z");
		}
		else if (typeStr.equals("java.lang.String") || typeStr.equals("Ljava.lang.String;"))
		{
			type = JVMType.getType(VarType.STR, "java.lang.String");
		}
		else if (typeStr.charAt(0) == 'L')
		{
			typeStr = typeStr.substring(1, typeStr.length() - 1);
			type = JVMType.getType(VarType.OBJ, typeStr);
		}
		else
		{
			type = JVMType.getType(VarType.OBJ, typeStr);
		}

		if (nArrayLevel == 0)
		{
			return	type;
		}

		return	ArrayType.getType(type, nArrayLevel);
	}

}
