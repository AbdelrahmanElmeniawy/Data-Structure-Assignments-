package eg.edu.alexu.csd.datastructure.hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class rondomwordtest {

	@Test
	void test() {
		Hangman test = new Hangman();
		test.setPath("C:\\Users\\ECC\\eclipse-workspace\\eg.edu.alexu.csd.datastructure.hangman\\test.txt");
		String one =  test.selectRandomSecretWord();
		String two = "adsbdooooa";
		assertEquals(one, two);
		
		Hangman test0 = new Hangman();
		test0.setPath("C:\\Users\\ECC\\eclipse-workspace\\eg.edu.alexu.csd.datastructure.hangman\\test0.txt");
		 one =  test0.selectRandomSecretWord();
		 two = test0.getSecretWordTEST();
		assertEquals(one, two);
		
		Hangman test1 = new Hangman();
		test1.setPath("C:\\Users\\ECC\\eclipse-workspace\\eg.edu.alexu.csd.datastructure.hangman\\test1.txt");
		 one =  test1.selectRandomSecretWord();
		 two = test1.getSecretWordTEST();
		assertEquals(one, two);
		
		Hangman test2 = new Hangman();
		test2.setPath("C:\\Users\\ECC\\eclipse-workspace\\eg.edu.alexu.csd.datastructure.hangman\\test2.txt");
		 one =  test2.selectRandomSecretWord();
		 two = test2.getSecretWordTEST();
		assertEquals(one, two);
		
		Hangman RealDictionary = new Hangman();
		RealDictionary.setPath("C:\\Users\\ECC\\eclipse-workspace\\eg.edu.alexu.csd.datastructure.hangman\\RealDictionary.txt");
		 one =  RealDictionary.selectRandomSecretWord();
		 two = RealDictionary.getSecretWordTEST();
		assertEquals(one, two);
		
	}

}
