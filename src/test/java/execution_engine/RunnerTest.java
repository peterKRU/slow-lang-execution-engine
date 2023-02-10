package execution_engine;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RunnerTest {
	
	
	
	@Test
	@DisplayName("Test Runner with default input: should log 11")
	
	final void testRunnerWithDefaultTest() throws IOException {

		Runner.runDefaultTest();

		List<String> log = ChainedVM.logger.getLog();

		assumeTrue(log.size() == 1);

		Integer resultValue = ResourceReader.readInteger(log.get(0));

		assertTrue(resultValue == 11);
	}

}
