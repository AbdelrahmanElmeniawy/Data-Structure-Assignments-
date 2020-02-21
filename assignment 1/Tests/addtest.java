import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class addtest {

	@Test
	void test() {
		Calculator test = new Calculator();
		int output = test.add(2, 3);
		assertEquals(5, output);
		output = test.add(2, -3);
		assertEquals(-1, output);
		output = test.add(-2, 3);
		assertEquals(1, output);
		output = test.add(-2, -3);
		assertEquals(-5, output);
		output = test.add(0, 3);
		assertEquals(3, output);
		output = test.add(2, 0);
		assertEquals(2, output);
		output = test.add(0, 0);
		assertEquals(0, output);
		output = test.add(20, 100);
		assertEquals(120, output);
	}

}
