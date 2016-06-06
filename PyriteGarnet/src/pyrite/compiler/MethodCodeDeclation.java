package pyrite.compiler;

import java.util.ArrayList;
import java.util.List;

import pyrite.compiler.type.MethodType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarTypeName;
import pyrite.compiler.util.HashMapStack;

public class MethodCodeDeclation
{
	public final static	List<VarTypeName>	EMPTY_PARAMETER = new ArrayList<>();

//	public String	_className;	// TODO:未使用?
	public String	_methodName;
	public boolean	_isStatic;
	public List<VarTypeName>	_inParamList;
	public List<VarTypeName>	_outParamList;

	public BCContainer	_code = new BCContainer();


	// ローカル変数のスタック
	private HashMapStack<String, VarTypeName>	_localVarMapStack = new HashMapStack<String, VarTypeName>();
	private int	_maxNLocalVar = 0;	// ローカル変数の使用数の最大


	// Exception table
	public List<ExceptionTableEntry>	_exceptionTableEntryList = new ArrayList<ExceptionTableEntry>();

//	public void	setClassName(String className)
//	{
//		_className = className;
//	}

	public void	setMethodName(String methodName)
	{
		_methodName = methodName;
	}

	public void setStatic(boolean isStatic)
	{
		_isStatic = isStatic;
//		if (isStatic == false)
//		{
//			putLocalVar("this", ObjectType.getType(_className));
//		}
	}

	public void setInParamList(List<VarTypeName> methodParamList)
	{
		_inParamList = methodParamList;
	}

	public void setOutParamList(List<VarTypeName> methodParamList)
	{
		_outParamList = methodParamList;
	}

	public void	setCode(BCContainer code)
	{
		_code = code;
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


	public int	getMaxStack()
	{
		return	_code.getMaxStack();
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
