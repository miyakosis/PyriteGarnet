package pyrite.compiler.type;

import java.util.ArrayList;
import java.util.List;

public class ExpressionListType
{
	public List<VarType>	_paramTypeList = new ArrayList<>();
	public List<Integer>	_paramCodePosList = new ArrayList<>();	// パラメータを処理した直後のコード位置を保持する。
}
