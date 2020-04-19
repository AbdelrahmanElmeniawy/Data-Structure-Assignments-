package tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import classes.ArrayBased;

public class ArrayBasedTest02 {

	@Test
	public void test() {
		int n = 5;
		ArrayBased test = new ArrayBased(n);
		test.enqueue(5);
		test.enqueue("hello");
		test.dequeue();
		assertEquals(test.isEmpty(),false);
		assertEquals(test.size(),1);
	}

}
