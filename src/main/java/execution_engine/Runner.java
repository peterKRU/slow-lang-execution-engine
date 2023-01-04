package execution_engine;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Interpreter running...");
		System.out.println("Importing compiled files...");
		int[] compiledCode = BytecodeImporter.importBytecode("compiledTest");
		
		System.out.println("Running process...");
		ChainedVM chainedVM = new ChainedVM(compiledCode, 0);
		chainedVM.executeProgram();
		
		System.out.println("Preparing output...");
		
		String consoleOutput = "";
		
		for(int i : ChainedVM.localStorage) {
			
			if(i != 0) {
				consoleOutput = consoleOutput + i + " ";
			}
			
		}
		
		ConsoleOutputExporter outputExporter = new ConsoleOutputExporter();
		outputExporter.export(consoleOutput, "consoleOutput.txt");
		
		System.out.println("Output saved in file \"consoleOutput.txt\".");
	}

}
