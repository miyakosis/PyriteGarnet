package pyrite.compiler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import pyrite.compiler.FQCNParser.FQCN;

/**
 * コンパイラメインクラス。
 *
 */
public class Compiler
{
	private static Compiler	_instance = new Compiler();
	private  Compiler()
	{
	}

	public static Compiler	getInstance()
	{
		return	_instance;
	}


	// コンパイル対象ソースファイル
	private List<SourceFile>	_sourceFileList = new ArrayList<SourceFile>();

	// main
	public static void main(String[] args) throws IOException
	{
		Logger	logger = Logger.getGlobal();
		ConsoleHandler	ch = new ConsoleHandler();
		ch.setFormatter(new Formatter()
		{
			@Override
			public String format(LogRecord rec)
			{
				return rec.getMessage() + "\n";
			}
		});

//		(logger.getHandlers())[0].setFormatter(new Formatter()
//		{
//			@Override
//			public String format(LogRecord rec)
//			{
//				return rec.getMessage();
//			}
//		});

//		__logger.setLevel(Level.ALL);
		ch.setLevel(Level.WARNING);
		logger.addHandler(ch);
		logger.setUseParentHandlers(false);
		logger.setLevel(Level.ALL);

		Compiler.getInstance().compile(args);
		Compiler.getInstance().createClassFiles();
	}

	// class resolver
	private ClassResolver	_cr;

	/**
	 * コンパイルを実行する。
	 *
	 * @param args	プログラム引数(ファイル名)
	 * @throws IOException
	 */
	public void	compile(String[] args) throws IOException
	{
		// argsで指定されたソースファイルをコンパイルする。
		// そのソースで参照されるクラスのソースファイルについて、
		// a. クラスファイルが存在しない → 対応するソースファイルもコンパイルする
		// b-1. クラスファイルが存在し、ソースファイルより古い → クラスファイルを削除し、対応するソースファイルもコンパイルする
		// b-2. クラスファイルが存在し、ソースファイルより新しい → コンパイルをスキップする
		// c. クラスファイルが存在するが、Jar内にある → コンパイルをスキップする

		// 複数クラスで相互参照しているときのため、以下の順で処理を行う。
		// 1. 引数で指定されたソースファイルに含まれるクラス名を全て取得する。
		// 2. クラスパスに含まれるクラスを全て取得する。(1.に含まれるクラスはスキップする)
		// 3. ソースファイルごとにメンバーフィールド・メソッドを取得する。この時にメソッド引数等で上記で取得されたクラス以外を参照していればコンパイルエラー。
		// 4. メソッドの内部を解析する。この時に上記で取得されたメンバー以外を参照していればコンパイルエラー。
		// 5. クラスファイルを出力する。

		_cr = new ClassResolver();	// クラス名やクラスに含まれるフィールド・メソッドを解決するクラス
		_cr.setPhase(1);
		for (int i = 0; i < args.length; ++i)
		{
			SourceFile	sf = new SourceFile(args[i], _cr);
			_sourceFileList.add(sf);
			_cr.addSourceFileClass(sf);
		}
		// クラスパスを解析
		_cr.resolveClasspath();

		_cr.setPhase(2);
		// メソッド定義を処理する。
		// ソースファイル間でクラスの相互参照がある場合でも、参照先ソースファイルからクラス名が解決できていれば、メソッド定義の解析・チェックは可能。
		for (int i = 0; i < _sourceFileList.size(); ++i)
		{
			_sourceFileList.get(i).parseMethodDeclaration();
		}

		_cr.setPhase(3);
		/*
		// import文までを処理する。
		for (int i = 0; i < _sourceFileList.size(); ++i)
		{
			_sourceFileList.get(i).parseImport();
		}

		// import文のチェック。
		// ソースファイル間で相互参照がある場合、コンパイル位置に存在する参照先ソースファイルについて、
		// import文およびclass名のチェックまでが終わっている状態ではないとimportが妥当かチェックできない。
		for (int i = 0; i < _sourceFileList.size(); ++i)
		{
			_sourceFileList.get(i).checkImport();
		}
		*/


		// メソッドの中身を処理する
		// 参照先ソースファイルの全てのメソッド定義が出揃っていないと、メソッド呼び出しが解決できない。
		for (int i = 0; i < _sourceFileList.size(); ++i)
		{
			_sourceFileList.get(i).parseCodeGeneration();
		}
	}

	//	指定ソースファイルのクラス名のみ解決する
	public SourceFile	compileClassName(FQCN fqcn, String srcFilePathName)
	{
		// ソースファイル解析
		SourceFile	sf = new SourceFile(srcFilePathName, _cr);
		_sourceFileList.add(sf);
		_cr.addSourceFileClass(sf);

		return	sf;
	}

	// 指定ソースファイルのクラス名・メソッド定義を解決する
	public void compileMetohdDeclation(FQCN fqcn, String srcFilePathName)
	{
		SourceFile	sf = compileClassName(fqcn, srcFilePathName);
		sf.parseMethodDeclaration();
	}

	// 指定ソースファイルのクラス名・メソッド定義を解決する
	public void compileMetohdDeclation(SourceFile sf)
	{
		sf.parseMethodDeclaration();
	}

	// コンパイルがすべて正常終わったので、クラスファイルを作成する
	private void createClassFiles() throws IOException
	{
		for (SourceFile sf : _sourceFileList)
		{
			sf.createClassFile();
		}
	}
}
