package pyrite.compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * break や continue 文のため、制御ブロック情報を保持するクラス
 */
public class ControlBlockManager
{
	public static enum TYPE {INIT, WHILE, FOR, SWITCH};

	private ControlBlock	_currentCB = new ControlBlock(TYPE.INIT, null);
	private Stack<ControlBlock>	_cbStack = new Stack<ControlBlock>();

	public void	push(TYPE type, String label)
	{
		if (label != null)
		{
			// ラベルの重複をチェックする
			for (ControlBlock cb : _cbStack)
			{
				if (label.equals(cb._label))
				{
					throw new PyriteSyntaxException("label is duplicated.");
				}
			}
		}

		_cbStack.push(_currentCB);
		_currentCB = new ControlBlock(type, label);
	}

	public void	pop()
	{
		_currentCB = _cbStack.pop();
	}


	public void setBreakPos(String label, int breakPos)
	{
		ControlBlock	cb = findControlBrock(label);

		if (cb._type == TYPE.WHILE || cb._type == TYPE.FOR || cb._type == TYPE.SWITCH)
		{
			cb.setBreakPos(breakPos);
		}
		else
		{
			throw new PyriteSyntaxException("label is only for control statement.");
		}
	}

	public void setContinuePos(String label, int continuePos)
	{
		ControlBlock	cb = findControlBrock(label);

		if (cb._type == TYPE.WHILE || cb._type == TYPE.FOR)
		{
			cb.setContinuePos(continuePos);
		}
		else
		{
			throw new PyriteSyntaxException("label is only for control statement.");
		}
	}

	protected ControlBlock	findControlBrock(String label)
	{
		if (label == null)
		{
			return	_currentCB;
		}
		else
		{	// ラベルで指定された制御構文位置を探す
			for (ControlBlock cb : _cbStack)
			{
				if (label.equals(cb._label))
				{
					return	cb;
				}
			}
			throw new PyriteSyntaxException("label not found.");
		}
	}

	public List<Integer>	getBreakPosList()
	{
		return	_currentCB._breakPosList;
	}

	public List<Integer>	getContinuePosList()
	{
		return	_currentCB._continuePosList;
	}


	public static class ControlBlock
	{
		private final TYPE	_type;
		private final String	_label;

		private List<Integer>	_breakPosList = new ArrayList<Integer>();
		private List<Integer>	_continuePosList = new ArrayList<Integer>();

		public ControlBlock(TYPE type, String label)
		{
			_type = type;
			_label = label;
		}

		public void setBreakPos(int breakPos)
		{
			_breakPosList.add(breakPos);
		}

		public void setContinuePos(int continuePos)
		{
			_continuePosList.add(continuePos);
		}
	}
}
