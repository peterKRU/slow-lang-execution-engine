package execution_engine;

import java.util.ArrayList;
import java.util.List;

public class SlowLangClassLoader {

	private ClassSpace classSpace;

	public SlowLangClassLoader(ClassSpace classSpace) {

		this.classSpace = classSpace;
	}

	public void loadClasses(int[] instructions) {

		List<List<Integer>> classAddresses = parseClasses(instructions);
		loadClassMetadata(instructions, classAddresses);
	}

	private List<List<Integer>> parseClasses(int[] instructions) {

		List<List<Integer>> classAddresses = new ArrayList<>();

		int classStartIndex = -1;

		for (int i = 0; i < instructions.length; i++) {

			int instruction = instructions[i];

			if (instruction == Bytecodes.CDECL) {

				if (classStartIndex != -1) {

					classAddresses.add(List.of(classStartIndex, i - 1));
				}

				classStartIndex = i;
			}
		}

		if (classStartIndex != -1) {

			classAddresses.add(List.of(classStartIndex, instructions.length - 1));
		}

		return classAddresses;
	}

	private void loadClassMetadata(int[] instructions, List<List<Integer>> classAddresses) {

		int classStartIndex = -1;

		for (List<Integer> classAddress : classAddresses) {

			int startIndex = classAddress.get(0);
			int endIndex = classAddress.get(1);

			int classId = instructions[startIndex + 1];
			List<List<Integer>> methodAddresses = new ArrayList<List<Integer>>();
			int methodStartIndex = startIndex - 1;

			for (int i = startIndex; i < endIndex; i++) {

				int instruction = instructions[i];

				if (instruction == Bytecodes.MDECL) {

					if (methodStartIndex != startIndex - 1) {

						methodAddresses.add(List.of(methodStartIndex, i - 1));
					}

					methodStartIndex = i;
				}

				if (methodStartIndex != startIndex - 1) {

					classAddresses.add(List.of(classStartIndex, instructions.length - 1));
				}
			}

			classSpace.registerClass(new SlowLangClass(classId, methodAddresses));
		}

	}

}
