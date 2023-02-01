package execution_engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemoryManagerTest {

	@Test
	@DisplayName("Test getInstance method: should return the same instance")
	final void testMemoryManagerSingleton() {

		MemoryManager memoryManagerInstance = MemoryManager.getInstance();
		MemoryManager memoryManagerOtherInstance = MemoryManager.getInstance();

		assertTrue(memoryManagerInstance == memoryManagerOtherInstance);
	}

}
