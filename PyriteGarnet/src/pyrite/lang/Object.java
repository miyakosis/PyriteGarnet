package pyrite.lang;

import pyrite.runtime.PyriteRuntime;

public class Object extends java.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Object";

	public String	toStr()
	{
		return	PyriteRuntime.toPyriteString(toString());
	}
}
