package pyrite.compiler;

/*
 * Pyrite 構文エラーの際の例外
 */
public class PyriteSyntaxException extends RuntimeException
{
	public PyriteSyntaxException(String message)
	{
		super(message);
	}
}
