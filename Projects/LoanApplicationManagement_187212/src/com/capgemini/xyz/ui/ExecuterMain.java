package com.capgemini.xyz.ui;

import java.util.Scanner;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;
import com.capgemini.xyz.dao.LoanAppException;
import com.capgemini.xyz.service.ILoanService;
import com.capgemini.xyz.service.LoanService;

public class ExecuterMain {
	private static final Scanner scan = new Scanner(System.in);
	private static final ILoanService loanService = new LoanService();

	public static ILoanService getLoanService() {
		return loanService;
	}

	public static void showMenu() { // Prints the menu
		System.out.println("XYZ Finance Company welcomes you\n1. Register Customer\n2. Exit");
	}

	public static void registerCust() throws LoanAppException {
		System.out.println("Enter Customer Name");
		String name = scan.next();
		name += scan.nextLine().trim();// input name from the client
		System.out.print("Enter Address");
		String address = scan.nextLine().trim();// input the address from the client
		System.out.print("Enter Email");
		String email = scan.next().trim();// input email from the client
		Customer cust = new Customer(name, address, email);
		long custId = getLoanService().insertCust(cust);

		System.out.println("Customer information saved successfully.");
		System.out.println("Yout Customer Id is " + custId);
		System.out.println("Do you wish to apply for Loan?(Yes/No)");
		boolean loanChoice = scan.next().trim().equalsIgnoreCase("yes");
		if (loanChoice) {
			applyLoan(custId);
		} else {
			System.out.println(cust);

		}

	}

	public static void applyLoan(long custId) {
		System.out.println("Enter the loan amount");
		double amount = Double.parseDouble(scan.next());// input the Enquiry Id from the client
		System.out.println("Enter the loan duration");
		int duration = Integer.parseInt(scan.next());// input the Enquiry Id from the client
		Loan loan = new Loan(amount, custId, duration);
		double emi = getLoanService().calculateEMI(amount, duration);
		System.out.println("For loan amount Rs. " + amount + " and " + duration + " months duration.");
		System.out.println("Your EMI per month will be " + emi);
		System.out.println("Do you want to apply fo loan now?(Yes/No)");
		boolean loanChoice = scan.next().trim().equalsIgnoreCase("yes");
		if (loanChoice) {
			getLoanService().applyLoan(loan);
			System.out.println("Your Loan request is generated.");
			System.out.println("Your Loan ID is " + loan.getLoanID());
			System.out.println(((LoanService) getLoanService()).getCustomerDetails(custId));
			System.out.println(loan);
		}
	}

	public static void run() {
		char run = 'y';
		do {
			showMenu();
			String choice = scan.next().trim(); // getting user choice for menu
			switch (choice) {
			case "1":// Register Customer
				try {
					registerCust();
				} catch (LoanAppException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					// System.out.println("Something went wrong!");
					e.printStackTrace();
				}
				break;
			case "":// Exit
				System.out.println("Thank You for using our service!");
				System.exit(0);
				break;
			default:
				System.out.println("Please select a valid option!");
			}
			System.out.println("\nDo you want to continue? (y/n)......");
			run = scan.next().charAt(0);
		} while (run == 'y' || run == 'Y');
		scan.close();
	}

	public static void main(String[] args) throws LoanAppException {
		run();
	}

}
