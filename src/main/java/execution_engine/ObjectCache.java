package execution_engine;

public interface ObjectCache {

	public void store(int[] object);
	public int[] fetch(int objectId);		
}
