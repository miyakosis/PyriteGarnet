package pyrite.compiler.type;

import java.util.ArrayList;
import java.util.List;

import pyrite.compiler.FQCNParser;

// 複数の型情報を保持するためのクラス。pyrite.lang.MultipleValue に対応する型。
public class MultipleValueType extends VarType
{
	public final List<VarType>	_varTypeList;

	// 他のVarTypeのサブクラスとは違い、インスタンス可を許容する
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
}
