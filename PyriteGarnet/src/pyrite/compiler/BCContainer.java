package pyrite.compiler;

import java.util.ArrayList;
import java.util.List;

// Byte code container
public class BCContainer
{
	private List<Byte>	_code = new ArrayList<Byte>();

	public void	clear()
	{
		_code.clear();
	}

	public int	size()
	{
		return	_code.size();
	}

	public int	getCodePos()
	{
		return	_code.size();
	}

	public List<Byte>	getCodeList()
	{
		return	_code;
	}

	public void	addCodeOp(byte op)
	{
		_code.add(op);
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
}


