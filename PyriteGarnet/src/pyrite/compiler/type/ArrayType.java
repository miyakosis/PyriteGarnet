package pyrite.compiler.type;

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
			varType = new ArrayType(typeId, arrayVarType);
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

	protected ArrayType(String typeId, VarType arrayVarType)
	{
		super(TYPE.ARRAY, typeId, "Lpyrite.lang.Array;");
		_arrayVarType = arrayVarType;
	}
}
