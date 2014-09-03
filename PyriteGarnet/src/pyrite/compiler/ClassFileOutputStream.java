package pyrite.compiler;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class ClassFileOutputStream extends FilterOutputStream
{

	public ClassFileOutputStream(OutputStream os)
	{
		super(os);
	}

	public void	write2(int n) throws IOException
	{
		write(n >> 8);
		write(n);
	}

	public void	write4(int n) throws IOException
	{
		write(n >> 24);
		write(n >> 16);
		write(n >> 8);
		write(n);
	}
}
