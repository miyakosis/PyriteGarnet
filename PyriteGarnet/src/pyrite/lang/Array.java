package pyrite.lang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Array extends pyrite.lang.Object implements Iterable
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Array";

	private final List<java.lang.Object>	_v = new ArrayList<java.lang.Object>();

	public int	size()
	{
		return	_v.size();
	}

	public int	length()
	{
		return	size();
	}

	public java.lang.Object	get(Integer index)
	{
		return	_v.get(index.to_i());
	}

	public java.lang.Object	set(Integer index, java.lang.Object val)
	{
		return	_v.set(index.to_i(), val);
	}


	@Override
	public Iterator iterator()
	{
		return _v.iterator();
	}
}
