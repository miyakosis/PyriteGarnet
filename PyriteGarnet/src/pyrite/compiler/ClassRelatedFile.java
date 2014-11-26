package pyrite.compiler;

import pyrite.compiler.FQCNParser.FQCN;

public abstract class ClassRelatedFile
{
	public FQCN	_fqcn;

	public FQCN	getFQCN()
	{
		return	_fqcn;
	}

	// 実装的に微妙かもしれないが、SourceFileにあまりコードを追加したくない
	public boolean isCompileTarget()
	{
		return	(this instanceof SourceFile);
	}

}
