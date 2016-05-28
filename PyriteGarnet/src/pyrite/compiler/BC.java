package pyrite.compiler;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;


public class BC
{
	public final static Charset	UTF8 = Charset.forName("UTF-8");

	// JVM op code
	public final static byte	NOP = (byte)0x00;
	public final static byte	ACONST_NULL = (byte)0x01;
	public final static byte	ICONST_M1 = (byte)0x02;
	public final static byte	ICONST_0 = (byte)0x03;
	public final static byte	ICONST_1 = (byte)0x04;
	public final static byte	ICONST_2 = (byte)0x05;
	public final static byte	ICONST_3 = (byte)0x06;
	public final static byte	ICONST_4 = (byte)0x07;
	public final static byte	ICONST_5 = (byte)0x08;
	public final static byte	LCONST_0 = (byte)0x09;
	public final static byte	LCONST_1 = (byte)0x0A;
	public final static byte	FCONST_0 = (byte)0x0B;
	public final static byte	FCONST_1 = (byte)0x0C;
	public final static byte	FCONST_2 = (byte)0x0D;
	public final static byte	DCONST_0 = (byte)0x0E;
	public final static byte	DCONST_1 = (byte)0x0F;
	public final static byte	BIPUSH = (byte)0x10;
	public final static byte	SIPUSH = (byte)0x11;
	public final static byte	LDC = (byte)0x12;
	public final static byte	LDC_W = (byte)0x13;
	public final static byte	LDC2_W = (byte)0x14;
	public final static byte	ILOAD = (byte)0x15;
	public final static byte	LLOAD = (byte)0x16;
	public final static byte	FLOAD = (byte)0x17;
	public final static byte	DLOAD = (byte)0x18;
	public final static byte	ALOAD = (byte)0x19;
	public final static byte	ILOAD_0 = (byte)0x1A;
	public final static byte	ILOAD_1 = (byte)0x1B;
	public final static byte	ILOAD_2 = (byte)0x1C;
	public final static byte	ILOAD_3 = (byte)0x1D;
	public final static byte	LLOAD_0 = (byte)0x1E;
	public final static byte	LLOAD_1 = (byte)0x1F;
	public final static byte	LLOAD_2 = (byte)0x20;
	public final static byte	LLOAD_3 = (byte)0x21;
	public final static byte	FLOAD_0 = (byte)0x22;
	public final static byte	FLOAD_1 = (byte)0x23;
	public final static byte	FLOAD_2 = (byte)0x24;
	public final static byte	FLOAD_3 = (byte)0x25;
	public final static byte	DLOAD_0 = (byte)0x26;
	public final static byte	DLOAD_1 = (byte)0x27;
	public final static byte	DLOAD_2 = (byte)0x28;
	public final static byte	DLOAD_3 = (byte)0x29;
	public final static byte	ALOAD_0 = (byte)0x2A;
	public final static byte	ALOAD_1 = (byte)0x2B;
	public final static byte	ALOAD_2 = (byte)0x2C;
	public final static byte	ALOAD_3 = (byte)0x2D;
	public final static byte	IALOAD = (byte)0x2E;
	public final static byte	LALOAD = (byte)0x2F;
	public final static byte	FALOAD = (byte)0x30;
	public final static byte	DALOAD = (byte)0x31;
	public final static byte	AALOAD = (byte)0x32;
	public final static byte	BALOAD = (byte)0x33;
	public final static byte	CALOAD = (byte)0x34;
	public final static byte	SALOAD = (byte)0x35;
	public final static byte	ISTORE = (byte)0x36;
	public final static byte	LSTORE = (byte)0x37;
	public final static byte	FSTORE = (byte)0x38;
	public final static byte	DSTORE = (byte)0x39;
	public final static byte	ASTORE = (byte)0x3A;
	public final static byte	ISTORE_0 = (byte)0x3B;
	public final static byte	ISTORE_1 = (byte)0x3C;
	public final static byte	ISTORE_2 = (byte)0x3D;
	public final static byte	ISTORE_3 = (byte)0x3E;
	public final static byte	LSTORE_0 = (byte)0x3F;
	public final static byte	LSTORE_1 = (byte)0x40;
	public final static byte	LSTORE_2 = (byte)0x41;
	public final static byte	LSTORE_3 = (byte)0x42;
	public final static byte	FSTORE_0 = (byte)0x43;
	public final static byte	FSTORE_1 = (byte)0x44;
	public final static byte	FSTORE_2 = (byte)0x45;
	public final static byte	FSTORE_3 = (byte)0x46;
	public final static byte	DSTORE_0 = (byte)0x47;
	public final static byte	DSTORE_1 = (byte)0x48;
	public final static byte	DSTORE_2 = (byte)0x49;
	public final static byte	DSTORE_3 = (byte)0x4A;
	public final static byte	ASTORE_0 = (byte)0x4B;
	public final static byte	ASTORE_1 = (byte)0x4C;
	public final static byte	ASTORE_2 = (byte)0x4D;
	public final static byte	ASTORE_3 = (byte)0x4E;
	public final static byte	IASTORE = (byte)0x4F;
	public final static byte	LASTORE = (byte)0x50;
	public final static byte	FASTORE = (byte)0x51;
	public final static byte	DASTORE = (byte)0x52;
	public final static byte	AASTORE = (byte)0x53;
	public final static byte	BASTORE = (byte)0x54;
	public final static byte	CASTORE = (byte)0x55;
	public final static byte	SASTORE = (byte)0x56;
	public final static byte	POP = (byte)0x57;
	public final static byte	POP2 = (byte)0x58;
	public final static byte	DUP = (byte)0x59;
	public final static byte	DUP_X1 = (byte)0x5A;
	public final static byte	DUP_X2 = (byte)0x5B;
	public final static byte	DUP2 = (byte)0x5C;
	public final static byte	DUP2_X1 = (byte)0x5D;
	public final static byte	DUP2_X2 = (byte)0x5E;
	public final static byte	SWAP = (byte)0x5F;
	public final static byte	IADD = (byte)0x60;
	public final static byte	LADD = (byte)0x61;
	public final static byte	FADD = (byte)0x62;
	public final static byte	DADD = (byte)0x63;
	public final static byte	ISUB = (byte)0x64;
	public final static byte	LSUB = (byte)0x65;
	public final static byte	FSUB = (byte)0x66;
	public final static byte	DSUB = (byte)0x67;
	public final static byte	IMUL = (byte)0x68;
	public final static byte	LMUL = (byte)0x69;
	public final static byte	FMUL = (byte)0x6A;
	public final static byte	DMUL = (byte)0x6B;
	public final static byte	IDIV = (byte)0x6C;
	public final static byte	LDIV = (byte)0x6D;
	public final static byte	FDIV = (byte)0x6E;
	public final static byte	DDIV = (byte)0x6F;
	public final static byte	IREM = (byte)0x70;
	public final static byte	LREM = (byte)0x71;
	public final static byte	FREM = (byte)0x72;
	public final static byte	DREM = (byte)0x73;
	public final static byte	INEG = (byte)0x74;
	public final static byte	LNEG = (byte)0x75;
	public final static byte	FNEG = (byte)0x76;
	public final static byte	DNEG = (byte)0x77;
	public final static byte	ISHL = (byte)0x78;
	public final static byte	LSHL = (byte)0x79;
	public final static byte	ISHR = (byte)0x7A;
	public final static byte	LSHR = (byte)0x7B;
	public final static byte	IUSHR = (byte)0x7C;
	public final static byte	LUSHR = (byte)0x7D;
	public final static byte	IAND = (byte)0x7E;
	public final static byte	LAND = (byte)0x7F;
	public final static byte	IOR = (byte)0x80;
	public final static byte	LOR = (byte)0x81;
	public final static byte	IXOR = (byte)0x82;
	public final static byte	LXOR = (byte)0x83;
	public final static byte	IINC = (byte)0x84;
	public final static byte	I2L = (byte)0x85;
	public final static byte	I2F = (byte)0x86;
	public final static byte	I2D = (byte)0x87;
	public final static byte	L2I = (byte)0x88;
	public final static byte	L2F = (byte)0x89;
	public final static byte	L2D = (byte)0x8A;
	public final static byte	F2I = (byte)0x8B;
	public final static byte	F2L = (byte)0x8C;
	public final static byte	F2D = (byte)0x8D;
	public final static byte	D2I = (byte)0x8E;
	public final static byte	D2L = (byte)0x8F;
	public final static byte	D2F = (byte)0x90;
	public final static byte	I2B = (byte)0x91;
	public final static byte	I2C = (byte)0x92;
	public final static byte	I2S = (byte)0x93;
	public final static byte	LCMP = (byte)0x94;
	public final static byte	FCMPL = (byte)0x95;
	public final static byte	FCMPG = (byte)0x96;
	public final static byte	DCMPL = (byte)0x97;
	public final static byte	DCMPG = (byte)0x98;
	public final static byte	IFEQ = (byte)0x99;
	public final static byte	IFNE = (byte)0x9A;
	public final static byte	IFLT = (byte)0x9B;
	public final static byte	IFGE = (byte)0x9C;
	public final static byte	IFGT = (byte)0x9D;
	public final static byte	IFLE = (byte)0x9E;
	public final static byte	IF_ICMPEQ = (byte)0x9F;
	public final static byte	IF_ICMPNE = (byte)0xA0;
	public final static byte	IF_ICMPLT = (byte)0xA1;
	public final static byte	IF_ICMPGE = (byte)0xA2;
	public final static byte	IF_ICMPGT = (byte)0xA3;
	public final static byte	IF_ICMPLE = (byte)0xA4;
	public final static byte	IF_ACMPEQ = (byte)0xA5;
	public final static byte	IF_ACMPNE = (byte)0xA6;
	public final static byte	GOTO = (byte)0xA7;
	public final static byte	JSR = (byte)0xA8;
	public final static byte	RET = (byte)0xA9;
	public final static byte	TABLESWITCH = (byte)0xAA;
	public final static byte	LOOKUPSWITCH = (byte)0xAB;
	public final static byte	IRETURN = (byte)0xAC;
	public final static byte	LRETURN = (byte)0xAD;
	public final static byte	FRETURN = (byte)0xAE;
	public final static byte	DRETURN = (byte)0xAF;
	public final static byte	ARETURN = (byte)0xB0;
	public final static byte	RETURN = (byte)0xB1;
	public final static byte	GETSTATIC = (byte)0xB2;
	public final static byte	PUTSTATIC = (byte)0xB3;
	public final static byte	GETFIELD = (byte)0xB4;
	public final static byte	PUTFIELD = (byte)0xB5;
	public final static byte	INVOKEVIRTUAL = (byte)0xB6;
	public final static byte	INVOKESPECIAL = (byte)0xB7;
	public final static byte	INVOKESTATIC = (byte)0xB8;
	public final static byte	INVOKEINTERFACE = (byte)0xB9;
	public final static byte	INVOKEDYNAMIC = (byte)0xBA;
	public final static byte	NEW = (byte)0xBB;
	public final static byte	NEWARRAY = (byte)0xBC;
	public final static byte	ANEWARRAY = (byte)0xBD;
	public final static byte	ARRAYLENGTH = (byte)0xBE;
	public final static byte	ATHROW = (byte)0xBF;
	public final static byte	CHECKCAST = (byte)0xC0;
	public final static byte	INSTANCEOF = (byte)0xC1;
	public final static byte	MONITORENTER = (byte)0xC2;
	public final static byte	MONITOREXIT = (byte)0xC3;
	public final static byte	WIDE = (byte)0xC4;
	public final static byte	MULTIANEWARRAY = (byte)0xC5;
	public final static byte	IFNULL = (byte)0xC6;
	public final static byte	IFNONNULL = (byte)0xC7;
	public final static byte	GOTO_W = (byte)0xC8;
	public final static byte	JSR_W = (byte)0xC9;
	public final static byte	BREAKPOINT = (byte)0xCA;
	public final static byte	IMPDEP1 = (byte)0xFE;
	public final static byte	IMPDEP2 = (byte)0xFF;

	// オペレーション実行後に増減するスタックの量
	public final static Map<Byte, Integer>	STACK_INCDEC = new HashMap<Byte, Integer>();

	static
	{
		STACK_INCDEC.put(AALOAD, -1);
		STACK_INCDEC.put(AASTORE, -3);
		STACK_INCDEC.put(ACONST_NULL, 1);
		STACK_INCDEC.put(ALOAD, 1);
		STACK_INCDEC.put(ALOAD_0, 1);
		STACK_INCDEC.put(ALOAD_1, 1);
		STACK_INCDEC.put(ALOAD_2, 1);
		STACK_INCDEC.put(ALOAD_3, 1);
		STACK_INCDEC.put(ANEWARRAY, 0);
		STACK_INCDEC.put(ARETURN, 0);
		STACK_INCDEC.put(ARRAYLENGTH, 0);
		STACK_INCDEC.put(ASTORE, -1);
		STACK_INCDEC.put(ASTORE_0, -1);
		STACK_INCDEC.put(ASTORE_1, -1);
		STACK_INCDEC.put(ASTORE_2, -1);
		STACK_INCDEC.put(ASTORE_3, -1);
		STACK_INCDEC.put(ATHROW, 0);
		STACK_INCDEC.put(BALOAD, -1);
		STACK_INCDEC.put(BASTORE, -3);
		STACK_INCDEC.put(BIPUSH, 1);
		STACK_INCDEC.put(CALOAD, -1);
		STACK_INCDEC.put(CASTORE, -3);
		STACK_INCDEC.put(CHECKCAST, 0);
		STACK_INCDEC.put(D2F, -1);
		STACK_INCDEC.put(D2I, -1);
		STACK_INCDEC.put(D2L, 0);
		STACK_INCDEC.put(DADD, -2);
		STACK_INCDEC.put(DALOAD, 0);
		STACK_INCDEC.put(DASTORE, -4);
		STACK_INCDEC.put(DCMPG, -3);
		STACK_INCDEC.put(DCMPL, -3);
		STACK_INCDEC.put(DCONST_0, 2);
		STACK_INCDEC.put(DCONST_1, 2);
		STACK_INCDEC.put(DDIV, -2);
		STACK_INCDEC.put(DLOAD, 2);
		STACK_INCDEC.put(DLOAD_0, 2);
		STACK_INCDEC.put(DLOAD_1, 2);
		STACK_INCDEC.put(DLOAD_2, 2);
		STACK_INCDEC.put(DLOAD_3, 2);
		STACK_INCDEC.put(DMUL, -2);
		STACK_INCDEC.put(DNEG, -2);
		STACK_INCDEC.put(DREM, -2);
		STACK_INCDEC.put(DRETURN, 0);
		STACK_INCDEC.put(BREAKPOINT, 0);	// 要定義確認
		STACK_INCDEC.put(DSTORE, -2);
		STACK_INCDEC.put(DSTORE_0, -2);
		STACK_INCDEC.put(DSTORE_1, -2);
		STACK_INCDEC.put(DSTORE_2, -2);
		STACK_INCDEC.put(DSTORE_3, -2);
		STACK_INCDEC.put(DSUB, -2);
		STACK_INCDEC.put(DUP, 1);
		STACK_INCDEC.put(DUP2, 2);
		STACK_INCDEC.put(DUP2_X1, 2);
		STACK_INCDEC.put(DUP2_X2, 2);
		STACK_INCDEC.put(DUP_X1, 1);
		STACK_INCDEC.put(DUP_X2, 1);
		STACK_INCDEC.put(F2D, 1);
		STACK_INCDEC.put(F2I, 0);
		STACK_INCDEC.put(F2L, 1);
		STACK_INCDEC.put(FADD, -1);
		STACK_INCDEC.put(FALOAD, -1);
		STACK_INCDEC.put(FASTORE, -3);
		STACK_INCDEC.put(FCMPG, -1);
		STACK_INCDEC.put(FCMPL, -1);
		STACK_INCDEC.put(FCONST_0, 1);
		STACK_INCDEC.put(FCONST_1, 1);
		STACK_INCDEC.put(FCONST_2, 1);
		STACK_INCDEC.put(FDIV, -1);
		STACK_INCDEC.put(FLOAD, 1);
		STACK_INCDEC.put(FLOAD_0, 1);
		STACK_INCDEC.put(FLOAD_1, 1);
		STACK_INCDEC.put(FLOAD_2, 1);
		STACK_INCDEC.put(FLOAD_3, 1);
		STACK_INCDEC.put(FMUL, -1);
		STACK_INCDEC.put(FNEG, 0);
		STACK_INCDEC.put(FREM, -1);
		STACK_INCDEC.put(FRETURN, 0);
		STACK_INCDEC.put(FSTORE, -1);
		STACK_INCDEC.put(FSTORE_0, -1);
		STACK_INCDEC.put(FSTORE_1, -1);
		STACK_INCDEC.put(FSTORE_2, -1);
		STACK_INCDEC.put(FSTORE_3, -1);
		STACK_INCDEC.put(FSUB, -1);
		STACK_INCDEC.put(GETFIELD, 0);	// 取得するフィールドがlong, doubleの場合はさらに+1?
		STACK_INCDEC.put(GETSTATIC, 1);	// 取得するフィールドがlong, doubleの場合はさらに+1?
		STACK_INCDEC.put(GOTO, 0);
		STACK_INCDEC.put(GOTO_W, 0);
		STACK_INCDEC.put(I2B, 0);
		STACK_INCDEC.put(I2C, 0);
		STACK_INCDEC.put(I2D, 1);
		STACK_INCDEC.put(I2F, 0);
		STACK_INCDEC.put(I2L, 1);
		STACK_INCDEC.put(I2S, 0);
		STACK_INCDEC.put(IADD, -1);
		STACK_INCDEC.put(IALOAD, -1);
		STACK_INCDEC.put(IAND, -1);
		STACK_INCDEC.put(IASTORE, -3);
		STACK_INCDEC.put(ICONST_0, 1);
		STACK_INCDEC.put(ICONST_1, 1);
		STACK_INCDEC.put(ICONST_2, 1);
		STACK_INCDEC.put(ICONST_3, 1);
		STACK_INCDEC.put(ICONST_4, 1);
		STACK_INCDEC.put(ICONST_5, 1);
		STACK_INCDEC.put(ICONST_M1, 1);
		STACK_INCDEC.put(IDIV, -1);
		STACK_INCDEC.put(IFEQ, -1);
		STACK_INCDEC.put(IFGE, -1);
		STACK_INCDEC.put(IFGT, -1);
		STACK_INCDEC.put(IFLE, -1);
		STACK_INCDEC.put(IFLT, -1);
		STACK_INCDEC.put(IFNE, -1);
		STACK_INCDEC.put(IFNONNULL, -1);
		STACK_INCDEC.put(IFNULL, -1);
		STACK_INCDEC.put(IF_ACMPEQ, -2);
		STACK_INCDEC.put(IF_ACMPNE, -2);
		STACK_INCDEC.put(IF_ICMPEQ, -2);
		STACK_INCDEC.put(IF_ICMPGE, -2);
		STACK_INCDEC.put(IF_ICMPGT, -2);
		STACK_INCDEC.put(IF_ICMPLE, -2);
		STACK_INCDEC.put(IF_ICMPLT, -2);
		STACK_INCDEC.put(IF_ICMPNE, -2);
		STACK_INCDEC.put(IINC, 0);
		STACK_INCDEC.put(ILOAD, 1);
		STACK_INCDEC.put(ILOAD_0, 1);
		STACK_INCDEC.put(ILOAD_1, 1);
		STACK_INCDEC.put(ILOAD_2, 1);
		STACK_INCDEC.put(ILOAD_3, 1);
		STACK_INCDEC.put(IMPDEP1, 0);	// no def
		STACK_INCDEC.put(IMPDEP2, 0);	// no def
		STACK_INCDEC.put(IMUL, -1);
		STACK_INCDEC.put(INEG, 0);
		STACK_INCDEC.put(INSTANCEOF, 0);
		STACK_INCDEC.put(INVOKEDYNAMIC, -1);	// no def 引数の数をさらに減少?
		STACK_INCDEC.put(INVOKEINTERFACE, -1);	// 引数の数をさらに減少
		STACK_INCDEC.put(INVOKESPECIAL, -1);	// 引数の数をさらに減少
		STACK_INCDEC.put(INVOKESTATIC, 0);	// 引数の数をさらに減少
		STACK_INCDEC.put(INVOKEVIRTUAL, -1);	// 引数の数をさらに減少
		STACK_INCDEC.put(IOR, -1);
		STACK_INCDEC.put(IREM, -1);
		STACK_INCDEC.put(IRETURN, 0);
		STACK_INCDEC.put(ISHL, -1);
		STACK_INCDEC.put(ISHR, -1);
		STACK_INCDEC.put(ISTORE, -1);
		STACK_INCDEC.put(ISTORE_0, -1);
		STACK_INCDEC.put(ISTORE_1, -1);
		STACK_INCDEC.put(ISTORE_2, -1);
		STACK_INCDEC.put(ISTORE_3, -1);
		STACK_INCDEC.put(ISUB, -1);
		STACK_INCDEC.put(IUSHR, -1);
		STACK_INCDEC.put(IXOR, -1);
		STACK_INCDEC.put(JSR, 1);
		STACK_INCDEC.put(JSR_W, 1);
		STACK_INCDEC.put(L2D, 0);
		STACK_INCDEC.put(L2F, -1);
		STACK_INCDEC.put(L2I, -1);
		STACK_INCDEC.put(LADD, -2);
		STACK_INCDEC.put(LALOAD, 0);
		STACK_INCDEC.put(LAND, -2);
		STACK_INCDEC.put(LASTORE, -4);
		STACK_INCDEC.put(LCMP, -3);
		STACK_INCDEC.put(LCONST_0, 2);
		STACK_INCDEC.put(LCONST_1, 2);
		STACK_INCDEC.put(LDC, 1);
		STACK_INCDEC.put(LDC2_W, 2);
		STACK_INCDEC.put(LDC_W, 1);
		STACK_INCDEC.put(LDIV, -2);
		STACK_INCDEC.put(LLOAD, 2);
		STACK_INCDEC.put(LLOAD_0, 2);
		STACK_INCDEC.put(LLOAD_1, 2);
		STACK_INCDEC.put(LLOAD_2, 2);
		STACK_INCDEC.put(LLOAD_3, 2);
		STACK_INCDEC.put(LMUL, -2);
		STACK_INCDEC.put(LNEG, 0);
		STACK_INCDEC.put(LOOKUPSWITCH, -2);
		STACK_INCDEC.put(LOR, -2);
		STACK_INCDEC.put(LREM, -2);
		STACK_INCDEC.put(LRETURN, 0);
		STACK_INCDEC.put(LSHL, -2);
		STACK_INCDEC.put(LSHR, -2);
		STACK_INCDEC.put(LSTORE, -2);
		STACK_INCDEC.put(LSTORE_0, -2);
		STACK_INCDEC.put(LSTORE_1, -2);
		STACK_INCDEC.put(LSTORE_2, -2);
		STACK_INCDEC.put(LSTORE_3, -2);
		STACK_INCDEC.put(LSUB, -2);
		STACK_INCDEC.put(LUSHR, -2);
		STACK_INCDEC.put(LXOR, -2);
		STACK_INCDEC.put(MONITORENTER, -1);
		STACK_INCDEC.put(MONITOREXIT, -1);
		STACK_INCDEC.put(MULTIANEWARRAY, 1);	// 配列の次元数分をさらに減少
		STACK_INCDEC.put(NEW, 1);
		STACK_INCDEC.put(NEWARRAY, 0);
		STACK_INCDEC.put(NOP, 0);
		STACK_INCDEC.put(POP, -1);
		STACK_INCDEC.put(POP2, -2);
		STACK_INCDEC.put(PUTFIELD, -2);	// 設定するフィールドがlong, doubleの場合はさらに-1?
		STACK_INCDEC.put(PUTSTATIC, -1);	// 設定するフィールドがlong, doubleの場合はさらに-1?
		STACK_INCDEC.put(RET, 0);
		STACK_INCDEC.put(RETURN, 0);
		STACK_INCDEC.put(SALOAD, -1);
		STACK_INCDEC.put(SASTORE, -3);
		STACK_INCDEC.put(SIPUSH, 1);
		STACK_INCDEC.put(SWAP, 0);
		STACK_INCDEC.put(TABLESWITCH, -1);
		STACK_INCDEC.put(WIDE, 0);
	}

	public final static int	ACC_PUBLIC = 0x0001;		// C F M IC
	public final static int	ACC_PRIVATE = 0x0002;		//   F M IC
	public final static int	ACC_PROTECTED = 0x0004;		//   F M IC
	public final static int	ACC_STATIC = 0x0008;		//   F M IC
	public final static int	ACC_FINAL = 0x0010;			// C F M IC
	public final static int	ACC_SUPER = 0x0020;			// C
	public final static int	ACC_SYNCHRONIZED = 0x0020;	//     M
	public final static int	ACC_VOLATILE = 0x0040;		//   F
	public final static int	ACC_TRANSIENT = 0x0080;		//   F
	public final static int	ACC_NATIVE = 0x0100;		//     M
	public final static int	ACC_INTERFACE = 0x0200;		// C     IC
	public final static int	ACC_ABSTRACT = 0x0400;		// C   M IC
	public final static int	ACC_STRICT = 0x0800;		//     M

}
