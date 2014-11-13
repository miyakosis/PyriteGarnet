package pyrite.compiler.type;



public class ObjectType extends VarType
{
	// for className
	public String	_fqcn;

	public static VarType getType(String fqcn)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("L").append(fqcn).append(";");

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			varType = new ObjectType(typeId, fqcn);
			__varTypeMap.put(typeId, varType);
		}

		return	varType;
	}

	protected ObjectType(String typeId, String fqcn)
	{
		super(TYPE.ASSOC, typeId, typeId);

		_fqcn = fqcn;
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

		_packageClassName = packageClassName;
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

			varType = cr.dispatchVariableI(_packageClassName, id);
			if (varType != null)
			{
//				cgv.setLeftExpressionVarType(2, -1, _packageClassName, id);
//				return	varType;
				return	new AssignLeftExpressionType(varType, 2, -1, _packageClassName, id);
			}

			varType = cr.dispatchVariableC(_packageClassName, id);
			if (varType != null)
			{
//				cgv.setLeftExpressionVarType(3, -1, _packageClassName, id);
//				return	varType;
				return	new AssignLeftExpressionType(varType, 3, -1, _packageClassName, id);
			}
		}
		else
		{
			varType = cr.dispatchVariableI(_packageClassName, id);
			if (varType != null)
			{
				methodDeclaretion.addCodeOp(BC.GETFIELD);
				methodDeclaretion.addCodeU2(cpm.getFieldRef(_packageClassName, id, varType._jvmExpression));

				return	varType;
			}

			varType = cr.dispatchVariableC(_packageClassName, id);
			if (varType != null)
			{
				methodDeclaretion.addCodeOp(BC.GETSTATIC);
				methodDeclaretion.addCodeU2(cpm.getFieldRef(_packageClassName, id, varType._jvmExpression));

				return	varType;
			}
		}

		varType = cr.dispatchMethodIC(_packageClassName, id);
		if (varType != null)
		{
			return	varType;
		}

		throw new RuntimeException("id is not declared." + id);
	}
	*/
}
