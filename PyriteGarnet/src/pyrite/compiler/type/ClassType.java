package pyrite.compiler.type;

import pyrite.compiler.BC;
import pyrite.compiler.ClassResolver;
import pyrite.compiler.CodeGenerationVisitor;
import pyrite.compiler.ConstantPoolManager;
import pyrite.compiler.MethodCodeDeclation;
import pyrite.compiler.util.StringUtil;


public class ClassType extends VarType
{
	// for METHOD, CLASS, PACKAGE
	public String	_packageName;
	// for METHOD, CLASS
	public String	_className;

	public String	_packageClassName;


	public static VarType	getType(String packageName, String className)
	{
		String	fqcn = StringUtil.concat(packageName, className);
		int	hashCode = createHashCode(TYPE.CLASS, fqcn);
		VarType	varType = __varTypeMap.get(hashCode);
		if (varType == null)
		{
			varType = new ClassType(TYPE.CLASS, packageName, className);
		}

		return	varType;
	}

	protected ClassType(TYPE type, String packageName, String className)
	{
		super._type = type;
		super._hashCode = createHashCode(type, StringUtil.concat(packageName,  className));

		_packageName = packageName;
		_className = className;
		_packageClassName = StringUtil.concat(packageName, className);
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
		ConstantPoolManager	cpm = cgv._cpm;
		MethodCodeDeclation	methodDeclaretion = cgv._currentMethodCodeDeclation;

		VarType	varType;
		String	packageClassName = StringUtil.concat(_packageName, _className);

		varType = cd.dispatchVariableC(packageClassName, id);
		if (varType != null)
		{	// クラス変数

			// code
			if (cgv.isAssignLeftExpressionElement(id))
			{	// assign
				// assign()で値設定するため、ここでコードは作成しない。
				// 代わりに setLeftExpressionVarType() を呼び出し、設定情報を保持しておく。
//				cgv.setLeftExpressionVarType(3, -1, packageClassName, id);

				return	new AssignLeftExpressionType(varType, 3, -1, packageClassName, id);

			}
			else
			{
				methodDeclaretion.addCodeOp(BC.GETSTATIC);
				methodDeclaretion.addCodeU2(cpm.getFieldRef(packageClassName, id, varType._jvmExpression));
			}

			return	varType;
		}

		varType = cd.dispatchMethodC(packageClassName, id);
		if (varType != null)
		{	// クラスメソッド
			return	varType;
		}

		// TODO:クラス.クラスはとりあえず未サポート
		throw new RuntimeException("id is not declared. " + id);
	}

//	// TODO:メソッドの存在を確認する
//	// 配列次元数の差分の型を返す
//	@Override
//	public VarType	getArrayType(int addNArrayLevel)
//	{
//		assert (_nArrayLevel + addNArrayLevel >= 0);
//		return	getType(_packageName, _className, _nArrayLevel + addNArrayLevel);
//	}
}
