package pyrite.compiler.type;

import pyrite.compiler.FQCNParser;
import pyrite.compiler.FQCNParser.FQCN;
import pyrite.lang.Assoc;

/*
 * 連想配列型
 */
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
			FQCN	fqcn = FQCNParser.getFQCN(Assoc.CLASS_NAME);
			varType = new AssocType(typeId, fqcn, keyVarType, valVarType);
		}

		return	varType;
	}

	protected AssocType(String typeId, FQCN fqcn, VarType keyVarType, VarType valVarType)
	{
		super(TYPE.ASSOC, typeId, fqcn, "L" + fqcn._fqcnStr + ";");

		_keyVarType = keyVarType;
		_valVarType = valVarType;
	}
}
