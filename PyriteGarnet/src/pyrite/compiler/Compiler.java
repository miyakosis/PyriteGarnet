package pyrite.compiler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pyrite.compiler.FQCNParser.FQCN;

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

	private List<SourceFile>	_sourceFileList = new ArrayList<SourceFile>();

	public static void main(String[] args) throws IOException
	{
		Compiler.getInstance().compile(args);
		Compiler.getInstance().createClassFiles();
	}


	private ClassResolver	_cr;
	public void	compile(String[] args) throws IOException
	{
		// argsで指定されたファイルは必ずコンパイルする。
		// クラスパス上のファイルは、クラスファイルの方がソースファイルより新しければコンパイルをスキップする。
		// これは、クラスパス上のファイルはコンパイルをスキップしてもクラス情報が取得できるが、
		// argsで指定されたファイルはクラスパス上に無い場合、コンパイルスキップした場合にクラス情報が取得できない。

		// 複数クラスで相互参照しているときのため、以下の順で処理を行う。
		// 引数で指定されたソースファイルに含まれるクラス名を全て取得する。
		// クラスパスに含まれるクラスを全て取得する。
		// ソースファイルごとのメンバーフィールド・メソッドを取得する。この時に上記で取得されたクラス以外を参照していればコンパイルエラー。
		// メソッドの内部を解析する。この時に上記で取得されたメンバー以外を参照していればコンパイルエラー。
		// クラスファイルを出力する。

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
		// ソースファイル間で相互参照がある場合、コンパイル位置に存在する参照先ソースファイルについて、
		// クラス名が解決できていれば、メソッド定義の解析・チェックは可能。
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
		// コンパイルした結果、クラス情報が存在しない場合に
		// ファイル名から取得したクラス情報を残さないため、情報をクリアしておく
		_cr.removeClassEntry(fqcn);

		// ソースファイル解析
		SourceFile	sf = new SourceFile(srcFilePathName, _cr);
		FQCN	fqcnSf = sf.getFQCN();
		_cr.addSourceFileClass(sf);

		_sourceFileList.add(sf);

		return	sf;
	}

	// 指定ソースファイルのクラス名・メソッド定義を解決する
	public void compileMetohdDeclation(FQCN fqcn, String srcFilePathName)
	{
		SourceFile	sf = compileClassName(fqcn, srcFilePathName);
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
