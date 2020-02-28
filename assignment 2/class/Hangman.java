package eg.edu.alexu.csd.datastructure.hangman;
import java.io.*;
import java.util.*;

public class Hangman implements IHangman{
	final private static int MAXLENGTH = (int) 150000;
	private  
		    Scanner scan;
	 		int counter = 0; 
	 		int MAX;
	 		String secretword;
	 		int length;
	 		int winner;
	 		char[] showword;
	 		String PATH;
	 		Boolean EndGame = false;
		 
	   Boolean fileexist() {
			 try {
				 File file = new File (PATH);
				 scan = new Scanner(file);
				 return true;
			 } catch (Exception e) {
				 System.out.println(e.getMessage());
				return false;
			 }
		 }
		 
	  Boolean isAlpha(String word) {
			 char[] chars = word.toCharArray();
			 for (char c : chars) {
				 if (c > 'z' || c < 'a'  && c > 'Z' || c < 'A') {
					 return false;
				 }
			 }
			 return true;
		 }
		 
		    String readfile() {
				if (scan.hasNextLine()) {
					String word = scan.nextLine();
					if (isAlpha(word)) {
						return word;
					} else {
						return readfile();
					}
				}
				return null;
		}
	
		 
	public   String getSecretWordTEST() {
		System.out.println(secretword);
		return secretword;
	}
	public  void setSecretWordTEST(String test) {
		secretword = test;
	}
	public   void printArrayTEST (String[] test) {
		for (int i = 0; i < counter; i++) {
			System.out.println(test[i]);
		}
	}
	public  void setPath (String loc) {
		PATH = loc;
	}
	
	
	public   void setDictionary(String[] words) {
		if (fileexist()) {
			while (true) {
				String word = readfile();
				if (word == null) {
					break;
				}
				char[] word1 = word.toCharArray();
				for (int i = 0; i < word1.length; i++) {
					word1[i] = Character.toLowerCase(word1[i]);
				}
				String word2 = String.copyValueOf(word1);
				words[counter] = word2;
				counter++;
			}
		}
		//printArrayTEST(words);
	}
	
	
	public   String selectRandomSecretWord() {
		String[] words = new String[MAXLENGTH];
		setDictionary(words);
		if (counter != 0) {
			Date t = new Date();
			int ron = (int)t.getTime();
			ron = Math.abs(ron);
			//System.out.println(ron);
			ron = ron % counter;
			//System.out.println(ron);
			secretword = words[ron];
			length = secretword.length();
			showword = new char[length];
			winner = length;
			for (int i = 0; i < length; i++) {
				showword[i] = '-';
				System.out.print(showword[i]);
			}
			System.out.print('\n');
			return secretword;
		} else {
			return null;
		}
	}
	
	
	public    void setMaxWrongGuesses(Integer max) {
		if (max == null) {
			MAX = 1;
		} else {
			try {
				MAX = (int) max;
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	public   String guess(Character c) throws Exception{
		try {
			char guess = c;
			if (counter == 0) {
				System.out.println("dictionary is empty");
				return null;
			} else {
				if(c == null) {
					System.out.println(showword);
					return null;
				}
					if (Character.isLetter(guess)) {
						guess = Character.toLowerCase(guess);
						int x = 0;
						int existAt = secretword.indexOf(guess, x);
						Boolean exist = false;
						while (existAt != -1) {
							exist = true;
							showword[existAt] = secretword.charAt(existAt);
							x = existAt + 1;
							winner--;
							existAt = secretword.indexOf(guess, x);
						}
						if (exist) {
							if (winner == 0) {
								//System.out.println(secretword);
								System.out.println("winner winner chicken dinner");
								EndGame = true;
								return secretword;
							} else {
								//System.out.println(String.copyValueOf(showword));
								return String.copyValueOf(showword);
							}
						} else {
							MAX = MAX - 1;
							if(MAX == 0) {
								/*System.out.println(secretword);
								System.out.println("Game over");*/
								EndGame = true;
								return null;
							} else {
								//System.out.println(String.copyValueOf(showword));
								return String.copyValueOf(showword);
							}
						}
					}
					else {
						//System.out.println(String.copyValueOf(showword));
						return String.copyValueOf(showword);
					}
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
	}
	public  Boolean EndOfGame() {
		return EndGame;
	}
}
