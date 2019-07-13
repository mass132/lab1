package concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class CHMEx {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ConcurrentHashMap chm = new ConcurrentHashMap<>();
		chm.put(12, "hello");
		chm.put(23, 34);
		chm.put(23, "hi");
		chm.putIfAbsent(25, "poonam");
		chm.putIfAbsent(23, "rythem");//it will not overwrite the value
		chm.remove(12,"hello");//removes if key with same value is present
		chm.replace(23,"hi",12);//replace if key with same value is present
		System.out.println(chm);
	}

}
