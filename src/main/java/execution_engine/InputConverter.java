package execution_engine;

import java.nio.ByteBuffer;

public class InputConverter {

	public static int[] convertBytesToInstructions(String hexadecimalBytes) {

		hexadecimalBytes = hexadecimalBytes.replace("\n", "").replace(" ", "");

		byte[] byteArray = new byte[hexadecimalBytes.length() / 2];

		for (int i = 0; i < byteArray.length; i++) {
			int index = i * 2;
			byteArray[i] = (byte) ((Character.digit(hexadecimalBytes.charAt(index), 16) << 4)
					+ Character.digit(hexadecimalBytes.charAt(index + 1), 16));
		}

		return convertBytesToInstructions(byteArray);
	}

	public static int[] convertBytesToInstructions(byte[] bytes) {

		ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

		int[] intArray = new int[bytes.length / 4];

		for (int i = 0; i < intArray.length; i++) {

			intArray[i] = byteBuffer.getInt();
		}

		return intArray;
	}

}
