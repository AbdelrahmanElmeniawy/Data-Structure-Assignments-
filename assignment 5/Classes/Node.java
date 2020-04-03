package eg.edu.alexu.csd.datastructure.stack;
/**
 * this class implements a single node in the stack
 * @author Elmeniawy
 *
 */
public class Node {
	public Object item;
	public Node next ;
	
	/**
	 * Initializing the node item and the pointer next to null if there is no parameter
	 */
	public Node() {
		item = null;
		next = null;
	}
	
	/**
	 * Initializing the node item to object o and the pointer next to null if there is one parameter
	 * @param o the object that the user want to initialize the node item with
	 */
	public Node (Object o) {
		item = o;
		next = null;
	}
}
