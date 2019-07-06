package collections;

import java.util.LinkedHashSet;

/* 
 * duplicates are not allowed,insertion order is preserved
 */
public class LinkedHashSetEx {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		LinkedHashSet set = new LinkedHashSet();
		set.add(6);
		set.add(5);
		set.add(8);
		set.add(5);
		set.add(7);
		System.out.println(set);

	}

}
