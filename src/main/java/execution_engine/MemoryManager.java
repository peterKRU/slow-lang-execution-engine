package execution_engine;

public class MemoryManager implements InstructionsLoader, HeapCache {

	private static MemoryManager memoryManagerInstance;
//	private MainBlock mainBlock;
//	private ClassSpace classSpace;
//	private Heap heap;
//	private GarbageCollector garbageCollector;
	
	private MemoryManager() {
		
		
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

		return null;
	}

	@Override
	public void store(int[] object) {

	}

	@Override
	public int[] fetch(int objectId) {

		return null;
	}
}
