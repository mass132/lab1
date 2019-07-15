package com.cg.eis.pl;

import java.util.Scanner;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

public class Main {
static Scanner scan = new Scanner(System.in);
static EmployeeService eService = new EmployeeServiceImpl();

	public static void showMenu() { // Prints the menu
		System.out.print(
				"1)\tGenerate Bill by entering Product code and quantity\n2)\tExit\nPlease enter your choice : ");
	}

	public static void process(){
		System.out.println("Enter name of the employee : ");
		String name = scan.nextLine().trim();
		System.out.println("Enter the salary : ");
		double salary = scan.nextDouble();
		System.out.println("Enter the designation : ");
		String designation = scan.nextLine().trim();
		Employee emp = new Employee(name, salary, designation);
		eService.findInsuranceScheme(emp);
		eService.displayEmployeeDetails(emp);

	}

	public static void run() {
		char run = 'y';
		do {
			showMenu();
			String choice = scan.next().trim(); //getting user choice for menu
			switch (choice) {
			case "1"://Start the product Processing
				
				break;
			case "2"://Exit
				System.out.println("Program closed!");
				System.exit(0);
				break;
			default:
				System.out.println("Please select a valid option!");
			}
			System.out.println("\nDo you want to continue? (y/n)......");
			run = scan.next().charAt(0);
		} while (run == 'y' || run == 'Y');
		scan.close();
		System.out.println("Bye!");
	}

	public static void main(String[] args) {
		run();
	}


}
