package execution_engine;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Runner {

	private static boolean useTestInput = false;

	public static void main(String[] args) throws IOException {

		if (useTestInput) {

			runDefaultTest();

		} else {

			Scanner scanner = new Scanner(System.in);

			while (true) {

				System.out.print(":");

				String input = scanner.nextLine();

				if (input.equals("exit")) {

					break;
				}

				if (input.equals("test")) {

					runDefaultTest();

					break;
				}

				File file = new File(input);

				if (file.exists()) {

					MemoryManager memoryManager = new MemoryManager(input);
					ChainedVM chainedVM = new ChainedVM(memoryManager);
					chainedVM.executeProgram();

					ChainedVM.logger.exportLog("log.txt");
				}
			}

			scanner.close();
		}

	}

	public static void runDefaultTest() throws IOException {

		MemoryManager memoryManager = new MemoryManager(ConstantsTable.DEFAULT_TEST_FILE_NAME);
		ChainedVM chainedVM = new ChainedVM(memoryManager);
		chainedVM.executeProgram();

		ChainedVM.logger.exportLog("log.txt");
	}
	
	public static void runTestFile(String fileName) throws IOException {
		
		MemoryManager memoryManager = new MemoryManager(fileName);
		ChainedVM chainedVM = new ChainedVM(memoryManager);
		chainedVM.executeProgram();

		ChainedVM.logger.exportLog("log.txt");		
	}
	
	public static void enableTestRun() {

		useTestInput = true;
	}
}
