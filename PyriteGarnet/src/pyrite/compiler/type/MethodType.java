package pyrite.compiler.type;

import pyrite.compiler.CodeGenerationVisitor;



public class MethodType extends VarType
{
	public String	_packageClassName;
	public String	_methodName;
	public VarType[]	_paramTypes;
	public VarType[]	_returnTypes;
	public boolean	_isStatic;

	public String	_methodSignature;	// 名前解決のためメソッドのクラス、メソッド名、引数の型よりメソッドを一意に識別する文字列

	public String	_jvmMethodParamExpression;	// メソッド引数のJVM表現

	public static VarType	getType(String packageClassName, String methodName, VarType[] paramTypes, VarType[] returnTypes, boolean isStatic)
	{
		int	hashCode = createHashCode(packageClassName, methodName, paramTypes, returnTypes, isStatic);
		VarType	varType = __varTypeMap.get(hashCode);
		if (varType == null)
		{
			varType = new MethodType(TYPE.METHOD, packageClassName, methodName, paramTypes, returnTypes, isStatic);
			__varTypeMap.put(hashCode, varType);
		}

		return	varType;
	}

	protected static int	createHashCode(String packageClassName, String methodName, VarType[] paramTypes, VarType[] returnTypes, boolean isStatic)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append(TYPE.METHOD).append(packageClassName).append(".").append(methodName);

		sb.append("(");
		for (VarType param : paramTypes)
		{
			sb.append(param._jvmExpression);
		}
		sb.append(")");
		sb.append("(");
		for (VarType param : returnTypes)
		{
			sb.append(param._jvmExpression);
		}
		sb.append(")");
		sb.append(isStatic);

		return	sb.toString().hashCode();
	}


	public static String	createMethodSignature(String packageClassName, String methodName, String methodParamSignature)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append(packageClassName);
		sb.append(".");
		sb.append(methodName);
		sb.append("(");
		sb.append(methodParamSignature);
		sb.append(")");

		return	sb.toString();
	}

	public static String	createMethodSignature(String packageClassName, String methodName, VarType[] paramTypes)
	{
		StringBuilder	sb = new StringBuilder();
		for (VarType param : paramTypes)
		{
			assert (param._jvmExpression != null);
			sb.append(param._jvmExpression);
		}

		return	createMethodSignature(packageClassName, methodName, sb.toString());
	}

	public static String createJvmMethodParamExpression(VarType[] paramTypes, VarType[] returnTypes)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("(");
		for (VarType param : paramTypes)
		{
			assert (param._jvmExpression != null);
			sb.append(param._jvmExpression);
		}
		sb.append(")");

		if (returnTypes.length > 1)
		{
			throw new RuntimeException("not supported yet");
		}

		if (returnTypes.length == 0)
		{
			sb.append("V");
		}
		else
		{
			sb.append(returnTypes[0]._jvmExpression);
		}

		return	sb.toString();
	}

	public String	createConstructorJvmMethodParamExpression()
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("(");
		for (VarType param : _paramTypes)
		{
			assert (param._jvmExpression != null);
			sb.append(param._jvmExpression);
		}
		sb.append(")");
		sb.append("V");
		return	sb.toString();
	}


	protected MethodType(TYPE type, String packageClassName, String methodName, VarType[] paramTypes, VarType[] returnTypes, boolean isStatic)
	{
		_type = type;
		_packageClassName = packageClassName;
		_methodName = methodName;
		_paramTypes = paramTypes;
		_returnTypes = returnTypes;
		_isStatic = isStatic;

		_hashCode = createHashCode(packageClassName, methodName, paramTypes, returnTypes, isStatic);
		_methodSignature = createMethodSignature(packageClassName, methodName, paramTypes);
		_jvmMethodParamExpression = createJvmMethodParamExpression(paramTypes, returnTypes);
	}


	// 識別子解決の段階では、メソッド名に続く識別子は存在しないため、例外を発行
	// (自分の型, 続く型)
	//       (変数, そのクラスのインスタンス変数 | クラス変数 | インスタンスメソッド | クラスメソッド)
	//       (クラス, クラス変数 | クラスメソッド),
	//       (クラス, クラス),
	//       (パッケージ, クラス)
	//       (パッケージ, パッケージ)
	@Override
	public VarType	resolveTrailerType(CodeGenerationVisitor cgv, String id)
	{
		throw new RuntimeException("id is not declared." + id);
	}


	public String getParamStr()
	{
		StringBuilder	sb = new StringBuilder();
		sb.append("(");
		addParamStr(_paramTypes, sb);
		sb.append(")");
		addParamStr(_returnTypes, sb);	// TODO:とりあえず今はパラメータが1個以下のみ

		return	sb.toString();
	}

	private void	addParamStr(VarType[] params, StringBuilder sb)
	{
		if (params.length == 0)
		{
			sb.append("V");
		}
		else
		{
			for (VarType p : params)
			{
				assert (p._jvmExpression != null);
				sb.append(p._jvmExpression);
			}
		}
	}
}
