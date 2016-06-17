package pyrite.compiler.type;

import pyrite.compiler.FQCNParser;
import pyrite.compiler.FQCNParser.FQCN;


public class ObjectType extends VarType
{
	public static VarType getType(String fqcnStr)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("L").append(fqcnStr).append(";");

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			FQCN	fqcn = FQCNParser.getFQCN(fqcnStr);
			varType = new ObjectType(typeId, fqcn);
		}

		return	varType;
	}

	protected ObjectType(String typeId, FQCN fqcn)
	{
		super(TYPE.OBJ, typeId, fqcn, typeId);
	}
}
