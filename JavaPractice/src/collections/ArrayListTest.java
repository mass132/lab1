package collections;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		Employee emp = new Employee();

		Employee emp1 = new Employee();
		emp1.setEmpLoc("Bhilai");
		emp1.setEmpName("NewName");
		emp1.setEmpSalary(250000);
		emp1.setEmpId(5);
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(emp);
		al.add(emp1);
		System.out.println(al);
	}

}
