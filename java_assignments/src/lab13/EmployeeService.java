package lab13;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

	public Double getSumOfSalary(List<Employee> elist) {
		double sum = elist.stream().map(e -> e.getSalary()).collect(Collectors.summingDouble(sal -> sal));
		return sum;
	}

	public List<Employee> getEmployeeWithOutDepartment(List<Employee> elist) {
		List<Employee> e1 = elist.stream().filter(e -> e.getDepartment() == null).collect(Collectors.toList());
		return e1;

	}

	public List<String> getSalIncdetails(List<Employee> elist) {
		List<String> e2 = elist.stream().map(e -> e.getFirstName() + " " + e.getLastName() + " " + e.getSalary() + " "
				+ (e.getSalary() + e.getSalary() * 0.15)).collect(Collectors.toList());
		return e2;

	}

	public List<Employee> getEmployeeWithoutManager(List<Employee> elist) {
		List<Employee> e3 = elist.stream().filter(e -> e.getManagerId() == null).collect(Collectors.toList());
		return e3;
	}

	public List<Employee> sortByName(List<Employee> elist) {

		Comparator<Employee> fname = (e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName());
		List<Employee> e4 = elist.stream().sorted(fname).collect(Collectors.toList());
		return e4;
	}

	public List<Employee> sortByEmployeeId(List<Employee> elist) {

		Comparator<Employee> eid = (e1, e2) -> e1.getEmployeeID().compareTo(e2.getEmployeeID());
		List<Employee> e5 = elist.stream().sorted(eid).collect(Collectors.toList());
		return e5;
	}

	public List<Employee> sortByDept(List<Employee> elist) {

		Comparator<Employee> deptId = (e1, e2) -> e1.getDepartment().getDepartmentId()
				.compareTo(e2.getDepartment().getDepartmentId());
		List<Employee> e6 = elist.stream().filter(e -> e.getDepartment() != null).sorted(deptId)
				.collect(Collectors.toList());
		List<Employee> e7 = elist.stream().filter(e -> e.getDepartment() == null).collect(Collectors.toList());
		e6.addAll(e7);
		return e6;
	}

}
