package execution_engine;

public class Decompiler {

	public static void decompile(int[] instructions) {

		int programId = instructions[0];
		System.out.println(0 + ": " + "PROG_ID " + programId);

		for (int i = 1; i < instructions.length; i++) {

			int instruction = instructions[i];

			if (instruction == Bytecodes.IADD) {

				System.out.println(i + ": " + "IADD");

			} else if (instruction == Bytecodes.ISUB) {

				System.out.println(i + ": " + "ISUB");

			} else if (instruction == Bytecodes.ICONST) {

				System.out.println(i + ": " + "ICONST " + instructions[++i]);

			} else if (instruction == Bytecodes.VSTORE) {

				System.out.println(i + ": " + "VSTORE " + instructions[++i]);

			} else if (instruction == Bytecodes.VLOAD) {

				System.out.println(i + ": " + "VLOAD " + instructions[++i]);

			} else if (instruction == Bytecodes.ASS) {

				System.out.println(i + ": " + "ASS");

			} else if (instruction == Bytecodes.CALL) {

				System.out.println(i + ": " + "CALL " + instructions[++i]);

			} else if (instruction == Bytecodes.CDECL) {

				System.out.println(i + ": " + "CDECL " + instructions[++i]);

			} else if (instruction == Bytecodes.PRINT) {

				System.out.println(i + ": " + "PRINT");

			} else if (instruction == Bytecodes.MDECL) {

				System.out.println(i + ": " + "MDECL " + instructions[++i]);

			} else if (instruction == Bytecodes.RET) {

				System.out.println(i + ": " + "RET");
			}

			else {

				System.out.println(i + ": " + "UNKNOWN TOKEN: " + instruction);
			}

		}
	}
}
