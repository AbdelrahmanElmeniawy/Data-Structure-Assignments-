import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Dividetest {

	@Test
	void test() {
		Calculator test = new Calculator();
		float output = test.divide(5, 2);
		float answer = (float) 2.5;
		assertEquals(answer, output);
		output = test.divide(10, 2);
		answer = (float) 5;
		assertEquals(answer, output);
		output = test.divide(0, 2);
		answer = (float) 0;
		assertEquals(answer, output);
		try {
			test.divide(5, 0);
		}catch (Exception e) {
			assertEquals("Infinity", e.getMessage());
		}
		try {
			test.divide(0, 0);
		}catch (Exception e) {
			assertEquals("Infinity", e.getMessage());
		}
		output = test.divide(9, 3);
		answer = (float) 3;
		assertEquals(answer, output);
		output = test.divide(3, 1);
		answer = (float) 3;
		assertEquals(answer, output);
		output = test.divide(1, 3);
		answer = (float) 1 / 3;
		assertEquals(answer, output);
		output = test.divide(7, 4);
		answer = (float) 1.75;
		assertEquals(answer, output);
		output = test.divide(-7, -4);
		answer = (float) 1.75;
		assertEquals(answer, output);
		output = test.divide(7, -4);
		answer = (float) -1.75;
		assertEquals(answer, output);
		output = test.divide(-7, 4);
		answer = (float) -1.75;
		assertEquals(answer, output);
		try {
			test.divide(-7, 0);
		}catch (Exception e) {
			assertEquals("Infinity", e.getMessage());
		}
		try {
			test.divide(-0, -0);
		}catch (Exception e) {
			assertEquals("Infinity", e.getMessage());
		}
		output = test.divide(0, -4);
		answer = (float) 0;
		assertEquals(answer, output);
	}

}
