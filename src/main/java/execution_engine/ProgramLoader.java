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

	@SuppressWarnings("unused")
	private ClassSpace classSpace;
	@SuppressWarnings("unused")
	private HashMap<Integer, Integer> methodRegister;

	private static String programName;

	public ProgramLoader(ClassSpace classSpace, int[] instructions, HashMap<Integer, Integer> methodRegister) {

		bytecodeVerifier = new BytecodeVerifier();
		fileImporter = new BytecodeImporter();

		this.instructions = instructions;
		this.classSpace = classSpace;
		this.methodRegister = methodRegister;

		classLoader = new SlowLangClassLoader(classSpace);
		methodBinder = new MethodBinder(instructions, classSpace, methodRegister);
	}

	public void loadProgram(String fileName) throws IOException {

		instructions = loadProgramBytes(fileName);
		programName = stripFileExtensions(fileName);

		Decompiler.decompile(instructions);

		int expectedProgramId = Objects.hashCode(programName);
		int actualProgramId = instructions[0] - Bytecodes.MAIN;

		if (!bytecodeVerifier.verifyProgramId(expectedProgramId, actualProgramId)) {

			throw new RuntimeException("Invalid bytecode");
		}

		classLoader.loadClasses(instructions);
		methodBinder.bindMethods();
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

}
