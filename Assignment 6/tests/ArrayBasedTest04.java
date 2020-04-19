package tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import classes.ArrayBased;

public class ArrayBasedTest04 {

	@Test
	public void test() {
		int n = 2;
		ArrayBased test = new ArrayBased(n);
		try {
			test.enqueue(null);
		}catch (Exception e) {
			assertEquals("The item to be enqueued is null.",e.getMessage());
		}
		try {
			test.dequeue();
		}catch (Exception e) {
			assertEquals("Queue is empty.",e.getMessage());
		}
		test.enqueue(5);
		test.enqueue("hello");
		try {
			test.enqueue('c');
		}catch (Exception e) {
			assertEquals("Queue is full.",e.getMessage());
		}
		
		assertEquals(5,test.dequeue());
		
	}

}
