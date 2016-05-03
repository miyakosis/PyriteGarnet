package pyrite.lang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pyrite.runtime.PyriteRuntime;

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
		return	_v.get(PyriteRuntime.cnvJavaInt(index));
	}

	public java.lang.Object	set(Integer index, java.lang.Object val)
	{
		return	_v.set(PyriteRuntime.cnvJavaInt(index), val);
	}


	@Override
	public Iterator iterator()
	{
		return _v.iterator();
	}
}
