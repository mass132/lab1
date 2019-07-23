package lab14.com.cg.eis.pl;

import java.util.Scanner;

import lab14.com.cg.eis.service.EmployeeService;
import lab14.com.cg.eis.service.EmployeeServiceI;

public class MainUi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id");
		int empId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee name");
		String empName = sc.nextLine();
		System.out.println("Enter employee salary");
		int empSal = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee designation");
		String empDesg = sc.nextLine();

		EmployeeServiceI empService = new EmployeeService();
		empService.setUserInformation(empId, empName, empSal, empDesg);
		System.out.println(empService.getUserData());
		sc.close();
	}

}
