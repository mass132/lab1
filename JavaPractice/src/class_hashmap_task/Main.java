package class_hashmap_task;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Rythem", "Chennai");
		Employee e2 = new Employee(2, "Rythem", "Chennai");
		Employee e3 = new Employee(3, "Rythem", "Chennai");
		HashMap<Integer,Employee> emp = new HashMap<Integer,Employee>();
		emp.put(e1.getId(), e1);
		emp.put(e2.getId(), e2);
		emp.put(e3.getId(), e3);
		Set<Entry<Integer, Employee>> set = emp.entrySet();
		Iterator<Entry<Integer, Employee>> itr = set.iterator();
		while(itr.hasNext())
		{
			Entry<Integer,Employee> er = itr.next();
			Employee e = er.getValue();
			System.out.println("Employee Id : "+e.getId() +", Employee Name : "+e.getName()+", Employee Location : "+e.getLocation());
		}
		

	}

}
