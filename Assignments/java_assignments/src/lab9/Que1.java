package lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
@SuppressWarnings("rawtypes")
class myComparator implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		Integer i1 = (Integer) o1;
		Integer i2 = (Integer) o2;
		return i1.compareTo(i2);
	}
}
public class Que1 {
	/*
	 * Get the values of a map in sorted order
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List getValues(HashMap myHashMap) {
		List myList = new ArrayList(myHashMap.values());
		myList.sort(new myComparator());
		return myList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		HashMap myHashMap = new HashMap();
		myHashMap.put('a', 1);
		myHashMap.put('b', 100);
		myHashMap.put(10, 43);
		myHashMap.put(535, 453);
		System.out.println(Que1.getValues(myHashMap));

	}

}
