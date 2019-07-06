package collections;

public class CompareToEx {
	/*
	 * present in java.lang.Comparable interface
	 * It has only one method
	 */

	/*
	 * returns -ve when obj1 is less than obj2
	 * returns +ve when obj1 is more than obj2
	 * returns 0 when obj1 and obj2 are equal
	 */
	public static void main(String[] args) {

		System.out.println("A".compareTo("Z"));

		System.out.println("Z".compareTo("K"));
		System.out.println("A".compareTo("A"));

	}

}
