package eg1;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
//import java.util.Vector;

public class Demo1 {

	public static void main(String[] args) {
		
		//Task here is to recreate the same and try the same way to explore about the Queue Interface
		
		Queue qu0 = new PriorityQueue();  // Defaults to String
		qu0.add("hello");
//		qu0.add(1234); // Doesn't work - Only String is allowed by default
//		qu0.add(true); // Doesn't work - Only String is allowed by default
//		qu0.add('d'); // Doesn't work - Only String is allowed by default
//		qu0.add(1233.4455f); // Doesn't work - Only String is allowed by default
		qu0.add("Good-Bye");
//		qu0.add(null); // Doesn't work - NullPointerException
		qu0.add("Where will this go?");
		qu0.add("Salty");
		qu0.add("Far Out");
		System.out.println(qu0);
		
		Queue<Integer> qu1 = new PriorityQueue(); // Queue seems to force a type that has to be met
		qu1.add(12);
		qu1.add(123);
		qu1.add(0);
		qu1.add(145);
		qu1.add(122);
		qu1.add(123);
		qu1.add(56);
		qu1.add(189);
		qu1.add(111);
//		qu1.add("rrr");   // No Good now
		System.out.println(qu1);
		
		Queue<Float> qu2 = new PriorityQueue(); // Queue seems to force a type that has to be met

//		qu2.add(12); // No Good - Not a float
		qu2.add(12f);
		qu2.add(12.f);
		qu2.add(3.141592f);
		System.out.println(qu2);
		
		System.out.println("qu0.element() = "+qu0.element());
		System.out.println("qu1.element() = "+qu1.element());
		System.out.println("qu2.element() = "+qu2.element());
		
		System.out.println("peek - qu0.element() = "+qu0.peek());
		System.out.println("qu0.element() = "+qu0.element());
		
		System.out.println("remove - qu0.element() = "+qu0.remove());
		System.out.println("qu0.element() = "+qu0.element());  // New head of queue
		
		System.out.println("qu0 : "+qu0);
//		Collections.reverse(qu0);  // No Good
//		Collections.shuffle(qu0);  // No Good
		
		//----------------//
		// PRIORITY QUEUE //
		//----------------//
		
		PriorityQueue pq0 = new PriorityQueue();
		
		pq0.add("Stay Away");
//		pq0.add(1234);  // Same as Queue - causes an error
//		pq0.add(true);  // Same as Queue - causes an error
//		pq0.add('d');   // Same as Queue - causes an error
//		pq0.add(1233.4455f); // Same as Queue - causes an error
		pq0.add("Go home");
		pq0.add("Skip school");
		pq0.add("No - Learn MORE!");
		System.out.println(pq0);
		
		PriorityQueue<Integer> pq1 = new PriorityQueue();
		pq1.add(12);
		pq1.add(123);
		pq1.add(0);
		pq1.add(145);
		pq1.add(122);
		pq1.add(123);
		pq1.add(56);
		pq1.add(189);
		pq1.add(111);
//		pq1.addAll(null);   // No Good
		System.out.println(pq1);
		
		System.out.println("Size of PriorityQueue = "+pq1.size());
		
		System.out.println("Remove 57 = "+pq1.remove(57));
		System.out.println("Contains 56 = "+pq1.contains(56));
		System.out.println("Remove 56 = "+pq1.remove(56));
		System.out.println("Contains 56 = "+pq1.contains(56));
		System.out.println(pq1);
		System.out.println("Size of PriorityQueue = "+pq1.size());
		
		while(pq1.remove(123)) {} //remove all the occurrences of that object value
		System.out.println(pq1);
		System.out.println("Size of PriorityQueue = "+pq1.size());

//		System.out.println("pq1.get(3) : "+pq1.get(3)); // No such call	

//		System.out.println("Iterating using a for each loop");  // No Good
//		for(Integer i2:pq1) {
//			System.out.println(i2);
//		}
	
		PriorityQueue<Integer> pq2=new PriorityQueue<>(pq1); //copy all contents
		System.out.println("pq2 = "+pq2);
		
//		Collections.sort(pq1); // No Good

	}

}
