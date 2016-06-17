package pyrite.lang;

import java.util.ArrayList;
import java.util.Iterator;

import pyrite.runtime.PyriteRuntime;

public class Array extends pyrite.lang.Object implements Iterable
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Array";

	private final ArrayList<java.lang.Object>	_v = new ArrayList<java.lang.Object>();

	// method
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
		return	_v.get(PyriteRuntime.toJavaInt(index));
	}

	public java.lang.Object	set(Integer index, java.lang.Object val)
	{
		int	i = PyriteRuntime.toJavaInt(index);

		// 容量を保証するのに、ensureCapacityが使えないため、ダミー要素を追加する
		// _v.ensureCapacity(i + 1);
		while (_v.size() < i + 1)
		{
			_v.add(null);
		}

		return	_v.set(i, val);
	}


	@Override
	public Iterator<java.lang.Object> iterator()
	{
		return _v.iterator();
	}
}
