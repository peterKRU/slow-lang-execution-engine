package execution_engine;

import java.util.HashMap;
import java.util.Map;

public class MockupMetaSpace {
	
	public static Map<Integer, Integer> functionDictionary = new HashMap<Integer, Integer>();
	
	static {
		
		Integer funcId = 5555;
		Integer funcAddress = 14;
		functionDictionary.put(funcId, funcAddress);
		System.out.println(functionDictionary.size());		
	}
	
	public static Integer getFunction(Integer address) {
		
		System.out.println("elele");
		
		System.out.println(functionDictionary.get(address) + "test");
		
		if(functionDictionary.containsKey(address)) {
			
			return functionDictionary.get(address);
		}
		else {
			System.out.println("No such function");
			
			return 0;
		}
	}
	
	public Map<Integer, Integer> getFunctionMap(){
		
		return functionDictionary;
	}
}
