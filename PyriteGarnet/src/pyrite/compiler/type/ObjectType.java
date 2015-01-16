package pyrite.compiler.type;

import pyrite.compiler.BC;
import pyrite.compiler.ClassResolver;
import pyrite.compiler.CodeGenerationVisitor;
import pyrite.compiler.ConstantPoolManager;
import pyrite.compiler.FQCNParser;
import pyrite.compiler.FQCNParser.FQCN;
import pyrite.compiler.MethodCodeDeclation;



public class ObjectType extends VarType
{
	// for className
	public FQCN	_fqcn;

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
		super(TYPE.OBJ, typeId, typeId);

		_fqcn = fqcn;
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
		ClassResolver	cr = cgv._cr;
		ConstantPoolManager	cpm = cgv._cpm;
		MethodCodeDeclation	methodDeclaretion = cgv._currentMethodCodeDeclation;

		VarType	varType;
		if (cgv.isAssignLeftExpressionElement(id))
		{	// assign
			// assign()で値設定するため、ここでコードは作成しない。
			// 代わりに setLeftExpressionVarType() を呼び出し、設定情報を保持しておく。

			varType = cr.dispatchVariableI(_fqcn._fqcnStr, id);
			if (varType != null)
			{
//				cgv.setLeftExpressionVarType(2, -1, _fqcn._fqcnStr, id);
//				return	varType;
				return	new AssignLeftExpressionType(varType, 2, -1, _fqcn._fqcnStr, id);
			}

			varType = cr.dispatchVariableC(_fqcn._fqcnStr, id);
			if (varType != null)
			{
//				cgv.setLeftExpressionVarType(3, -1, _fqcn._fqcnStr, id);
//				return	varType;
				return	new AssignLeftExpressionType(varType, 3, -1, _fqcn._fqcnStr, id);
			}
		}
		else
		{
			varType = cr.dispatchVariableI(_fqcn._fqcnStr, id);
			if (varType != null)
			{
				methodDeclaretion.addCodeOp(BC.GETFIELD);
				methodDeclaretion.addCodeU2(cpm.getFieldRef(_fqcn._fqcnStr, id, varType._jvmExpression));

				return	varType;
			}

			varType = cr.dispatchVariableC(_fqcn._fqcnStr, id);
			if (varType != null)
			{
				methodDeclaretion.addCodeOp(BC.GETSTATIC);
				methodDeclaretion.addCodeU2(cpm.getFieldRef(_fqcn._fqcnStr, id, varType._jvmExpression));

				return	varType;
			}
		}

		varType = cr.dispatchMethodIC(_fqcn._fqcnStr, id);
		if (varType != null)
		{
			return	varType;
		}

		throw new RuntimeException("id is not declared." + id);
	}


	// TODO:
	/*
	public static VarType	getType(String fqcn)
	{
		int	hashCode = createHashCode(TYPE.OBJ, packageClassName);
		VarType	varType = __varTypeMap.get(hashCode);
		if (varType == null)
		{
			varType = new ObjectType(TYPE.OBJ, packageClassName);
			__varTypeMap.put(hashCode, varType);
		}

		return	varType;
	}

	protected static String	createJVMExpression(TYPE type, String packageClassName)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("L").append(packageClassName).append(";");
		return	sb.toString();
	}

	protected ObjectType(TYPE type, String packageClassName)
	{
		super._type = type;
		super._hashCode = createHashCode(type, packageClassName);
		super._jvmExpression = createJVMExpression(type, packageClassName);

		_fqcn._fqcnStr = packageClassName;
	}

	*/
}
