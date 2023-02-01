package execution_engine;

public interface HeapCache {
	
	public void store(int[] object);
	public int[] fetch(int objectId);
}
