package execution_engine;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		int[] compiledCode = BytecodeImporter.importBytecode("compiledTest");
		System.out.println("running...");
		
		ChainedVM chainedVM = new ChainedVM(compiledCode, 0);
		chainedVM.executeProgram();
	}

}
