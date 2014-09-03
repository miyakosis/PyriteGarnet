package pyrite.compiler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pyrite.compiler.type.ImportDeclaration;
import pyrite.compiler.util.StringUtil;

public class ImportDeclarationManager
{
	private ClassResolver _cr;

	//	public HashMapMap<String, String, String>	_importMap = new HashMapMap<String, String, String>();	// key:class name value:full class name full class name
	private Map<String, ImportDeclaration>	_importMap = new HashMap<String, ImportDeclaration>();	// key:class name value:ImportDeclaration

	public ImportDeclarationManager(ClassResolver cr)
	{
		_cr = cr;
	}

	public void	checkImportDeclaretion(List<String> importDeclartionStrList)
	{
		Set<String>	packageNameSet = new HashSet<String>();
		Set<String>	packageClassNameSet = new HashSet<String>();

		// パッケージ全指定かどうかで振り分ける
		for (String importDeclaretionStr : importDeclartionStrList)
		{
			if (importDeclaretionStr.endsWith(".*"))
			{
				String	packageName = importDeclaretionStr.substring(0, importDeclaretionStr.length() - 2);
				packageNameSet.add(packageName);
			}
			else
			{
				packageClassNameSet.add(importDeclaretionStr);
			}
		}

		// パッケージ全指定を先に解決
		for (String packageName : packageNameSet)
		{
			if (_cr.isPackage(packageName) == false)
			{
				throw new PyriteSyntaxException("package not found.");
			}
			List<String>	classNameList = _cr.getPackageMemberClassName(packageName);
			for (String className : classNameList)
			{
				ImportDeclaration	importDeclaration = _importMap.get(className);
				if (importDeclaration == null)
				{
					importDeclaration = new ImportDeclaration();
					_importMap.put(className, importDeclaration);
				}
				importDeclaration.addPackageClassName(packageName + "." + className, true);
			}
		}
		// クラス直指定を解決
		for (String packageClassName : packageClassNameSet)
		{
			String[]	element = StringUtil.splitLastElement(packageClassName, '.');
			String	packageName = element[0];
			String	className = element[1];

			if (_cr.isClass(packageName, className) == false)
			{
				throw new PyriteSyntaxException("class not found.");
			}

			ImportDeclaration	importDeclaration = _importMap.get(className);
			if (importDeclaration == null)
			{
				importDeclaration = new ImportDeclaration();
				_importMap.put(className, importDeclaration);
			}
			importDeclaration.addPackageClassName(packageClassName, false);
		}
	}

	public String[]	resolveClassName(String packageName, String className)
	{
		String	packageClassName = StringUtil.concat(packageName, className);

		if (_cr.getClassFieldMember(packageClassName) != null)
		{
			return	new String[]{packageName, className};	// そのまま返す
		}

		if (packageName.equals(""))
		{	// クラス名の場合、import宣言されているか確認する
			ImportDeclaration	importDeclaration = _importMap.get(className);
			if (importDeclaration != null)
			{
				if (importDeclaration.isDuplicatedDeclaration())
				{
					throw new PyriteSyntaxException("class name is ambiguity");
				}
				String	fqcn = importDeclaration.getFQCN();
				return	StringUtil.splitLastElement(fqcn, '.');
			}
		}
		return	null;
	}
}
