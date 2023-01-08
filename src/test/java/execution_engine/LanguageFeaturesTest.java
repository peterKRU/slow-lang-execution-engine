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
 		Integer var2 = ResourceReader.readInteger(log.get(0));
 		Integer var3 = ResourceReader.readInteger(log.get(0));
 		
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
