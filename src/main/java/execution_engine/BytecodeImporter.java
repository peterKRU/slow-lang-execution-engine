package execution_engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class BytecodeImporter implements FileImporter {

	private int[] importBytecode(String fileName) throws IOException {

		String hexBytes = readHexFromFile(fileName);

		return convertHexToInt(hexBytes);
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

	public static int[] convertHexToInt(String hexString) {

		hexString = hexString.replace("\n", "").replace(" ", "");

		byte[] byteArray = new byte[hexString.length() / 2];

		for (int i = 0; i < byteArray.length; i++) {
			int index = i * 2;
			byteArray[i] = (byte) ((Character.digit(hexString.charAt(index), 16) << 4)
					+ Character.digit(hexString.charAt(index + 1), 16));
		}

		return convertByteToInt(byteArray);
	}

	public static int[] convertByteToInt(byte[] byteArray) {

		ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);

		int[] intArray = new int[byteArray.length / 4];

		for (int i = 0; i < intArray.length; i++) {

			intArray[i] = byteBuffer.getInt();
		}

		return intArray;
	}

}
