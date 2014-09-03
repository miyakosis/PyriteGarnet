package pyrite.compiler.type;

import java.util.HashMap;
import java.util.Map;

import pyrite.compiler.CodeGenerationVisitor;

/*
 * コンパイル情報としての型を保持するクラス
 */
public class VarType
{
	public enum	TYPE {NULL, VOID, OBJ, NUM, INT, FLT, STR, CHR, BOL, BYT, ARRAY, JVM_TYPE, PACKAGE, CLASS, METHOD, PARTIALID};

	public static VarType	NULL = new VarType(TYPE.NULL);
	public static VarType	VOID = new VarType(TYPE.VOID);
	public static VarType	OBJ = new VarType(TYPE.OBJ);
	public static VarType	NUM = new VarType(TYPE.NUM);
	public static VarType	INT = new VarType(TYPE.INT);
	public static VarType	FLT = new VarType(TYPE.FLT);
	public static VarType	STR = new VarType(TYPE.STR);
	public static VarType	CHR = new VarType(TYPE.CHR);
	public static VarType	BOL = new VarType(TYPE.BOL);
	public static VarType	BYT = new VarType(TYPE.BYT);


	protected static Map<Integer, VarType>	__varTypeMap = new HashMap<Integer, VarType>();

	static
	{
		__varTypeMap.put(NULL._hashCode, NULL);
		__varTypeMap.put(VOID._hashCode, VOID);
		__varTypeMap.put(OBJ._hashCode, OBJ);
		__varTypeMap.put(NUM._hashCode, NUM);
		__varTypeMap.put(INT._hashCode, INT);
		__varTypeMap.put(FLT._hashCode, FLT);
		__varTypeMap.put(STR._hashCode, STR);
		__varTypeMap.put(CHR._hashCode, CHR);
		__varTypeMap.put(BOL._hashCode, BOL);
		__varTypeMap.put(BYT._hashCode, BYT);
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
	public TYPE	_type;
	protected int	_hashCode;

	// for VOID, INT, STR, BOL, OBJECT
	public String	_jvmExpression;


//	// for PARTIALID
//	protected String	_id;
//
//	// for METHOD, CLASS, PACKAGE
//	protected String	_package;
//	// for METHOD, CLASS
//	protected String	_class;
//	// for METHOD
//	protected String	_method;

	protected VarType()
	{
	}

	protected VarType(TYPE type)
	{
		_type = type;
		_hashCode = createHashCode(type);

		_jvmExpression = createJVMExpression(type);
	}

//	protected VarType(TYPE type, int nArrayLevel, String id)
//	{
//		_type = type;
//		_nArrayLevel = nArrayLevel;
//		_id = id;
//
//		_hashCode = createHashCode(type, nArrayLevel, id);
//	}

	public int	hashCode()
	{
		return	_hashCode;
	}

	public boolean	equals(Object o)
	{
		return	((VarType)o)._hashCode == _hashCode;
	}

	public String	toString()
	{
		return	_jvmExpression;
	}

//	public boolean	isPartialId()
//	{
//		return	_type == TYPE.PARTIALID;
//	}


	// ID 先頭要素の型解決を行った後の型を返す
	public VarType	resolveType(CodeGenerationVisitor cgv)
	{
		return	this;	// PartialIdType 以外は型解決済みなので、自分自身を返す
	}

	// (自分の型, 続く型)
	//       (変数, そのクラスのインスタンス変数 | クラス変数 | インスタンスメソッド | クラスメソッド)
	//       (クラス, クラス変数 | クラスメソッド),
	//       (クラス, クラス),
	//       (パッケージ, クラス)
	//       (パッケージ, パッケージ)
	public VarType	resolveTrailerType(CodeGenerationVisitor cgv, String id)
	{
		throw new RuntimeException("not implemented");
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
