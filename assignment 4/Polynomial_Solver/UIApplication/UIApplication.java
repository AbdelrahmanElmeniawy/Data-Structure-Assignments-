package eg.edu.alexu.csd.datastructure.linkedList.cs70_cs39;
import java.util.*;

public class UIApplication {
	static Scanner input = new Scanner (System.in);
	public static void main (String[] args) {
		PolynomialSolver polynomial = new PolynomialSolver();
		while (true) {
			System.out.println(
					"Please choose an action\r\n" + 
					"-----------------------\r\n" + 
					"1- Set a polynomial variable\r\n" + 
					"2- Print the value of a polynomial variable\r\n" + 
					"3- Add two polynomials\r\n" + 
					"4- Subtract two polynomials\r\n" + 
					"5- Multiply two polynomials\r\n" + 
					"6- Evaluate a polynomial at some point\r\n" + 
					"7- Clear a polynomial variable\r\n" + 
					"0- Exit\n" +
					"====================================================================");
			int num = scanint();
			char poly, poly1, poly2;
			if (num == 1 || num == 2 || num == 6 || num == 7) {
				if (num == 2 || num == 6) {
					System.out.println("Insert the variable name: A, B, C or R");
				} else {
					System.out.println("Insert the variable name: A, B or C");
				}
				do {
					poly = scanchar();
					if (poly == 'A' || poly == 'B' || poly == 'C' || (poly == 'R' && (num == 2 || num == 6))) {
						break;
					}
					System.out.println("please, Enter proper variable name");
				} while (true);
				switch (num) {
					case 1:
						System.out.println("Enter the number of terms:");
						int number;
						do {
							number = scanint();
							if (number > 0) {
								break;
							}
							System.out.println("please, Enter proper number");
						} while (true);
						int[][] arr = new int[number][2];
						System.out.println("Insert the polynomial terms in the form: coefficient exponent");
						for (int i = 1; i <= number; i++) {
							do {
								System.out.println("Insert term number" + i + ":");
								if(terms(arr, i - 1)) {
									break;
								}
								System.out.println("please, Enter proper term");
							} while (true);
						}
						polynomial.setPolynomial(poly, arr);
						break;
					case 2:
						try {
							System.out.println(polynomial.print(poly));
						} catch (Exception e) {
							System.out.println("Variable not set");
						}
						break;
					case 6:
						System.out.println("Enter the value:");
						float value;
						do {
							value = scanfloat();
							if (value != -1909020201) {
								break;
							}
							System.out.println("please, Enter proper number");
						} while (true);
						try {
							System.out.println(polynomial.evaluatePolynomial(poly, value));
						} catch (Exception e) {
							System.out.println("Variable not set");
						}
						break;
					case 7:
						polynomial.clearPolynomial(poly);
						break;
				}
			}
			else if (num == 3 || num == 4 || num == 5) {
				System.out.println("Insert the first oprand variable name: A, B or C");
				do {
					poly1 = scanchar();
					if (poly1 == 'A' || poly1 == 'B' || poly1 == 'C') {
						break;
					}
					System.out.println("please, Enter proper variable name");
				} while (true);
				System.out.println("Insert the second oprand variable name: A, B or C");
				do {
					poly2 = scanchar();
					if (poly2 == 'A' || poly2 == 'B' || poly2 == 'C') {
						break;
					}
					System.out.println("please, Enter proper variable name");
				} while (true);
				try {
					switch (num) {
						case 3:
							polynomial.add(poly1, poly2);
							break;
						case 4:
							polynomial.subtract(poly1, poly2);
							break;
						case 5:
							polynomial.multiply(poly1, poly2);
							break;
					}
				}catch(Exception e) {
					System.out.println("Variables not set");
				}
			}
			else if(num == 0) {
				break;
			} else {
				System.out.println("Choose proper number"); 
			}
		}
		input.close();
	}
	
	public static int scanint() {
		String str = input.nextLine();
		try {
			int number = Integer.parseInt(str);
			return number;
		}catch(NumberFormatException e){  
			return -1909020201;  
		}  	
	}
	
	public static char scanchar() {
		String str = input.nextLine();
		if (str.length() != 1 || str.charAt(0) < 'A' || str.charAt(0) > 'Z') {
			return '*';
		}
		return str.charAt(0);
	}

	public static Boolean terms(int[][] arr, int x) {
		String[] str=input.nextLine().split(" ");
		int size = str.length;
		if (size != 2) {
			return false;
		}
		for(int i = 0; i < size; i++) {
			try {
				arr[x][i] = Integer.parseInt(str[i]);
			}catch(NumberFormatException e){  
				return false;  
			} 
			
		}
		return true;
	}
	
	public static float scanfloat() {
		String str = input.nextLine();
		try {
			float number = Float.parseFloat(str);
			return number;
		}catch(NumberFormatException e){  
			return -1909020201;  
		}  
	}
}
