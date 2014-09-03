package pyrite.compiler.util;

import java.util.HashMap;
import java.util.Map;

public class HashMapMap<TK, TVK, TVV>
{
	private Map<TK, Map<TVK, TVV>>	_map = new HashMap<TK, Map<TVK, TVV>>();

	public TVV	put(TK key, TVK valueKey, TVV valueValue)
	{
		Map<TVK, TVV>	map = _map.get(key);
		if (map == null)
		{
			map = new HashMap<TVK, TVV>();
			_map.put(key, map);
		}
		map.put(valueKey, valueValue);

		return	valueValue;
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
}
