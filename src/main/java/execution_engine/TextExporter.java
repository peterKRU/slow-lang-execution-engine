package execution_engine;

import java.io.IOException;

public interface TextExporter {
	
	public void export(String output, String fileName) throws IOException;
}
