package pyrite.compiler.type;

import java.lang.reflect.Modifier;

import pyrite.compiler.FQCNParser.FQCN;



public class MethodType extends VarType
{
//	public final FQCN	_fqcn;		// メソッドが所属するクラス
	public final String	_methodName;
	public final VarType[]	_paramTypes;
	public final VarType[]	_returnTypes;
	public final boolean	_isStatic;
	public final int	_modifier;

	public final String	_methodSignature;	// 名前解決のためメソッドのクラス、メソッド名、引数の型よりメソッドを一意に識別する文字列(返り値は含まれない)

	public final String	_jvmMethodParamExpression;	// メソッド引数のJVM表現

	public static VarType	getType(FQCN fqcn, String methodName, VarType[] paramTypes, VarType[] returnTypes, int modifier)
	{
		boolean	isStatic = ((modifier & Modifier.STATIC) != 0);

		StringBuilder	sb = new StringBuilder();
		sb.append("METHOD:").append(fqcn._fqcnStr).append(".").append(methodName);
		sb.append("(");
		for (VarType param : paramTypes)
		{
			sb.append(param._typeId);
		}
		sb.append(")");
		sb.append("(");
		for (VarType param : returnTypes)
		{
			sb.append(param._typeId);
		}
		sb.append(")");
		sb.append(isStatic);

		String	typeId = sb.toString();
		VarType	varType = __varTypeMap.get(typeId);
		if (varType == null)
		{
			varType = new MethodType(typeId, fqcn, methodName, paramTypes, returnTypes, isStatic, modifier);
		}

		return	varType;
	}

	protected MethodType(String typeId, FQCN fqcn, String methodName, VarType[] paramTypes, VarType[] returnTypes, boolean isStatic, int modifier)
	{
		super(TYPE.METHOD, typeId, fqcn, null);

//		_fqcn = fqcn;
		_methodName = methodName;
		_paramTypes = paramTypes;
		_returnTypes = returnTypes;
		_isStatic = isStatic;
		_modifier = modifier;

		_methodSignature = createMethodSignature(fqcn._fqcnStr, methodName, paramTypes);
		_jvmMethodParamExpression = createJvmMethodParamExpression(paramTypes, returnTypes);
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

		switch (returnTypes.length)
		{
		case 0:
			sb.append("V");
			break;
		case 1:
			sb.append(returnTypes[0]._jvmExpression);
			break;
		default:
			sb.append("Lpyrite.lang.MultipleValue;");
			break;
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

	// 引数の型で戻り値の型は一意に決まるため、戻り値の型はシグネチャに含めない
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

	/*
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
	*/
/*
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
	*/
}
