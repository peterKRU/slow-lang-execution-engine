package execution_engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BytecodeImporter {

	public static int[] importBytecode(String fileName) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		int[] intArray = reader.lines().flatMap(line -> Arrays.stream(line.split(" "))).mapToInt(Integer::parseInt)
				.toArray();

		reader.close();

		return intArray;
	}

}
