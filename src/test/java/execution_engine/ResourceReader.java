package execution_engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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
}
