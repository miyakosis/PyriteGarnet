package pyrite.compiler.type;

import pyrite.compiler.ClassResolver;
import pyrite.compiler.CodeGenerationVisitor;
import pyrite.compiler.ImportDeclarationManager;
import pyrite.compiler.util.StringUtil;


public class PackageType extends VarType
{
	// for METHOD, CLASS, PACKAGE
	protected String	_package;

	public static VarType	getType(String packageName1, String packageName2)
	{
		String	id = StringUtil.concat(packageName1, packageName2);
		int	hashCode = createHashCode(TYPE.PACKAGE, id);
		VarType	varType = __varTypeMap.get(hashCode);
		if (varType == null)
		{
			varType = new PackageType(TYPE.PACKAGE, id);
			__varTypeMap.put(hashCode, varType);
		}

		return	varType;
	}

	protected PackageType(TYPE type, String packageName)
	{
		super._type = type;
		super._hashCode = createHashCode(type, packageName);

		_package = packageName;
	}

	// (自分の型, 続く型)
	//       (変数, そのクラスのインスタンス変数 | クラス変数 | インスタンスメソッド | クラスメソッド)
	//       (クラス, クラス変数 | クラスメソッド),
	//       (クラス, クラス),
	//       (パッケージ, クラス)
	//       (パッケージ, パッケージ)
	@Override
	public VarType	resolveTrailerType(CodeGenerationVisitor cgv, String id)
	{
		ClassResolver	cd = cgv._cr;
		ImportDeclarationManager	idm = cgv._idm;

		String[]	packageClassName = idm.resolveClassName(_package, id);
		if (packageClassName != null)
		{	// class name
			return	ClassType.getType(packageClassName[0], packageClassName[1]);
		}

		if (cd.isPackage(_package, id))
		{
			return	PackageType.getType(_package, id);
		}

		throw new RuntimeException("id is not declared." + id);
	}
}
