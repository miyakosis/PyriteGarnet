package pyrite.lang;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Assoc extends pyrite.lang.Object implements Iterable
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Assoc";

	private final Map<java.lang.Object, java.lang.Object>	_v = new HashMap<java.lang.Object, java.lang.Object>();

	// method
	public int	size()
	{
		return	_v.size();
	}

	public int	length()
	{
		return	size();
	}

	public java.lang.Object	get(java.lang.Object index)
	{
		return	_v.get(index);
	}

	public java.lang.Object	set(java.lang.Object index, java.lang.Object val)
	{
		return	_v.put(index, val);
	}

	@Override
	public Iterator<Entry<java.lang.Object, java.lang.Object>> iterator()
	{
		return _v.entrySet().iterator();
	}
}
