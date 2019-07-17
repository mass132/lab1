package task1;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Task {
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public static void main(String[] args) {
		HashMap<Long, Emp> data = new HashMap<Long, Emp>();
		Emp e1 = new Emp(10, "pc", "doctor");

		Emp e2 = new Emp(11, "sumit", "senior doctor");
		Emp e3 = new Emp(12, "poonam", "junior doctor");
		data.put(e1.getId(), e1);
		data.put(e3.getId(), e3);
		data.put(e2.getId(), e2);
		Set<Entry<Long, Emp>> s = data.entrySet();
		s.stream().forEach((e) -> {
			System.out.println(e.getValue());
		});

	}

}
