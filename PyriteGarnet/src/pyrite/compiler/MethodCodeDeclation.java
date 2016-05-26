package pyrite.compiler;

import java.util.ArrayList;
import java.util.List;

import pyrite.compiler.type.MethodType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarTypeName;
import pyrite.compiler.util.HashMapStack;

public class MethodCodeDeclation
{
	public String	_className;
	public String	_methodName;
	public boolean	_isStatic;
	public List<VarTypeName>	_inParamList;
	public List<VarTypeName>	_outParamList;

	// メソッドのコード
	private List<Byte>	_code = new ArrayList<Byte>();

	// ローカル変数のスタック
	private HashMapStack<String, VarTypeName>	_localVarMapStack = new HashMapStack<String, VarTypeName>();
	private int	_maxNLocalVar = 0;	// ローカル変数の使用数の最大

	// コードの最大スタックサイズ
	private MaxStack _maxStack = new MaxStack();

	// Exception table
	public List<ExceptionTableEntry>	_exceptionTableEntryList = new ArrayList<ExceptionTableEntry>();

	public void	setClassName(String className)
	{
		_className = className;
	}

	public void	setMethodName(String methodName)
	{
		_methodName = methodName;
	}

	public void setStatic(boolean isStatic)
	{
		_isStatic = isStatic;
		if (isStatic == false)
		{
			putLocalVar("this", ObjectType.getType(_className));
		}
	}

	public void setInParamList(List<VarTypeName> methodParamList)
	{
		_inParamList = methodParamList;
	}

	public void setOutParamList(List<VarTypeName> methodParamList)
	{
		_outParamList = methodParamList;
	}


	// ローカル変数
	public void	pushLocalVarStack()
	{
		_localVarMapStack.push();
	}

	public void	popLocalVarStack()
	{
		_localVarMapStack.pop();
	}

	// true:現在のレベルで同名のローカル変数が登録済み false:それ以外
	public boolean	isDuplicatedLocalVar(String name)
	{
		VarTypeName	var = _localVarMapStack.get(name);
		if (var != null)
		{
			if (_localVarMapStack.stackSize() == var._blockLevel)
			{
				return	true;
			}
		}

		return	false;
	}

	// ローカル変数を追加
	public VarTypeName	putLocalVar(String name, VarType type)
	{
		if (_localVarMapStack.size() >= 255)
		{
			throw new RuntimeException("not suppoted over 255 local variables");
		}
		VarTypeName	addVar = new VarTypeName(type, name, _localVarMapStack.size(), _localVarMapStack.stackSize());

		// 同名のローカル変数が存在している場合は上書き
		_localVarMapStack.put(name, addVar);

		// 使用しているローカル変数の最大が増えていたら更新
		_maxNLocalVar = Math.max(_localVarMapStack.size(), _maxNLocalVar);

		return	addVar;
	}

	// ローカル変数を取得
	public VarTypeName	getLocalVar(String name)
	{
		return	_localVarMapStack.get(name);
	}

	// code
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

	public int	getCodePos()
	{
		return	_code.size();
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
	public void	addCodeBlock(List<Byte> byteList, int pos)
	{
		_code.addAll(pos, byteList);
	}

	// コード領域からして範囲のコードを取得する
	public List<Byte>	getCodeBlock(int from, int to)
	{
		return	_code.subList(from, to);
	}

	public int	getAccessFlag()
	{
		int	acc = BC.ACC_PUBLIC;	// TODO メソッド公開子対応

		if (_isStatic)
		{
			acc |= BC.ACC_STATIC;
		}
		return	acc;
	}

	public String	getJvmMethodParamExpression()
	{
		VarType[] inParamTypes = new VarType[_inParamList.size()];
		VarType[] outParamTypes  = new VarType[_outParamList.size()];

		for (int i = 0; i < _inParamList.size(); ++i)
		{
			inParamTypes[i] = _inParamList.get(i)._type;
		}
		for (int i = 0; i < _outParamList.size(); ++i)
		{
			outParamTypes[i] = _outParamList.get(i)._type;
		}

		return	MethodType.createJvmMethodParamExpression(inParamTypes, outParamTypes);
	}

	public byte[]	getCodeByteArray()
	{
		byte[]	ba = new byte[_code.size()];
		int	pos = 0;
		for (Byte b : _code)
		{
			ba[pos++] = b;
		}
		return	ba;
	}

	public int	getMaxStack()
	{
		return	_maxStack._maxStack;
	}

	public int	getMaxLocal()
	{
		return	_maxNLocalVar;
	}


	public void	addExceptionTableEntry(int startPc, int endPc, int handlerPc, int catchType)
	{
		_exceptionTableEntryList.add(new ExceptionTableEntry(startPc, endPc, handlerPc, catchType));
	}

	public List<ExceptionTableEntry>	getExceptionTableList()
	{
		return	_exceptionTableEntryList;
	}

	public static class	MaxStack
	{
		private int	_currentStack = 0;
		private int	_maxStack = 0;

		public void	setN(int n)
		{
			_currentStack += n;

			if (_currentStack < 0)
			{
				throw new RuntimeException("assertion");
			}
			else if (_currentStack > _maxStack)
			{
				_maxStack = _currentStack;
			}
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

	public static class	ExceptionTableEntry
	{
		public final int	_startPc;
		public final int	_endPc;
		public final int	_handlerPc;
		public final int	_catchType;		// anyの場合は 0

		public ExceptionTableEntry(int startPc, int endPc, int handlerPc, int catchType)
		{
			_startPc = startPc;
			_endPc = endPc;
			_handlerPc = handlerPc;
			_catchType = catchType;
		}
	}
}
