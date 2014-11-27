package pyrite.compiler.type;


public class AssocType extends VarType
{
	public final VarType	_keyVarType;
	public final VarType	_valVarType;

	public static VarType getType(VarType keyVarType, VarType valVarType)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("{").append(keyVarType._typeId).append(":").append(valVarType._typeId);

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			varType = new AssocType(typeId, keyVarType, valVarType);
		}

		return	varType;
	}

	protected AssocType(String typeId, VarType keyVarType, VarType valVarType)
	{
		super(TYPE.ASSOC, typeId, "Lpyrite.lang.Assoc;");

		_keyVarType = keyVarType;
		_valVarType = valVarType;
	}
}
