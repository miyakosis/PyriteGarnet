package pyrite.compiler.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapMap<TK, TVK, TVV>
{
	private Map<TK, Map<TVK, TVV>>	_map = new HashMap<TK, Map<TVK, TVV>>();

	public TVV	put(TK key, TVK valueKey, TVV valueValue)
	{
		Map<TVK, TVV>	map = put(key);
		map.put(valueKey, valueValue);

		return	valueValue;
	}

	public Map<TVK, TVV>	put(TK key)
	{
		Map<TVK, TVV>	map = _map.get(key);
		if (map == null)
		{
			map = new HashMap<TVK, TVV>();
			_map.put(key, map);
		}
		return	map;
	}

	public Map<TVK, TVV>	get(TK key)
	{
		return	_map.get(key);
	}

	public TVV	get(TK key, TVK valueKey)
	{
		Map<TVK, TVV>	map = _map.get(key);
		if (map == null)
		{
			return	null;
		}
		return	map.get(valueKey);
	}

	// キーで指定された要素のマップを空にする
	public void	clear(TK key)
	{
		Map<TVK, TVV>	map = _map.get(key);
		if (map != null)
		{
			map.clear();
		}
	}

	public void remove(TK key, TVK valueKey)
	{
		Map<TVK, TVV>	map = _map.get(key);
		if (map != null)
		{
			map.remove(valueKey);
		}
	}

	public Collection<TVV>	values()
	{
		List<TVV>	values = new ArrayList<TVV>();
		for (Map<TVK, TVV> map : _map.values())
		{
			values.addAll(map.values());
		}

		return	values;
	}
}
