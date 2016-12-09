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
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import pyrite.compiler.FQCNParser.FQCN;
import pyrite.compiler.type.ArrayType;
import pyrite.compiler.type.AssocType;
import pyrite.compiler.type.MethodNameType;
import pyrite.compiler.type.MethodType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarTypeName;
import pyrite.compiler.util.HashMapList;
import pyrite.compiler.util.HashMapMap;
import pyrite.runtime.type.MultipleValueAnnotation;

//クラス名やクラスに含まれるフィールド・メソッドを解決するクラス
/*
 * クラスパスにある、ファイル存在パターン：
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


	// コンパイルフェーズ (メソッド呼び出しのチェックに使用)
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
		// クラスパスエントリから、
		//   指定jarファイルを展開してクラスファイルを取得する。
		//   指定ディレクトリ配下のクラスファイルを取得する。

		Logger.getGlobal().info("resolveClasspath");
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

		String	ext = classPathEntry.toLowerCase();
		if (ext.endsWith("jar") || ext.endsWith("zip"))
		{	// jar file
			Logger.getGlobal().info("ZIP:" + classPathEntry);
			readJarFile(classPathEntry);
		}
		else
		{	// directory
			File	dir = new File(classPathEntry);
			if (dir.isDirectory())
			{
				Logger.getGlobal().info("DIR:" + classPathEntry);
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
		Logger.getGlobal().finest("\t" + filePathName);
		String[]	element = filePathName.split("/");
		String	packageName;

		// パッケージ情報を保持する
		if (element.length == 1)
		{
			packageName = "";
			_packageMapMap.put(packageName);
		}
		else
		{
			packageName = element[0];
			_packageMapMap.put(packageName);
			for (int i = 1; i < element.length - 1; ++i)
			{
				packageName = packageName + "." + element[i];
				_packageMapMap.put(packageName);
			}
		}
		String	className = element[element.length - 1];
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
			// そうではない場合、クラスパスの後の方に定義されている別のクラスパスエントリの同じクラス名の情報であるため無視する
			if (classPathEntry.equals(cpf._classPathEntry))
			{
				cpf.addClassFileInfo(filePathName, fileLastModified);
			}
		}
		// crf instanceof SourceFile の場合は、そのクラスはコンパイル対象として登録されているため、何もしない
	}

	// パッケージに含まれるクラス名のリストを返す
	public List<String>	getPackageMemberClassName(String packageName)
	{
		Map<String, ClassRelatedFile>	classNameMap = _packageMapMap.get(packageName);	// key:class name value:ClassRelatedFile
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


	public boolean existsPackage(FQCN fqcn)
	{
		// Package.getPackage(String) は、含まれるクラスが一つ以上ロードされないと Package オブジェクトが生成されない模様なので、存在判定には使えない
//		return Package.getPackage(fqcn._fqcnStr) != null;
		return	_packageMapMap.get(fqcn._fqcnStr) != null;
	}

	// assertion: pahese1ではこのメソッドは呼ばれない
	public boolean existsFQCN(FQCN fqcn)
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
		{	// キャッシュにないため、まずはそのクラスの存在をチェックする
			ClassRelatedFile	crf = _packageMapMap.get(fqcn._packageName, fqcn._className);
			if (crf == null)
			{	// そのようなクラスは無い
				return	null;
			}
			else if (crf instanceof SourceFile)
			{	// クラス名まで解析されているので、クラス名・メソッド定義のコンパイル実行
				Compiler.getInstance().compileMetohdDeclation((SourceFile)crf);

				return	_classCache.get(fqcn._fqcnStr);
			}
			else
			{
				assert (crf instanceof ClassPathFile);

				ClassPathFile	cpf = (ClassPathFile)crf;
				if (cpf.isNeedCompile())
				{	// コンパイルが必要
					// クラス名・メソッド定義のコンパイル実行
					Compiler.getInstance().compileMetohdDeclation(fqcn, cpf.getSourceFilePath());

					// コンパイルによってクラス名が正常に解決できるなら、_classCacheにオブジェクトが登録されている
					return	_classCache.get(fqcn._fqcnStr);
				}
				else if (cpf.existsClassFile())
				{	// クラスファイルのみがある
					try
					{	// クラス情報をClassLoaderを用いて取得する
						Class<?>	c = Class.forName(fqcn._fqcnStr);
						cls = new ClassFieldMember(fqcn, c, this);

//						if (cpf.existsPyriteClassFile())
//						{	// Pyrite 型情報ファイルがあれば、その情報を読み込む
//							cls.readPyriteClassFile(cpf.getPyriteClassFilePath());
//						}
						_classCache.put(fqcn._fqcnStr, cls);
						return	cls;
					}
					catch (ClassNotFoundException e)
					{
						throw new RuntimeException("assert:must exist");
					}
				}
				else
				{	// クラスファイルが無いし、Pyriteコンパイルもできない
					throw new RuntimeException("assert:must exist");
				}
			}
		}

		return	cls;
	}

	// 該当クラスの該当クラスフィールドの返り値を返す
	public VarType dispatchVariableC(FQCN fqcn, String fieldName)
	{
		VarType	resultType = null;
		for (ClassFieldMember cfm = getClassFieldMember(fqcn); cfm != null; cfm = cfm._superCFM)
		{
			resultType = cfm._classFieldMap.get(fieldName);
			if (resultType != null)
			{
				break;
			}
		}
		return	resultType;
	}


	// 該当クラスの該当インスタンスフィールドの返り値を返す
	public VarType dispatchVariableI(FQCN fqcn, String fieldName)
	{
		VarType	resultType = null;
		for (ClassFieldMember cfm = getClassFieldMember(fqcn); cfm != null; cfm = cfm._superCFM)
		{
			resultType = cfm._instanceFieldMap.get(fieldName);
			if (resultType != null)
			{
				break;
			}
		}
		return	resultType;
	}

	// 該当クラスの該当クラスメソッドが存在するかを返す
	public boolean existsMethodC(FQCN fqcn, String methodName)
	{
		for (ClassFieldMember cfm = getClassFieldMember(fqcn); cfm != null; cfm = cfm._superCFM)
		{
			if (cfm._classMethodNameMapList.containsKey(methodName))
			{
				return	true;
			}
		}
		return	false;
	}

	// 該当クラスの該当クラスメソッドまたはインスタンスメソッドが存在するかを返す
	public boolean existsMethodIC(FQCN fqcn, String methodName)
	{
		for (ClassFieldMember cfm = getClassFieldMember(fqcn); cfm != null; cfm = cfm._superCFM)
		{
			if (cfm._classMethodNameMapList.containsKey(methodName) || cfm._instanceMethodNameMapList.containsKey(methodName))
			{
				return	true;
			}
		}
		return	false;
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
	public MethodParamSignature	resolveMethod(
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
			List<MethodParamSignature>	resultMethodParamSignatureList = new ArrayList<MethodParamSignature>();

			// すべての入力メソッドパラメータ識別子について、当クラスのメソッド定義が存在するかチェックする
			for (MethodParamSignature methodParamSignature : methodParamSignatureList)
			{	// methodParamSignature : 入力パラメータから作成された識別子
//				String	methodSignature = MethodType.createMethodSignature(cls._fqcn._fqcnStr, methodNameType._methodName, methodParamSignature._methodParamSignarure);	// エスケープが不完全なので、下記コードで代替
				StringBuilder	sb = new StringBuilder();
				sb.append(Pattern.quote(cls._fqcn._fqcnStr));
				sb.append("\\.");
				sb.append(methodNameType._methodName);
				sb.append("\\(");
				sb.append(methodParamSignature._methodParamSignarure);
				sb.append("\\)");
				String	methodSignature = sb.toString();


				List<MethodType>	methodTypeList;
				methodTypeList = cls._classMethodNameMapList.get(methodNameType._methodName);
				if (methodTypeList != null)
				{
					for (MethodType m : methodTypeList)
					{	// m : クラスに定義されている同名のメソッド
						if (m._methodSignature.matches(methodSignature))
						{
							if (methodParamSignature.getMethodType() != null)
							{	// このメソッド引数パラメータが、複数のメソッド定義に合致する場合(メソッド引数にnullリテラルが含まれる場合のみ、この状態が発生する)はエラーとする
								// (Javaでは継承関係を考慮して、対立しない場合は継承先のオブジェクトが選択されるが、この判定が大変なのでとりあえずエラーにしてコードで指定してもらうよう仕様とする)
								throw new PyriteSyntaxException("method ambiguity.");
							}
							methodParamSignature.setMethodType(m);

							resultMethodParamSignatureList.add(methodParamSignature);
						}
					}
				}
				methodTypeList = cls._instanceMethodNameMapList.get(methodNameType._methodName);
				if (isStaticOnly == false && methodTypeList != null)
				{
					for (MethodType m : methodTypeList)
					{	// m : クラスに定義されている同名のメソッド
						if (m._methodSignature.matches(methodSignature))
						{
							if (methodParamSignature.getMethodType() != null)
							{	// このメソッド引数パラメータに複数のメソッド定義に合致する場合(メソッド引数にnullリテラルが含まれる場合のみ、この状態が発生する)はエラーとする
								// (Javaでは継承関係を考慮して、対立しない場合は継承先のオブジェクトが選択されるが、この判定が大変なのでとりあえずエラーにしてコードで指定してもらうよう仕様とする)
								throw new PyriteSyntaxException("method ambiguity.");
							}
							methodParamSignature.setMethodType(m);

							resultMethodParamSignatureList.add(methodParamSignature);
						}
					}
				}
			}

			if (resultMethodParamSignatureList.size() > 0)
			{	// 最適なメソッド定義がどれかを判別して返す
				return	checkClassPriority(resultMethodParamSignatureList);
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

			if (inputParamType._type == VarType.TYPE.NULL)
			{
				paramClassHierarchyList.add(new ClassHierarchy(VarType.NULL, 0));
			}
			else
			{
				// 継承関係を遡って型階層オブジェクトを作る
				int	level = 0;
				for (ClassFieldMember cls = getClassFieldMember(inputParamType._fqcn);
						cls != null;
						cls = cls._superCFM)
				{
					// 引数オブジェクトを型階層に追加
					addInterfaceClassHierarchyRecursive(cls._fqcn, level, paramClassHierarchyList);
					level += 10;	// 後でレベルを差し込むために、多めにレベル間隔を設定する
				}
			}

			// Java型変換
			VarType[]	jvmDataTypes = VarType.getAssociatedJVMType(inputParamType);	// inputParamTypeに対応するJVM型を取得する
			int	offset = 0;
			for (VarType jvmDataType : jvmDataTypes)
			{	// リストに追加する
				paramClassHierarchyList.add(new ClassHierarchy(jvmDataType, 5 + offset++));
				// とりあえず int > long > short, double > float の順で解決する。明示的にlongやfloatを指定する方法は、今後検討
			}

			// 保持
			inputParamTypeClassHierarchyListList.add(paramClassHierarchyList);
		}

		// パラメータごとの型階層オブジェクトを全て組み合わせ、メソッドのパラメータ文字列を作成する
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
			String	paramSignature = paramSignaturePrev;
			if (inputParamTypeClassHierarchy._type == VarType.NULL)
			{
				paramSignature += "L.+?;";	// どのクラスにも合うように正規表現設定する
			}
			else
			{
				paramSignature += Pattern.quote(inputParamTypeClassHierarchy._type._jvmExpression);
			}

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

	// メソッドの優先順を判定し、最も優先されるMethodParamSignatureを返す。
	// 優先度が曖昧な場合は例外を発行する
	private MethodParamSignature checkClassPriority(List<MethodParamSignature> resultMethodParamSignatureList)
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
				if (otherLevel[j]._hierarchyLevel < minLevel[j]._hierarchyLevel)
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
				if (otherLevel[j]._hierarchyLevel < minLevel[j]._hierarchyLevel)
				{	// 最適と思われるものよりレベルが小さいパラメータが発見されたので、どちらを選択すべきか曖昧
					throw new PyriteSyntaxException("method call is ambiguity");
				}
				else if (otherLevel[j]._hierarchyLevel > minLevel[j]._hierarchyLevel)
				{
					existsHigherLevel = true;
				}
			}

			if (existsHigherLevel == false)
			{	// すべて同じレベルの引数パラメータのメソッドが存在する(インターフェース違いの場合)ので、どちらを選択すべきか曖昧
				throw new PyriteSyntaxException("method call is ambiguity");
			}
		}
		return	resultMethodParamSignatureList.get(minIdx);
	}

	public MethodParamSignature	resolveConstructor(
			FQCN fqcn,
			List<VarType> inputParamTypeList)
	{
		// 入力パラメータから、メソッドパラメータ識別子の組み合わせを作る
		List<MethodParamSignature>	methodParamSignatureList = createMethodParamSignarureList(inputParamTypeList);

		// メソッドが存在するかチェックする
		ClassFieldMember cls = getClassFieldMember(fqcn);

		List<MethodParamSignature>	resultMethodParamSignatureList = new ArrayList<MethodParamSignature>();

		for (MethodParamSignature methodParamSignature : methodParamSignatureList)
		{
			// すべての入力メソッドパラメータ識別子について、当クラスのメソッド定義が存在するかチェックする
//			String	methodSignature = MethodType.createMethodSignature(cls._fqcn._fqcnStr, fqcn._className, methodParamSignature._methodParamSignarure);	// エスケープ対応が不完全なため、下記コードで代替
			StringBuilder	sb = new StringBuilder();
			sb.append(Pattern.quote(cls._fqcn._fqcnStr));
			sb.append("\\.");
			sb.append("<init>");
			sb.append("\\(");
			sb.append(methodParamSignature._methodParamSignarure);
			sb.append("\\)");
			String	methodSignature = sb.toString();

			for (MethodType m : cls._constructorMap.values())
			{
				if (m._methodSignature.matches(methodSignature))
				{
					if (methodParamSignature.getMethodType() != null)
					{	// このメソッド引数パラメータに複数のメソッド定義に合致する場合(メソッド引数にnullリテラルが含まれる場合のみ、この状態が発生する)はエラーとする
						throw new PyriteSyntaxException("method ambiguity.");
					}
					methodParamSignature.setMethodType(m);

					resultMethodParamSignatureList.add(methodParamSignature);
				}
			}
		}

		if (resultMethodParamSignatureList.size() > 0)
		{	// 最適なメソッド定義がどれかを判別して返す
			return	checkClassPriority(resultMethodParamSignatureList);
		}

		return	null;	// no such method
	}


	// subClass が baseClass が継承しているか
	public boolean	isInherited(FQCN subClass, FQCN baseClass)
	{
		// subClass について、baseClass と同じものがあるかを super class 方向に調べていく
		for (ClassFieldMember cfm = getClassFieldMember(subClass); cfm != null; cfm = cfm._superCFM)
		{
			if (cfm._fqcn == baseClass || cfm._interfaceSet.contains(baseClass))
			{
				return	true;
			}
		}
		return	false;
	}

	// lTypeにrTypeを代入可能か(rType が lType と同じ、または継承しているか)を調べる
	public boolean	isAssignable(VarType lType, VarType rType)
	{
		// precond:lType._fqcnは、Array と Assoc の両方を継承することはない
		if (rType == VarType.NULL)
		{	// nullは常に代入可
			return	true;
		}

		if (isInherited(lType._fqcn, rType._fqcn))
		{
			if (lType._type == VarType.TYPE.ARRAY)
			{	// 要素の型が一致しているかをチェックする
				VarType	lElementType = ((ArrayType)lType)._arrayVarType;
				VarType	rElementType = ((ArrayType)rType)._arrayVarType;
				if (lElementType.equals(rElementType))
				{
					return	true;
				}
			}
			else if (lType._type == VarType.TYPE.ASSOC)
			{
				VarType	lKeyType = ((AssocType)lType)._keyVarType;
				VarType	rKeyType = ((AssocType)rType)._keyVarType;
				VarType	lValType = ((AssocType)lType)._valVarType;
				VarType	rValType = ((AssocType)rType)._valVarType;
				if (lKeyType.equals(rKeyType) && lValType.equals(rValType))
				{
					return	true;
				}
			}
			else
			{
				return	true;
			}
		}

		// 型が違うので代入不可
		return	false;
	}

	// fqcn が Throwable を継承しているかを返す
	public boolean	isThrowable(FQCN fqcn)
	{
		for (ClassFieldMember cfm = getClassFieldMember(fqcn); cfm != null; cfm = cfm._superCFM)
		{
			if (cfm._fqcn == FQCNParser.getFQCN("java.lang.Throwable"))
			{
				return	true;
			}
		}
		return	false;
	}

	// クラスのフィールド定義・メソッド定義を保持する
	public static class	ClassFieldMember
	{
		public final FQCN	_fqcn;

		public ClassFieldMember	_superCFM;

		public int	_modifier;
		public Map<String, VarType>	_classFieldMap = new HashMap<String, VarType>();		// key:field name value:型
		public Map<String, VarType>	_instanceFieldMap = new HashMap<String, VarType>();		// key:field name value:型
		public Map<String, MethodType>	_classMethodMap = new HashMap<String, MethodType>();		// key:signature
		public Map<String, MethodType>	_instanceMethodMap = new HashMap<String, MethodType>();		// key:signature
		public HashMapList<String, MethodType>	_classMethodNameMapList = new HashMapList<String, MethodType>();	// key:method name
		public HashMapList<String, MethodType>	_instanceMethodNameMapList = new HashMapList<String, MethodType>();	// key:method name
		public Map<String, MethodType>	_constructorMap = new HashMap<String, MethodType>();		// key:signature

		public Set<FQCN>	_interfaceSet = new HashSet<FQCN>();	// key:name

		// 自ソースの情報を保持するためのコンストラクタ。
		// メソッドを用いて情報を追加していく。
		public ClassFieldMember(FQCN fqcn)
		{
			_fqcn = fqcn;
		}

		// Class loader を用いて情報を取得するコンストラクタ。
		// クラスのメタ情報を解析して定義を取得する
		public ClassFieldMember(FQCN fqcn, Class<?> c, ClassResolver cr)
		{
			_fqcn = fqcn;

			Class<?>	superClass = c.getSuperclass();
			if (superClass == null)
			{	// 基底クラス定義が取得できなければ、自クラスは "java.lang.Object" か interfaceなど。
				_superCFM = null;
			}
			else
			{	// 基底クラス定義がある場合は、再帰的に取得
				_superCFM = cr.getClassFieldMember(FQCNParser.getFQCN(superClass.getName()));
			}

			_modifier = c.getModifiers();

			// java.lang.Objectを継承している場合、superClass == null になる、と思っての以下の実装だが、今試すと普通に java.lang.Object が取れる。要確認。
//			if (_fqcn._fqcnStr.equals("java.lang.Object"))
//			{	// 自クラスが java.lang.Object なら基底クラス無し
//				_superCFM = null;
//			}
//			else if (superClass == null)
//			{	// 基底クラス定義が取得できなければ、基底クラスは "java.lang.Object" か interfaceなど。
//				_superCFM = cr.getClassFieldMember(FQCNParser.getFQCN("java.lang.Object"));
//			}
//			else
//			{	// 基底クラス定義がある場合は、再帰的に取得
//				_superCFM = cr.getClassFieldMember(FQCNParser.getFQCN(superClass.getName()));
//			}

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

			for (Method m : c.getDeclaredMethods())
			{
				String	methodName = m.getName();
				Class<?>[]	paramTypeClasses = m.getParameterTypes();
				Class<?>	returnTypeClass = m.getReturnType();
				int	modifier = m.getModifiers();
				MultipleValueAnnotation anno = m.getAnnotation(MultipleValueAnnotation.class);

				addMethodType(createMethodType(fqcn, methodName, paramTypeClasses, returnTypeClass, modifier, anno));
			}

			for (Constructor<?> cn : c.getDeclaredConstructors())
			{
				String	methodName = "<init>";
				Class<?>[]	paramTypeClasses = cn.getParameterTypes();
				int	modifier = cn.getModifiers();

				addConstructorType(createMethodType(fqcn, methodName, paramTypeClasses, c, modifier, null));
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
				int	modifier,
				MultipleValueAnnotation	anno)
		{
			VarType[]	paramTypes = new VarType[paramTypeClasses.length];
			for (int i = 0; i < paramTypeClasses.length; ++i)
			{
				paramTypes[i] = VarType.parseJavaTypeName(paramTypeClasses[i].getName());
			}

			VarType[]	returnTypes;
			if (returnTypeClass.getName().equals("void"))
			{
				returnTypes = new VarType[0];
			}
			else if (anno == null)
			{
				returnTypes = new VarType[1];
				returnTypes[0] = VarType.parseJavaTypeName(returnTypeClass.getName());
			}
			else
			{	// アノテーションによって複数戻り値の指定がある
				Class<?>[]	returnTypeClasses = anno.value();
				returnTypes = new VarType[returnTypeClasses.length];
				for (int i = 0; i < returnTypes.length; ++i)
				{
					returnTypes[i] = VarType.parseJavaTypeName(returnTypeClasses[i].getName());
				}
			}

			return	(MethodType)MethodType.getType(fqcn, methodName, paramTypes, returnTypes, modifier);
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
				_classMethodNameMapList.put(type._methodName, type);
			}
			else
			{
				_instanceMethodMap.put(type._methodSignature, type);
				_instanceMethodNameMapList.put(type._methodName, type);
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


		public void	setSuperCFM(FQCN superClassFQCN, ClassResolver cr)
		{
			_superCFM = cr.getClassFieldMember(superClassFQCN);
		}

		public boolean	isClass()
		{
			return	!(Modifier.isInterface(_modifier)  || (_modifier & (0x2000 | 0x4000)) != 0);
		}

		public boolean	isInterface()
		{
			return	Modifier.isInterface(_modifier);
		}

		public boolean	isInstancable()
		{
			return	!(Modifier.isInterface(_modifier) || Modifier.isAbstract(_modifier) || (_modifier & (BC.ACC_ANNOTATION | BC.ACC_ENUM)) != 0);
		}

//		// Pyrite class file を読み込み、そこに記載された型情報(複数の戻り値の情報)でメソッド戻り値を上書きする
//		public void readPyriteClassFile(String pyriteClassFilePath)
//		{
//			try (BufferedReader reader = new BufferedReader(new FileReader(pyriteClassFilePath)))
//			{
//				String	line;	// Signature {\t} return type
//				while ((line = reader.readLine()) != null)
//				{
//					String[]	elm = line.split("\t");
//					String	signature = elm[0];
//					VarType[]	returnTypes = new VarType[elm.length - 1];
//					for (int i = 0; i < returnTypes.length; ++i)
//					{
//						returnTypes[i] = VarType.parseJavaTypeName(elm[i + 1]);
//					}
//
//					MethodType	methodType;
//					if ((methodType = _classMethodMap.get(signature)) != null)
//					{
//						assert (_instanceMethodMap.get(signature) == null);
//						if (methodType._returnTypes.length != 1 || methodType._returnTypes[0] != ObjectType.getType(MultipleValue.CLASS_NAME))
//						{
//							throw new PyriteSyntaxException(".pyrc info unmatched.");
//						}
//						MethodType	newMethodType = (MethodType)MethodType.getType(methodType._fqcn, methodType._methodName, methodType._paramTypes, returnTypes, methodType._modifier);
//
//						// MethodMap からは要素が置き換えられるので特に除去はしなくてよいが、MethodNameMapListからは明示的にオブジェクトを除去する必要がある
//						boolean result = _classMethodNameMapList.remove(methodType._methodName, methodType);
//						assert(result);
//						addMethodType(newMethodType);
//					}
//					else if ((methodType = _instanceMethodMap.get(signature)) != null)
//					{
//						if (methodType._returnTypes.length != 1 || methodType._returnTypes[0] != ObjectType.getType(MultipleValue.CLASS_NAME))
//						{
//							throw new PyriteSyntaxException(".pyrc info unmatched.");
//						}
//						MethodType	newMethodType = (MethodType)MethodType.getType(methodType._fqcn, methodType._methodName, methodType._paramTypes, returnTypes, methodType._modifier);
//
//						// MethodMap からは要素が置き換えられるので特に除去はしなくてよいが、MethodNameMapListからは明示的にオブジェクトを除去する必要がある
//						boolean result = _instanceMethodNameMapList.remove(methodType._methodName, methodType);
//						assert(result);
//						addMethodType(newMethodType);
//					}
//					else
//					{
//						throw new PyriteSyntaxException(".pyrc info unmatched.");
//					}
//
//				}
//			}
//			catch (IOException e)
//			{
//				PyriteSyntaxException	pyrEx = new PyriteSyntaxException("invalid .pyrc");
//				pyrEx.initCause(e);
//				throw	pyrEx;
//			}
//		}
	}


	// 引数の型階層の一つを保持するクラス
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

	// メソッドシグネチャと、それぞれの引数に対応する型を保持するクラス
	public static class	MethodParamSignature
	{
		public final String	_methodParamSignarure;
		public final ClassHierarchy[]	_classHierarchys;

		private MethodType	_matchedMethodType;

		public MethodParamSignature(String methodParamSignarure, ClassHierarchy[] classHierarchys)
		{
			_methodParamSignarure = methodParamSignarure;
			_classHierarchys = Arrays.copyOf(classHierarchys, classHierarchys.length);

			_matchedMethodType = null;
		}

		public void	setMethodType(MethodType m)
		{
			_matchedMethodType = m;
		}

		public MethodType	getMethodType()
		{
			return	_matchedMethodType;
		}

		@Override
		public String	toString()
		{
			return	_methodParamSignarure;
		}
	}
}
