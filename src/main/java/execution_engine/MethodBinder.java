package execution_engine;

import java.util.HashMap;
import java.util.List;

public class MethodBinder {

	private ClassSpace classSpace;
	private HashMap<Integer, Integer> methodRegister;

	public MethodBinder(ClassSpace classSpace, HashMap<Integer, Integer> methodRegister) {

		this.classSpace = classSpace;
		this.methodRegister = methodRegister;
	}

	public void bindMethods(int[] instructions) {

		List<Integer> classIdRegister = classSpace.getClassIdList();

		for (int classId : classIdRegister) {

			List<List<Integer>> classMethods = classSpace.getClass(classId).getClassMethodAddresses();

			for (List<Integer> classMethod : classMethods) {

				int methodId = instructions[classMethod.get(0) + 1];
				int methodAddress = classMethod.get(0);

				methodRegister.put(methodId, methodAddress);
			}
		}

	}

}
