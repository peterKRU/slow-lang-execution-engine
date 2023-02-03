package execution_engine;

import java.io.IOException;

public interface FileImporter {

	public int[] importFile(String fileName) throws IOException;
}
