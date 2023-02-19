package execution_engine;

import java.io.IOException;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		outer : while (true) {

			logMessage(ConsoleUtils.DEFAULT_STATIC_MESSAGE);

			String input = scanner.nextLine();

			if (input.equals(ConsoleUtils.EXIT)) {

				break;
			}

			switch (input) {

				case ConsoleUtils.TEST -> {
	
					run(ConstantsTable.DEFAULT_TEST_FILE_NAME);
					break outer;
				}
	
				default -> {
	
					run(input);
				}

			}

		}

		scanner.close();
	}

	public static void run(String fileName) throws IOException {

		MemoryManager memoryManager = new MemoryManager(fileName);
		ChainedVM chainedVM = new ChainedVM(memoryManager);
		chainedVM.executeProgram();

		ChainedVM.logger.exportLog(ConstantsTable.DEFAULT_LOG_FILE_NAME);
	}
	
	public static void runDefaultTest() throws IOException {
		
		run(ConstantsTable.DEFAULT_TEST_FILE_NAME);
	}	
	
	private static void logMessage(String message) {

		System.out.print(message);
	}
}
