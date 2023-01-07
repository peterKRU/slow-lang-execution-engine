package execution_engine;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class RunnerTest {

	@Test
	void test() throws IOException {
		assertTrue(true);
		
		String test = ResourceReader.readResource("test.txt");
		System.out.println(test);
	}

}
