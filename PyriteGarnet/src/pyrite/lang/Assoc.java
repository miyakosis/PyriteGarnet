package pyrite.lang;

import java.util.HashMap;
import java.util.Map;

public class Assoc extends pyrite.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Assoc";

	private final Map<String, java.lang.Object>	_v = new HashMap<String, java.lang.Object>();

	public int	size()
	{
		return	_v.size();
	}

	public int	length()
	{
		return	size();
	}

	public java.lang.Object	get(String index)
	{
		return	_v.get(index);
	}

	public java.lang.Object	set(String index, java.lang.Object val)
	{
		return	_v.put(index, val);
	}

}
