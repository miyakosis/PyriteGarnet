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
import pyrite.compiler.type.MethodNameType;
import pyrite.compiler.type.MethodType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarTypeName;
import pyrite.compiler.util.HashMapMap;
import pyrite.compiler.util.StringUtil;

//クラス名やクラスに含まれるフィールド・メソッドを解決するクラス
/*
 * クラスパス：
 *	.pyr .class .pyrc
 *   o    o      o
 *   o    o      o
 *   o    x      x
 *   o    o      x
 *   o    x      x
 *   o    x
 */
public class ClassResolver
{
	private final static String	PROPERTY_KEY_CLASS_PATH = "java.class.path";
	private final static String	PROPERTY_KEY_CLASS_PATH_SEPARATOR = "path.separator";
	private final static String	PROPERTY_KEY_JAVA_HOME = "java.home";
	private final static String	JAVA_LIB_PATH = "/lib/rt.jar";

	private Set<String>	classPathEntrySet = new HashSet<String>();	// 同じクラスパスが複数回設定されている場合に、二重取り込みを回避するためのSet

	// パッケージ・クラス名とそれに紐づくソースファイル情報のMap
	private HashMapMap<String, String, ClassRelatedFile>	_packageMapMap = new HashMapMap<String, String, ClassRelatedFile>();	// key:パッケージ valueKey:クラス名 value:ClassRelatedFile

	// フィールド・メソッド定義まで取得ずみのクラス情報のキャッシュ
	private Map<String, ClassFieldMember>	_classCache = new HashMap<String, ClassFieldMember>();	// key:fqcn value:ClassFieldMember


	// クラスパスエントリから、
	// 　指定jarファイルを展開してクラスファイルを取得する。
	// 　指定ディレクトリ配下のクラスファイルを取得する。
	public ClassResolver()
	{
	}

	// メソッド呼び出しのチェックに使用
	private int	_phase = 0;	// 0:init 1:init(クラスパス解析中) 2:クラスパスに含まれるクラス取得済み(メソッド定義解析中) 3:メソッド定義解析済み (メソッド本体コンパイル中)
	public void	setPhase(int phase)
	{
		_phase = phase;
	}

	// コンパイル対象ソースファイルに存在するクラス名を登録する
	public void	addSourceFileClass(SourceFile sf)
	{
		FQCN	fqcn = sf.getFQCN();
		ClassRelatedFile	crf = _packageMapMap.get(fqcn._packageName, fqcn._className);
		if (crf != null)
		{	// 同じクラスが存在する。
			// 同じソースファイルを複数指定したか、別のファイルに同じクラスが存在する場合。
			throw new PyriteSyntaxException("Class duplicated in other files. FQCN:" + fqcn._fqcnStr);
		}
		else
		{
			_packageMapMap.put(fqcn._packageName, fqcn._className, sf);
		}
	}

	// コンパイルした結果、クラス名がソースファイル名と異なる場合に、
	// ソースファイル名から取得したクラス情報を残さないため、情報をクリアする
	public void	removeClassEntry(FQCN fqcn)
	{
		_packageMapMap.remove(fqcn._packageName, fqcn._className);
	}

	// クラスパスに含まれるクラスを解決する
	public void	resolveClasspath() throws IOException
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

		// 解決した結果、.pyrc のみしか存在せず、class参照もコンパイルもできないものを除外する
		for (ClassRelatedFile crf : _packageMapMap.values())
		{
			if (crf instanceof ClassPathFile)
			{
				ClassPathFile	cpf = (ClassPathFile)crf;
				if (cpf.isClassFileExists() == false && cpf.isSourceFileExists() == false)
				{
					_packageMapMap.remove(cpf._fqcn._packageName, cpf._fqcn._className);
				}
			}
		}
	}

	private void	addClassPathEntry(String classPathEntry) throws IOException
	{
		if (classPathEntrySet.contains(classPathEntry))
		{	// 取り込み済みであるため無処理
			return;
		}
		classPathEntrySet.add(classPathEntry);

		String	ext = classPathEntry.toLowerCase();
		if (ext.endsWith("jar") || ext.endsWith("zip"))
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

		ClassRelatedFile	crf = _packageMapMap.get(packageName, className);
		if (crf == null)
		{
			FQCN	fqcn = FQCNParser.getFQCN(packageName, className);
			ClassPathFile	cpf = new ClassPathFile(classPathEntry, fqcn);
			cpf.addClassFileInfo(filePathName, fileLastModified);
			_packageMapMap.put(packageName, className, cpf);
		}
		else if (crf instanceof ClassPathFile)
		{
			ClassPathFile	cpf = (ClassPathFile)crf;

			// クラスパスエントリが同じであれば、追加情報を登録する
			// そうではない場合、クラスパスの後の方に定義されている、同じクラス名の情報であるため無視する
			if (classPathEntry.equals(cpf._classPathEntry))
			{
				cpf.addClassFileInfo(filePathName, fileLastModified);
			}
		}
		// crf instanceof SourceFile の場合は、そのクラスはコンパイル対象として登録されているため、何もしない

//		System.out.println(packageName + " / " + packageClassFile._className);
	}

	// パッケージに含まれるクラス名のリストを返す
	public List<String>	getPackageMemberClassName(String packageName)
	{
		Map<String, ClassRelatedFile>	classNameMap = _packageMapMap.get(packageName);
		assert(classNameMap != null);

		List<String>	classNameList = new ArrayList<String>();
		for (ClassRelatedFile packageClassFile : classNameMap.values())
		{
			classNameList.add(packageClassFile._fqcn._className);
		}

		return	classNameList;
	}

	// ClassFieldMember を追加する
	public void putClassFieldMember(String fqcnStr, ClassFieldMember declaredMember)
	{
		_classCache.put(fqcnStr, declaredMember);
	}


	public boolean isPackage(FQCN fqcn)
	{
		if (fqcn._fqcnStr.equals("java"))
		{
			return	true;
		}

		return Package.getPackage(fqcn._fqcnStr) != null;
	}

	// assertion: pahese1ではこのメソッドは呼ばれない
	public boolean isClass(FQCN fqcn)
	{
		assert(_phase > 1);
		ClassRelatedFile	crf = _packageMapMap.get(fqcn._packageName, fqcn._className);
		if (crf == null)
		{
			return	false;
		}

		assert (crf instanceof SourceFile || crf instanceof ClassPathFile);
		if (crf instanceof ClassPathFile)
		{
			ClassPathFile	cpf = (ClassPathFile)crf;
			if (cpf.isNeedCompile())
			{
				// クラス名のコンパイル実行
				// コンパイル対象のClassPathFileを除去しておく
				removeClassEntry(fqcn);

				Compiler.getInstance().compileClassName(fqcn, cpf.getSourceFilePath());

				// コンパイル後のクラス名が_packageMapMapにオブジェクトが登録されている。
				return	_packageMapMap.get(fqcn._packageName, fqcn._className) != null;
			}
		}

		return	true;
	}


	public boolean hasInterface(FQCN fqcn, FQCN interfaceFQCN)
	{
		ClassFieldMember	cls = getClassFieldMember(fqcn);
		assert (cls != null);
		return	cls._interfaceSet.contains(interfaceFQCN);
	}


	// assertion: pahese2ではこのメソッドは呼ばれない
	public ClassFieldMember	getClassFieldMember(FQCN fqcn)
	{
		assert(_phase > 2);
		ClassFieldMember	cls = _classCache.get(fqcn._fqcnStr);
		if (cls == null)
		{
			ClassRelatedFile	crf = _packageMapMap.get(fqcn._packageName, fqcn._className);
			if (crf == null)
			{	// そのようなクラスは無い
				return	null;
			}

			// phase3の段階で、SourceFileは_classCacheに登録されているはずなので、ここではClassPathFileのみが取得される
			assert (crf instanceof ClassPathFile == false);

			ClassPathFile	cpf = (ClassPathFile)crf;
			if (cpf.isNeedCompile())
			{	// コンパイルが必要
				// クラス名・メソッド定義のコンパイル実行
				Compiler.getInstance().compileMetohdDeclation(fqcn, cpf.getSourceFilePath());

				// コンパイルによってクラス名が正常に解決できるなら、_classCacheにオブジェクトが登録されている
				return	_classCache.get(fqcn._fqcnStr);
			}
			else if (cpf.hasClassFile())
			{	// クラスファイルのみがある
				try
				{
					Class<?>	c = Class.forName(fqcn._fqcnStr);
					cls = new ClassFieldMember(fqcn, c, this);
					_classCache.put(fqcn._fqcnStr, cls);
					return	cls;
				}
				catch (ClassNotFoundException e)
				{
					throw new RuntimeException("must exist");
					//						_classCache.put(packageClassName, null);
					//						return	null;
				}
			}
			else
			{	// クラスファイルが無いし、Pyriteコンパイルもできない
				// (このケースはありえない?)
				return	null;
			}
		}
		return	cls;
	}

	// 該当クラスの該当クラスフィールドの返り値を返す
	public VarType dispatchVariableC(FQCN fqcn, String fieldName)
	{
		VarType	resultType = null;

		ClassFieldMember	cls = getClassFieldMember(fqcn);
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
	public VarType dispatchVariableI(FQCN fqcn, String fieldName)
	{
		VarType	resultType = null;

		ClassFieldMember	cls = getClassFieldMember(fqcn);
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

	// 該当クラスの該当クラスメソッドが存在するかを返す
	public boolean existsMethodC(FQCN fqcn, String methodName)
	{
		ClassFieldMember	cls = getClassFieldMember(fqcn);
		return (cls != null && cls._classMethodNameSet.contains(methodName));
	}

	// 該当クラスの該当クラスメソッドまたはインスタンスメソッドが存在するかを返す
	public boolean existsMethodIC(FQCN fqcn, String methodName)
	{
		ClassFieldMember	cls = getClassFieldMember(fqcn);
		return (cls != null && (cls._classMethodNameSet.contains(methodName) || cls._instanceMethodNameSet.contains(methodName)));
	}



	// メソッド引数を考慮して、適切なMethodTypeを返す
	// 1. m(Object, List)() と m(List, Object)() が定義されているとき、m(ArrayList p1, ArrayList p2) はどちらを呼び出すか曖昧なのでコンパイルエラー
	// 2. m(Object, Object)() と m(List, Object)() が定義されているとき、m(ArrayList p1, ArrayList p2) は後者を呼び出す
	// 3. m(Object, Object)() と m(ArrayList, Object)() が定義されているとき、m(ArrayList p1, Object p2) は後者を呼び出す
	// 4. m(Object, Object)() と m(ArrayList, Object)() が定義されているとき、m(List p1, Object p2) は前者を呼び出す
	// 5. m(Object, Object)() と m(List, Object) と m(ArrayList p1, Object p2)() が定義されているとき、m(ArrayList p1, Object p2) は曖昧なのでコンパイルエラー
	//   (Javaでは classがinterfaceより優先されるので、三番目が呼び出される)
	//   (< 多重継承を見越して、クラスとインターフェースはフラットに扱う)
	// 6. 当クラスでメソッド解決できない場合、スーパークラスのメソッドに遡って解決を試みる
	//   (このとき、Javaではメソッド定義に一番近いものが選択されるが、Pyriteでは自クラスのクラス階層に近いものを選択する)
	//   (例、スーパークラスで m(String)、自クラスで m(Object)が定義されている場合、
	//     m(String p)はJavaではスーパークラスのm(String)、Pyriteでは自クラスのm(Object)が選択される
	//   (Javaにあわせるか?)
	// よって、以下の順で処理する
	// a. それぞれの引数について、引数に指定されたクラスを基準に、クラス階層を遡って引数のクラスの組み合わせを作成する。
	// b. それぞれの組み合わせにおいて、該当メソッドが存在するかをチェックする。
	// c. メソッド定義のクラス階層が最も大きいものを選択する(2.)
	//    引数によってクラス階層に入れ違いがある場合、コンパイルエラーにする(1.)
	// d. 該当するメソッドが存在しない場合、親クラスに遡ってチェックする。
	//
	// とりあえず、クラス階層のみを対象とする。インターフェース定義はフラットとして扱う。
	public MethodType	dispatchMethodVarType(
			MethodNameType methodNameType,
			List<VarType> inputParamTypeList)
	{
		boolean	isStaticOnly = methodNameType._isStatic;		// true:かならずclass methodでないといけない false:class methodでもinstance methodでもよい

		// 入力パラメータから、メソッドパラメータ識別子の組み合わせを作る
		List<MethodParamSignature>	methodParamSignatureList = createMethodParamSignarureList(inputParamTypeList);

		// クラス階層を遡ってメソッドが存在するかチェックする
		for (ClassFieldMember cls = getClassFieldMember(methodNameType._fqcn);
				cls != null;
				cls = cls._superCFM)
		{
			List<MethodType>	resultTypeList = new ArrayList<MethodType>();
			List<MethodParamSignature>	resultMethodParamSignatureList = new ArrayList<MethodParamSignature>();

			for (MethodParamSignature methodParamSignature : methodParamSignatureList)
			{
				// すべての入力メソッドパラメータ識別子について、当クラスのメソッド定義が存在するかチェックする
				String	methodSignature = MethodType.createMethodSignature(cls._fqcn._fqcnStr, methodNameType._methodName, methodParamSignature._methodParamSignarure);

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

			if (resultTypeList.size() > 0)
			{	// 最適なメソッド定義がどれかを判別して返す
				int	resultIdx = checkClassPriority(resultMethodParamSignatureList);
				return	resultTypeList.get(resultIdx);
			}
			// 該当するメソッドが一つも無いので、クラス階層を遡ってチェックする
		}

		return	null;	// no such method
	}


	protected List<MethodParamSignature> createMethodParamSignarureList(List<VarType> inputParamTypeList)
	{
		List<MethodParamSignature>	methodParamSignarureList = new ArrayList<MethodParamSignature>();	// 作成したメソッド識別子の組み合わせリスト(返り値)

		if (inputParamTypeList.size() == 0)
		{	// 引数が空という要素のみを設定したリストを返す
			MethodParamSignature	methodParamSignature = new MethodParamSignature("", new ClassHierarchy[0]);
			methodParamSignarureList.add(methodParamSignature);
			return	methodParamSignarureList;
		}

		// 「入力パラメータを階層化した値を保持するリスト」のリスト。入力パラメータ毎に値を保持する。
		// 「入力パラメータを階層化した値を保持するリスト」には、対応する入力パラメータについて型階層を遡った型情報を保持する。
		List<List<ClassHierarchy>>	inputParamTypeClassHierarchyListList = new ArrayList<List<ClassHierarchy>>();

		// パラメータごとに型階層オブジェクトを作る
		for (VarType inputParamType : inputParamTypeList)
		{
			List<ClassHierarchy>	paramClassHierarchyList = new ArrayList<ClassHierarchy>();
			switch (inputParamType._type)
			{
			case OBJ:
				// 継承関係がある場合は、継承元の型を遡る
				ObjectType	type = (ObjectType)inputParamType;
				int	level = 0;
				for (ClassFieldMember cls = getClassFieldMember(type._fqcn);
						cls != null;
						cls = cls._superCFM)
				{
					// 引数オブジェクトを型階層に追加
					addInterfaceClassHierarchyRecursive(cls._fqcn, level, paramClassHierarchyList);
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



	// 指定されたクラスを型階層に追加し、インターフェースも再帰的に展開し、同じレベルの型階層に追加する
	private void addInterfaceClassHierarchyRecursive(
			FQCN fqcn,
			int level,
			List<ClassHierarchy> paramClassHierarchyList)
	{
		// クラスを登録する
		VarType	type = ObjectType.getType(fqcn._fqcnStr);
		ClassHierarchy	ch = new ClassHierarchy(type, level);
		if (paramClassHierarchyList.contains(ch) == false)
		{	// レベル違いで同じ型が存在していない場合に追加する
			paramClassHierarchyList.add(ch);
		}

		ClassFieldMember	cls = getClassFieldMember(fqcn);
		assert (cls != null);

		// インターフェースに対して再帰的に展開して追加する
		for (FQCN interfaceFqcn : cls._interfaceSet)
		{
			addInterfaceClassHierarchyRecursive(interfaceFqcn, level, paramClassHierarchyList);
		}
	}

	// メソッドのパラメータ文字列を組み合わせで再帰的に作成する
	/**
	 *
	 * @param inputParamTypeClassHierarchyListList	「入力パラメータを階層化した値を保持するリスト」のリスト
	 * @param inListIdx					今回処理対象とする入力パラメータの位置
	 * @param paramSignaturePrev		一つ前までの入力パラメータを組み合わせたパラメータ識別子
	 * @param pramClassHierarchys		一つ前までの入力パラメータの選択された型情報を保持した配列
	 * @param methodParamSignarureList	作成したメソッド識別子を保持するリスト
	 */
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

		// 処理対象のパラメータの型をすべて組み合わせる
		for (ClassHierarchy inputParamTypeClassHierarchy : inputParamTypeClassHierarchyListList.get(inListIdx))
		{
			String	paramSignature = paramSignaturePrev + inputParamTypeClassHierarchy._type._jvmExpression;
			pramClassHierarchys[inListIdx] = inputParamTypeClassHierarchy;		// 今回選択された型情報を保持する

			// 再帰的に作成
			createMethodParamSignatureRecursive(
					inputParamTypeClassHierarchyListList,
					inListIdx + 1,		// 次のパラメータを処理する
					paramSignature,
					pramClassHierarchys,
					methodParamSignarureList);
		}
	}

	// メソッドの優先順を判定する。最も優先されるMethodParamSignatureのインデクスを返す。
	// 優先度が曖昧な場合は例外を発行する
	private int checkClassPriority(List<MethodParamSignature> resultMethodParamSignatureList)
	{
		// c.f.
		//  C0 extends C1, C1 extends C2 とする。(数字はレベルに対応している)
		//	m(C0, C1) m(C1, C0) m(C0, C0)という定義に対して m(C0, C0) という呼び出しがある場合、最も合致するm(C0, C0)を選択する
		//	m(C0, C1) m(C1, C0) という定義に対して m(C0, C0) という呼び出しがある場合、優先度が曖昧のため例外を発行する。
		//
		// そのため、まず最適と思われるもの(levelが最も小さいもの=引数パラメータの型に近いもの)を探す
		// その後、最適と思われるものに対して、一つでも小さいレベルのパラメータを持つものがある場合、例外を発行する。
		//

		MethodParamSignature	min = resultMethodParamSignatureList.get(0);	// 最適と思われるMethodParamSignature
		int	minIdx = 0;	// 最適と思われるMethodParamSignatureのIndex

		// 最適と思われるものを探す。
		for (int i = 1; i < resultMethodParamSignatureList.size(); ++i)
		{
			MethodParamSignature	other = resultMethodParamSignatureList.get(i);
			ClassHierarchy[]	minLevel = min._classHierarchys;
			ClassHierarchy[]	otherLevel = other._classHierarchys;

			// levelがより小さいものが発見されたら、それを最適と想定して入れ替える
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

		// レベルが最小かチェックする。
		for (int i = 0; i < resultMethodParamSignatureList.size(); ++i)
		{
			if (i == minIdx)
			{	// skip
				continue;
			}
			MethodParamSignature	other = resultMethodParamSignatureList.get(i);
			ClassHierarchy[]	minLevel = min._classHierarchys;
			ClassHierarchy[]	otherLevel = other._classHierarchys;

			boolean	existsHigherLevel = false;	// true: otherLevel は一つでも minLevel より高レベルの引数パラメータがあった false:すべて同じレベルの引数パラメータだった
			for (int j = 0; j < otherLevel.length; ++j)
			{
				if (otherLevel[i]._hierarchyLevel < minLevel[j]._hierarchyLevel)
				{	// 最適と思われるものよりレベルが小さいパラメータが発見されたので、どちらを選択すべきか曖昧
					throw new PyriteSyntaxException("method call is ambiguity");
				}
				else if (otherLevel[i]._hierarchyLevel > minLevel[j]._hierarchyLevel)
				{
					existsHigherLevel = true;
				}
			}

			if (existsHigherLevel == false)
			{	// すべて同じレベルの引数パラメータのメソッドが存在する(インターフェース違いの場合)ので、どちらを選択すべきか曖昧
				throw new PyriteSyntaxException("method call is ambiguity");
			}
		}
		return	minIdx;
	}

	public MethodType	dispatchConstructor(
			ClassType classType,
			List<VarType> inputParamTypeList)
	{
		String	methodSignature = MethodType.createMethodSignature(classType._fqcn._fqcnStr, classType._fqcn._className, inputParamTypeList.toArray(new VarType[0]));

		MethodType	resultType = null;

		ClassFieldMember	cls = getClassFieldMember(classType._fqcn);
		assert (cls != null);

		resultType = (MethodType)cls._constructorMap.get(methodSignature);
		if (resultType != null)
		{
			return	resultType;
		}

		return	null;	// no such method
	}



	// subClass と baseClass が継承関係にあるか(baseClassにsubClassを代入可能か)を調べる
	//
	public boolean	isInherited(FQCN baseClass, FQCN subClass)
	{
		for (ClassFieldMember cfm = getClassFieldMember(subClass); cfm != null; cfm = cfm._superCFM)
		{
			if (cfm._fqcn == baseClass)
			{
				return	true;
			}
			if (cfm._interfaceSet.contains(baseClass))
			{
				return	true;
			}
		}
		return	false;
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
		public final FQCN	_fqcn;

		public ClassFieldMember	_superCFM;

		public Map<String, VarType>	_classFieldMap = new HashMap<String, VarType>();		// key:field name value:型
		public Map<String, VarType>	_instanceFieldMap = new HashMap<String, VarType>();		// key:field name value:型
		public Map<String, MethodType>	_classMethodMap = new HashMap<String, MethodType>();		// key:signature
		public Map<String, MethodType>	_instanceMethodMap = new HashMap<String, MethodType>();		// key:signature
		public Set<String>	_classMethodNameSet = new HashSet<String>();	// key:method name
		public Set<String>	_instanceMethodNameSet = new HashSet<String>();	// key:method name
		public Map<String, MethodType>	_constructorMap = new HashMap<String, MethodType>();		// key:signature

		public Set<FQCN>	_interfaceSet = new HashSet<FQCN>();	// key:name

		public ClassFieldMember(FQCN fqcn)
		{
			_fqcn = fqcn;
		}

		// クラスのメタ情報を解析して定義を取得する
		public ClassFieldMember(FQCN fqcn, Class<?> c, ClassResolver cr)
		{
			_fqcn = fqcn;

			Class<?>	superClass = c.getSuperclass();
			if (_fqcn._fqcnStr.equals("java.lang.Object"))
			{	// 自クラスが java.lang.Object なら基底クラス無し
				_superCFM = null;
			}
			else if (superClass == null)
			{	// 基底クラス定義が取得できなければ、基底クラスは "java.lang.Object"
				_superCFM = cr.getClassFieldMember(FQCNParser.getFQCN("java.lang.Object"));
			}
			else
			{	// 基底クラス定義がある場合は、再帰的に取得
				_superCFM = cr.getClassFieldMember(FQCNParser.getFQCN(superClass.getName()));
			}

			Field[]	fields = c.getDeclaredFields();
			for (Field f : fields)
			{
				String	fieldName = f.getName();
				String	typeName = f.getType().getName();
				int	modifier = f.getModifiers();
				VarType	type = VarType.parseJavaTypeName(typeName);

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

				addMethodType(createMethodType(fqcn, methodName, paramTypeClasses, returnTypeClass, isStatic));

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

				addConstructorType(createMethodType(fqcn, methodName, paramTypeClasses, c, isStatic));
			}

			for (Class<?> interfaceClass : c.getInterfaces())
			{
				_interfaceSet.add(FQCNParser.getFQCN(interfaceClass.getName()));
			}
		}

		public MethodType	createMethodType(FQCN fqcn,
				String	methodName,
				Class<?>[]	paramTypeClasses,
				Class<?>	returnTypeClass,
				boolean	isStatic)
		{
			VarType[]	paramTypes = new VarType[paramTypeClasses.length];
			for (int i = 0; i < paramTypeClasses.length; ++i)
			{
				paramTypes[i] = VarType.parseJavaTypeName(paramTypeClasses[i].getName());
			}

			VarType[]	returnTypes;
			if (returnTypeClass.getName().equals("pyrite.compiler.type.JVMReturnType"))
			{
				// Pyriteの型であれば、解析して複数の帰り値型として解決する
				throw new RuntimeException("not implemented yet");	// TODO
			}
			else if (returnTypeClass.getName().equals("void"))
			{
				returnTypes = new VarType[0];
			}
			else
			{
				returnTypes = new VarType[1];
				returnTypes[0] = VarType.parseJavaTypeName(returnTypeClass.getName());
			}

			return	(MethodType)MethodType.getType(fqcn, methodName, paramTypes, returnTypes, isStatic);
		}

		public void	addConstructorType(MethodType type)
		{
			_constructorMap.put(type._typeId, type);
		}

		public void	addMethodType(MethodType type)
		{
			if (type._isStatic)
			{
				_classMethodMap.put(type._typeId, type);
				_classMethodNameSet.add(type._methodName);
			}
			else
			{
				_instanceMethodMap.put(type._typeId, type);
				_instanceMethodNameSet.add(type._methodName);
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
