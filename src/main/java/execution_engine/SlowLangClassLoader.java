package execution_engine;

import java.util.ArrayList;
import java.util.List;

public class SlowLangClassLoader {

	private ClassSpace classSpace;

	public SlowLangClassLoader(ClassSpace classSpace) {

		this.classSpace = classSpace;
	}

	public void loadClasses(int[] instructions) {

		List<List<Integer>> classAddressList = parseClasses(instructions);
		loadClassMetadata(instructions, classAddressList);
	}

	private List<List<Integer>> parseClasses(int[] instructions) {

		List<List<Integer>> classAddressList = new ArrayList<>();
		List<Integer> classDeclarations = new ArrayList<Integer>();

		for (int i = 0; i < instructions.length - 1; i++) {

			int currentInstruction = instructions[i];
			int nextInstruction = instructions[i + 1];

			if (currentInstruction == Bytecodes.CDECL && Math.abs(nextInstruction) > Byte.MAX_VALUE) {

				classDeclarations.add(i);
			}
		}

		if (classDeclarations.size() == 1) {

			classAddressList.add(List.of(classDeclarations.get(0), instructions.length - 1));
		} else {

			for (int i = 0; i < classDeclarations.size() - 1; i++) {

				classAddressList.add(List.of(classDeclarations.get(i), classDeclarations.get(i + 1) - 1));
			}
		}

		return classAddressList;
	}

	private List<List<Integer>> parseClassesTest(int[] instructions) {

		List<List<Integer>> classAddressList = new ArrayList<>();

		int classStartIndex = -1;

		for (int i = 0; i < instructions.length; i++) {

			int instruction = instructions[i];

			if (instruction == Bytecodes.CDECL) {

				if (classStartIndex != -1) {

					classAddressList.add(List.of(classStartIndex, i - 1));
				}

				classStartIndex = i;
			}
		}

		if (classStartIndex != -1) {

			classAddressList.add(List.of(classStartIndex, instructions.length - 1));
		}

		return classAddressList;
	}

	private void loadClassMetadataTest(int[] instructions, List<List<Integer>> classAddressList) {

		for (List<Integer> classAddress : classAddressList) {

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

					classAddressList.add(List.of(methodStartIndex, instructions.length - 1));
				}
			}

			classSpace.registerClass(new SlowLangClass(classId, methodAddresses));
		}

	}

	private void loadClassMetadata(int[] instructions, List<List<Integer>> classAddressList) {

		for (List<Integer> classAddress : classAddressList) {

			int classId = instructions[classAddress.get(0) + 1];
			List<List<Integer>> classMethodAddressList = loadMethodAddresses(classAddress, instructions);

			classSpace.registerClass(new SlowLangClass(classId, classMethodAddressList));
		}

	}

	private List<List<Integer>> loadMethodAddresses(List<Integer> classAddress, int[] instructions) {

		int classStartIndex = classAddress.get(0);
		int classEndIndex = classAddress.get(1);

		List<List<Integer>> methodAddressList = new ArrayList<>();
		List<Integer> methodDeclarations = new ArrayList<Integer>();

		for (int i = classStartIndex; i < classEndIndex; i++) {

			int currentInstruction = instructions[i];
			int nextInstruction = instructions[i + 1];

			if (currentInstruction == Bytecodes.MDECL && Math.abs(nextInstruction) > Byte.MAX_VALUE) {

				methodDeclarations.add(i);
			}
		}
		
		methodDeclarations.add(classEndIndex);
		
		for(int i = 0; i < methodDeclarations.size() - 1; i++) {
			
			int methodStartIndex = methodDeclarations.get(i); 
			int methodEndIndex = methodDeclarations.get(i + 1) - 1;
			methodAddressList.add(List.of(methodStartIndex, methodEndIndex));
		}

		return methodAddressList;
	}
}
