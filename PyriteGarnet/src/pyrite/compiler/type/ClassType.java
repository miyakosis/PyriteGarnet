package pyrite.compiler.type;

import pyrite.compiler.FQCNParser.FQCN;


public class ClassType extends VarType
{
	public static VarType	getType(FQCN fqcn)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("CLASS:").append(fqcn._fqcnStr);

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			varType = new ClassType(typeId, fqcn);
		}

		return	varType;
	}

	protected ClassType(String typeId, FQCN fqcn)
	{
		super(TYPE.CLASS, typeId, fqcn, null);
	}
}
