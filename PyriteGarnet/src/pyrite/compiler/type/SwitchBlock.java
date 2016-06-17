package pyrite.compiler.type;

import java.util.List;

/*
 * Switch文のブロック情報を保持するクラス
 */
public class SwitchBlock
{
	public final int	_blockStartPos;
	public final int	_blockEndPos;
	public final List<SwitchCase>	_caseList;
	public final boolean	_isFallthrough;

	public SwitchBlock(int blockStartPos, int blockEndPos, List<SwitchCase> caseList, boolean isFallthrough)
	{
		_blockStartPos = blockStartPos;
		_blockEndPos = blockEndPos;
		_caseList = caseList;
		_isFallthrough = isFallthrough;
	}
}
