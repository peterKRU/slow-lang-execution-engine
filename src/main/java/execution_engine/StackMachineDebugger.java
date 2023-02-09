package execution_engine;

import java.util.Map;

public class StackMachineDebugger {

	public static void logVariablesTable(Map<Integer, Integer> variablesTable) {
		
		for (Map.Entry<Integer, Integer> entry : variablesTable.entrySet()) {
			
			System.out.println("ID : " + entry.getKey() + " VALUE : " + entry.getValue());
		}
	}
}
