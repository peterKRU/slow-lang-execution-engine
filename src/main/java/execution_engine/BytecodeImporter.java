package execution_engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BytecodeImporter implements FileImporter {

	private int[] importBytecode(String fileName) throws IOException {

		String hexBytes = readHexFromFile(fileName);

		return InputConverter.convertBytesToInstructions(hexBytes);
	}

	private static String readHexFromFile(String filePath) throws FileNotFoundException {

		File file = new File(filePath);
		Scanner scanner = new Scanner(file);
		StringBuilder builder = new StringBuilder();

		while (scanner.hasNextLine()) {

			String line = scanner.nextLine();
			String[] hexBytes = line.split(" ");

			for (String hexByte : hexBytes) {

				builder.append(hexByte);
			}

			builder.append("\n");
		}

		scanner.close();

		return builder.toString();
	}

	@Override
	public int[] importFile(String fileName) throws IOException {

		return importBytecode(fileName);
	}

}
