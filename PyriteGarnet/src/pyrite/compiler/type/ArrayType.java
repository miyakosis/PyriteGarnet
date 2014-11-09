package pyrite.compiler.type;




public class ArrayType extends VarType
{
	public final VarType	_arrayVarType;

	public static VarType getType(VarType arrayVarType)
	{
		int	hashCode = createHashCode(TYPE.ARRAY, arrayVarType);
		VarType	varType = __varTypeMap.get(hashCode);
		if (varType == null)
		{
			varType = new ArrayType(TYPE.ARRAY, arrayVarType);
			__varTypeMap.put(hashCode, varType);
		}

		return	varType;
	}

	protected static int	createHashCode(TYPE type, VarType arrayVarType)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append(type).append(arrayVarType.hashCode());
		return	sb.toString().hashCode();
	}

	protected static String	createJVMExpression(TYPE type, VarType arrayVarType)
	{
		StringBuilder	sb = new StringBuilder();
		// TODO:
		sb.append(arrayVarType._jvmExpression);

		return	sb.toString();
	}

	protected ArrayType(TYPE type, VarType arrayVarType)
	{
		super._type = type;
		super._hashCode = createHashCode(TYPE.ARRAY, arrayVarType);
		super._jvmExpression = createJVMExpression(TYPE.ARRAY, arrayVarType);

		_arrayVarType = arrayVarType;
	}
}
