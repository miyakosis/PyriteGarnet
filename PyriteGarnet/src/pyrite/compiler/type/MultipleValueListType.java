package pyrite.compiler.type;

import java.util.ArrayList;
import java.util.List;

// 複数の型情報を保持するためのクラス。
// MultipleValueType との違いは、スタック上に保持する値が別々に保持されている事、メソッド引数の解析の場合もあるため、コード位置を保存する事。
//また、LValueType もこちらで保持される(LValueTypeの場合は)。
public class MultipleValueListType extends VarType
{
	public final List<VarType>	_varTypeList;
	public final List<Integer>	_paramCodePosList = new ArrayList<>();	// パラメータを処理した直後のコード位置を保持する。

	// 他のVarTypeのサブクラスとは違い、インスタンス化を許容する
	public MultipleValueListType()
	{
		this(new ArrayList<VarType>());
	}

	public MultipleValueListType(List<VarType>	varTypeList)
	{
		super(TYPE.MULTIPLE_LIST, null, null, "MultipleValueListType");	// Type cache には保存しないよう、typeId は null。jvmExpressionも使用されない。
		_varTypeList = varTypeList;
	}

	public void	addType(VarType varType)
	{
		_varTypeList.add(varType);
	}

	public void	addPos(int pos)
	{
		_paramCodePosList.add(pos);
	}

	@Override
	public String	toString()
	{
		return	_jvmExpression;
	}
}
