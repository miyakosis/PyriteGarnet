package pyrite.compiler;

import pyrite.compiler.FQCNParser.FQCN;

// クラスパスに含まれるファイル情報を保持する
// ファイル名をクラス名と判断し、FQCN はディレクトリから取得したパッケージ名と、ファイル名から取得したクラス名を保持する。
// .class, .pryc は常に「ファイル名＝クラス名」だが、.pyrは「ファイル名≠クラス名」の場合がある。
public class ClassPathFile extends ClassRelatedFile
{
	public final String	_classPathEntry;	// 対応するクラスパスのエントリ

	// .class, .pry, .pryc の最終更新日時。ファイルが存在しない場合は負の値。
	private long	_classFileLastModified = -1;
	private long	_pyriteClassFileLastModified = -1;
	private String	_pyriteClassFile;
	private long	_pyriteSourceFileLastModified = -1;
	private String	_pyriteSoutceFile;

	public ClassPathFile(String classPathEntry, FQCN fqcn)
	{
		_fqcn = fqcn;
		_classPathEntry = classPathEntry;
	}

	public void addClassFileInfo(String filePathName, long fileLastModified)
	{
		if (filePathName.endsWith(".pyrc"))
		{
			_pyriteClassFileLastModified = fileLastModified;
			_pyriteClassFile = filePathName;
		}
		else if (filePathName.endsWith(".pyr"))
		{
			_pyriteSourceFileLastModified = fileLastModified;
			_pyriteSoutceFile = filePathName;
		}
		else if (filePathName.endsWith(".class"))
		{	// class
			_classFileLastModified = fileLastModified;
		}
		else
		{	// assertion
			throw new RuntimeException();
		}
	}

	public boolean isNeedCompile()
	{
		// ソースファイルが存在し(_pyriteSourceFileLastModified >= 0)、classファイルの更新日付より新しい場合、コンパイル要
		return	(existsSourceFile() && (_pyriteSourceFileLastModified > _classFileLastModified));
	}

	public boolean existsSourceFile()
	{
		return _pyriteSourceFileLastModified >= 0;
	}

	public boolean existsClassFile()
	{
		return _classFileLastModified >= 0;
	}

	public boolean existsPyriteClassFile()
	{
		return _pyriteClassFileLastModified >= 0;
	}

	public String	getSourceFilePath()
	{
		return	_classPathEntry + "/" + _pyriteSoutceFile;
	}

	public String	getPyriteClassFilePath()
	{
		return	_classPathEntry + "/" + _pyriteClassFile;
	}
}
