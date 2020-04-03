package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;
/**
 * User Interface that have the main method
 * @author Elmeniawy
 *
 */
public class UIapplication {
	/**
	 * the main method that take the input from user and print on screen
	 * @param args
	 */
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		while(true) {
			System.out.println("Please choose action's number\n"
					+ "1: Push\r\n" + 
					"2: Pop\r\n" + 
					"3: Peek\r\n" + 
					"4: Get size\r\n" + 
					"5: Check if empty\r\n" +
					"6: Close");
			int choose = 0;
			Boolean exit = false;
			try {
				choose = scan.nextInt();
			}catch(Exception e) {
				System.out.println("Please enter a proper input");
			}
			switch(choose) {
			case 1:
				System.out.print("Please input tne next number: ");
				try {
					int input = scan.nextInt();
					stack.push(input);
					System.out.println(input + "  is added to the stack");
				} catch(Exception e) {
					System.out.println("Please enter a proper input");
				}
				break;
			case 2:
				try {
					System.out.println(stack.pop() + "\nelement is removed");
				}catch(Exception e) {
					System.out.println("The stack is Empty");
				}
				break;
			case 3:
				try {
					System.out.println(stack.peek());
				}catch(Exception e) {
					System.out.println("The stack is Empty");
				}
				break;
			case 4:
				System.out.println("size = " + stack.size());
				break;
			case 5:
				if (stack.isEmpty()) {
					System.out.println("Yes, it is Empty");
				} else {
					System.out.println("No, it is not Empty");
				}
				break;
			case 6:
				exit = true;
				break;
			default :
				System.out.println("Enter prober number");
			}
			if (exit) {
				scan.close();
				break;
			}
		}	
	}
}
