package execution_engine;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoggerTest {

	@Test
	@DisplayName("Test Logger with default input: should output log with size 1 and value 11")
	final void testLoggerWithDefaultInput() throws IOException {

		Runner.runDefaultTest();

		List<String> log = ChainedVM.logger.getLog();
		assertTrue(log.size() == 1);
		Integer resultValue = ResourceReader.readInteger(log.get(0));
		assertTrue(resultValue == 11);
	}

}
