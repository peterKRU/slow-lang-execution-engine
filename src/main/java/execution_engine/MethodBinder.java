package execution_engine;

import java.util.HashMap;
import java.util.List;

public class MethodBinder {

	private int[] instructions;
	private ClassSpace classSpace;
	private HashMap<Integer, Integer> methodRegister;

	public MethodBinder(int[] instructions, ClassSpace classSpace, HashMap<Integer, Integer> methodRegister) {

		this.instructions = instructions;
		this.classSpace = classSpace;
		this.methodRegister = methodRegister;
	}

	public void bindMethods() {

		List<Integer> classIdRegister = classSpace.getClassIds();

		for (int classId : classIdRegister) {

			List<List<Integer>> classMethods = classSpace.getClass(classId).getClassMethodAddresses();

			for (List<Integer> classMethod : classMethods) {

				int methodId = instructions[classMethod.get(0)];
				int methodAddress = classMethod.get(0);
				methodRegister.put(methodId, methodAddress);
			}
		}
	}

}
