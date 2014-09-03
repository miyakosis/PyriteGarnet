package pyrite.compiler.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class HashMapStack<TK, TV>
{
	private Map<TK, TV>	_currentMap = new HashMap<TK, TV>();
	private Stack<Map<TK, TV>>	_mapStack = new Stack<Map<TK, TV>>();

	public void	push()
	{
		_mapStack.push(_currentMap);
		_currentMap = new HashMap<TK, TV>(_currentMap);
	}

	public void	pop()
	{
		_currentMap = _mapStack.pop();
	}

	public TV	put(TK key, TV value)
	{
		return	_currentMap.put(key, value);
	}

	public TV	get(TK key)
	{
		return	_currentMap.get(key);
	}

	public boolean	containsKey(TK key)
	{
		return	_currentMap.containsKey(key);
	}

	public int	size()
	{
		return	_currentMap.size();
	}

	public int	stackSize()
	{
		return	_mapStack.size();
	}
}
