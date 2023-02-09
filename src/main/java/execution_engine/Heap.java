package execution_engine;

import java.util.HashMap;

public class Heap implements ObjectCache{
	
	private HashMap<Integer, int[]> storage;
	
	public Heap(HashMap<Integer, int[]> storage) {
		
		this.storage = storage;
	}
	
	@Override
	public void store(int[] object) {
		
		int objectId = object[0];
		storage.put(objectId, object);
	}

	@Override
	public int[] fetch(int objectId) {
		
		return storage.get(objectId);
	}

}
