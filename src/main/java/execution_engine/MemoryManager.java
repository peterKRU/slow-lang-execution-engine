package execution_engine;

import java.io.IOException;
import java.util.HashMap;

public class MemoryManager implements InstructionsLoader, ObjectCache {

	private int[] instructions;

	@SuppressWarnings("unused")
	private ClassSpace classSpace;

	private HashMap<Integer, Integer> methodRegister;
	private Heap heap;

	private ProgramLoader programLoader;

	public MemoryManager(String fileName) throws IOException {

		heap = new Heap(new HashMap<Integer, int[]>());

		programLoader = new ProgramLoader();
		programLoader.loadProgram(fileName);

		instructions = programLoader.getInstructions();
		classSpace = programLoader.getClassSpace();
		methodRegister = programLoader.getMethodRegister();

		heap = new Heap(new HashMap<Integer, int[]>());
	}

	@SuppressWarnings("unused")
	private void invokeGarbageCollection(Heap heap) {

	}

	@Override
	public int[] loadInstructions() {

		return instructions;
	}

	public int fetchMethodAddress(int methodId) {

		if (methodRegister.containsKey(methodId)) {

			return methodRegister.get(methodId);

		} else {

			System.err.println("Method not found.");

			return -1;
		}

	}

	@Override
	public void store(int[] object) {

		heap.store(object);
	}

	@Override
	public int[] fetch(int objectId) {

		return heap.fetch(objectId);
	}

}
