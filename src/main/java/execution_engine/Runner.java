package execution_engine;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		int[] compiledCode = BytecodeImporter.importBytecode("test_compiled.txt");
		int[] testCode = {88, 120, 80, 1, 80, 10, 102, 5555, 85, 89, 120, 100, 101, 2, 2000, 3000, 88, 1000, 89, 2000, 89, 3000, 21, 85, 89, 1000, 103 };
		
		System.out.println(testCode.length);
		
		ChainedVM chainedVM = new ChainedVM(testCode, 0);
		chainedVM.executeProgram();
		
		ChainedVM.logger.exportLog("log.txt");
	}

}
