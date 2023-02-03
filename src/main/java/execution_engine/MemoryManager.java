package execution_engine;

import java.util.HashMap;

public class MemoryManager implements InstructionsLoader, HeapCache {

	private static MemoryManager memoryManagerInstance;
	private int[] mainExecutionBlock;
	private SlowLangClassLoader classLoader;

	private HashMap<Integer, Integer> methodRegister;

	private MemoryManager(SlowLangClassLoader classLoader) {
		
	}

	public static MemoryManager getInstance() {

		if (memoryManagerInstance == null) {

			memoryManagerInstance = new MemoryManager();

			return memoryManagerInstance;
		} else {
			return memoryManagerInstance;
		}
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
