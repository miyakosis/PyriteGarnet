package pyrite.compiler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import pyrite.compiler.FQCNParser.FQCN;
import pyrite.compiler.type.ClassType;
import pyrite.compiler.type.JVMType;
import pyrite.compiler.type.MethodType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarTypeName;
import pyrite.compiler.util.HashMapMap;
import pyrite.compiler.util.StringUtil;

//クラス名やクラスに含まれるフィールド・メソッドを解決するクラス
public class ClassResolver
{
	private Map<String, ClassFieldMember>	_classCache = new HashMap<String, ClassFieldMember>();	// key:クラス名 value:ClassFieldMember

	private final static String	PROPERTY_KEY_CLASS_PATH = "java.class.path";
	private final static String	PROPERTY_KEY_CLASS_PATH_SEPARATOR = "path.separator";
	private final static String	PROPERTY_KEY_JAVA_HOME = "java.home";
	private final static String	JAVA_LIB_PATH = "/lib/rt.jar";

	private Set<String>	classPathEntrySet = new HashSet<String>();

	private HashMapMap<String, String, PackageClassFile>	_packageMapMap = new HashMapMap<String, String, PackageClassFile>();	// key:パッケージ valueKey:クラス名 value:PackageClassFile

	// クラスパスエントリから、
	// 　指定jarファイルを展開してクラスファイルを取得する。
	// 　指定ディレクトリ配下のクラスファイルを取得する。
	public ClassResolver() throws IOException
	{
		String	separator = System.getProperty(PROPERTY_KEY_CLASS_PATH_SEPARATOR);
		String	classPath = System.getProperty(PROPERTY_KEY_CLASS_PATH);

		String[]	classPathEntrys = classPath.split(separator);
		for (String classPathEntry : classPathEntrys)
		{
			addClassPathEntry(classPathEntry);
		}

		// rt.jar を展開追加する
		addClassPathEntry(System.getProperty(PROPERTY_KEY_JAVA_HOME) + JAVA_LIB_PATH);

		// TODO: pyrite.jarの展開
	}

	private void	addClassPathEntry(String classPathEntry) throws IOException
	{
		if (classPathEntrySet.contains(classPathEntry))
		{	// 取り込み済みであるため無処理
			return;
		}
		classPathEntrySet.add(classPathEntry);

		String	checkExt = classPathEntry.toLowerCase();
		if (checkExt.endsWith("jar") || checkExt.endsWith("zip"))
		{	// jar file
			readJarFile(classPathEntry);
		}
		else
		{	// directory
			File	dir = new File(classPathEntry);
			if (dir.isDirectory())
			{
				readDirectory(classPathEntry, dir, dir.getAbsolutePath());
			}
		}
	}

	private void readJarFile(String classPathEntry) throws IOException
	{
		File	jarFile = new File(classPathEntry);
		if (jarFile.isFile() == false)
		{
			return;	// ファイルが無ければ何もしない
		}
		ZipFile zf = new ZipFile(jarFile);
		for (Enumeration<? extends ZipEntry> e = zf.entries(); e.hasMoreElements();)
		{
			ZipEntry entry = e.nextElement();
			String	filePathName = entry.getName();
			if (filePathName.endsWith(".class") || filePathName.endsWith(".pyrc"))
			{	// javaクラスファイルまたはPyriteクラスファイルのみ処理
				setPackageClass(classPathEntry, filePathName, 0);
			}
		}
		zf.close();
	}

	private void readDirectory(String classPathEntry, File dir, String rootPath)
	{
		File[]	files = dir.listFiles();
		for (File f : files)
		{
			String	filePathName = f.getAbsolutePath();

			if (f.isDirectory())
			{
				readDirectory(classPathEntry, f, rootPath);
			}
			else if (filePathName.endsWith(".class") || filePathName.endsWith(".pyrc") || filePathName.endsWith(".pyr"))
			{	// javaクラスファイルまたはPyriteファイルのみ処理
				// クラスパス文字列を除外してから登録
				filePathName = filePathName.substring(rootPath.length() + 1);	// +1 for dir separator
				filePathName = filePathName.replace('\\', '/');	// とりあえず
				setPackageClass(classPathEntry, filePathName, f.lastModified());
			}
		}
	}

	// パッケージ・クラス情報を内部に保持する
	private void	setPackageClass(String classPathEntry, String filePathName, long fileLastModified)
	{
		String[]	element = StringUtil.splitLastElement(filePathName, '/');
		String	packageName = element[0];
		String	className = element[1];
		packageName = packageName.replace('/', '.');
		className = className.substring(0, className.indexOf('.'));

		PackageClassFile	packageClassFile = _packageMapMap.get(packageName, className);
		if (packageClassFile == null)
		{
			packageClassFile = new PackageClassFile(classPathEntry, className);
			packageClassFile.addClassFileInfo(filePathName, fileLastModified);
			_packageMapMap.put(packageName, className, packageClassFile);
		}
		else if (classPathEntry.equals(packageClassFile._classPathEntry))
		{	// クラスパスエントリが同じであれば、追加情報を登録する
			// そうではない場合、クラスパスの後の方に定義されているクラス情報であるため無視する
			packageClassFile.addClassFileInfo(filePathName, fileLastModified);
		}

//		System.out.println(packageName + " / " + packageClassFile._className);
	}

	// コンパイル単位に存在する、クラス名
	// クラスパスエントリより優先して指定する
	public void	addSourceFileClass(FQCN className, String filePathName, long fileLastModified)
	{
		PackageClassFile	packageClassFile = new PackageClassFile("", className._className);
		packageClassFile.addClassFileInfo(filePathName, fileLastModified);
		// 既存の登録情報を上書き
		_packageMapMap.put(className._packageName, className._className, packageClassFile);
	}

	// パッケージに含まれるクラス名のリストを返す
	public List<String>	getPackageMemberClassName(String packageName)
	{
		Map<String, PackageClassFile>	classNameMap = _packageMapMap.get(packageName);
		assert(classNameMap != null);

		List<String>	classNameList = new ArrayList<String>();
		for (PackageClassFile packageClassFile : classNameMap.values())
		{
			classNameList.add(packageClassFile._className);
		}

		return	classNameList;
	}

	// ClassFieldMember を追加する
	public void putClassFieldMember(String className, ClassFieldMember declaredMember)
	{
		_classCache.put(className, declaredMember);
	}


	public boolean isPackage(String packageName1, String packageName2)
	{
		String	packageName = StringUtil.concat(packageName1, packageName2);
		return	isPackage(packageName);
	}

	public boolean isPackage(String packageName)
	{
		if (packageName.equals("java"))
		{
			return	true;
		}

		return Package.getPackage(packageName) != null;
	}

	// assertion: pahese1ではこのメソッドは呼ばれない
	public boolean isClass(FQCN fqcn)
	{
		PackageClassFile	pcf = _packageMapMap.get(fqcn._packageName, fqcn._className);
		if (pcf == null)
		{
			return	false;
		}

		if (pcf.isNeedCompile())
		{
			// コンパイルした結果、クラス情報が存在しない場合にクラス情報を残さないため、情報をクリアしておく
			_packageMapMap.remove(fqcn._packageName, fqcn._className);
			Compiler.getInstance().compileClassName(pcf.getSourcePathFile());

			// オブジェクト取り直し
			pcf = _packageMapMap.get(fqcn._packageName, fqcn._className);
		}

		return	pcf.hasClassFile();
	}


	public boolean hasInterface(String packageClassName, String interfaceName)
	{
		ClassFieldMember	cls = getClassFieldMember(packageClassName);
		assert (cls != null);
		return	cls._interfaceSet.contains(interfaceName);
	}


	public ClassFieldMember	getClassFieldMember(String packageClassName)
	{
		try
		{
			ClassFieldMember	cls = _classCache.get(packageClassName);
			if (cls == null)
			{
				String[]	elements = StringUtil.splitLastElement(packageClassName, '.');
				PackageClassFile	packageClassFile = _packageMapMap.get(elements[0], elements[1]);
				if (packageClassFile == null)
				{	// そのようなクラスは無い
					_classCache.put(packageClassName, null);
					return	null;
				}

				if (packageClassFile.isNeedCompile())
				{	// コンパイルが必要
					try
					{	// TODO:
						Compiler.getInstance().compile(packageClassFile.getSourcePathFile());
					}
					catch (IOException e)
					{
						throw new RuntimeException("lower file compiliation failed.");
					}
				}
				else if (packageClassFile.hasClassFile())
				{	// クラスファイルがある
					Class<?>	c = Class.forName(packageClassName);
					cls = new ClassFieldMember(packageClassName, c, this);
					_classCache.put(packageClassName, cls);
				}
				else
				{	// クラスファイルが無いし、Pyriteコンパイルもできない
					_classCache.put(packageClassName, null);
					return	null;
				}
			}
			return	cls;
		}
		catch (ClassNotFoundException e)
		{
			throw new RuntimeException("must exist");
//			_classCache.put(packageClassName, null);
//			return	null;
		}
	}

	// 該当クラスの該当クラスフィールドの返り値を返す
	public VarType dispatchVariableC(String packageClassName, String fieldName)
	{
		VarType	resultType = null;

		ClassFieldMember	cls = getClassFieldMember(packageClassName);
		if (cls != null)
		{
			resultType = cls._classFieldMap.get(fieldName);

			if (resultType != null)
			{
				return	resultType;
			}
		}

		return null;
	}


	// 該当クラスの該当インスタンスフィールドの返り値を返す
	public VarType dispatchVariableI(String packageClassName, String fieldName)
	{
		VarType	resultType = null;

		ClassFieldMember	cls = getClassFieldMember(packageClassName);
		if (cls != null)
		{
			resultType = cls._instanceFieldMap.get(fieldName);

			if (resultType != null)
			{
				return	resultType;
			}
		}

		return null;
	}

	// 該当クラスの該当クラスメソッドの型を返す
	public VarType dispatchMethodC(String packageClassName, String methodName)
	{
		VarType	resultType = null;

		ClassFieldMember	cls = getClassFieldMember(packageClassName);
		if (cls != null)
		{
			resultType = cls._classMethodNameMap.get(methodName);

			if (resultType != null)
			{
				return	resultType;
			}
		}

		return null;
	}

	// 該当クラスの該当クラスメソッドまたはインスタンスメソッドの返り値を返す
	public VarType dispatchMethodIC(String packageClassName, String methodName)
	{
		VarType	resultType = null;

		ClassFieldMember	cls = getClassFieldMember(packageClassName);
		if (cls != null)
		{
			resultType = cls._instanceMethodNameMap.get(methodName);

			if (resultType != null)
			{
				return	resultType;
			}
			return	dispatchVariableC(packageClassName, methodName);
		}

		return null;
	}



	// メソッド引数を考慮して、適切なMethodTypeを返す
	// 1. m(Object, List)() と m(List, Object)() が定義されているとき、m(ArrayList p1, ArrayList p2) がどちらを呼び出すか曖昧なのでコンパイルエラー
	// 2. m(Object, Object)() と m(List, Object)() が定義されているとき、m(ArrayList p1, ArrayList p2) は後者を呼び出す
	// 3. m(Object, Object)() と m(ArrayList, Object)() が定義されているとき、m(ArrayList p1, Object p2) は後者を呼び出す
	// 4. m(Object, Object)() と m(ArrayList, Object)() が定義されているとき、m(List p1, Object p2) は前者を呼び出す
	// 5. m(Object, Object)() と m(List, Object) と m(ArrayList p1, Object p2)() が定義されているとき、m(ArrayList p1, Object p2) は曖昧なのでコンパイルエラー
	//   (Javaでは classがinterfaceより優先されるので、三番目が呼び出される)
	//   (< 多重継承を見越して、クラスとインターフェースはフラットに扱う)
	// 6. 当クラスでメソッド解決できない場合、スーパークラスのメソッドに遡って解決を試みる
	//   (このとき、Javaではメソッド定義に一番近いものが選択されるが、Pyriteでは自クラスのクラス階層に近いものが選択される)
	//   (例、スーパークラスで m(String)、自クラスで m(Object)が定義されている場合、
	//     m(String p)はJavaではスーパークラスのm(String)、Pyriteでは自クラスのm(Object)が選択される
	//   (Javaにあわせるか?)
	// よって、
	// それぞれの引数について、引数に指定されたクラスを基準に、クラス階層を遡って引数のクラスの組み合わせを作成する。
	// それぞれの組み合わせにおいて、該当メソッドが存在するかをチェックする。
	// メソッド定義のクラス階層が最も大きいものを選択する(2.)
	// 引数によってクラス階層に入れ違いがある場合、コンパイルエラーにする(1.)
	// 該当するメソッドが存在しない場合、親クラスに遡ってチェックする。
	//
	// とりあえず、クラス階層のみを対象とする。インターフェース定義はフラットとして扱う。
	public MethodType	dispatchMethodVarType(
			MethodType methodType,
			List<VarType> inputParamTypeList)
	{
		// TODO:この判定でよいのか、再検討
		boolean	isStaticOnly = methodType._isStatic;		// true:かならずstaticメソッドでないといけない false:staticでもinstanceでもよい

		// メソッドパラメータシグネチャの組み合わせを作る
		List<MethodParamSignature>	methodParamSignatureList = createMethodParamSignarureList(inputParamTypeList);

		// クラス階層を遡ってメソッドが存在するかチェックする
		for (ClassFieldMember cls = getClassFieldMember(methodType._packageClassName);
				cls != null;
				cls = cls._superCFM)
		{
			List<MethodType>	resultTypeList = new ArrayList<MethodType>();
			List<MethodParamSignature>	resultMethodParamSignatureList = new ArrayList<MethodParamSignature>();

			for (MethodParamSignature methodParamSignature : methodParamSignatureList)
			{
				// すべてのメソッドパラメータシグネチャについて、メソッドに存在するかチェックする
				String	methodSignature = MethodType.createMethodSignature(methodType._packageClassName, methodType._methodName, methodParamSignature._methodParamSignarure);

				MethodType	resultType = (MethodType)cls._classMethodMap.get(methodSignature);
				if (resultType != null)
				{
					resultTypeList.add(resultType);
					resultMethodParamSignatureList.add(methodParamSignature);
				}
				if (isStaticOnly == false)
				{
					resultType = (MethodType)cls._instanceMethodMap.get(methodSignature);
					if (resultType != null)
					{
						resultTypeList.add(resultType);
						resultMethodParamSignatureList.add(methodParamSignature);
					}
				}
			}

			// 合致するメソッドがいくつあるか判定する。
			switch (resultTypeList.size())
			{
			case 0:	// 該当するメソッドが一つも無いので、クラス階層を遡ってチェックする
				break;
			case 1:	// 該当するメソッドが一つのみだったので、それを返す
				return	resultTypeList.get(0);
			default:	// メソッドのクラス階層をチェックする。
				int	resultIdx = checkClassPriority(resultMethodParamSignatureList);
				return	resultTypeList.get(resultIdx);
			}
		}

		return	null;	// no such method
	}


	protected List<MethodParamSignature> createMethodParamSignarureList(List<VarType> inputParamTypeList)
	{
		List<MethodParamSignature>	methodParamSignarureList = new ArrayList<MethodParamSignature>();

		if (inputParamTypeList.size() == 0)
		{	// 引数が空という要素のみを追加したリストを返す
			MethodParamSignature	methodParamSignature = new MethodParamSignature("", new ClassHierarchy[0]);
			methodParamSignarureList.add(methodParamSignature);
			return	methodParamSignarureList;
		}

		List<List<ClassHierarchy>>	inputParamTypeClassHierarchyListList = new ArrayList<List<ClassHierarchy>>();

		// パラメータごとに型階層オブジェクトを作る
		for (VarType inputParamType : inputParamTypeList)
		{
			List<ClassHierarchy>	paramClassHierarchyList = new ArrayList<ClassHierarchy>();
			switch (inputParamType._type)
			{
			case OBJ:
				ObjectType	type = (ObjectType)inputParamType;
				int	level = 0;
				for (ClassFieldMember cls = getClassFieldMember(type._packageClassName);
						cls != null;
						cls = cls._superCFM)
				{
					// 引数オブジェクトを型階層に追加
					addInterfaceClassHierarchyRecursive(cls._fqcnStr, level, paramClassHierarchyList);
					level += 1;
				}
				break;

			default:
				ClassHierarchy	ch = new ClassHierarchy(inputParamType, 0);
				paramClassHierarchyList.add(ch);
				break;
			}
			// 保持
			inputParamTypeClassHierarchyListList.add(paramClassHierarchyList);
		}

		// メソッドのパラメータ文字列を組み合わせで再帰的に作成する
		createMethodParamSignatureRecursive(inputParamTypeClassHierarchyListList, 0, "", new ClassHierarchy[inputParamTypeList.size()], methodParamSignarureList);
		return	methodParamSignarureList;
	}



	// 指定されたクラスを型階層に追加し、再帰的にインターフェースも型階層に追加する
	private void addInterfaceClassHierarchyRecursive(
			String fqcn,
			int level,
			List<ClassHierarchy> paramClassHierarchyList)
	{
		// 自分自身を登録する
		VarType	type = ObjectType.getType(fqcn);
		ClassHierarchy	ch = new ClassHierarchy(type, level);
		if (paramClassHierarchyList.contains(ch) == false)
		{	// レベル違いで同じ型が存在していない場合に追加する
			paramClassHierarchyList.add(ch);
		}

		ClassFieldMember	cls = getClassFieldMember(fqcn);
		assert (cls != null);

		// インターフェースに対して再帰的に実行する
		for (String interfaceFqcn : cls._interfaceSet)
		{
			addInterfaceClassHierarchyRecursive(interfaceFqcn, level, paramClassHierarchyList);
		}
	}

	// メソッドのパラメータ文字列を組み合わせで再帰的に作成する
	private void createMethodParamSignatureRecursive(
			List<List<ClassHierarchy>> inputParamTypeClassHierarchyListList,
			int inListIdx,
			String	paramSignaturePrev,
			ClassHierarchy[]	pramClassHierarchys,
			List<MethodParamSignature> methodParamSignarureList)
	{
		if (inListIdx >= inputParamTypeClassHierarchyListList.size())
		{	// 末尾要素まで組み合わせたので値を保存する
			MethodParamSignature	methodParamSignature = new MethodParamSignature(paramSignaturePrev, pramClassHierarchys);
			methodParamSignarureList.add(methodParamSignature);
			return;
		}

		for (ClassHierarchy inputParamTypeClassHierarchy : inputParamTypeClassHierarchyListList.get(inListIdx))
		{
			String	paramSignature = paramSignaturePrev + inputParamTypeClassHierarchy._type._jvmExpression;
			pramClassHierarchys[inListIdx] = inputParamTypeClassHierarchy;

			// 再帰的に作成
			createMethodParamSignatureRecursive(
					inputParamTypeClassHierarchyListList,
					inListIdx + 1,
					paramSignature,
					pramClassHierarchys,
					methodParamSignarureList);
		}
	}

	// メソッドの優先順を判定する。最も優先されるもののインデクスを返す。
	// 優先度が曖昧な場合は負の値を返す。
	private int checkClassPriority(List<MethodParamSignature> resultMethodParamSignatureList)
	{
		// まずは最適と思われるもの(levelが最も小さいもの)を探す
		// その後、最適と思われるものと一つでも小さいクラス階層のパラメータになっているものがあるかを調べる
		// c.f.	m(C1, C2) m(C2, C1) m(C3, C3)という定義に対して m(C3, C3) はコンパイルエラーではないため
		MethodParamSignature	min = resultMethodParamSignatureList.get(0);
		int	minIdx = 0;

		for (int i = 1; i < resultMethodParamSignatureList.size(); ++i)
		{
			MethodParamSignature	other = resultMethodParamSignatureList.get(i);
			ClassHierarchy[]	minLevel = min._classHierarchys;
			ClassHierarchy[]	otherLevel = other._classHierarchys;

			for (int j = 0; j < otherLevel.length; ++j)
			{
				if (otherLevel[i]._hierarchyLevel < minLevel[j]._hierarchyLevel)
				{	// 最小レベル入れ替え
					min = other;
					minIdx = i;
					break;
				}
			}
		}

		for (int i = 0; i < resultMethodParamSignatureList.size(); ++i)
		{
			if (i == minIdx)
			{	// skip
				continue;
			}
			MethodParamSignature	other = resultMethodParamSignatureList.get(i);
			ClassHierarchy[]	minLevel = min._classHierarchys;
			ClassHierarchy[]	otherLevel = other._classHierarchys;

			boolean	isHigherLevel = false;	// true: otherLevel は一つでも minLevel より高レベルの引数パラメータがあった false:すべて同じレベルの引数パラメータだった
			for (int j = 0; j < otherLevel.length; ++j)
			{
				if (otherLevel[i]._hierarchyLevel < minLevel[j]._hierarchyLevel)
				{	// 最適と思われるものよりレベルが小さいものが発見されたので、どちらを選択すべきか曖昧
					throw new PyriteSyntaxException("method call is ambiguity");
				}
				else if (otherLevel[i]._hierarchyLevel > minLevel[j]._hierarchyLevel)
				{
					isHigherLevel = true;
				}
			}

			if (isHigherLevel == false)
			{	// すべて同じレベルの引数パラメータのメソッドが存在する(インターフェース違い)ので、どちらを選択すべきか曖昧
				throw new PyriteSyntaxException("method call is ambiguity");
			}
		}
		return	minIdx;
	}

	public MethodType	dispatchConstractor(
			ClassType classType,
			List<VarType> inputParamTypeList)
	{
		String	methodSignature = MethodType.createMethodSignature(classType._packageClassName, classType._className, inputParamTypeList.toArray(new VarType[0]));

		MethodType	resultType = null;

		ClassFieldMember	cls = getClassFieldMember(classType._packageClassName);
		assert (cls != null);

		resultType = (MethodType)cls._constructorMap.get(methodSignature);
		if (resultType != null)
		{
			return	resultType;
		}

		return	null;	// no such method
	}




	//	public MethodDeclation dispatchMethodDeclation(
//			String packageClassName,
//			String methodName,
//			List<MethodParam> inParamList,
//			boolean isStaticOnly)
//	{
//		VarType	resultType = null;
//
//		ClassFieldMember	cls = _classCache.get(packageClassName);
//		assert (cls != null);
//
//		String	methodSignature = createMethodSignature(packageClassName, methodName, inParamList);
//
//		resultType = cls._classMethodMap.get(methodSignature);
//
//		if (resultType != null)
//		{
//			List<MethodParam>	outParamList = new ArrayList<MethodParam>();
//			outParamList.add(new MethodParam(resultType));
//
//			MethodDeclation	methodDeclation = new MethodDeclation();
//			methodDeclation.setClassName(packageClassName);
//			methodDeclation.setMethodName(methodName);
//			methodDeclation.setInParamList(inParamList);
//			methodDeclation.setOutParamList(outParamList);
//			methodDeclation.setStatic(true);
//
//			return	methodDeclation;
//		}
//		else if (isStaticOnly == false)
//		{
//			resultType = cls._instanceMethodMap.get(methodSignature);
//			if (resultType != null)
//			{
//				List<MethodParam>	outParamList = new ArrayList<MethodParam>();
//				outParamList.add(new MethodParam(resultType));
//
//				MethodDeclation	methodDeclation = new MethodDeclation();
//				methodDeclation.setClassName(packageClassName);
//				methodDeclation.setMethodName(methodName);
//				methodDeclation.setInParamList(inParamList);
//				methodDeclation.setOutParamList(outParamList);
//				methodDeclation.setStatic(false);
//
//				return	methodDeclation;
//			}
//		}
//
//		return	null;	// no such method
//	}
//
//	public static String	createMethodSignature(
//			String className,
//			String methodName,
//			Class[] inParamList)
//	{
//		StringBuilder	sb = new StringBuilder();
//		sb.append(className);
//		sb.append(".");
//		sb.append(methodName);
//		sb.append("(");
//		for (Class param : inParamList)
//		{
//			sb.append(param.getName());
//		}
//		sb.append(")");
//
//		return	sb.toString();
//	}
//
//	public static String	createMethodSignature(
//			String className,
//			String methodName,
//			List<MethodParam> inParamList)
//	{
//		StringBuilder	sb = new StringBuilder();
//		sb.append(className);
//		sb.append(".");
//		sb.append(methodName);
//		sb.append("(");
//		for (MethodParam param : inParamList)
//		{
//			sb.append(param.getJVMExpression());
//		}
//		sb.append(")");
//
//		return	sb.toString();
//	}


	// クラスのフィールド定義・メソッド定義を保持する
	public static class	ClassFieldMember
	{
		public final String	_fqcnStr;

		public ClassFieldMember	_superCFM;

		public Map<String, VarType>	_classFieldMap = new HashMap<String, VarType>();		// key:field name value:型
		public Map<String, VarType>	_instanceFieldMap = new HashMap<String, VarType>();		// key:field name value:型
		public Map<String, MethodType>	_classMethodMap = new HashMap<String, MethodType>();		// key:signature
		public Map<String, MethodType>	_instanceMethodMap = new HashMap<String, MethodType>();		// key:signature
		public Map<String, MethodType>	_classMethodNameMap = new HashMap<String, MethodType>();	// key:method name value:返す型の代表一つ
		public Map<String, MethodType>	_instanceMethodNameMap = new HashMap<String, MethodType>();	// key:method name value:返す型の代表一つ
		public Map<String, MethodType>	_constructorMap = new HashMap<String, MethodType>();		// key:signature

		public Set<String>	_interfaceSet = new HashSet<String>();	// key:name

		public ClassFieldMember(String fqcnStr)
		{
			_fqcnStr = fqcnStr;
		}

		public ClassFieldMember(String fqcnStr, Class<?> c, ClassResolver cr)
		{
			_fqcnStr = fqcnStr;
			Class<?>	superClass = c.getSuperclass();
			if (superClass != null)
			{
				_superCFM = cr.getClassFieldMember(superClass.getName());
			}
			else if (fqcnStr.equals("java.lang.Object") == false)
			{
				_superCFM = cr.getClassFieldMember("java.lang.Object");
			}
			else
			{
				_superCFM = null;
			}

			Field[]	fields = c.getDeclaredFields();
			for (Field f : fields)
			{
				String	fieldName = f.getName();
				String	typeName = f.getType().getName();
				int	modifier = f.getModifiers();
				VarType	type = JVMType.parseJavaTypeName(typeName);

				if ((modifier & Modifier.STATIC) != 0)
				{
					_classFieldMap.put(fieldName, type);
				}
				else
				{
					_instanceFieldMap.put(fieldName, type);
				}
			}

//			System.out.println(packageClassName);

			for (Method m : c.getDeclaredMethods())
			{
				String	methodName = m.getName();
				Class<?>[]	paramTypeClasses = m.getParameterTypes();
				Class<?>	returnTypeClass = m.getReturnType();
				int	modifier = m.getModifiers();
				boolean	isStatic = ((modifier & Modifier.STATIC) != 0);

				addMethodType(createMethodType(fqcnStr, methodName, paramTypeClasses, returnTypeClass, isStatic));

//				MethodType	type = createMethodType(packageClassName, methodName, paramTypeClasses, returnTypeClass, isStatic);
//				System.out.println("\t" + packageClassName + " . " + methodName + ":" + type._methodSignature);
			}

			for (Constructor<?> cn : c.getDeclaredConstructors())
			{
				String	methodName = cn.getName();
				// メソッド名にパッケージ名が含まれる場合、パッケージ部分を除去する
				methodName = StringUtil.getClassName(methodName);
				Class<?>[]	paramTypeClasses = cn.getParameterTypes();
				int	modifier = cn.getModifiers();
				boolean	isStatic = ((modifier & Modifier.STATIC) != 0);

				addConstructorType(createMethodType(fqcnStr, methodName, paramTypeClasses, c, isStatic));
			}

			for (Class<?> interfaceClass : c.getInterfaces())
			{
				_interfaceSet.add(interfaceClass.getName());
			}
		}

		public MethodType	createMethodType(String packageClassName,
				String	methodName,
				Class<?>[]	paramTypeClasses,
				Class<?>	returnTypeClass,
				boolean	isStatic)
		{
			VarType[]	paramTypes = new VarType[paramTypeClasses.length];
			for (int i = 0; i < paramTypeClasses.length; ++i)
			{
				paramTypes[i] = JVMType.parseJavaTypeName(paramTypeClasses[i].getName());
			}

			VarType[]	returnTypes;
			if (returnTypeClass.getName().equals("pyrite.compiler.type.JVMReturnType"))
			{
				// Pyriteの型であれば、解析して複数の帰り値型として解決する
				throw new RuntimeException("not implemented yet");	// TODO
			}
			else
			{
				returnTypes = new VarType[1];
				returnTypes[0] = JVMType.parseJavaTypeName(returnTypeClass.getName());
			}

			return	(MethodType)MethodType.getType(packageClassName, methodName, paramTypes, returnTypes, isStatic);
		}

		public void	addConstructorType(MethodType type)
		{
			_constructorMap.put(type._methodSignature, type);
		}

		public void	addMethodType(MethodType type)
		{
			if (type._isStatic)
			{
				_classMethodMap.put(type._methodSignature, type);
				_classMethodNameMap.put(type._methodName, type);
			}
			else
			{
				_instanceMethodMap.put(type._methodSignature, type);
				_instanceMethodNameMap.put(type._methodName, type);
			}
		}

		public void	addFieldType(VarTypeName type, boolean isStatic)
		{
			if (isStatic)
			{
				_classFieldMap.put(type._name, type._type);
			}
			else
			{
				_instanceFieldMap.put(type._name, type._type);
			}
		}
	}


	// クラスパスに含まれるクラス情報を保持する
	public static class	PackageClassFile
	{
		private final String	_classPathEntry;
		private final String	_className;

		private boolean	_isClassFileExist = false;
		private boolean	_isPyriteClassFileExist = false;
		private boolean	_isPyriteSourceFileExist = false;
		private long	_pyriteClassFileLastModified = 0;
		private long	_pyriteSourceFileLastModified = 0;
		private String	_pyriteSoutceFile;

		public PackageClassFile(String classPathEntry, String className)
		{
			_classPathEntry = classPathEntry;
			_className = className;
		}

		public boolean isNeedCompile()
		{
			return	(_pyriteClassFileLastModified < _pyriteSourceFileLastModified);
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

	public static class	ClassHierarchy
	{
		public final VarType	_type;
		public final int	_hierarchyLevel;	// 引数の型と同じなら0、親クラスに遡るたびに+1。インターフェース間ではレベルの差は無し

		public ClassHierarchy(VarType type, int hierarchyLevel)
		{
			_type = type;
			_hierarchyLevel = hierarchyLevel;
		}

		@Override
		public int	hashCode()
		{
			return	_type.hashCode();
		}

		@Override
		public boolean	equals(Object o)
		{
			return	_type.equals(o);
		}
	}

	public static class	MethodParamSignature
	{
		public final String	_methodParamSignarure;
		public final ClassHierarchy[]	_classHierarchys;

		public MethodParamSignature(String methodParamSignarure, ClassHierarchy[] classHierarchys)
		{
			_methodParamSignarure = methodParamSignarure;
			_classHierarchys = Arrays.copyOf(classHierarchys, classHierarchys.length);
		}
	}

}
