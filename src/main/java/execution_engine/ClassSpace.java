package execution_engine;

import java.util.Map;

public class ClassSpace {
	
	private Map<Integer, SlowLangClass> classRegister;
	
	public void loadClass(SlowLangClass slowLangClass) {
		
		classRegister.put(slowLangClass.getClassId(), slowLangClass);
	}
}
