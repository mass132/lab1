package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Maptest {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		HashMap hs = new HashMap();//duplicate keys are not allowed -value is updated when found,Insertion order is not preserved ,key value pair is called entry
		hs.put("poonam", 25);
		hs.put("naresh", 100);
		hs.put("suresh", 7);
		hs.put("ramesh", 5);
		hs.put("poonam", 26);
		System.out.println(hs);
		System.out.println("+++++++++++++++++++++++++++++++");
		LinkedHashMap lhs = new LinkedHashMap();//Insertion order is preserved
		lhs.put("poonam", 25);
		lhs.put("naresh", 100);
		lhs.put("suresh", 7);
		lhs.put("ramesh", 5);
		lhs.put("poonam", 26);
		System.out.println(lhs);
		System.out.println("+++++++++++++++++++++++++++++++");
		TreeMap tm = new TreeMap();//return sorted by key
		tm.put("poonam", 25);
		tm.put("naresh", 100);
		tm.put("suresh", 7);
		tm.put("ramesh", 5);
		tm.put("poonam", 26);
		System.out.println(tm);
		System.out.println("+++++++++++++++++++++++++++++++");
		HashMap hs1 = new HashMap();//duplicate keys are not allowed -value is updated when found,Insertion order is not preserved ,key value pair is called entity
		hs1.put("poonam1", 25);
		hs1.put("naresh1", 100);
		hs1.put("suresh1", 7);
		hs1.put("ramesh1", 5);
		hs.putAll(hs1);
		System.out.println(hs);
		System.out.println(hs.get("poonam"));

		System.out.println(hs.isEmpty());
		System.out.println(hs.keySet());
		System.out.println(hs.values());

		System.out.println(hs.containsKey("poonam"));

		System.out.println(hs.containsKey("poonam12"));

		System.out.println(hs.containsValue(5));
		System.out.println(hs.entrySet());

		System.out.println(hs.putIfAbsent("poonam", 10));

		System.out.println(hs);
		System.out.println(hs.remove("poonam1"));
		System.out.println(hs);

		System.out.println(hs.remove("poonam",27));
		System.out.println(hs);
		System.out.println(hs.replace("poonam", 50));
		System.out.println(hs);
		
		
		

	}

}
