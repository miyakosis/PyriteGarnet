package pyrite.compiler;

import pyrite.compiler.FQCNParser.FQCN;

public abstract class ClassRelatedFile
{
	public FQCN	_fqcn;

	public FQCN	getFQCN()
	{
		return	_fqcn;
	}
}
