package com.asif.immutable;

/**
 * Test class for checking the correctness of ImmutableQueue
 * * The enQueue() and deQueue() 
 * Each operation of the ImmutableQueue class runs in an amortized 
 * @author asifiqbal
 *
 */
public class Test {

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		Queue<Integer> q = ImmutableQueue.getEmptyQueue();
		try{
			q = q.enQueue(5);
			print(q);
			q = q.enQueue(10);
			print(q);
			q = q.enQueue(20);
			print(q);
			q = q.enQueue(30);
			print(q);
			q = q.enQueue(null);
			print(q);
			q = q.enQueue(null);
			print(q);
			q = q.enQueue(60);
			print(q);
			q = q.deQueue();
			print(q);
			q = q.deQueue();
			print(q);
			q = q.deQueue();
			print(q);
			q = q.deQueue();
			print(q);
			q = q.deQueue();
			print(q);
			q = q.deQueue();
			print(q);
			System.out.println("Is queue empty ? " + q.isEmpty());
			q = q.deQueue();
			System.out.println("Is queue empty ? " + q.isEmpty());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void print(Queue<Integer> q) throws Exception{
		while(q != null && !q.isEmpty()){
			System.out.print(q.head() + " -> ");
			q = q.deQueue();
		}
		System.out.println();
	}

}