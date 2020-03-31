package eg.edu.alexu.csd.datastructure.linkedList.cs70_cs39;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPolynomial {

	@Test
	void test() {
		
		PolynomialSolver test = new PolynomialSolver();
		int[][] arr = {
				{0,1},
				{5,3},
				{6,3},
				{2,-1},
				{10,0},
		};

		//TESTING SET POLYNOMIAL METHOD
		test.setPolynomial('A', arr);
		
		//TESTING PRINT METHOD
		assertEquals(test.print('A'),"11x^3 + 10 + 2x^-1");
		
		//TESTINGEVALUATE POLYNOMIAL METHOD
		assertEquals(test.evaluatePolynomial('A', 1),23.0);
		assertEquals(test.evaluatePolynomial('A', (float)0.5),15.375);
		
		//TESTING CLEAR METHOD
		test.clearPolynomial('A');
		assertThrows(NullPointerException.class,()->test.print('A'));	
	
	}
	
	@Test
	void test1() {
		
		float Conv= (float)10E20;
		PolynomialSolver test = new PolynomialSolver();
		int[][] arr = {
				{5,10},
				{3,22},
				{100,7},
				{2,-10},
				{10,0},
				{20,0},
				{25,-5},
				{3,10},
				{30,2},
				{21,7},
				{13,1},
				{22,11},
				
		};

		//TESTING SET POLYNOMIAL METHOD
		test.setPolynomial('B', arr);
	
		//TESTING PRINT METHOD
		assertEquals(test.print('B'),"3x^22 + 22x^11 + 8x^10 + 121x^7 + 30x^2 + 13x + 30 + 25x^-5 + 2x^-10");
		
		//TESTINGEVALUATE POLYNOMIAL METHOD
		assertEquals(test.evaluatePolynomial('B', 1),254.0);
		assertTrue(Math.abs(test.evaluatePolynomial('B', 7)-1.1729464E19)<=Conv);
		assertTrue(Math.abs(test.evaluatePolynomial('B', (float)0.1235)-2.42390989E9)<=Conv);
		
		//TESTING CLEAR METHOD
		test.clearPolynomial('B');
		assertThrows(NullPointerException.class,()->test.print('B'));
		
	}
	
	@Test
	void test2() {
		PolynomialSolver test = new PolynomialSolver();
		int[][] arr = {
				{0,0},
		};

		//TESTING SET POLYNOMIAL METHOD
		test.setPolynomial('C', arr);
		
		//TESTING PRINT METHOD
		assertEquals(test.print('C'),"0");
		
		//TESTINGEVALUATE POLYNOMIAL METHOD
		assertEquals(test.evaluatePolynomial('C', 1500),0);
		assertEquals(test.evaluatePolynomial('C', (float)0.5484231),0);
		
		//TESTING CLEAR METHOD
		test.clearPolynomial('C');
		assertThrows(NullPointerException.class,()->test.print('C'));

	}
	
	
	@Test
	void test3() {
		PolynomialSolver test = new PolynomialSolver();
		
		//TESTING SET POLYNOMIAL METHOD
		assertThrows(NullPointerException.class,()->test.setPolynomial('C', null));
		
		//TESTING PRINT METHOD
		assertThrows(NullPointerException.class,()->test.print('C'));
		
		//TESTINGEVALUATE POLYNOMIAL METHOD
		assertThrows(NullPointerException.class,()->test.evaluatePolynomial('C', 1500));
		
		//TESTING CLEAR METHOD
		test.clearPolynomial('C');
		assertThrows(NullPointerException.class,()->test.print('C'));	

	}
	
	
	
	@Test
	void test4() {
		
		PolynomialSolver test = new PolynomialSolver();
		int[][] arr1 = {
				{0,1},
				{5,3},
				{-6,3},
				{2,-1},
				{10,0},
		};
		int[][] arr2 = {
				{5,2},
				{2,3},
				{6,3},
				{2,-1},
				{10,0},
				{13,0},
				{-7,2},
		};
		
		
		test.setPolynomial('A', arr1);
		test.setPolynomial('B', arr2);
		
		//TESTING ADD METHOD
		test.add('A', 'B');	
		assertEquals(test.print('R'),"7x^3 + -2x^2 + 33 + 4x^-1");
		
		//TESTING SUBTRACT METHOD
		test.subtract('A', 'B');
		assertEquals(test.print('R'),"-9x^3 + 2x^2 + -13");
		
		//TESTING MULTIPLICATION
		test.multiply('A', 'B');
		assertEquals(test.print('R'),"-8x^6 + 2x^5 + 57x^3 + -6x^2 + -4x + 230 + 66x^-1 + 4x^-2");
	}
	
	
	@Test
	void test5() {
		
		PolynomialSolver test = new PolynomialSolver();
		int[][] arr1 = {
				{0,1},
				{5,7},
				{-6,3},
				{300,15},
				{20,5},
				{125,-7},
				
		};
		int[][] arr2 = {
				{4,2},
				{6,0},
				{5,8},
				{120,3},
				{5,-20},
				{2,-15},
				
		};
		
		
		test.setPolynomial('A', arr1);
		test.setPolynomial('B', arr2);
		
		//TESTING ADD METHOD
		test.add('A', 'B');
		System.out.println(test.print('R'));
		assertEquals(test.print('R'),"300x^15 + 5x^8 + 5x^7 + 20x^5 + 114x^3 + 4x^2 + 6 + 125x^-7 + 2x^-15 + 5x^-20");
		
		//TESTING SUBTRACT METHOD
		test.subtract('A', 'B');
		System.out.println(test.print('R'));
		assertEquals(test.print('R'),"300x^15 + -5x^8 + 5x^7 + 20x^5 + -126x^3 + -4x^2 + -6 + 125x^-7 + -2x^-15 + -5x^-20");
		
		//TESTING MULTIPLICATION
		test.multiply('A', 'B');
		System.out.println(test.print('R'));
		assertEquals(test.print('R'),"1500x^23 + 36000x^18 + 1200x^17 + 1825x^15 + 100x^13 + -30x^11 + 600x^10 + 20x^9 + 2400x^8 + 110x^7 + -720x^6 + 96x^5 + -36x^3 + 625x + 600 + 15000x^-4 + 2000x^-5 + 750x^-7 + 10x^-8 + 40x^-10 + -12x^-12 + 25x^-13 + 100x^-15 + -30x^-17 + 250x^-22 + 625x^-27");
	}
	
	@Test
	void test6() {
		PolynomialSolver test = new PolynomialSolver();
		int[][] arr1 = {{10,10}, {-10, 10}};
		int[][] arr2 = {
				{2, 3},
				{-4, 5},
		};
		int[][] arr3 = {
				{-2, 3},
				{4, 5},
		};
		int[][] arr4 = {
				{-1, -3},
		};
		int[][] arr5 = {
				{-1, 3},
		};
		
		test.setPolynomial('A', arr1);
		test.setPolynomial('B', arr2);
		test.setPolynomial('C', arr3);
		
		assertEquals(test.print('A'), "0");
		assertEquals(test.print('B'), "-4x^5 + 2x^3");
		assertEquals(test.print('C'), "4x^5 + -2x^3");
		
		test.add('B', 'C');
		assertEquals(test.print('R'), "0");
		test.multiply('A', 'B');
		assertEquals(test.print('R'), "0");
		
		test.setPolynomial('A', arr4);
		test.setPolynomial('B', arr5);
		
		assertEquals(test.print('A'), "-1x^-3");
		assertEquals(test.print('B'), "-1x^3");
		
		test.multiply('A', 'B');
		assertEquals(test.print('R'), "1");
	}
	
}
