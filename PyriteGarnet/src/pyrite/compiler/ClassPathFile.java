package pyrite.compiler;

import pyrite.compiler.FQCNParser.FQCN;

//クラスパスに含まれるファイル情報を保持する
//ファイル名＝クラス名と判断するため、FQCN はファイル名を保持する。
//.class, .pryc は常に「ファイル名＝クラス名」だが、.pyrは「ファイル名≠クラス名」の場合がある。
public class ClassPathFile extends ClassRelatedFile
{
//	private final static String	SOURCE_FILE_CLASSPATH_ENTRY = "<CompileTarget>";

	public final String	_classPathEntry;

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

	//	public boolean isCompileTargetClass()
//	{
//		return _classPathEntry.equals(SOURCE_FILE_CLASSPATH_ENTRY);
//	}

	public boolean isNeedCompile()
	{
		// ソースファイルが存在し(_pyriteSourceFileLastModified >= 0)、classファイルの更新日付より新しい場合、コンパイル要
		return	(isSourceFileExists() && (_classFileLastModified < _pyriteSourceFileLastModified));
	}

	public boolean hasClassFile()
	{
		return _classFileLastModified >= 0;
	}

	public String	getSourceFilePath()
	{
		return	_classPathEntry + "/" + _pyriteSoutceFile;
	}

	public boolean hasPyriteClassFile()
	{
		return _pyriteClassFileLastModified >= 0;
	}

	public String	getPyriteClassFilePath()
	{
		return	_classPathEntry + "/" + _pyriteClassFile;
	}

	public boolean isClassFileExists()
	{
		return _pyriteClassFileLastModified >= 0;
	}

	public boolean isSourceFileExists()
	{
		return _pyriteSourceFileLastModified >= 0;
	}

}
