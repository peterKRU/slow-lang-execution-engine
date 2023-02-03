package execution_engine;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		String testProgramFileName = "test_compiled.txt";
		
		MemoryManager memoryManager = new MemoryManager(testProgramFileName);
		ChainedVM chainedVM = new ChainedVM(memoryManager);
		chainedVM.executeProgram();
		
		ChainedVM.logger.exportLog("log.txt");
	}

}
