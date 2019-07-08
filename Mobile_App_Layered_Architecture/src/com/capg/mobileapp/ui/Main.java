package com.capg.mobileapp.ui;

import java.util.Scanner;

import com.capg.mobileapp.beans.Account;
import com.capg.mobileapp.beans.AccountNotFoundException;
import com.capg.mobileapp.beans.InvalidMobileNoException;
import com.capg.mobileapp.dao.AccountDAO;
import com.capg.mobileapp.service.AccountService;
import com.capg.mobileapp.service.AccountServiceInterface;

public class Main {
	private AccountServiceInterface accountService = new AccountService(new AccountDAO());

	private void showMenu() {
		System.out.println("1.\tShow Details\n2.\tExit");
		System.out.println("Enter you choice : ");
	}

	private static String getMobile(Scanner scan) {
		System.out.println("Enter mobile number : ");
		String mobile = scan.next();
		return mobile;

	}

	private AccountServiceInterface getAccountService() {
		return accountService;
	}

	private void runApp() {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		while (run) {
			showMenu();
			int input = scan.nextInt();
			switch (input) {
			case 1:
				try {
				String mobile = getMobile(scan);
				AccountServiceInterface service = getAccountService();
				Account account = service.getAccountDetails(mobile);
				System.out.println("Customer Name : " + account.getName());
				System.out.println("Balance : " + account.getBalance());
				System.out.println("Account Type : " + account.getAccountType());
				}
				catch(InvalidMobileNoException e)
				{
					System.out.println(e.getMessage());
				}
				catch (AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 2:
				System.out.println("Exiting....");
				run = false;
				break;
			default:
				System.out.println("Invalid Input!\nPlease Try Again...");

			}
		}

	}

	public static void main(String[] args) {
		Main runObject = new Main();
		runObject.runApp();

	}

}
