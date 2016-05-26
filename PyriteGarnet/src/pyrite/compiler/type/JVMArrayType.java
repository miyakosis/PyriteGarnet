package pyrite.compiler.type;


public class JVMArrayType extends VarType
{
	public final VarType	_arrayVarType;
	public final int	_nArrayDimension;

	public static VarType getType(VarType arrayVarType, int nArrayLevel)
	{
		StringBuilder	sb = new StringBuilder();
		for (int i = 0; i < nArrayLevel; ++i)
		{
			sb.append("[");
		}
		sb.append(arrayVarType._jvmExpression);

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			varType = new JVMArrayType(typeId, arrayVarType, nArrayLevel);
		}

		return	varType;
	}

	protected JVMArrayType(String typeId, VarType arrayVarType, int nArrayDimension)
	{
		super(TYPE.JVM_ARRAY, typeId, null, typeId);

		_arrayVarType = arrayVarType;
		_nArrayDimension = nArrayDimension;
	}
}
