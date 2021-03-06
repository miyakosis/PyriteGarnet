package pyrite.compiler.type;

import java.util.HashMap;
import java.util.Map;

import pyrite.compiler.FQCNParser;
import pyrite.compiler.FQCNParser.FQCN;

/*
 * コンパイル情報としての型を保持するクラス
 */
public class VarType
{
	public final static String	CLASS_NAME = "pyrite.compiler.type.VarType";

	// 型のタイプ
	public static enum	TYPE {NULL, VOID, OBJ, NUM, INT, DEC, FLT, STR, CHR, BOL, BYT, ARRAY, ASSOC,
		MULTIPLE, MULTIPLE_LIST,
		PACKAGE, CLASS, METHOD, METHOD_NAME,
		JVM_OBJECT, JVM_INT, JVM_LONG, JVM_SHORT, JVM_FLOAT, JVM_DOUBLE, JVM_CHAR, JVM_BYTE, JVM_BOOLEAN, JVM_ARRAY,
	};

	// typeIdをキーに、VarTypeをキャッシュするMap
	// new VarType(TYPE) より先にMapを生成しておく必要がある
	protected static Map<String, VarType>	__varTypeMap = new HashMap<String, VarType>();	// key:_typeId

	public final static VarType	NULL = new VarType(TYPE.NULL);
	public final static VarType	VOID = new VarType(TYPE.VOID);
	public final static VarType	OBJ = new VarType(TYPE.OBJ);
	public final static VarType	NUM = new VarType(TYPE.NUM);
	public final static VarType	INT = new VarType(TYPE.INT);
	public final static VarType	DEC = new VarType(TYPE.DEC);
	public final static VarType	FLT = new VarType(TYPE.FLT);
	public final static VarType	STR = new VarType(TYPE.STR);
	public final static VarType	CHR = new VarType(TYPE.CHR);
	public final static VarType	BOL = new VarType(TYPE.BOL);
	public final static VarType	BYT = new VarType(TYPE.BYT);

	public final static VarType	JVM_INT = new VarType(TYPE.JVM_INT);
	public final static VarType	JVM_LONG = new VarType(TYPE.JVM_LONG);
	public final static VarType	JVM_SHORT = new VarType(TYPE.JVM_SHORT);
	public final static VarType	JVM_FLOAT = new VarType(TYPE.JVM_FLOAT);
	public final static VarType	JVM_DOUBLE = new VarType(TYPE.JVM_DOUBLE);
	public final static VarType	JVM_CHAR = new VarType(TYPE.JVM_CHAR);
	public final static VarType	JVM_BYTE = new VarType(TYPE.JVM_BYTE);
	public final static VarType	JVM_BOOLEAN = new VarType(TYPE.JVM_BOOLEAN);
	public final static VarType	JVM_STRING = ObjectType.getType("java.lang.String");

	// _typeId は VarTypeを一意に識別できる文字列。
	// NULL:
	// VOID:
	// OBJ:
	// NUM:
	// INT:
	// FLT:
	// STR:
	// CHR:
	// BOL:
	// BYT:
	// ARRAY:
	// ASSOC:
	// PACKAGE:
	// CLASS:
	// METHOD, PARTIALID,
	// JVM_OBJECT, JVM_INT, JVM_LONG, JVM_SHORT, JVM_FLOAT, JVM_DOUBLE, JVM_CHAR, JVM_BYTE, JVM_BOOLEAN, JVM_ARRAY


// instance
	public final TYPE	_type;
	public final String	_typeId;	// オブジェクトを一意に識別する文字列。大抵は_jvmExpressionと同じだが、ArrayやAssocは保持する型情報もこの文字列に含め、一意性を確保している。
	public final FQCN	_fqcn;
	public final String	_jvmExpression;	// オブジェクトをjava vmで参照するための文字列。

	// constructor for sub classes
	protected VarType(TYPE type, String typeId, FQCN fqcn, String jvmExpression)
	{
		_type = type;
		_typeId = typeId;
		_fqcn = fqcn;
		_jvmExpression = jvmExpression;

		if (typeId != null)
		{
			__varTypeMap.put(typeId, this);
		}
	}

	protected VarType()
	{
		_type = null;
		_typeId = null;
		_fqcn = null;
		_jvmExpression = null;
	}

	private VarType(TYPE type)
	{
		switch (type)
		{
		case NULL:
			_fqcn = null;
			_jvmExpression = null;
			break;
		case VOID:
			_fqcn = null;
			_jvmExpression = "V";
			break;
		case JVM_INT:
			_fqcn = FQCNParser.getFQCN(int.class.getName());
			_jvmExpression = "I";
			break;
		case JVM_LONG:
			_fqcn = FQCNParser.getFQCN(long.class.getName());
			_jvmExpression = "J";
			break;
		case JVM_SHORT:
			_fqcn = FQCNParser.getFQCN(short.class.getName());
			_jvmExpression = "S";
			break;
		case JVM_FLOAT:
			_fqcn = FQCNParser.getFQCN(float.class.getName());
			_jvmExpression = "F";
			break;
		case JVM_DOUBLE:
			_fqcn = FQCNParser.getFQCN(double.class.getName());
			_jvmExpression = "D";
			break;
		case JVM_CHAR:
			_fqcn = FQCNParser.getFQCN(char.class.getName());
			_jvmExpression = "C";
			break;
		case JVM_BYTE:
			_fqcn = FQCNParser.getFQCN(byte.class.getName());
			_jvmExpression = "B";
			break;
		case JVM_BOOLEAN:
			_fqcn = FQCNParser.getFQCN(boolean.class.getName());
			_jvmExpression = "Z";
			break;

		case OBJ:
		case NUM:
		case INT:
		case DEC:
		case FLT:
		case STR:
		case CHR:
		case BOL:
		case BYT:
			String	fqcnStr;
			switch (type)
			{
			case OBJ:
				fqcnStr = pyrite.lang.Object.CLASS_NAME;	break;
			case NUM:
				fqcnStr = pyrite.lang.Number.CLASS_NAME;	break;
			case INT:
				fqcnStr = pyrite.lang.Integer.CLASS_NAME;	break;
			case DEC:
				fqcnStr = pyrite.lang.Decimal.CLASS_NAME;	break;
			case FLT:
				fqcnStr = pyrite.lang.Float.CLASS_NAME;	break;
			case STR:
				fqcnStr = pyrite.lang.String.CLASS_NAME;	break;
			case CHR:
				fqcnStr = pyrite.lang.Character.CLASS_NAME;	break;
			case BOL:
				fqcnStr = pyrite.lang.Boolean.CLASS_NAME;	break;
			case BYT:
				fqcnStr = pyrite.lang.Byte.CLASS_NAME;	break;
			default:
				throw new RuntimeException("assertion");
			}
			_fqcn = FQCNParser.getFQCN(fqcnStr);
			_jvmExpression = "L" + fqcnStr + ";";

			break;

		default:
			throw new RuntimeException("assertion");
		}

		_type = type;
		_typeId = _jvmExpression;

		__varTypeMap.put(_typeId, this);
	}

	@Override
	public int	hashCode()
	{
		return	_typeId.hashCode();
	}

	@Override
	public boolean	equals(Object o)
	{
		return	(o instanceof VarType) && _typeId.equals(((VarType)o)._typeId);
	}

	@Override
	public String	toString()
	{
		return	_typeId;
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
			type = VarType.JVM_INT;
		}
		else if (typeStr.equals("long") || typeStr.charAt(0) == 'J')
		{
			type = VarType.JVM_LONG;
		}
		else if (typeStr.equals("short") || typeStr.charAt(0) == 'S')
		{
			type = VarType.JVM_SHORT;
		}
		else if (typeStr.equals("float") || typeStr.charAt(0) == 'F')
		{
			type = VarType.JVM_FLOAT;
		}
		else if (typeStr.equals("double") || typeStr.charAt(0) == 'D')
		{
			type = VarType.JVM_DOUBLE;
		}
		else if (typeStr.equals("char") || typeStr.charAt(0) == 'C')
		{
			type = VarType.JVM_CHAR;
		}
		else if (typeStr.equals("byte") || typeStr.charAt(0) == 'B')
		{
			type = VarType.JVM_BYTE;
		}
		else if (typeStr.equals("boolean") || typeStr.charAt(0) == 'Z')
		{
			type = VarType.JVM_BOOLEAN;
		}
		else
		{
			if (typeStr.charAt(0) == 'L')
			{
				typeStr = typeStr.substring(1, typeStr.length() - 1);
			}

			if (typeStr.equals(pyrite.lang.Object.CLASS_NAME))
			{
				type = OBJ;
			}
			else if (typeStr.equals(pyrite.lang.Number.CLASS_NAME))
			{
				type = NUM;
			}
			else if (typeStr.equals(pyrite.lang.Integer.CLASS_NAME))
			{
				type = INT;
			}
			else if (typeStr.equals(pyrite.lang.Decimal.CLASS_NAME))
			{
				type = DEC;
			}
			else if (typeStr.equals(pyrite.lang.Float.CLASS_NAME))
			{
				type = FLT;
			}
			else if (typeStr.equals(pyrite.lang.String.CLASS_NAME))
			{
				type = STR;
			}
			else if (typeStr.equals(pyrite.lang.Character.CLASS_NAME))
			{
				type = CHR;
			}
			else if (typeStr.equals(pyrite.lang.Boolean.CLASS_NAME))
			{
				type = BOL;
			}
			else if (typeStr.equals(pyrite.lang.Byte.CLASS_NAME))
			{
				type = BYT;
			}
			else
			{
				type = ObjectType.getType(typeStr);
			}
		}

		if (nArrayLevel == 0)
		{
			return	type;
		}
		else
		{
			return	JVMArrayType.getType(type, nArrayLevel);
		}
	}

	// Pyrite型に対応するJVM型を返す。
	public static VarType[]	getAssociatedJVMType(VarType pyriteType)
	{
		final	VarType[]	emptyType = new VarType[0];
		switch (pyriteType._type)
		{
		case NULL:
			return	emptyType;

		case OBJ:
			return	emptyType;

		case ARRAY:
			// TODO: ARRAY, ASSOC は 保持するオブジェクトの型一致判定もする必要がある。今後要検討
			// javaの配列型に変換する。多次元配列にも対応する。ex. [[bol]] -> boolean[][]
			ArrayType	arrayType = (ArrayType)pyriteType;

			VarType	arrayContentType = ArrayType.getContentVarType(arrayType);
			int	dimension = ArrayType.getContentDimension(arrayType);

			// ArrayContentType に対応するJVM型が存在する場合は取得する
			VarType[]	jvmDataTypes = getAssociatedJVMType(arrayContentType);

			// 対応するJVM配列型を返す
			VarType[]	result = new VarType[jvmDataTypes.length + 1];
			result[0] = JVMArrayType.getType(arrayContentType, dimension);
			for (int i = 0; i < jvmDataTypes.length; ++i)
			{
				result[i + 1] = JVMArrayType.getType(jvmDataTypes[i], dimension);
			}
			return	result;

		case ASSOC:
			// TODO: ARRAY, ASSOC は 保持するオブジェクトの型一致判定もする必要がある。今後要検討
			// 処理なし
			return	emptyType;

		case INT:
			// TODO:プログラムからどのようにlong, short の引数のメソッドを指定させるか
			// pyrite.lang.Integer > int(Java) > pyrite.lang.Object の順とする
			return	new VarType[]{VarType.JVM_INT, VarType.JVM_LONG, VarType.JVM_SHORT,};

		case DEC:
			return	new VarType[]{VarType.JVM_DOUBLE, VarType.JVM_FLOAT,};

		case STR:
			// pyrite.lang.String > java.lang.String > pyrite.lang.Object > java.lang.Object の順とする
			return	new VarType[]{VarType.JVM_STRING};

		case CHR:
			return	new VarType[]{VarType.JVM_CHAR};

		case BOL:
			return	new VarType[]{VarType.JVM_BOOLEAN};

		case BYT:
			return	new VarType[]{VarType.JVM_BYTE};

		default:
			throw new RuntimeException("assertion");
		}
	}

	// JVM型に対応するPyrite型を返す。
	public static VarType	getAssociatedPyriteType(VarType jvmType)
	{
		switch (jvmType._type)
		{
		case JVM_INT:
			return	VarType.INT;
		case JVM_LONG:
			return	VarType.INT;
		case JVM_SHORT:
			return	VarType.INT;
		case JVM_FLOAT:
			return	VarType.DEC;
		case JVM_DOUBLE:
			return	VarType.DEC;
		case JVM_CHAR:
			return	VarType.CHR;
		case JVM_BYTE:
			return	VarType.BYT;
		case JVM_BOOLEAN:
			return	VarType.BOL;
		case OBJ:
			if (jvmType._fqcn._fqcnStr.equals(VarType.JVM_STRING._fqcn._fqcnStr))
			{
				return	VarType.STR;
			}
			else
			{
				return	jvmType;
			}
		default:
			return	jvmType;
		}
	}
}
