package execution_engine;

import java.util.HashMap;

public class MemoryManager implements InstructionsLoader, HeapCache {

	private static MemoryManager memoryManagerInstance;
	private int[] mainExecutionBlock;
//	private ClassSpace classSpace;
//	private Heap heap;
//	private GarbageCollector garbageCollector;
	
	private HashMap<Integer, Integer> methodRegister;
	
	private MemoryManager() {
		
		this.mainExecutionBlock = SlowLangClassLoader.loadMainExecutionBlock();
		
		this.methodRegister = new HashMap<Integer, Integer>();
		SlowLangClassLoader.linkMethods(methodRegister);
		
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
		
		if(methodRegister.containsKey(methodId)) {
			
			return methodRegister.get(methodId);
		}
		else {
			
			System.err.println("Method not found.");
			
			return -1;
		}
		
	}
}
