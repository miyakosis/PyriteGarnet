package pyrite.compiler.type;

import pyrite.compiler.util.StringUtil;


public class PackageType extends VarType
{
	public final String	_package;

	public static VarType	getType(String packageName1, String packageName2)
	{
		String	packageName = StringUtil.concat(packageName1, packageName2);
		StringBuilder	sb = new StringBuilder();
		sb.append("PACKAGE:").append(packageName);

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			varType = new PackageType(typeId, packageName);
		}

		return	varType;
	}

	protected PackageType(String typeId, String packageName)
	{
		super(TYPE.PACKAGE, typeId, null);

		_package = packageName;
	}

	/*
	// (自分の型, 続く型)
	//       (変数, そのクラスのインスタンス変数 | クラス変数 | インスタンスメソッド | クラスメソッド)
	//       (クラス, クラス変数 | クラスメソッド),
	//       (クラス, クラス),
	//       (パッケージ, クラス)
	//       (パッケージ, パッケージ)
	@Override
	public VarType	resolveTrailerType(CodeGenerationVisitor cgv, String id)
	{
		ClassResolver	cr = cgv._cr;
		ImportDeclarationManager	idm = cgv._idm;

		String[]	packageClassName = idm.resolveClassName(_package, id);
		if (packageClassName != null)
		{	// class name
			return	ClassType.getType(packageClassName[0], packageClassName[1]);
		}

		if (cr.isPackage(_package, id))
		{
			return	PackageType.getType(_package, id);
		}

		throw new RuntimeException("id is not declared." + id);
	}
	*/
}
