package eg.edu.alexu.csd.datastructure.linkedList.cs70_cs39;

public class SLinkedList implements ILinkedList {
	private int size;
	private SNode head;
	
	
	public SLinkedList() {
		this.size = 0;
		this.head = null;
	}
	
	public void add(int index, Object element) {	
		SNode node = new SNode();
		node.item = element;
		if (!element.equals(null)) {
			SNode current = this.head;
			if(index <= this.size + 1 && index > 0) {
				for(int i = 1; i < index - 1; i++) {
					current = current.next;
				}
				if (current == this.head && index == 1) {
					node.next = current;
					this.head = node;
				} else {
					node.next = current.next;
					current.next = node;
				}
				this.size++;
			}
			else {
				throw new NullPointerException("The Index exceedes the Size of list,Size="+this.size);
			}	
		} else {
			throw new NullPointerException();
		}
		
	}
	
	
	public void add(Object element) {
		SNode node = new SNode();
		node.item = element;
		if (!element.equals(null)) {
			SNode current = this.head;
			node.next = null;
			if(this.head != null) { // can remove
				for(int i = 1; i < this.size; i++) {
					current = current.next;
				}
				current.next = node;
				this.size++;
				
			}
			else {
				this.head = node;
				this.size = 1;
			}
		} else {
			throw new NullPointerException();
		}
		
		
	}
	
	public Object get(int index) {
		SNode node = this.head;
		    									
		if (index >= 0) { // edit							//index--; (BOS 3la Da)
			if(index <= this.size && this.head != null) {
				for(int i = 1; i < index; i++) {            
					node = node.next;
				}
				return node.item;
			}
			else {
				throw new NullPointerException("The Index exceedes the Size of list,Size="+this.size);
			}
		} else {
			throw new NullPointerException("The Index must be positive integer number");
		}
		
	}

	public void set(int index, Object element) {
		
		SNode current = this.head;
		
		if(index <= this.size && this.head != null && index > 0 && !element.equals(null)) {
			for(int i = 1; i < index; i++) {
				current = current.next;
			}	
			current.item = element;
		}
		else {
			throw new NullPointerException("The Index exceedes the Size of list,Size="+this.size);
		}
	}


	public void clear() { //edit
		if(this.head != null) {
			this.head = null;
			this.size = 0;
		}
		else {
			System.out.println("The List is already empty");
		}
	}

	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		else {
			return false;
		}
	}


	public void remove(int index) { //edit
		SNode exnode = new SNode();
		SNode current = this.head;
		if (index >= 1) {										//BOS HNA
			if(index <= this.size && this.head != null) {
				for(int i = 1; i < index - 1; i++) {
					current = current.next;
				}
				if (index == 1) {
					this.head = current.next;
				}
				else if (index == this.size) {
					current.next = null; 
				} else {
					exnode = current.next;
					current.next = exnode.next;
				}
				this.size--;
			}
			else {
				throw new NullPointerException("The Index exceedes the Size of list,Size="+this.size);
			}
		} else {
			throw new NullPointerException("The Index must be positive integer number");
		}
	}

	public int size() {
		return this.size;
	}

	public ILinkedList sublist(int fromIndex, int toIndex) { //edit
		SLinkedList Subone = new SLinkedList();
		if(this.head != null) {
			if(toIndex < fromIndex || fromIndex < 1 || toIndex < 1 || fromIndex > this.size || toIndex > this.size) {
				throw new NullPointerException("Error in border index");
			}
			else if(fromIndex == toIndex) {
				Subone.add(fromIndex,this.get(fromIndex));
				return Subone;
			}
			else {
				for(int i = fromIndex; i <= toIndex; i++) {	
					Subone.add(this.get(i));
				}
				return Subone;
			}
		}
		else {
			throw new NullPointerException();
		}
	}

	public boolean contains(Object o) {//edit
		if(this.head != null) {
			SNode current = this.head;
			for(int i = 1; i <= this.size; i++) {
				if(current.item.equals(o)) {
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}

}

