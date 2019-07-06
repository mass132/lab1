package collections;

import java.util.Comparator;
import java.util.TreeSet;

/*
 * java.util.Comparator Interface
 * It has two methods
 * compare and equals
 */
	class MyComparator implements Comparator<String> {
		/*
		 * returns +ve when obj1 is less than obj2 
		 * returns -ve when obj1 is more than
		 * obj2 returns 0 when obj1 and obj2 are equal
		 */
		public int compare(String o1, String o2) {
			return -o1.compareTo(o2);
		}
	}

	public class ComparatorTest {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static void main(String[] args) {
			TreeSet ts = new TreeSet(new MyComparator());
			ts.add("hello");
			ts.add("Hello");
			ts.add("HELLO");
			ts.add("poonam");
			ts.add("poonaM");
			System.out.println(ts);
		}

}
