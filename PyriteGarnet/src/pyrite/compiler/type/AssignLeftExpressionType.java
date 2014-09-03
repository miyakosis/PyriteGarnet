package pyrite.compiler.type;

// とりあえずインターフェースをあわせるため継承関係をつけているが、やっつけなので後で修正する。
public class AssignLeftExpressionType extends VarType
{
	public VarType	_type;

	public int	_assignType;	// 0:not assigned 1:local 2:instance field 3:class field 4:array
	public int	_assignLocalNum;	// _assignType = 1
	public String	_assignClassName;	// _assignType = 2, 3
	public String	_assignFieldName;	// _assignType = 2, 3

	public AssignLeftExpressionType(
			VarType	type,
			int	assignType,
			int	assignLocalNum,
			String	assignClassName,
			String	assignFieldName)
	{
		_type = type;
		_assignType = assignType;
		_assignLocalNum = assignLocalNum;
		_assignClassName = assignClassName;
		_assignFieldName = assignFieldName;
	}

	public AssignLeftExpressionType(
			VarType	type,
			int	assignLocalNum)
	{
		this(type, 1, assignLocalNum, null, null);
	}
}
