package execution_engine;

import java.io.FileWriter;
import java.io.IOException;

public class LogExporter implements TextExporter{
	
	@Override
	public void export(String output, String fileName) throws IOException {

		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write(output);

			writer.close();
			
		} catch (IOException e) {
			
			System.out.println("LogExporter: An error occurred while writing to the file.");
			e.printStackTrace();
		}
	}

}
