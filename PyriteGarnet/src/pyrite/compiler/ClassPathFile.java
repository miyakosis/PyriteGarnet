package pyrite.compiler;

//クラスパスに含まれるファイル情報を保持する
public class ClassPathFile extends ClassRelatedFile
{
	private final static String	SOURCE_FILE_CLASSPATH_ENTRY = "<CompileTarget>";

	public final String	_classPathEntry;
	public final String	_className;

	private boolean	_isClassFileExist = false;
	private boolean	_isPyriteClassFileExist = false;
	private boolean	_isPyriteSourceFileExist = false;
	private long	_pyriteClassFileLastModified = 0;
	private long	_pyriteSourceFileLastModified = 0;
	private String	_pyriteSoutceFile;

	public ClassPathFile(String classPathEntry, String className)
	{
		_classPathEntry = classPathEntry;
		_className = className;
	}

	public boolean isCompileTargetClass()
	{
		return _classPathEntry.equals(SOURCE_FILE_CLASSPATH_ENTRY);
	}

	public boolean isNeedCompile()
	{
		return	(isCompileTargetClass() == false &&
				_pyriteClassFileLastModified < _pyriteSourceFileLastModified);
	}

	public boolean hasClassFile()
	{
		return _isClassFileExist;
	}

	public void addClassFileInfo(String filePathName, long fileLastModified)
	{
		if (filePathName.endsWith(".pyrc"))
		{
			_isPyriteClassFileExist = true;
			_pyriteClassFileLastModified = fileLastModified;
		}
		else if (filePathName.endsWith(".pyr"))
		{
			_isPyriteSourceFileExist = true;
			_pyriteSourceFileLastModified = fileLastModified;
			_pyriteSoutceFile = filePathName;
		}
		else
		{	// class
			_isClassFileExist = true;
		}
	}

	public String	getSourcePathFile()
	{
		return	_pyriteSoutceFile;
	}
}
