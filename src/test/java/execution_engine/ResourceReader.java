package execution_engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class ResourceReader {

	public static String readResource(String resourceName) throws IOException {

		InputStream in = ClassLoader.getSystemResourceAsStream(resourceName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
		StringBuilder builder = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null) {

			builder.append(line);
		}

		String resource = builder.toString();

		return resource;
	}

	public static int[] readIntegers(String resourceString) throws IOException {

		Scanner scanner = new Scanner(resourceString);
		ArrayList<Integer> intList = new ArrayList<>();

		while (scanner.hasNextInt()) {
			intList.add(scanner.nextInt());
		}

		scanner.close();

		int[] intArray = new int[intList.size()];

		for (int i = 0; i < intList.size(); i++) {
			intArray[i] = intList.get(i);
		}

		return intArray;
	}
	
	public static Integer readInteger(String token) {
		
		Integer integerValue = null;

		try {
			integerValue = Integer.parseInt(token);
		} catch (NumberFormatException e) {
			System.out.println("ExpressionTranslator: input string is not a valid integer");
		}

		return integerValue;		
	}
}
