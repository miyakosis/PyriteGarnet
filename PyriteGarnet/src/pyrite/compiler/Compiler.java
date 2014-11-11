package pyrite.compiler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		// 複数クラスで相互参照しているときのため、以下の順で処理を行う。
		// クラスパスに含まれるクラスを全て取得する。
		// 引数で指定されたソースファイルに含まれるクラス名を全て取得する。
		// ソースファイルごとのメンバーフィールド・メソッドを取得する。この時に上記で取得されたクラス以外を参照していればコンパイルエラー。
		// メソッドの内部を解析する。この時に上記で取得されたメンバー以外を参照していればコンパイルエラー。
		// クラスファイルを出力する。

		_cr = new ClassResolver();	// クラス名やクラスに含まれるフィールド・メソッドを解決するクラス
		for (int i = 0; i < args.length; ++i)
		{
			SourceFile	sf = new SourceFile(args[i], _cr);
			// クラス名定義を解析する。
			if (sf.parseClassName())
			{	// コンパイル対象の場合は追加
				_sourceFileList.add(sf);
			}
		}

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

		// メソッド定義を処理する。
		// ソースファイル間で相互参照がある場合、コンパイル位置に存在する参照先ソースファイルについて、
		// クラス名が解決できていれば、メソッド定義の解析・チェックは可能。
		for (int i = 0; i < _sourceFileList.size(); ++i)
		{
			_sourceFileList.get(i).parseMethodDeclaration();
		}

		// メソッドの中身を処理する
		// 参照先ソースファイルの全てのメソッド定義が出揃っていないと、メソッド呼び出しが解決できない。
		for (int i = 0; i < _sourceFileList.size(); ++i)
		{
			_sourceFileList.get(i).parseCodeGeneration();
		}
	}

	//	指定ソースファイルのクラス名のみ解決する
	public void	compileClassName(String fileName)
	{
		try
		{
			SourceFile	sf = new SourceFile(fileName, _cr);
			if (sf.parseClassName())
			{	// コンパイル対象の場合は追加
				_sourceFileList.add(sf);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("IOException:" + e.getMessage());
		}
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
