package collections;

import java.util.TreeSet;

/* 
 * duplicates are not allowed,returns  in sorted order
 */
public class TreeSetEx {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		set.add(6);
		set.add(5);
		set.add(8);
		set.add(5);
		set.add(7);
		System.out.println(set);

	}

}
