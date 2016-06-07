package pyrite.compiler.type;

import java.util.ArrayList;
import java.util.List;

import pyrite.compiler.FQCNParser;

// 複数の型情報を保持するためのクラス。pyrite.lang.MultipleValue に対応する型。
// MultipleValueListType との違いは、スタック上に pyrite.lang.MultipleValue オブジェクトが存在し、それが複数オブジェクトの参照を保持する事。
public class MultipleValueType extends VarType
{
	public final List<VarType>	_varTypeList;

	// 他のVarTypeのサブクラスとは違い、インスタンス化を許容する
	public MultipleValueType()
	{
		this(new ArrayList<VarType>());
	}

	public MultipleValueType(List<VarType>	varTypeList)
	{
		super(TYPE.MULTIPLE, null, FQCNParser.getFQCN("pyrite.lang.MultipleValue"), "Lpyrite.lang.MultipleValue;");	// Type cache には保存しないよう、typeId は null
		_varTypeList = varTypeList;
	}

	public void	addType(VarType varType)
	{
		_varTypeList.add(varType);
	}

	@Override
	public String	toString()
	{
		return	_jvmExpression;
	}
}
