package execution_engine;

import java.util.List;

public class SlowLangClass {
	
	private int classId;
	private List<List<Integer>> classMethods;
	
	public SlowLangClass(int classId, List<List<Integer>> classMethods) {
		
		this.classId = classId;
		this.classMethods = classMethods;
	}
	
	public int getClassId() {
		return classId;
	}
	
	public List<List<Integer>> getClassMethods() {
		return classMethods;
	}
	
}
