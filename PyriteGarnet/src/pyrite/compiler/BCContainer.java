package pyrite.compiler;

import java.util.ArrayList;
import java.util.List;

// Byte code container
public class BCContainer
{
	// メソッドのコード
	private List<Byte>	_code = new ArrayList<Byte>();

	// コードの最大スタックサイズ
	private MaxStack _maxStack = new MaxStack();

	// code
	public List<Byte>	getCodeList()
	{
		return	_code;
	}

	public void	clear()
	{
		_code.clear();
	}

	public int	size()
	{
		return	_code.size();
	}

	// 現在のコードの位置を返す(後でこの位置にコードブロックを挿入するなど)
	public int	getCodePos()
	{
		return	_code.size();
	}

	public int	getMaxStack()
	{
		return	_maxStack._maxStack;
	}

	public int	getCurrentStackSize()
	{
		return	_maxStack._currentStack;
	}

	public void	setCurrentStackSize(int size)
	{
		_maxStack._currentStack = size;
	}


	public void	addCodeOp(byte op)
	{
		addCodeOp(op, 0);
	}

	public void	addCodeOp(byte op, int stackIncDec)
	{
		_code.add(op);
		_maxStack.setN(BC.STACK_INCDEC.get(op) + stackIncDec);
	}

	public void	addCodeU1(int n)
	{
		_code.add((byte)n);
	}

	public void	addCodeU2(int n)
	{
		_code.add((byte)(n >> 8));
		_code.add((byte)n);
	}

	public void	addCodeU4(int n)
	{
		_code.add((byte)(n >> 24));
		_code.add((byte)(n >> 16));
		_code.add((byte)(n >> 8));
		_code.add((byte)n);
	}

	public void	addCodeOpBIPUSH(int n)
	{
		switch (n)
		{
		case -1:	addCodeOp(BC.ICONST_M1);	break;
		case 0:	addCodeOp(BC.ICONST_0);	break;
		case 1:	addCodeOp(BC.ICONST_1);	break;
		case 2:	addCodeOp(BC.ICONST_2);	break;
		case 3:	addCodeOp(BC.ICONST_3);	break;
		case 4:	addCodeOp(BC.ICONST_4);	break;
		case 5:	addCodeOp(BC.ICONST_5);	break;
		default:
			addCodeOp(BC.BIPUSH);
			addCodeU1(n);
			break;
		}
	}

	public void	addCodeOpILOAD(int n)
	{
		switch (n)
		{
		case 0:	addCodeOp(BC.ILOAD_0);	break;
		case 1:	addCodeOp(BC.ILOAD_1);	break;
		case 2:	addCodeOp(BC.ILOAD_2);	break;
		case 3:	addCodeOp(BC.ILOAD_3);	break;
		default:
			addCodeOp(BC.ILOAD);
			addCodeU1(n);
			break;
		}
	}

	// TODO:LLOAD, FLOAD, DLOAD

	public void	addCodeOpALOAD(int n)
	{
		switch (n)
		{
		case 0:	addCodeOp(BC.ALOAD_0);	break;
		case 1:	addCodeOp(BC.ALOAD_1);	break;
		case 2:	addCodeOp(BC.ALOAD_2);	break;
		case 3:	addCodeOp(BC.ALOAD_3);	break;
		default:
			addCodeOp(BC.ALOAD);
			addCodeU1(n);
			break;
		}
	}

	public void	addCodeOpISTORE(int n)
	{
		switch (n)
		{
		case 0:	addCodeOp(BC.ISTORE_0);	break;
		case 1:	addCodeOp(BC.ISTORE_1);	break;
		case 2:	addCodeOp(BC.ISTORE_2);	break;
		case 3:	addCodeOp(BC.ISTORE_3);	break;
		default:
			addCodeOp(BC.ISTORE);
			addCodeU1(n);
			break;
		}
	}

	// TODO:LSTORE, FSTORE, DSTORE

	public void	addCodeOpASTORE(int n)
	{
		switch (n)
		{
		case 0:	addCodeOp(BC.ASTORE_0);	break;
		case 1:	addCodeOp(BC.ASTORE_1);	break;
		case 2:	addCodeOp(BC.ASTORE_2);	break;
		case 3:	addCodeOp(BC.ASTORE_3);	break;
		default:
			addCodeOp(BC.ASTORE);
			addCodeU1(n);
			break;
		}
	}

	public void	addCodePadding()
	{	// 4バイト境界まで0をつめる
		while (getCodePos() % 4 != 0)
		{
			addCodeU1(0);
		}
	}


	// コード領域から指定範囲のコードを除去する
	// from=5, to=8, size=10 (diff=3, copyLen=2)
	// 5 6 7 8 9
	// 8 9 7 8 9
	// 8 9
	public void	removeCode(int from, int to)
	{
		assert (from <= to);
		int	diff = to - from;
		if (diff == 0)
		{
			return;
		}
		int copyLen = _code.size() - from;
		for (int i = 0; i < copyLen; ++i)
		{
			_code.set(from + i, _code.get(to + i));
		}
		int removeFrom = _code.size() - 1;
		int removeTo = _code.size() - diff;
		for (int i = removeFrom; i >= removeTo; --i)
		{
			_code.remove(i);
		}
	}

	// コード領域から末尾 len バイトのコードを除去する
	public void	removeCodeEnd(int len)
	{
		int	offset = _code.size() - len;
		for (int i = len; i > 0; --i)
		{
			_code.remove(offset + i - 1);
		}
	}

	// コード領域の pos から 2バイトを n で置き換える
	public void	replaceCodeU2(int n, int pos)
	{
		assert (_code.get(pos) == 0x00);
		assert (_code.get(pos + 1) == 0x00);

		_code.set(pos, (byte)(n >> 8));
		_code.set(pos + 1, (byte)n);
	}

	// コード領域の pos に byteList を追加する
	// (スタックサイズの増減を航路する必要がない場合のみ使用可)
	public void	addCodeBlock(List<Byte> byteList, int pos)
	{
		_code.addAll(pos, byteList);
	}

	// コード領域の pos に BCContainer の内容を追加する
	public void	addCodeBlock(BCContainer insertBC, int pos)
	{
		_code.addAll(pos, insertBC._code);

		// スタック使用の最大を押し上げる
		_maxStack.addMax(insertBC.getMaxStack());
		// 本来は挿入位置において、追加コードのスタック増加を検討すべきであるが、困難であるため無駄はあるものの最大値を追加する
		// ex. 元コード
		// line : stack
		// 1    : 1
		// 2    : 2
		// 3    : 3
		// 4    : 1
		// 5    : 0

		// ここに追加コードの最大スタックが +2 で、コード位置 5 に挿入する場合、
		// ex. 本来
		// line : stack
		// 1    : 1
		// 2    : 2
		// 3    : 3
		// 4    : 1
		// I1   : 2
		// I2   : 3
		// I3   : 1
		// 5    : 0
		// であり、最大スタックは3で変わらない。しかし挿入位置時点のスタック数は保持していないため、このような判定は困難であるとし、
		// 単に最大スタックを 3 + 2 とする
	}

	// コード領域の pos に BCContainer の内容を追加する
	public void	addCodeBlock(BCContainer insertBC)
	{
		_code.addAll(insertBC._code);

		// スタック使用の最大を押し上げる
		_maxStack.setN(insertBC.getMaxStack());
		_maxStack.setN(-1 * insertBC.getMaxStack());
	}

	// コード領域から指定範囲のコードを取得する
	public List<Byte>	getCodeBlock(int from, int to)
	{
		return	_code.subList(from, to);
	}



/*
	public int	getCodePos()
	{
		return	_code.size();
	}

	public List<Byte>	getCodeList()
	{
		return	_code;
	}

	public void	addCodeOp(byte op, int stackIncDec)
	{
		// TODO:stack管理
		_code.add(op);
	}

	public void	addCodeOp(byte op)
	{
		addCodeOp(op, 0);
	}

	public void	addCodeU1(int n)
	{
		_code.add((byte)n);
	}

	public void	addCodeU2(int n)
	{
		_code.add((byte)(n >> 8));
		_code.add((byte)n);
	}

	public void	addCodeU4(int n)
	{
		_code.add((byte)(n >> 24));
		_code.add((byte)(n >> 16));
		_code.add((byte)(n >> 8));
		_code.add((byte)n);
	}

	public void	addCodeOpBIPUSH(int n)
	{
		switch (n)
		{
		case -1:	addCodeOp(BC.ICONST_M1);	break;
		case 0:	addCodeOp(BC.ICONST_0);	break;
		case 1:	addCodeOp(BC.ICONST_1);	break;
		case 2:	addCodeOp(BC.ICONST_2);	break;
		case 3:	addCodeOp(BC.ICONST_3);	break;
		case 4:	addCodeOp(BC.ICONST_4);	break;
		case 5:	addCodeOp(BC.ICONST_5);	break;
		default:
			addCodeOp(BC.BIPUSH);
			addCodeU1(n);
			break;
		}
	}
*/

	public static class	MaxStack
	{
		private int	_currentStack = 0;
		private int	_maxStack = 0;

		public void	setN(int n)
		{
			_currentStack += n;

			// JVM変換用コードなど、一部のコードでは負のスタックになることがあるため、assertを行わない
//			if (_currentStack < 0)
//			{
//				throw new RuntimeException("assertion");
//			}
			if (_currentStack > _maxStack)
			{
				_maxStack = _currentStack;
			}
		}

		public void	addMax(int n)
		{
			_maxStack += n;
		}

		public void	pop()
		{
			_currentStack -= 1;
			if (_currentStack < 0)
			{
				throw new RuntimeException("assertion");
			}
		}

		public void	push()
		{
			_currentStack += 1;
			if (_currentStack > _maxStack)
			{
				_maxStack = _currentStack;
			}
		}

		public void	clear()
		{
			_currentStack = 0;
			_maxStack = 0;
		}
	}
}


