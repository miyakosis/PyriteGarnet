package pyrite.lang;

public abstract class Number extends pyrite.lang.Object
{
	public final static java.lang.String	CLASS_NAME = "pyrite.lang.Number";

	public abstract Integer	toInt();
	public abstract Decimal	toDec();
	public abstract Float	toFlt();
}
