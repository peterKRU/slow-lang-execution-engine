package execution_engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgramLoader {

	private BytecodeVerifier bytecodeVerifier;
	private Heap heap;
	private ClassSpace classSpace;
	private int[] mainExecutionBlock;
	private int[] instructions;
	private HashMap<Integer, Integer> methodRegister;

	private FileImporter fileImporter;

	public ProgramLoader(BytecodeVerifier bytecodeVerifier, Heap heap, ClassSpace classSpace, int[] mainExecutionBlock, int[] instructions,
			HashMap<Integer, Integer> methodRegister) {

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
		
		if(!bytecodeVerifier.verifyBytecode(instructions)) {
			
			throw new RuntimeException("Invalid bytecode");
		}
		
		loadMainExecutionBlock(mainExecutionBlock, instructions);
		bindMethods(methodRegister, mainExecutionBlock, instructions);
		
		loadClasses(classSpace);
		loadObjects(heap);
	}

	private int[] loadProgramBytes(String fileName) throws IOException {

		return fileImporter.importFile(fileName);
	}

	private void loadObjects(Heap heap) {

	}

	private void loadClasses(ClassSpace classSpace) {

	}

	private void loadMainExecutionBlock(int[] mainExecutionBlock, int[] instructions) {

		List<Integer> mainExecutionBlockList = new ArrayList<Integer>();

		for (int i = 0; i < instructions.length; i++) {

			int instruction = instructions[i];

			if (instruction == Bytecodes.HALT) {

				mainExecutionBlockList.add(instruction);
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

}
