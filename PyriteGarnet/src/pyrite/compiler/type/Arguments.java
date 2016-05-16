package pyrite.compiler.type;

import java.util.ArrayList;
import java.util.List;

// メソッド引数の型を持つType.
// MultipleValueType との違いは、MultipleValueTypeはスタック上に MultipleValue オブジェクトが存在するが、
// ArgumentType は _paramTypeList の要素がそれぞれバラバラで存在する
public class Arguments
{
	public List<VarType>	_paramTypeList = new ArrayList<>();
	public List<Integer>	_paramCodePosList = new ArrayList<>();	// パラメータを処理した直後のコード位置を保持する。
}
