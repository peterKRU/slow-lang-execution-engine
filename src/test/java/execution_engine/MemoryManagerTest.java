package execution_engine;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemoryManagerTest {

	@Test
	@DisplayName("Test MemoryManager instantiation: should load instructions with length 76")
	final void testMemoryManagerInstantiation() throws IOException {

		MemoryManager memoryManager = new MemoryManager("test_classes_compiled.txt");
		
		assertTrue(memoryManager.loadInstructions().length == 76);
	}

}
