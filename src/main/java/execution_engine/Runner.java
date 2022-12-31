package execution_engine;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		int[] compiledCode = BytecodeImporter.importBytecode("compiledTest");
		System.out.println("running...");
		
		VM vm = new VM(compiledCode, 0, 0);
		vm.fde();
		
		System.out.println("PseudoHeap entries:");
		PseudoHeap.printHeap(VM.localVariablesMap);
	}

}
