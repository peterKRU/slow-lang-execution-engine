package execution_engine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class ProgramLoader {

	private BytecodeVerifier bytecodeVerifier;
	private FileImporter fileImporter;
	private SlowLangClassLoader classLoader;
	private MethodBinder methodBinder;

	private int[] instructions;

	private ClassSpace classSpace;
	private HashMap<Integer, Integer> methodRegister;

	private static String programName;
	private static boolean decompilerEnabled = false;

	public ProgramLoader() {

		bytecodeVerifier = new BytecodeVerifier();
		fileImporter = new BytecodeImporter();

		instructions = new int[0];
		classSpace = new ClassSpace();
		methodRegister = new HashMap<Integer, Integer>();

		classLoader = new SlowLangClassLoader(classSpace);
		methodBinder = new MethodBinder(classSpace, methodRegister);
	}

	public void loadProgram(byte[] programBytes, String programName) {

		instructions = InputConverter.convertBytesToInstructions(programBytes);
		ProgramLoader.programName = programName;

		if (decompilerEnabled) {

			Decompiler.decompile(instructions);
		}

		int expectedProgramId = Objects.hashCode(programName);
		int actualProgramId = instructions[0] - Bytecodes.MAIN;

		if (!bytecodeVerifier.verifyProgramId(expectedProgramId, actualProgramId)) {

			throw new RuntimeException("Invalid bytecode");
		}

		classLoader.loadClasses(instructions);
		methodBinder.bindMethods(instructions);
	}

	public void loadProgram(int[] programInstructions, String programName) {

		instructions = programInstructions;
		ProgramLoader.programName = programName;

		if (decompilerEnabled) {

			Decompiler.decompile(instructions);
		}

		int expectedProgramId = Objects.hashCode(programName);
		int actualProgramId = instructions[0] - Bytecodes.MAIN;

		if (!bytecodeVerifier.verifyProgramId(expectedProgramId, actualProgramId)) {

			throw new RuntimeException("Invalid bytecode");
		}

		classLoader.loadClasses(instructions);
		methodBinder.bindMethods(instructions);
	}

	public void loadProgramFromFile(String fileName) throws IOException {

		instructions = loadProgramBytes(fileName);
		programName = stripFileExtensions(fileName);

		if (decompilerEnabled) {

			Decompiler.decompile(instructions);
		}

		int expectedProgramId = Objects.hashCode(programName);
		int actualProgramId = instructions[0] - Bytecodes.MAIN;

		if (!bytecodeVerifier.verifyProgramId(expectedProgramId, actualProgramId)) {

			throw new RuntimeException("Invalid bytecode");
		}

		classLoader.loadClasses(instructions);
		methodBinder.bindMethods(instructions);
	}

	private int[] loadProgramBytes(String fileName) throws IOException {

		return fileImporter.importFile(fileName);
	}

	private static String stripFileExtensions(String fileName) {

		if (fileName.endsWith("compiled.txt")) {

			return fileName.substring(0, fileName.length() - "_compiled.txt".length());
		}

		return fileName;
	}

	public int[] getInstructions() {

		return instructions;
	}

	public ClassSpace getClassSpace() {

		return classSpace;
	}

	public HashMap<Integer, Integer> getMethodRegister() {

		return methodRegister;
	}

	public static void enableDecompiler() {

		decompilerEnabled = true;
	}
}
