package pyrite.compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ControlBlockManager
{
	public static enum TYPE {INIT, LOOP, SWITCH};

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

	public void setContinuePos(int condPos)
	{
		_currentCB.setContinuePos(condPos);
	}

	public int getContinuePos(String label)
	{
		if (label == null)
		{
			return	_currentCB._continuePos;
		}
		else
		{	// ラベルで指定された制御構文位置を探す
			for (ControlBlock cb : _cbStack)
			{
				if (label.equals(cb._label))
				{
					if (cb._type == TYPE.LOOP)
					{
						return	cb._continuePos;
					}
					else
					{
						throw new PyriteSyntaxException("label is only for control statement.");
					}
				}
			}
			throw new PyriteSyntaxException("label not found.");
		}
	}

	public void setBreakPos(String label, int breakPos)
	{
		if (label == null)
		{
			_currentCB.setBreakPos(breakPos);
		}
		else
		{	// ラベルで指定された制御構文位置を探す
			for (ControlBlock cb : _cbStack)
			{
				if (label.equals(cb._label))
				{
					if (cb._type == TYPE.LOOP || cb._type == TYPE.SWITCH)
					{
						cb.setBreakPos(breakPos);
						return;
					}
					else
					{
						throw new PyriteSyntaxException("label is only for control statement.");
					}
				}
			}
			throw new PyriteSyntaxException("label not found.");
		}
	}

	public int[]	getBreakPoss()
	{
		int[]	breakPoss = new int[_currentCB._breakPosList.size()];
		for (int i = 0; i < breakPoss.length; ++i)
		{
			breakPoss[i] = _currentCB._breakPosList.get(i);
		}
		return	breakPoss;
	}

	public static class ControlBlock
	{
		private TYPE	_type;
		private String	_label;

		private int	_continuePos;
		private List<Integer>	_breakPosList = new ArrayList<Integer>();

		public ControlBlock(TYPE type, String label)
		{
			_type = type;
			_label = label;
			_continuePos = -1;
		}

		public void setContinuePos(int condPos)
		{
			_continuePos = condPos;
		}

		public void setBreakPos(int breakPos)
		{
			_breakPosList.add(breakPos);
		}
	}
}
