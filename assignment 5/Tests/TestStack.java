package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStack {

	@Test
	void test0() {
		Stack test = new Stack();
		assertEquals(test.isEmpty(), true);
		test.push(5);
		test.push(3);
		test.pop();
		test.push(2);
		assertEquals(test.size(), 2);
		test.push(8);
		test.push(9);
		test.pop();
		assertEquals(test.pop(), 8);
		assertEquals(test.peek(), 2);
		test.pop();
		assertEquals(test.pop(), 5);
		assertEquals(test.size(), 0);
		assertThrows(NullPointerException.class,()->test.peek());
		assertThrows(NullPointerException.class,()->test.pop());
		assertThrows(NullPointerException.class,()->test.peek());
		test.push(4);
		assertEquals(test.isEmpty(), false);
		assertThrows(NullPointerException.class,()->test.push(null));
		test.push(6);
		assertEquals(test.pop(), 6);
		assertEquals(test.size(), 1);
	}
	
	@Test
	void test1() {
		Stack test = new Stack(0);
		assertEquals(test.isEmpty(), false);
		test.push(5);
		test.pop();
		test.push(3);
		test.pop();
		test.push(2);
		assertEquals(test.size(), 2);
		test.pop();
		assertEquals(test.pop(), 0);
		assertEquals(test.isEmpty(), true);
	}

}
