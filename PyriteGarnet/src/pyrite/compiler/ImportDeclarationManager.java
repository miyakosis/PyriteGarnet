package pyrite.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pyrite.compiler.FQCNParser.FQCN;

/**
 * import は、FQCN でクラス名まで指定されたものと、*で終わるパッケージが指定されたものがある。
 * importでクラス名の重複があっても、エラーとしてはいけない。
 * ソースコード内でクラス名が指定され、そのクラス名に対応するFQCNが複数取り合える場合にエラーにする必要がある。
 * この際に、FQCN指定とパッケージ指定で重複がある場合は、
 */
public class ImportDeclarationManager
{
	// java.lang.* 配下のクラスに優先して pyrite.lang.* のクラスを選択するクラス名。
	// Integer 等と指定された際に、java.lang.Integer と pyrite.lang.Integer の複数定義でエラーになることを防ぐ。(pyrite.lang.Integer と識別する)
	// ただし、import で FQCN で指定された場合はそれを優先する。
	public final static String[]	IMPORT_PYRITE_LANG_CLASSES =
		{
			"Array", "Assoc", "Boolean", "Character", "Decimal", "Float", "Integer", "MultipleValue", "Number", "Object", "String",
		};



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
	// パッケージやクラスが存在しない場合、エラーにする
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
					importDeclaration.addFqcnAst(fqcn);
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
				importDeclaration.addFqcn(fqcn);
			}
		}
	}



	/**
	 * 指定されたパッケージに含まれるクラスそれぞれについて、
	 *  * そのクラスが FQCN 指定されていれば何もしない
	 *  * そのクラスが FQCN 指定されていなければ、指定されたパッケージを優先する。(FQCN指定されているとみなす)
	 *
	 *  これは、同じパッケージのクラスをパッケージ指定のクラスより優先したり、
	 *  java.lang.* 配下のクラスに優先して pyrite.lang.* のクラスを優先したりするため。
	 *
	 */
	public void	overridePackage(String packageName)
	{
		List<String>	classNameList = _cr.getPackageMemberClassName(packageName);
		for (String className : classNameList)
		{
			FQCN	fqcn = FQCNParser.getFQCN(packageName, className);

			ImportDeclaration	importDeclaration = _importMap.get(fqcn._className);
			if (importDeclaration == null)
			{	// 無ければ作る
				importDeclaration = new ImportDeclaration(fqcn._className);
				_importMap.put(className, importDeclaration);
			}
			if (importDeclaration._fqcnSet.size() == 0)
			{	// FQCN指定が無い場合、この package を FQCN指定されたとみなすことで、優先する。
				importDeclaration.addFqcn(fqcn);
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
				FQCN	importFqcn = importDeclaration.getFQCN();
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
		private Set<FQCN>	_fqcnSet = new HashSet<FQCN>();
		// packageの末尾が.*で指定されたため、パッケージ名から展開されたfqcn
		private Set<FQCN>	_fqcnAstSet = new HashSet<FQCN>();


		public ImportDeclaration(String	className)
		{
			_className = className;
		}

		public void addFqcn(FQCN fqcn)
		{
			_fqcnSet.add(fqcn);
		}

		public void addFqcnAst(FQCN fqcn)
		{
			_fqcnAstSet.add(fqcn);
		}


		public FQCN	getFQCN()
		{
			Set<FQCN>	fqcnSet = (_fqcnSet.size() > 0) ? _fqcnSet : _fqcnAstSet;
			if (fqcnSet.size() > 1)
			{	// import宣言されているクラスが複数存在した
				throw new PyriteSyntaxException("class name is ambiguity");
			}
			assert	(fqcnSet.size() == 1);
			return	fqcnSet.iterator().next();
		}
	}
}
