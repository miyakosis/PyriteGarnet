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
        _cr = new ClassResolver();	// クラス名やクラスに含まれるフィールド・メソッドを解決するクラス
		for (int i = 0; i < args.length; ++i)
		{
			SourceFile	sf = new SourceFile(args[i], _cr);
			_sourceFileList.add(sf);
			// 先にメソッド定義のみ処理する
			sf.parseMethodDeclaration();
		}

		// メソッドの中身を処理する
		for (int i = 0; i < _sourceFileList.size(); ++i)
		{
			_sourceFileList.get(i).parseCodeGeneration();
		}
	}

	//	指定ソースファイルのメソッド定義のみ解決しておく
	public void	compile(String fileName) throws IOException
	{
		SourceFile	sf = new SourceFile(fileName, _cr);
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
