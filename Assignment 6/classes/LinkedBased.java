package classes;

import interfaces.ILinkedBased;
import interfaces.IQueue;

public class LinkedBased implements IQueue,ILinkedBased {

	
	DLinkedList Queue=new DLinkedList();
	
	
	public void enqueue(Object item) {
		if (item == null) {
			throw new NullPointerException("The item to be enqueued is null.");
		}
		Queue.add(item);
	}
	
	
	public Object dequeue() {
		if(Queue.isEmpty()) {
			throw new RuntimeException("Queue is empty.");
		}
		Object ret=Queue.get(0);
		Queue.remove(0);
		return ret;
		
	}
	
	public boolean isEmpty() {
		if(Queue.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	public int size() {
		return Queue.size();
	}
}
