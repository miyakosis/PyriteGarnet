package pyrite.compiler.type;

import pyrite.compiler.FQCNParser.FQCN;


public class PackageType extends VarType
{
	// precond:これが呼ばれるときは、必ずImport宣言を考慮したパッケージになっている
	public static VarType	getType(FQCN fqcn)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("PACKAGE:").append(fqcn._fqcnStr);

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			varType = new PackageType(typeId, fqcn);
		}

		return	varType;
	}

	protected PackageType(String typeId, FQCN fqcn)
	{
		super(TYPE.PACKAGE, typeId, null, null);
	}
}
