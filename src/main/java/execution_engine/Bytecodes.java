package execution_engine;

public class Bytecodes {
	
	public static final int IADD = 20;
	public static final int ISUB = 21;
	public static final int IMUL = 22;
	public static final int IDIV = 23;
	
	public static final int OR = 30;
	public static final int AND = 31;
	public static final int NOT = 32;	
	
	public static final int IEQ = 40;
	public static final int ILT = 41;
	public static final int IGT = 42;
	
	public static final int BR = 60;
	public static final int BRT = 61;
	public static final int BRF = 62;
	
	public static final int ICONST = 80;
	public static final int LLOAD = 81;
	public static final int GLOAD = 82;
	public static final int LSTORE = 83;
	public static final int GSTORE = 84;
	public static final int ASS = 85;
	public static final int LREF = 86;
	public static final int GREF = 87;
	public static final int VSTORE = 88;
	public static final int VLOAD = 89;
	
	public static final int PRINT = 100;
	public static final int HALT = 101;
	public static final int CALL = 102;
	public static final int RET = 103;
	
	public static final int MAIN = 120;
	public static final int CDECL = 121;
	public static final int MDECL = 122;
	public static final int IDECL = 123;
	public static final int IGDECL = 124;
	public static final int FDECL = 125;
	
}
