package lab13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

	static List<Employee> elist = new ArrayList<>();
	static List<Department> dlist = new ArrayList<>();

	public static List<Department> getDepartments() {

		dlist.add(new Department(10, "IT", 100));
		dlist.add(new Department(20, "Sales", 101));
		dlist.add(new Department(30, "Marketing", 102));
		dlist.add(new Department(40, "HR", 103));
		return dlist;

	}

	public static List<Employee> getEmployees() {

		elist.add(new Employee(100, "Ram", "sinha", "ram@cg.com", "9398720557", LocalDate.of(2012, 5, 25), "President",
				50000.00, null, new Department(10, "IT", 100)));
		elist.add(new Employee(101, "kavya", "Ande", "kavya@cg.com", "6301795725", LocalDate.of(2011, 6, 12),
				"sales_mrg", 450000.00, 100, null));
		elist.add(new Employee(102, "usmitha", "Kandukuri", "kusmitha@cg.com", "9666370099", LocalDate.of(2010, 5, 06),
				"sales_mrg", 50000.00, 100, new Department(20, "Sales", 101)));
		elist.add(new Employee(103, "Prasanth", "Guttula", "srpg@cg.com", "9398720558", LocalDate.of(2019, 3, 03),
				"Marketing", 30000.00, 100, new Department(30, "Marketing", 102)));
		elist.add(new Employee(104, "venu", "singh", "venu@cg.com", "9398720057", LocalDate.of(2014, 3, 22),
				"Marketing", 25000.00, 100, new Department(30, "Marketing", 102)));
		elist.add(new Employee(105, "jagadesh", "jallu", "jaggu@cg.com", "9398720517", LocalDate.of(2016, 4, 12),
				"sales_mrg", 45000.00, 100, null));
		elist.add(new Employee(106, "Debasish", "singh", "dev@cg.com", "9394720557", LocalDate.of(2012, 5, 15), "HR",
				35000.00, 105, new Department(10, "IT", 101)));
		elist.add(new Employee(107, "rahul", "kumar", "ramg@cg.com", "9398720557", LocalDate.of(2013, 2, 18),
				"Trainer_mrg", 22000.00, null, new Department(10, "IT", 100)));
		return elist;

	}
}
