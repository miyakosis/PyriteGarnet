package pyrite.compiler;

import java.util.HashMap;
import java.util.Map;

import pyrite.compiler.util.StringUtil;

public class FQCNParser
{
	private static Map<String, FQCN>	__fqcnMap = new HashMap<String, FQCN>();	// K:fqcnStr, V:FQCN

	public static FQCN	getFQCN(String packageName, String className)
	{
		StringBuilder	sb = new StringBuilder();
		sb.append(packageName).append(".").append(className);

		String	fqcnStr = sb.toString();
		FQCN	fqcn = __fqcnMap.get(fqcnStr);
		if (fqcn == null)
		{
			fqcn = new FQCN(fqcnStr, packageName, className);
			__fqcnMap.put(fqcnStr, fqcn);
		}
		return	fqcn;
	}

	public static FQCN	getFQCN(String fqcnStr)
	{
		FQCN	fqcn = __fqcnMap.get(fqcnStr);
		if (fqcn == null)
		{
			String[]	element = StringUtil.splitLastElement(fqcnStr, '.');
			fqcn = new FQCN(fqcnStr, element[0], element[1]);
			__fqcnMap.put(fqcnStr, fqcn);
		}
		return	fqcn;
	}

	public static class	FQCN
	{
		public final String	_fqcnStr;
		public final String	_packageName;
		public final String	_className;

		private FQCN(String fqcnStr, String packageName, String className)
		{
			_fqcnStr = fqcnStr;
			_packageName = packageName;
			_className = className;
		}
	}
}
