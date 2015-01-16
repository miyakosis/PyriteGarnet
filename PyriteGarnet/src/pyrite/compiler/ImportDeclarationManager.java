package pyrite.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pyrite.compiler.FQCNParser.FQCN;

public class ImportDeclarationManager
{
	private ClassResolver _cr;

	// import文を保持する
	private List<String>	_importDeclartionStrList = new ArrayList<String>();

	//	public HashMapMap<String, String, String>	_importMap = new HashMapMap<String, String, String>();	// key:class name value:full class name full class name
	private Map<String, ImportDeclaration>	_importMap = new HashMap<String, ImportDeclaration>();	// key:class name value:ImportDeclaration

	public ImportDeclarationManager(ClassResolver cr)
	{
		_cr = cr;
	}

	// import文を保持する
	public void	addImportDeclaretionStr(String importDeclaretionStr)
	{
		_importDeclartionStrList.add(importDeclaretionStr);
	}

	// import指定を解析し、クラス名をキーとする_importMapを作成する
	public void	checkImportDeclaretion()
	{
		Set<String>	packageNameSet = new HashSet<String>();
		Set<String>	packageClassNameSet = new HashSet<String>();

		// パッケージ指定かどうかで振り分ける
		for (String importDeclaretionStr : _importDeclartionStrList)
		{
			if (importDeclaretionStr.endsWith(".*"))
			{
				String	packageName = importDeclaretionStr.substring(0, importDeclaretionStr.length() - 2);	// remove ".*"
				packageNameSet.add(packageName);
			}
			else
			{
				packageClassNameSet.add(importDeclaretionStr);
			}
		}

		// パッケージ指定を先に解決
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
				importDeclaration.addFqcn(packageName + "." + className, false);
			}
		}
		// FQCN指定を解決
		for (String fqcnStr : packageClassNameSet)
		{
			FQCN	fqcn = FQCNParser.getFQCN(fqcnStr);
			if (_cr.isClass(fqcn) == false)
			{
				throw new PyriteSyntaxException("class not found.");
			}

			ImportDeclaration	importDeclaration = _importMap.get(fqcn._className);
			if (importDeclaration == null)
			{
				importDeclaration = new ImportDeclaration();
				_importMap.put(fqcn._className, importDeclaration);
			}
			importDeclaration.addFqcn(fqcn._fqcnStr, false);
		}
	}

	/*
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
	*/

	/**
	 * import節を考慮してクラス名を解決して返す
	 * @param fqcnStr
	 * @return	FQCN:存在するクラス名 null:クラス名が存在しない
	 */
	public FQCN	resolveClassName(String fqcnStr)
	{
		FQCN	fqcn = FQCNParser.getFQCN(fqcnStr);
		if (_cr.isClass(fqcn))
		{
			return	fqcn;	// そのまま返す
		}

		if (fqcn._packageName.equals(""))
		{	// パッケージ部分が無い意場合、import宣言されているクラスかどうか確認する
			ImportDeclaration	importDeclaration = _importMap.get(fqcn._className);
			if (importDeclaration != null)
			{
				if (importDeclaration.isDuplicatedDeclaration())
				{	// import宣言されているクラスが複数存在した
					throw new PyriteSyntaxException("class name is ambiguity");
				}
				String	importFqcnStr = importDeclaration.getFQCNStr();
				FQCN	importFqcn = FQCNParser.getFQCN(importFqcnStr);
				if (_cr.isClass(importFqcn))
				{
					return	importFqcn;	// そのまま返す
				}
			}
		}
		return	null;
	}

	public static class ImportDeclaration
	{
		private Set<String>	_fqcnSet = new HashSet<String>();

		// true:現在クラス名まで指定された import を保持している false:.* で終わる import を保持している
		private boolean	_isFqcn = false;

		/**
		 *
		 * @param fqcnStr
		 * @param isFqcn	true:import文で指定されたfqcn false:packageの末尾が.*で指定されたため、パッケージ名から展開されたfqcn
		 */
		public void addFqcn(String fqcnStr, boolean isFqcn)
		{
			if (_isFqcn == false && isFqcn)
			{	// 現在、.* で終わる import を保持しており、クラス名まで指定された import が指定された
				// .* で終わる import 内容をクリアして、今後はクラス名まで指定された import 内容のみを保持する
				_fqcnSet.clear();
				_isFqcn = true;
			}
			_fqcnSet.add(fqcnStr);
		}

		public boolean isDuplicatedDeclaration()
		{
			return	_fqcnSet.size() > 1;
		}

		public String	getFQCNStr()
		{
			assert	(_fqcnSet.size() == 1);
			return	_fqcnSet.iterator().next();
		}
	}
}
