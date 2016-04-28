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
	public static enum	TYPE {NULL, VOID, OBJ, NUM, INT, DEC, FLT, STR, CHR, BOL, BYT, ARRAY, ASSOC,
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

	static
	{
		/*
		__varTypeMap.put(NULL._typeId, NULL);
		__varTypeMap.put(VOID._typeId, VOID);
		__varTypeMap.put(OBJ._typeId, OBJ);
		__varTypeMap.put(NUM._typeId, NUM);
		__varTypeMap.put(INT._typeId, INT);
		__varTypeMap.put(FLT._typeId, FLT);
		__varTypeMap.put(STR._typeId, STR);
		__varTypeMap.put(CHR._typeId, CHR);
		__varTypeMap.put(BOL._typeId, BOL);
		__varTypeMap.put(BYT._typeId, BYT);

		__varTypeMap.put(JVM_INT._typeId, JVM_INT);
		__varTypeMap.put(JVM_LONG._typeId, JVM_LONG);
		__varTypeMap.put(JVM_SHORT._typeId, JVM_SHORT);
		__varTypeMap.put(JVM_FLOAT._typeId, JVM_FLOAT);
		__varTypeMap.put(JVM_DOUBLE._typeId, JVM_DOUBLE);
		__varTypeMap.put(JVM_CHAR._typeId, JVM_CHAR);
		__varTypeMap.put(JVM_BYTE._typeId, JVM_BYTE);
		__varTypeMap.put(JVM_BOOLEAN._typeId, JVM_BOOLEAN);
		*/
	}

//	// static
//	public static VarType	getType(TYPE type)
//	{
//		int	hashCode = createHashCode(type, nArrayLevel);
//		VarType	varType = __varTypeMap.get(hashCode);
//		if (varType == null)
//		{
//			varType = new VarType(type, nArrayLevel);
//			__varTypeMap.put(hashCode, varType);
//		}
//
//		return	varType;
//	}


/*
	protected static int	createHashCode(TYPE type)
	{
		return	type.hashCode();
	}

	protected static int	createHashCode(TYPE type, String id)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append(type).append(id);
		return	sb.toString().hashCode();
	}

	// TODO:要見直し
	protected static String	createJVMExpression(TYPE type)
	{
		StringBuilder	sb = new StringBuilder();
		switch (type)
		{
		case VOID:
			sb.append("V");
			break;
		case INT:
			sb.append("Ljava.lang.");
			break;
		case STR:
			sb.append("Ljava.lang.String;");
			break;
		case BOL:
			sb.append("Z");
			break;
		default:
			return	null;
		}

		return	sb.toString();
	}
*/

//	protected static String	createJVMExpression(TYPE type, int nArrayLevel)
//	{
//		StringBuilder	sb = new StringBuilder();
//		for (int i = 0; i < nArrayLevel; ++i)
//		{
//			sb.append("[");
//		}
//		switch (type)
//		{
//		case VOID:
//			sb.append("V");
//			break;
//		case INT:
//			sb.append("Ljava.lang.");
//			break;
//		case STR:
//			sb.append("Ljava.lang.String;");
//			break;
//		case BOL:
//			sb.append("Z");
//			break;
//		default:
//			return	null;
//		}
//
//		return	sb.toString();
//	}

// instance
	public final TYPE	_type;
	public final FQCN	_fqcn;
	public final String	_jvmExpression;
	public final String	_typeId;

//	// for PARTIALID
//	protected String	_id;
//
//	// for METHOD, CLASS, PACKAGE
//	protected String	_package;
//	// for METHOD, CLASS
//	protected String	_class;
//	// for METHOD
//	protected String	_method;

	// constructor for sub classes
	protected VarType(TYPE type, String typeId, FQCN fqcn, String jvmExpression)
	{
		_type = type;
		_fqcn = fqcn;
		_jvmExpression = jvmExpression;
		_typeId = typeId;

		__varTypeMap.put(typeId, this);
	}

	private VarType(TYPE type)
	{
		switch (type)
		{
		case NULL:
		case VOID:
		case JVM_INT:
		case JVM_LONG:
		case JVM_SHORT:
		case JVM_FLOAT:
		case JVM_DOUBLE:
		case JVM_CHAR:
		case JVM_BYTE:
		case JVM_BOOLEAN:
			switch (type)
			{
			case NULL:
				_jvmExpression = null;	break;
			case VOID:
				_jvmExpression = "V";	break;
			case JVM_INT:
				_jvmExpression = "I";	break;
			case JVM_LONG:
				_jvmExpression = "J";	break;
			case JVM_SHORT:
				_jvmExpression = "S";	break;
			case JVM_FLOAT:
				_jvmExpression = "F";	break;
			case JVM_DOUBLE:
				_jvmExpression = "D";	break;
			case JVM_CHAR:
				_jvmExpression = "C";	break;
			case JVM_BYTE:
				_jvmExpression = "B";	break;
			case JVM_BOOLEAN:
				_jvmExpression = "Z";	break;
			default:
				throw new RuntimeException("assertion");
			}
			_fqcn = null;			// なくてok
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

//	protected VarType(TYPE type, int nArrayLevel, String id)
//	{
//		_type = type;
//		_nArrayLevel = nArrayLevel;
//		_id = id;
//
//		_hashCode = createHashCode(type, nArrayLevel, id);
//	}

//	public int	hashCode()
//	{
//		return	_hashCode;
//	}
//
//	public boolean	equals(Object o)
//	{
//		return	((VarType)o)._hashCode == _hashCode;
//	}

	public String	toString()
	{
		return	_jvmExpression;
	}

//	public boolean	isPartialId()
//	{
//		return	_type == TYPE.PARTIALID;
//	}


//	// ID 先頭要素の型解決を行った後の型を返す
//	public VarType	resolveType(CodeGenerationVisitor cgv)
//	{
//		return	this;	// PartialIdType 以外は型解決済みなので、自分自身を返す
//	}

	// CodeGenerationVisitor に移動
	//	// この型に続く識別子の型を解決する。
//	// サブクラス毎にそれぞれ続くことができる型が異なるため、とり得る型をそれぞれでチェックする。
//	public VarType	resolveTrailerType(CodeGenerationVisitor cgv, ParseTree idNode)
//	{
//		throw new PyriteSyntaxException("id is not defined.:" + idNode.getText());
//	}


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
			type = ObjectType.getType(typeStr);
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



	// TODO このメソッドの存在を確認する
	// 配列次元数の差分の型を返す
//	public VarType	getArrayType(int addNArrayLevel)
//	{
//		assert (_nArrayLevel + addNArrayLevel >= 0);
//		return	getType(_type, _nArrayLevel + addNArrayLevel);
//	}


//
//	protected VarType(String className, int nArrayLevel, boolean isPartialId)
//	{
//		_className = className;
//		_nArrayLevel = nArrayLevel;
//		_isPartialId = isPartialId;
//
//		_hashCode = createHashCode(className, nArrayLevel, isPartialId);
//	}
//
//	public boolean	isPartialId()
//	{
//		return	_isPartialId;
//	}
//
//
//// static
//	private static Map<Integer, VarType>	__varTypeMap = new HashMap<Integer, VarType>();
//
//	public static VarType	getVarType(String className)
//	{
//		return	getVarType(className, 0);
//	}
//
//	public static VarType	getVarType(String className, int nArrayLevel)
//	{
//		int	hashCode = createHashCode(className, nArrayLevel, true);
//		VarType	varType = __varTypeMap.get(hashCode);
//		if (varType == null)
//		{
//			varType = new VarType(className, nArrayLevel, true);
//		}
//
//		return	varType;
//	}
//
//
//	// ドット続きのidについて、解析前で型が確定していない状態を示す
//	public static VarType	getPartialVarType(String className)
//	{
//		int	hashCode = createHashCode(className, 0, false);
//		VarType	varType = __varTypeMap.get(hashCode);
//		if (varType == null)
//		{
//			varType = new VarType(className, 0, false);
//		}
//
//		return	varType;
//	}



}
