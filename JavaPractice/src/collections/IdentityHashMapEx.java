package collections;

import java.util.IdentityHashMap;
/*
 * added in java 1.0(lagacy)
 * It uses == operator ,so compares the reference of key before adding value
 * whereas hashmap uses equals method
 */
public class IdentityHashMapEx {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		IdentityHashMap ihm = new IdentityHashMap();
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
		ihm.put(i1, "hello");
		ihm.put(i2, "hello");
		System.out.println(ihm);

	}

}
