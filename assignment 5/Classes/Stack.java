package eg.edu.alexu.csd.datastructure.stack;
/**
 * this class implements the stack 
 * stack is data structure that depends on first in last out
 * this class is linked list based
 * 
 * @author Elmeniawy
 *
 */
public class Stack implements IStack{
	int size;
	Node top;
	/**
	 * initializing first element of the stack
	 * 
	 * @param o the value that user wants to input
	 */
	public Stack(Object o){
		size = 1;
		top = new Node(o);
	}
	/**
	 * override to allow declare the stack if the user do not know first node item
	 * 
	 */
	public Stack() {
		size = 0;
		top = new Node();
	}

	@Override
	public Object pop() {
		if (size == 0) {
			throw new NullPointerException("the stack is Empty\n");
		}
		size--;
		Object temp = top.item;
		top = top.next;
		return temp;
	}

	@Override
	public Object peek() {
		if (size == 0) {	
			throw new NullPointerException("the stack is Empty\n");
		}
		return top.item;
	}
	
	@Override
	public void push(Object element) {
		if (element == null) {
			throw new NullPointerException("Enter a proper element");
		}
		Node temp = new Node(element);
		temp.next = top;
		top = temp;
		size++;
	}
	
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public int size() {
		return size;
	}
	/**
	 * Change the top item in the stack
	 * @param O new data that will save in the stack
	 */
	public void edit(Object O) {
		top.item = O;
	}
}
