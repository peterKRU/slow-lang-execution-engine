package execution_engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassSpace {
	
	private static Map<Integer, SlowLangClass> classRegister = new HashMap<Integer, SlowLangClass>();
	private static List<Integer> classIds = new ArrayList<Integer>();
	
	public void registerClass(SlowLangClass slowLangClass) {
		
		classIds.add(slowLangClass.getClassId());
		classRegister.put(slowLangClass.getClassId(), slowLangClass);
	}
	
	public SlowLangClass getClass(int classId) {
		
		return classRegister.get(classId);
	}
	
	public List<Integer> getClassIds() {
		
		return classIds;
	}
}
