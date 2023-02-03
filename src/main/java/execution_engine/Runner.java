package execution_engine;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		int[] compiledCode = BytecodeImporter.importBytecode("test_compiled.txt");		
		String testProgram = "test_compiled.txt";
		
		MemoryManager memoryManager = new MemoryManager(testProgram);
		ChainedVM chainedVM = new ChainedVM(memoryManager, compiledCode, 0);
		chainedVM.executeProgram();
		
		ChainedVM.logger.exportLog("log.txt");
	}

}
