package execution_engine;

import java.util.ArrayList;
import java.util.List;

public class SlowLangClass {

	private int classId;
	private List<List<Integer>> methodAddresses;

	public SlowLangClass(int classId, List<List<Integer>> methodAddresses) {

		this.classId = classId;
		this.methodAddresses = methodAddresses;
	}

	public SlowLangClass(int classId) {

		this.classId = classId;
		this.methodAddresses = new ArrayList<List<Integer>>();
	}

	public int getClassId() {

		return classId;
	}

	public List<List<Integer>> getClassMethodAddresses() {

		return methodAddresses;
	}

	public void addClassMethod(List<Integer> classMethodAddress) {

		methodAddresses.add(classMethodAddress);
	}

}
