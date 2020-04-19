package tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import classes.ArrayBased;

public class ArrayBasedTest01 {

	@Test
	public void test() {
		int n = 5;
		ArrayBased test = new ArrayBased(n);
		test.enqueue(5);
		test.enqueue("hello");
		assertEquals(test.dequeue(),5);
		assertEquals(test.dequeue(),"hello");
	}

}
