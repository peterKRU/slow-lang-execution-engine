package execution_engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ProgramLoader {

	private BytecodeVerifier bytecodeVerifier;
	private Heap heap;
	private ClassSpace classSpace;
	private int[] mainExecutionBlock;
	private int[] instructions;
	private HashMap<Integer, Integer> methodRegister;

	private FileImporter fileImporter;
	private static String programName;

	public ProgramLoader(BytecodeVerifier bytecodeVerifier, Heap heap, ClassSpace classSpace, int[] mainExecutionBlock,
			int[] instructions, HashMap<Integer, Integer> methodRegister) {

		this.bytecodeVerifier = bytecodeVerifier;
		this.heap = heap;
		this.classSpace = classSpace;
		this.mainExecutionBlock = mainExecutionBlock;
		this.instructions = instructions;
		this.methodRegister = methodRegister;

		this.fileImporter = new BytecodeImporter();

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

		for (int i : instructions) {

			System.out.print(i + " ");
		}

		loadMainExecutionBlock(mainExecutionBlock, instructions);
		bindMethods(methodRegister, mainExecutionBlock, instructions);

		loadClasses(classSpace, instructions);
		loadObjects(heap);
	}

	private int[] loadProgramBytes(String fileName) throws IOException {

		return fileImporter.importFile(fileName);
	}

	private void loadObjects(Heap heap) {

	}

	private void loadClasses(ClassSpace classSpace, int[] instructions) {
		
		
		for(int i = 0; i < instructions.length; i++) {
			
			
		}
	}

	private void loadMainExecutionBlock(int[] mainExecutionBlock, int[] instructions) {

		List<Integer> mainExecutionBlockList = new ArrayList<Integer>();
		int mainExecutionBlockEndCode = Objects.hashCode(programName) - Bytecodes.HALT;
		
		for (int i = 1; i < instructions.length; i++) {

			int instruction = instructions[i];

			if (instruction == mainExecutionBlockEndCode) {

				break;
			}

			mainExecutionBlockList.add(instruction);
		}

		mainExecutionBlock = mainExecutionBlockList.stream().mapToInt(i -> i).toArray();
	}
	
	private void bindMethods(HashMap<Integer, Integer> methodRegister, int[] mainExecutionBlock, int[] instructions) {

		for (int i = 0; i < mainExecutionBlock.length; i++) {

			int instruction = mainExecutionBlock[i];

			if (instruction == Bytecodes.CALL) {

				int methodId = mainExecutionBlock[i + 1];
				methodRegister.put(methodId, -1);
			}
		}

		for (int i = mainExecutionBlock.length; i < instructions.length; i++) {

			int instruction = instructions[i];

			if (methodRegister.containsKey(instruction)) {

				if (methodRegister.get(instruction) == -1) {

					methodRegister.put(instruction, i + 1);
				}
			}
		}
	}

	private static String getProgramName() {

		return programName;
	}

	private static String stripFileExtensions(String fileName) {

		if (fileName.endsWith("compiled.txt")) {

			return fileName.substring(0, fileName.length() - "_compiled.txt".length());
		}

		return fileName;
	}
	
}
