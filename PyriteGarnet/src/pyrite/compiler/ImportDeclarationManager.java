package pyrite.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pyrite.compiler.FQCNParser.FQCN;

/*
 * import定義を管理するクラス
 *
 * import は、FQCN でクラス名まで指定されたものと、*で終わるパッケージが指定されたものがある。
 * import でパッケージ違いでクラス名の重複があっても、エラーとしてはいけない。
 * ソースコード内でクラス名が参照され、そのクラス名に対応するFQCNが複数取り得る場合にエラーにする必要がある。
 * FQCN指定とパッケージ指定で重複がある場合は、FQCN指定を優先する
 */
public class ImportDeclarationManager
{
	private final ClassResolver _cr;

	// import文を保持する
	private List<String>	_importDeclartionStrList = new ArrayList<String>();

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
	 *  これは、ソースコードと同じパッケージ内のクラスをパッケージ指定のクラスより優先したり、
	 *  java.lang.* 配下のクラスに優先して pyrite.lang.* のクラスを優先したりするため。
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
