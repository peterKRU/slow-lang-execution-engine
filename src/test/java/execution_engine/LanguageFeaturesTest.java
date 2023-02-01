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
	@DisplayName("Test function calls with subtraction: should log 9")
	final void functionCallTestWithSubtraction() {

		int[] testCode = { 88, 120, 80, 1, 80, 10, 102, 5555, 85, 89, 120, 100, 101, 2, 2000, 3000, 88, 1000, 89, 2000,
				89, 3000, 21, 85, 89, 1000, 103 };
		ChainedVM chainedVM = new ChainedVM(testCode, 0);
		chainedVM.executeProgram();

		List<String> log = ChainedVM.logger.getLog();

		assumeTrue(log.size() == 1);

		Integer resultValue = ResourceReader.readInteger(log.get(0));

		assertTrue(resultValue == 9);
	}

	@Test
	@DisplayName("Test function calls with subtraction: should log 11")
	final void functionCallTestWithAddition() {

		int[] testCode = { 88, 120, 80, 1, 80, 10, 102, 5555, 85, 89, 120, 100, 101, 2, 2000, 3000, 88, 1000, 89, 2000,
				89, 3000, 20, 85, 89, 1000, 103 };
		ChainedVM chainedVM = new ChainedVM(testCode, 0);
		chainedVM.executeProgram();

		List<String> log = ChainedVM.logger.getLog();

		assumeTrue(log.size() == 1);

		Integer resultValue = ResourceReader.readInteger(log.get(0));

		assertTrue(resultValue == 11);
	}	
	
	@Test
	@DisplayName("Test assignment expression: should log 1")
	final void assignmentExpressionTest() throws IOException {

		String resourceString = ResourceReader.readResource("assignmentExpression_compiled.txt");
		int[] bytecode = ResourceReader.readIntegers(resourceString);
		ChainedVM chainedVM = new ChainedVM(bytecode, 0);
		chainedVM.executeProgram();

		List<String> log = ChainedVM.logger.getLog();

		assumeTrue(log.size() == 1);

		Integer resultValue = ResourceReader.readInteger(log.get(0));

		assertTrue(resultValue == 1);
	}

	@Test
	@DisplayName("Test assignment by adding values to 3 variables: should log 1, 2, 3")
	final void assignmentExpressionMultipleVarsTest() throws IOException {

		String resourceString = ResourceReader.readResource("assignmentExpression2_compiled.txt");
		int[] bytecode = ResourceReader.readIntegers(resourceString);
		ChainedVM chainedVM = new ChainedVM(bytecode, 0);
		chainedVM.executeProgram();

		List<String> log = ChainedVM.logger.getLog();

		assumeTrue(log.size() == 3);

		Integer var1 = ResourceReader.readInteger(log.get(0));
		Integer var2 = ResourceReader.readInteger(log.get(1));
		Integer var3 = ResourceReader.readInteger(log.get(2));

		assertTrue(var1 == 1);
		assertTrue(var2 == 2);
		assertTrue(var3 == 3);
	}

	@Test
	@DisplayName("Test additive expression: should return 3")
	final void additiveExpressionTest() throws IOException {

		String resourceString = ResourceReader.readResource("additiveExpression_compiled.txt");
		int[] bytecode = ResourceReader.readIntegers(resourceString);
		ChainedVM chainedVM = new ChainedVM(bytecode, 0);
		chainedVM.executeProgram();

		List<String> log = ChainedVM.logger.getLog();

		assumeTrue(log.size() == 1);

		Integer resultValue = ResourceReader.readInteger(log.get(0));

		assertTrue(resultValue == 3);
	}

}
