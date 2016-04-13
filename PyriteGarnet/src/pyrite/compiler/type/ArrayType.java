package pyrite.compiler.type;

import pyrite.compiler.FQCNParser;
import pyrite.compiler.FQCNParser.FQCN;

public class ArrayType extends VarType
{
	public final VarType	_arrayVarType;

	public static VarType getType(VarType arrayVarType)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("<").append(arrayVarType._typeId);

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			FQCN	fqcn = FQCNParser.getFQCN("pyrite.lang.Array");
			varType = new ArrayType(typeId, fqcn, arrayVarType);
		}

		return	varType;
	}

	/*
	protected static int	createHashCode(TYPE type, VarType arrayVarType)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append(type).append(arrayVarType.hashCode());
		return	sb.toString().hashCode();
	}

	protected static String	createJVMExpression(TYPE type, VarType arrayVarType)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("<");
		sb.append(arrayVarType._jvmExpression);

		return	sb.toString();
	}
	*/

	protected ArrayType(String typeId, FQCN fqcn, VarType arrayVarType)
	{
		super(TYPE.ARRAY, typeId, fqcn, "L" + fqcn._fqcnStr + ";");
		_arrayVarType = arrayVarType;
	}
}
