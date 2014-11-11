package pyrite.compiler.type;



public class AssocType extends VarType
{
	public final VarType	_keyVarType;
	public final VarType	_valVarType;

	public static VarType getType(VarType keyVarType, VarType valVarType)
	{
		int	hashCode = createHashCode(TYPE.ASSOC, keyVarType, valVarType);
		VarType	varType = __varTypeMap.get(hashCode);
		if (varType == null)
		{
			varType = new AssocType(TYPE.ASSOC, keyVarType, valVarType);
			__varTypeMap.put(hashCode, varType);
		}

		return	varType;
	}

	protected static int	createHashCode(TYPE type, VarType keyVarType, VarType valVarType)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append(type).append(keyVarType.hashCode()).append(valVarType.hashCode());
		return	sb.toString().hashCode();
	}

	protected static String	createJVMExpression(TYPE type, VarType keyVarType, VarType valVarType)
	{
		StringBuilder	sb = new StringBuilder();
		throw new RuntimeException("not implemented");
		// TODO
//		return	sb.toString();
	}

	protected AssocType(TYPE type, VarType keyVarType, VarType valVarType)
	{
		super._type = type;
		super._hashCode = createHashCode(TYPE.ASSOC, keyVarType, valVarType);
		super._jvmExpression = createJVMExpression(TYPE.ASSOC, keyVarType, valVarType);

		_keyVarType = keyVarType;
		_valVarType = valVarType;
	}


}
