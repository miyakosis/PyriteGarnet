package pyrite.compiler.type;

import java.util.HashSet;
import java.util.Set;

public class ImportDeclaration
{
	private Set<String>	_packageClassNameSet = new HashSet<String>();

	// true: 現在 .* で終わる import を保持している false: クラス名まで指定された import を保持している
	private boolean	_isAstDeclaration = true;

	// true: .* で終わる import false: class名が指定された import
	public void addPackageClassName(String packageClassName, boolean isAstDeclaration)
	{
		if (isAstDeclaration == false && _isAstDeclaration)
		{	// 現在、.* で終わる import を保持しており、クラス名まで指定された import が指定された
			// .* で終わる import 内容をクリアして、今後はクラス名まで指定された import 内容のみを保持する
			_packageClassNameSet.clear();
			_isAstDeclaration = true;
		}
		_packageClassNameSet.add(packageClassName);
	}

	public boolean isDuplicatedDeclaration()
	{
		return	_packageClassNameSet.size() > 1;
	}

	public String	getFQCN()
	{
		assert	(_packageClassNameSet.size() == 1);
		return	_packageClassNameSet.iterator().next();
	}
}
