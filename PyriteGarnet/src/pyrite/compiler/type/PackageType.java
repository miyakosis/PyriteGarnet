package pyrite.compiler.type;

import pyrite.compiler.FQCNParser.FQCN;


public class PackageType extends VarType
{
	public final FQCN	_fqcn;
//	public final String	_packageName;

	// これが呼ばれるときは、必ずImport宣言を考慮したパッケージになっている
//	public static VarType	getType(String packageName1, String packageName2)
//	{
//		String	packageName = StringUtil.concat(packageName1, packageName2);
//		StringBuilder	sb = new StringBuilder();
//		sb.append("PACKAGE:").append(packageName);
//
//		String	typeId = sb.toString();
//		VarType	varType = __varTypeMap.get(typeId);
//		if (varType == null)
//		{
//			varType = new PackageType(typeId, packageName);
//		}
//
//		return	varType;
//	}

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
		super(TYPE.PACKAGE, typeId, null);

		_fqcn = fqcn;
	}


	// CodeGenerationVisitor に移動
//	// この型に続く識別子の型を解決する。
//	//   Package.Package
//	//   Package.Class
//	@Override
//	public VarType	resolveTrailerType(CodeGenerationVisitor cgv, ParseTree idNode)
//	{
//		ClassResolver	cr = cgv._cr;
//		ImportDeclarationManager	idm = cgv._idm;
//
//		String	id = idNode.getText();
//		FQCN	fqcn = FQCNParser.getFQCN(_fqcn._fqcnStr, id);
//
//		if (cr.isClass(fqcn))
//		{	// class name
//			return	ClassType.getType(fqcn);
//		}
//
//		if (cr.isPackage(fqcn))
//		{
//			return	PackageType.getType(fqcn);
//		}
//
//		throw new RuntimeException("id is not declared." + id);
//	}
}
