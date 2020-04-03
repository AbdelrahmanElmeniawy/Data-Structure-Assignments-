package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestExressionEvaluator {

	@Test
	void test() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		assertEquals("3 4 5 * +", test.infixToPostfix("3 + 4 * 5"));
		assertEquals("2 3 4 * +", test.infixToPostfix("2 + 3 * 4"));
		assertEquals("a b * 5 +", test.infixToPostfix("a * b + 5"));
		assertEquals("1 2 + 7 *", test.infixToPostfix("(1 + 2) * 7"));
		assertEquals("a b * c /", test.infixToPostfix("a * b / c"));
		assertEquals("a b c - d + / e a - * c *", test.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));
		assertEquals("a b / c - d e * a c * - +", test.infixToPostfix("a / b - c + d * e - a * c"));
		assertEquals("0 3 - 4 0 5 - * -", test.infixToPostfix("-3 - 4 * -5"));
		assertEquals("0 5 - 10 20 30 * 40 + + 43 2 / / 3 + +" , test.infixToPostfix("-5 + (10 + 20 * 30 + 40) / (43 / 2) + 3"));
		assertThrows(NullPointerException.class,()->test.infixToPostfix(""));
		assertThrows(NullPointerException.class,()->test.infixToPostfix(null));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("(a / (b f - c + d)) * (e - a) * c"));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("(a / (b - - c + d)) * (e - a) * c"));
		assertThrows(RuntimeException.class,()->test.infixToPostfix("(a (b - c + d)) * (e - a) * c"));
		assertThrows(NullPointerException.class,()->test.infixToPostfix("(a / (b - c + d() * (e - a) * c"));
	}
	
	@Test
	void test0() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		assertEquals(23, test.evaluate("3 4 5 * +"));
		assertEquals(14, test.evaluate("2 3 4 * +"));
		assertThrows(RuntimeException.class,()->test.evaluate("a b * 5 +"));
		assertEquals(17, test.evaluate("3 4 * 5 +"));
		assertEquals(21, test.evaluate("1 2 + 7 *"));
		assertEquals(8, test.evaluate("3 5 * 2 /"));
		assertEquals(-5, test.evaluate("3 4 5 - 6 + / 7 8 - * 9 *"));
		assertEquals(-34, test.evaluate("3 4 / 5 - 6 7 * 8 9 * - +"));
		assertEquals(17, test.evaluate("0 3 - 4 0 5 - * -"));
		assertEquals(28, test.evaluate("0 5 - 10 20 30 * 40 + + 43 2 / / 3 + +"));
		assertEquals(1965186416, test.evaluate("1965186416"));
		assertThrows(NullPointerException.class,()->test.evaluate(""));
		assertThrows(NullPointerException.class,()->test.evaluate(null));
		assertThrows(RuntimeException.class,()->test.evaluate("3 5 * 5 5 - /"));
		assertThrows(RuntimeException.class,()->test.evaluate("//"));
		assertThrows(RuntimeException.class,()->test.evaluate("3 5"));
		
	}

}
