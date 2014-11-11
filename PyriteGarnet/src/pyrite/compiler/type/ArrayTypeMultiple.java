package pyrite.compiler.type;



// not used version 0.0.0
public class ArrayTypeMultiple extends VarType
{
	public final VarType	_arrayVarType;
	public final int	_nArrayLevel;

	public static VarType getType(VarType arrayVarType, int nArrayLevel)
	{
		int	hashCode = createHashCode(TYPE.ARRAY, arrayVarType, nArrayLevel);
		VarType	varType = __varTypeMap.get(hashCode);
		if (varType == null)
		{
			varType = new ArrayTypeMultiple(TYPE.ARRAY, arrayVarType, nArrayLevel);
			__varTypeMap.put(hashCode, varType);
		}

		return	varType;
	}

	protected static int	createHashCode(TYPE type, VarType arrayVarType, int nArrayLevel)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append(type).append(arrayVarType.hashCode());
		for (int i = 0; i < nArrayLevel; ++i)
		{
			sb.append("[");
		}
		return	sb.toString().hashCode();
	}

	protected static String	createJVMExpression(TYPE type, VarType arrayVarType, int nArrayLevel)
	{
		StringBuilder	sb = new StringBuilder();
		for (int i = 0; i < nArrayLevel; ++i)
		{
			sb.append("[");
		}
		sb.append(arrayVarType._jvmExpression);

		return	sb.toString();
	}

	protected ArrayTypeMultiple(TYPE type, VarType arrayVarType, int nArrayLevel)
	{
		super._type = type;
		super._hashCode = createHashCode(TYPE.ARRAY, arrayVarType, nArrayLevel);
		super._jvmExpression = createJVMExpression(TYPE.ARRAY, arrayVarType, nArrayLevel);

		_arrayVarType = arrayVarType;
		_nArrayLevel = nArrayLevel;
	}

	public VarType	getType(int nArrayLevelDiff)
	{
		int	nextLevel = _nArrayLevel + nArrayLevelDiff;
		return	(nextLevel == 0) ? _arrayVarType : getType(_arrayVarType, nArrayLevelDiff);
	}
}
