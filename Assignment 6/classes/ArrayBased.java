package classes;

import interfaces.IArrayBased;
import interfaces.IQueue;

public class ArrayBased implements IQueue, IArrayBased{
	
	int maxsize, f, r, sz;
	Object[] arr;
	public ArrayBased(int n){
		this.maxsize = n;
		f = r = sz = 0;
		arr = new Object[maxsize];
	}
	 

	@Override
	public void enqueue(Object item) {
		if (item == null) {
			throw new NullPointerException("The item to be enqueued is null.");
		}
		if (sz == maxsize) {
			throw new RuntimeException("Queue is full.");
		}
		arr[r] = item;
		r = (r + 1) % maxsize;
		sz++;
	}

	@Override
	public Object dequeue() {
		if (sz == 0) {
			throw new RuntimeException("Queue is empty.");
		}
		Object temp = arr[f]; 
		f = (f + 1) % maxsize;
		sz--;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		if (sz == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return sz;
	}

}
