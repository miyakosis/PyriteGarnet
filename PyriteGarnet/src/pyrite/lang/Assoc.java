package pyrite.lang;

import java.util.HashMap;
import java.util.Map;

public class Assoc extends pyrite.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Assoc";

	private final Map<java.lang.Object, java.lang.Object>	_v = new HashMap<java.lang.Object, java.lang.Object>();

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

}
