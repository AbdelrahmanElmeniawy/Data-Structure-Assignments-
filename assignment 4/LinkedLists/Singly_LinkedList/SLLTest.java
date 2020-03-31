package eg.edu.alexu.csd.datastructure.linkedList.cs70_cs39;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SLLTest {

	@Test
	void test() {
		
		//TESTING ADD()
		
		ILinkedList Test=new SLinkedList();
		
		Test.add(1);
		Test.add(2);
		Test.add(3);									//ADDING INTEGER TO LINKEDLIST 
		assertEquals(Test.get(1),1);					
		assertEquals(Test.get(2),2);			
		assertEquals(Test.get(3),3);
	}
	
	@Test
	void tes1t() {
		
		//TESTING ADD(INDEX,OBJECT)
		
		ILinkedList Test=new SLinkedList();
		Test.add(1,"Mohamed");
		Test.add(2,"Ahmed");
		Test.add(3,"Mostafa");								//ADDING STRINGS TO LINKEDLIST
		assertEquals(Test.get(1),"Mohamed");				//USING INDEXING METHOD
		assertEquals(Test.get(2),"Ahmed");			
		assertEquals(Test.get(3),"Mostafa");
		
		Test.add(2,"john");								
		assertEquals(Test.get(2),"john");
		assertEquals(Test.get(3),"Ahmed");				//ADDING OBJECT IN THE MIDDLE OF THE LL
		assertEquals(Test.get(4),"Mostafa");
		
		//THROWING EXCEPTIONS INDEX > SIZE OF LL
		assertThrows(NullPointerException.class,()->Test.add(6,"Leo"));	
		//THROWING EXCEPTIONS INDEX IS -VE
		assertThrows(NullPointerException.class,()->Test.add(-5,"Leo"));
		
		//TESTING SET()
		
		Test.set(2,"Ali");
		Test.set(3,"Fares");
		assertEquals(Test.get(1),"Mohamed");			//MAKING NODE POINT TO ANOTHER OBJECT
		assertEquals(Test.get(2),"Ali");			
		assertEquals(Test.get(3),"Fares");
		assertEquals(Test.get(4),"Mostafa");
		
		//THROWING EXCEPTIONS INDEX > SIZE OF LL
		assertThrows(NullPointerException.class,()->Test.set(15,"mmm"));	
		//THROWING EXCEPTIONS INDEX IS -VE
		assertThrows(NullPointerException.class,()->Test.set(-15,"lll"));
		//THROWING EXCEPTIONS NULL ELEMENT
		assertThrows(NullPointerException.class,()->Test.set(2,null));		
	}

	
	@Test
	void test2() {
		
		//TESTING sublist()
		
		ILinkedList Test=new SLinkedList();
		ILinkedList sublist=new SLinkedList();
		ILinkedList sublist1=new SLinkedList();
		
		Test.add(1);
		Test.add(2);
		Test.add(3);									//ADDING INTEGER TO LINKEDLIST 
		Test.add(88);
		Test.add(32);
		Test.add(22);
		
		sublist=Test.sublist(1,2);
		assertEquals(sublist.get(1),1);				//USING INDEXING METHOD
		assertEquals(sublist.get(2),2);
		
		sublist=Test.sublist(2,6);
		assertEquals(sublist.get(1),2);				
		assertEquals(sublist.get(2),3);
		assertEquals(sublist.get(3),88);				
		assertEquals(sublist.get(4),32);
		assertEquals(sublist.get(5),22);	
		
		//THROWING EXCEPTIONS INDEX > SIZE OF LL
		assertThrows(NullPointerException.class,()->Test.sublist(2,17));	
		//THROWING EXCEPTIONS FROM INDEX > TO INDEX
		assertThrows(NullPointerException.class,()->Test.sublist(5,3));	
		//THROWING EXCEPTIONS -VE INDEX
		assertThrows(NullPointerException.class,()->Test.sublist(-5,-7));		
		
	}
	
	@Test
	void test3() {
		
		//TESTING REMOVE()
		
		ILinkedList Test=new SLinkedList();
		
		Test.add(100);
		Test.add(99);
		Test.add(80);									//ADDING INTEGER TO LINKEDLIST 
		Test.add(55);									//ADDING INTEGER TO LINKEDLIST
		Test.add(30);									//ADDING INTEGER TO LINKEDLIST
		Test.add(23);									//ADDING INTEGER TO LINKEDLIST
	
		Test.remove(1);
		Test.remove(4);
		
		assertEquals(Test.get(1),99);
		assertEquals(Test.get(2),80);	
		assertEquals(Test.get(3),55);
		assertEquals(Test.get(4),23);
		assertEquals(Test.size(),4);
		
		//THROWING EXCEPTIONS INDEX > SIZE OF LL
		assertThrows(NullPointerException.class,()->Test.remove(15));	
		//THROWING EXCEPTIONS FROM INDEX > TO INDEX
		assertThrows(NullPointerException.class,()->Test.remove(-5));	
		//THROWING EXCEPTIONS -VE INDEX
		
	}
	
	
	@Test
	void test4() {
		
		//TESTING CONTAINS()
		
		ILinkedList Test=new SLinkedList();
		
		Test.add(100);
		Test.add(99);
		Test.add(80);									//ADDING INTEGER TO LINKEDLIST 

			
		assertEquals(Test.contains(99),true);
		assertEquals(Test.contains(0),false);
	
	}
	@Test
	void test5() {
		
		//TESTING CLEAR()
		
		ILinkedList Test=new SLinkedList();
		
		Test.add(100);
		Test.add(99);
		Test.add(80);									//ADDING INTEGER TO LINKEDLIST 

		Test.clear();
		assertEquals(Test.size(),0);
		
		
	}
	@Test
	void test6() {
		SLinkedList test = new SLinkedList();
		
		test.add(1, 60);
		test.add(30);
		test.add(2, 20);
		test.add(4, 50);
		test.remove(1);
		test.add(1, 10);
		test.remove(4);
		test.add(40);
		test.add(5, 60);
		test.remove(5);
		int size = test.size();
		for (int i = 1; i <= size; i++) {
			Object x = test.get(i);
			if (!x.equals(i * 10)) {
				assertEquals(1, 0);
			}
		}
		if (test.contains(60)) {
			assertEquals(1, 0);
		}
		if (!test.contains(40)) {
			assertEquals(1, 0);
		}
		if (test.isEmpty()) {
			assertEquals(1, 0);
		}
		test.clear();
		if (!test.isEmpty()) {
			assertEquals(1, 0);
		}
		assertEquals(1, 1);	
	}
	
	
}
