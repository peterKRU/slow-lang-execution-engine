package execution_engine;

import java.util.HashMap;

public class MemoryManager implements InstructionsLoader, HeapCache {

	private BytecodeVerifier bytecodeVerifier;
	private Heap heap;
	private ClassSpace classSpace;
	private int[] mainExecutionBlock;
	private HashMap<Integer, Integer> methodRegister;
	
	private ProgramLoader programLoader;
	
	public MemoryManager(String fileName) {
		
		bytecodeVerifier = new BytecodeVerifier();
		heap = new Heap();
		classSpace = new ClassSpace();
		mainExecutionBlock = new int[0];
		methodRegister = new HashMap<Integer, Integer>();
		
		programLoader = new ProgramLoader(bytecodeVerifier, heap, classSpace, mainExecutionBlock, methodRegister);
		programLoader.loadProgram(fileName);
	}
	
	private void invokeGarbageCollection() {

	}

	@Override
	public int[] loadInstructions() {

		return mainExecutionBlock;
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
