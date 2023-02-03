package execution_engine;

import java.io.IOException;
import java.util.HashMap;

public class MemoryManager implements InstructionsLoader, HeapCache {

	private BytecodeVerifier bytecodeVerifier;
	private Heap heap;
	private ClassSpace classSpace;
	private int[] mainExecutionBlock;
	private int[] instructions;
	private HashMap<Integer, Integer> methodRegister;

	private ProgramLoader programLoader;

	public MemoryManager(String fileName) throws IOException {

		bytecodeVerifier = new BytecodeVerifier();
		heap = new Heap();
		classSpace = new ClassSpace();
		mainExecutionBlock = new int[0];
		methodRegister = new HashMap<Integer, Integer>();

		programLoader = new ProgramLoader(bytecodeVerifier, heap, classSpace, mainExecutionBlock, instructions,
				methodRegister);
		programLoader.loadProgram(fileName);
	}

	@SuppressWarnings("unused")
	private void invokeGarbageCollection(Heap heap) {
		
	}

	@Override
	public int[] loadInstructions() {

		return instructions;
	}

	@Override
	public void store(int[] object) {

	}

	@Override
	public int[] fetch(int objectId) {

		return null;
	}

	public int fetchMethodAddress(int methodId) {

		if (methodRegister.containsKey(methodId)) {

			return methodRegister.get(methodId);

		} else {

			System.err.println("Method not found.");

			return -1;
		}

	}
}
