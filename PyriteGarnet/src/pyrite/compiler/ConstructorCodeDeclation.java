package pyrite.compiler;

/*
 * コンストラクタの定義情報
 */
public class ConstructorCodeDeclation extends MethodCodeDeclation
{
	// フィールド初期化コードを挿入する位置
	public int	_fieldInitializeCodePos;

	public boolean	_hasConstractorCall = false;

	// フィールド初期化コードを挿入する位置を設定する
	public void	setFieldInitializeCodePos(int pos)
	{
		_fieldInitializeCodePos = pos;
	}

	public void	setHasConstractorCall()
	{
		_hasConstractorCall = true;
	}
}
