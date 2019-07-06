package collections;

import java.util.LinkedList;

/* 
 * accessing operation is time taking
 * Not synchronized,capacity increased by (c * 3/2) + 1 ,used for insertion deletion,duplicates are allowed,insertion order is preserved
 */
public class LinkedListEx {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
	LinkedList ll = new LinkedList();
	ll.addFirst(5);
	ll.addLast(6);
	ll.addLast(8);
	LinkedList ll2 = (LinkedList) ll.clone();
	System.out.println(ll);
	ll2.addAll(ll);
	System.out.println(ll2);
	System.out.println(ll.getFirst());
	;
	System.out.println(ll.getLast());
	System.out.println(ll.removeLast());

	}

}
