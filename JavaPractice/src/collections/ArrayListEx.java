package collections;

import java.util.ArrayList;
/* 
 * Implements java.util.RandomAccess so accessing operation is faster
 * Not synchronized,capacity increased by (c * 3/2) + 1 ,used for searching,duplicates are allowed,insertion order is preserved
 */
public class ArrayListEx {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("pooonam");
		al.add(123);
		al.add(123.41234);
		al.add(new String("hello"));
		System.out.println(al);
		ArrayList al2 = new ArrayList(al);
		al2.addAll(al);
		System.out.println(al2);
		ArrayList al3 = new ArrayList();
		al3.add("hello");
		al3.add(123);
		al2.remove("hello");
		al2.removeAll(al3);
		System.out.println(al2);
		System.out.println(al.size());
		System.out.println(al.contains("hello"));
		al2.clear();
		System.out.println(al2);
		System.out.println(al.get(1));
		//System.out.println(al.get(10)); //IndexOutOfBoundsException
		al.retainAll(al3);
		System.out.println(al);
		al2.clear();
		System.out.println(al2);
		ArrayList al5 = (ArrayList) al.clone();
		System.out.println(al5);
		System.out.println(al.indexOf(5));
		System.out.println(al.lastIndexOf(5));
		System.out.println(al.toString());
		ArrayList al4 = new ArrayList();
		al4.add(123);
		al4.add(4);
		al4.add(5);
		al4.set(2, 7);
		System.out.println(al4);
		Integer[] a =(Integer[]) al4.toArray(new Integer[al4.size()]);
		for(Integer a1: a)
		{
			System.out.println(a1);
		}
		
	}

}
