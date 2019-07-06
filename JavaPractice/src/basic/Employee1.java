package basic;

import java.util.Scanner;

public class Employee1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your Id");
		int empId = scan.nextInt();
		System.out.println("Enter your Name");
		String empName = scan.next();
		System.out.println("Enter your Salary");
		float empSalary = scan.nextFloat();
		System.out.println("Enter your Address");
		String empAdd = scan.next();
		empAdd += scan.nextLine();
		System.out.print("Employee ID : ");
		System.out.println(empId);
		System.out.print("Employee Name : ");
		System.out.println(empName);
		System.out.print("Employee Salary : ");
		System.out.println(empSalary);
		System.out.print("Employee Address : ");
		System.out.println(empAdd);
		scan.close();
	}

}
