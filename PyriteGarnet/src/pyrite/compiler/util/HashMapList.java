package pyrite.compiler.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ListMap
public class HashMapList<TK, TV>
{
	private Map<TK, List<TV>>	_map = new HashMap<TK, List<TV>>();

	public TV	put(TK key, TV value)
	{
		List<TV>	list = _map.get(key);
		if (list == null)
		{
			list = new ArrayList<TV>();
			_map.put(key, list);
		}
		list.add(value);

		return	value;
	}

	public boolean	remove(TK key, TV value)
	{
		List<TV>	list = _map.get(key);
		if (list == null)
		{
			return	false;
		}
		return	list.remove(value);
	}

	public List<TV>	get(TK key)
	{
		return	_map.get(key);
	}


	public boolean	containsKey(TK key)
	{
		return	_map.containsKey(key);
	}
}
