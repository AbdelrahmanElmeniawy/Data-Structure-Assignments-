package tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import classes.LinkedBased;

public class LinkedBasedTest01 {

	@Test
	public void test() {
		LinkedBased test = new LinkedBased();
		test.enqueue(5);
		test.enqueue("hello");
		assertEquals(test.dequeue(),5);
		assertEquals(test.dequeue(),"hello");
	}

}
