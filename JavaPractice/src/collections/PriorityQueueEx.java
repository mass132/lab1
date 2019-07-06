package collections;

import java.util.Iterator;
import java.util.PriorityQueue;
/*
 * the head value is the lowest
 */
public class PriorityQueueEx {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<String>();
		//System.out.println(queue.element());//throws NoSuchElementException when queue is empty
		System.out.println(queue.peek()); //Returns null if queue is empty
		queue.add("d");
		queue.add("D");
		queue.add("c");
		queue.add("d");
		System.out.println(queue);
		System.out.println(queue.element());
		System.out.println(queue.peek());
		System.out.println("head : "+queue.poll());//returns null if queue is empty
		System.out.println("head : "+queue.remove());//throws exception if queue is empty
		System.out.println(queue);
		queue.clear();
		queue.add("d");
		queue.add("D");
		queue.add("c");
		queue.add("d");
		System.out.println(queue);

		Iterator itr = queue.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("head : "+queue.poll());
		itr = queue.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

}
