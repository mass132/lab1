package lab13;

import java.util.List;
import java.util.Scanner;

public class EmployeeMain {

	static void Operations() {
		System.out.println("1. Employees List sorted by Department ID :");
		System.out.println("2. Employees List sorted by Employee ID :");
		System.out.println("3. Employees List sorted by name :");
		System.out.println("4. Salary Increment details :");
		System.out.println("5. Employees without Manager :");
		System.out.println("6. Employees without Department :");
		System.out.println("7. Sum of salary of all Employees is :");
		System.out.println("8. Exit");

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		EmployeeService es = new EmployeeService();
		List<Employee> elist = EmployeeRepository.getEmployees();

		while (true) {
			Operations();
			System.out.println("Please select operation :");
			String choice = sc.next().trim();

			switch (choice) {

			case "1":
				System.out.println("================================================");
				System.out.println(" Employees List sorted by Department ID :");
				List<Employee> e6 = es.sortByDept(elist);
				for (Employee employee : e6) {
					System.out.println(employee);
				}
				break;
			case "2":
				System.out.println("================================================");
				System.out.println(" Employees List sorted by Employee ID :");
				List<Employee> e5 = es.sortByEmployeeId(elist);
				for (Employee employee : e5) {
					System.out.println(employee);
				}
				break;
			case "3":
				System.out.println("================================================");
				System.out.println(" Employees List sorted by name :");
				List<Employee> e4 = es.sortByName(elist);
				for (Employee employee : e4) {
					System.out.println(employee);
				}
				break;
			case "4":
				System.out.println();
				System.out.println("================================================");
				System.out.println(" Salary Increment details :");
				List<String> e2 = es.getSalIncdetails(elist);
				for (String sal : e2) {
					System.out.println(sal);
				}
				break;
			case "5":
				System.out.println("================================================");
				System.out.println(" Employees without Manager :");
				List<Employee> e3 = es.getEmployeeWithoutManager(elist);
				for (Employee employee : e3) {
					System.out.println(employee);
				}
				break;
			case "6":
				System.out.println("================================================");
				System.out.println(" Employees without Department :");
				List<Employee> e1 = es.getEmployeeWithOutDepartment(elist);
				for (Employee employee : e1) {
					System.out.println(employee);
				}
				break;
			case "7":
				System.out.println("sum of salary of all Employees is:" + es.getSumOfSalary(elist));
				break;
			case "8":
				System.out.println("Thank you");
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid input");
				break;

			}

		}

	}

}
