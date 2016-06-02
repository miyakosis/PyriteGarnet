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

	// クラス名に対応するimport宣言
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
		for (String importDeclaretionStr : _importDeclartionStrList)
		{
			if (importDeclaretionStr.endsWith(".*"))
			{	// パッケージ指定
				String	packageName = importDeclaretionStr.substring(0, importDeclaretionStr.length() - 2);	// remove ".*"
				if (_cr.existsPackage(FQCNParser.getFQCN(packageName)) == false)
				{
					throw new PyriteSyntaxException("package not found.:" + packageName);
				}
				List<String>	classNameList = _cr.getPackageMemberClassName(packageName);
				for (String className : classNameList)
				{
					FQCN	fqcn = FQCNParser.getFQCN(packageName, className);

					ImportDeclaration	importDeclaration = _importMap.get(fqcn._className);
					if (importDeclaration == null)
					{
						importDeclaration = new ImportDeclaration(fqcn._className);
						_importMap.put(className, importDeclaration);
					}
					importDeclaration.addFqcnAst(fqcn._fqcnStr);
				}
			}
			else
			{	// FQCN指定を解決
				FQCN	fqcn = FQCNParser.getFQCN(importDeclaretionStr);
				if (_cr.existsFQCN(fqcn) == false)
				{
					throw new PyriteSyntaxException("class not found.");
				}

				ImportDeclaration	importDeclaration = _importMap.get(fqcn._className);
				if (importDeclaration == null)
				{
					importDeclaration = new ImportDeclaration(fqcn._className);
					_importMap.put(fqcn._className, importDeclaration);
				}
				importDeclaration.addFqcn(fqcn._fqcnStr);
			}
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
		if (_cr.existsFQCN(fqcn))
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
				if (_cr.existsFQCN(importFqcn))
				{
					return	importFqcn;	// そのまま返す
				}
			}
		}
		// TODO:inner classの場合を考慮する
		return	null;
	}

	// classに対応するimport宣言
	public static class ImportDeclaration
	{
		public final String	_className;

		// クラス名が複数のFQCNを持つ場合があるため、Setで保持する
		// FQCNで指定されたimport文
		private Set<String>	_fqcnSet = new HashSet<String>();
		// packageの末尾が.*で指定されたため、パッケージ名から展開されたfqcn
		private Set<String>	_fqcnAstSet = new HashSet<String>();


		public ImportDeclaration(String	className)
		{
			_className = className;
		}

		public void addFqcn(String fqcnStr)
		{
			_fqcnSet.add(fqcnStr);
		}

		public void addFqcnAst(String fqcnStr)
		{
			_fqcnAstSet.add(fqcnStr);
		}


		public boolean isDuplicatedDeclaration()
		{	// クラス名が参照されるタイミングで、重複チェックを行う
			Set<String>	fqcnSet = (_fqcnSet.size() > 0) ? _fqcnSet : _fqcnAstSet;
			return	(fqcnSet.size() > 1);
		}

		public String	getFQCNStr()
		{
			Set<String>	fqcnSet = (_fqcnSet.size() > 0) ? _fqcnSet : _fqcnAstSet;
			assert	(fqcnSet.size() == 1);
			return	fqcnSet.iterator().next();

		}
	}
}
