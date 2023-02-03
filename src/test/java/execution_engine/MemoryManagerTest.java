package execution_engine;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemoryManagerTest {

	@Test
	@DisplayName("Test loadInstructionsMethod: loaded instructions array size should be 28")
	final void testMemoryManager() throws IOException {

		MemoryManager memoryManager = new MemoryManager("test_compiled.txt");
		int[] instructions = memoryManager.loadInstructions();
				
		assertTrue(instructions.length == 28);
	}

}
