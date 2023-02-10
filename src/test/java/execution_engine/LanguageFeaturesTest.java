package execution_engine;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("SlowLang language features tests")
class LanguageFeaturesTest {

	@Test
	@DisplayName("Test arithmetic operations, multiple function calls, print statement, class declarations and method declarations")
	final void functionCallTestTwoMethods() throws IOException {

		Runner.runDefaultTest();

		List<String> log = ChainedVM.logger.getLog();

		assumeTrue(log.size() == 1);

		Integer resultValue = ResourceReader.readInteger(log.get(0));

		assertTrue(resultValue == 11);
	}	

}
