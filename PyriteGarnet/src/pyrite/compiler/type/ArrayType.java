package pyrite.compiler.type;

import pyrite.compiler.FQCNParser;
import pyrite.compiler.FQCNParser.FQCN;
import pyrite.lang.Array;

/*
 * 配列型
 */
public class ArrayType extends VarType
{
	// 配列に保持する型
	public final VarType	_arrayVarType;

	public static VarType getType(VarType arrayVarType)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("<").append(arrayVarType._typeId);

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			FQCN	fqcn = FQCNParser.getFQCN(Array.CLASS_NAME);
			varType = new ArrayType(typeId, fqcn, arrayVarType);
		}

		return	varType;
	}

	// JVMArrayType より対応する ArrayTypeを作成する
	public static VarType getType(JVMArrayType jvmArrayType)
	{
		VarType	pyriteType = VarType.getAssociatedPyriteType(jvmArrayType._arrayVarType);

		VarType	resultArrayType = ArrayType.getType(pyriteType);
		for (int i = 1; i < jvmArrayType._nArrayDimension; ++i)
		{
			resultArrayType = ArrayType.getType(resultArrayType);
		}
		return	resultArrayType;
	}

	// 配列を辿り、保持している ArrayType 以外の VarType を返す
	public static VarType	getContentVarType(ArrayType arrayType)
	{
		int	dimension;
		for (dimension = 1;; ++dimension)
		{
			if (arrayType._arrayVarType._type == TYPE.ARRAY)
			{
				// ArrayのArrayであるため、次のレベルを探索する
				arrayType = (ArrayType)arrayType._arrayVarType;
			}
			else
			{	// 保持される型である
				return	arrayType._arrayVarType;
			}
		}
	}

	// 配列を辿り、保持している ArrayType 以外の VarType の次元を返す
	public static int	getContentDimension(ArrayType arrayType)
	{
		int	dimension;
		for (dimension = 1;; ++dimension)
		{
			if (arrayType._arrayVarType._type == TYPE.ARRAY)
			{
				// ArrayのArrayであるため、次のレベルを探索する
				arrayType = (ArrayType)arrayType._arrayVarType;
			}
			else
			{	// 保持される型である
				return	dimension;
			}
		}
	}

	protected ArrayType(String typeId, FQCN fqcn, VarType arrayVarType)
	{
		super(TYPE.ARRAY, typeId, fqcn, "L" + fqcn._fqcnStr + ";");
		_arrayVarType = arrayVarType;
	}
}
