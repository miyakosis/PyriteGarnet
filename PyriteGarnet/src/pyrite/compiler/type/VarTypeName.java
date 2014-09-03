package pyrite.compiler.type;

public class VarTypeName
{
	public final VarType	_type;
	public final String	_name;
	public final int	_localVarNum;	// ローカル変数番号。インスタンス変数などの場合は -1
	public final int	_blockLevel;	// ローカル変数が登録されたブロックレベル。同じレベルの同名のローカル変数は名前重複エラーになる。ブロックレベルをチェックしない場合は -1

	public VarTypeName(VarType type, String name, int localVarNum, int blockLevel)
	{
		_type = type;
		_name = name;
		_localVarNum = localVarNum;
		_blockLevel = blockLevel;
	}

	public VarTypeName(VarType type, String name)
	{
		this(type, name, -1, -1);
	}
}
