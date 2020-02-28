package eg.edu.alexu.csd.datastructure.hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class guesstest {

	@Test
	void test() {
		Hangman test = new Hangman();
		test.setPath("C:\\Users\\ECC\\eclipse-workspace\\eg.edu.alexu.csd.datastructure.hangman\\test.txt");
		String one =  test.selectRandomSecretWord();
		test.setMaxWrongGuesses(5);
		try {
			assertEquals("a--------a", test.guess('a'));
			assertEquals("a--------a", test.guess('*'));
			assertEquals("a--b-----a", test.guess('b'));
			assertEquals("a--b-----a", test.guess('@'));
			assertEquals("a--b-----a", test.guess('k'));
			assertEquals("a--b-----a", test.guess('/'));
			assertEquals("a--b-----a", test.guess('3'));
			assertEquals("a--b-----a", test.guess('P'));
			assertEquals("a--b-----a", test.guess('j'));
			assertEquals("a--b-----a", test.guess('M'));
			assertEquals(null, test.guess('r'));
			assertEquals(true, test.EndOfGame());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Hangman test1 = new Hangman();
		test1.setPath("C:\\Users\\ECC\\eclipse-workspace\\eg.edu.alexu.csd.datastructure.hangman\\test.txt");
		one =  test1.selectRandomSecretWord();
		test1.setMaxWrongGuesses(5);
		try {
			assertEquals("a--------a", test1.guess('a'));
			assertEquals("a--------a", test1.guess('*'));
			assertEquals("a--b-----a", test1.guess('b'));
			assertEquals("ad-bd----a", test1.guess('D'));
			assertEquals("ad-bdooooa", test1.guess('O'));
			assertEquals("ad-bdooooa", test1.guess('/'));
			assertEquals("adsbdooooa", test1.guess('S'));
			assertEquals("adsbdooooa", one);
			assertEquals(true, test1.EndOfGame());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
