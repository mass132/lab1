package collections;

import java.util.HashSet;
/* 
 * duplicates are not allowed,insertion order is not preserved
 */
public class HashSetEx {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add(6);
		set.add(5);
		set.add(8);
		set.add(5);
		set.add(7);
		System.out.println(set);

	}

}
