package com.capg.wallet.ui;

import java.util.Scanner;

import com.capg.wallet.services.AccountServiceInterface;

public class Main {
	private void showMenu()
	{
		System.out.println(
				"XYZ Wallet\n***************************************************\n1.\tCreate Account\n2.\tDeposit\n3.\tWithdraw\n4.\tFund Transfer\n5.\tPrint Transaction\n6.\tExit\nPlease enter your choice : ");
	}
	private void runApp() {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		while (run) {
			showMenu();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your name : ");
				String name = scan.next();
				name += scan.nextLine().trim();
				System.out.println("Enter mobile number : ");
				String mobile = scan.next().trim();
				AccountServiceInterface accountService = getAccountService();
				if (temp_account.createAccount(name, mobile)) {
					System.out.println("Account created !\n");
					System.out.println(temp_account);
					break;
				}
				System.out.println("Could not create the account !");
				break;
			case 2:
				System.out.println("Enter account number : ");
				accNum = scan.nextLong();
				System.out.println("Enter amount : ");
				amount = scan.nextDouble();
				if (Account.accountData.containsKey(accNum)) {
					Account thisAcc = Account.accountData.get(accNum);
					if (thisAcc.withdraw(amount)) {
						System.out.println("Deposit successful!");
						break;
					}

				}
				System.out.println("Deposit failed!");
				break;
			case 3:
				System.out.println("Enter account number : ");
				accNum = scan.nextLong();
				System.out.println("Enter amount : ");
				amount = scan.nextDouble();
				if (Account.accountData.containsKey(accNum)) {
					Account thisAcc = Account.accountData.get(accNum);
					if (thisAcc.withdraw(amount)) {
						System.out.println("Withdraw successful!");
						break;
					}

				}
				System.out.println("Withdraw failed!");
				break;
			case 4:
				System.out.println("Enter your account number : ");
				accNum = scan.nextLong();
				System.out.println("Enter receiver account number : ");
				accNum_second = scan.nextLong();
				System.out.println("Enter amount : ");
				amount = scan.nextDouble();
				if (Account.accountData.containsKey(accNum)) {
					Account thisAcc = Account.accountData.get(accNum);
					if (thisAcc.fundTransfer(accNum_second, amount)) {
						System.out.println("Fund Transfer successful!");
						break;
					}
				}
				System.out.println("Fund Transfer failed!");
				break;
			case 5:
				System.out.println("Enter account number : ");
				accNum = scan.nextLong();
				if (Account.accountData.containsKey(accNum)) {
					Account thisAcc = Account.accountData.get(accNum);
					thisAcc.printTransactions();

					break;
				}
				System.out.println("No data found!");
				break;
			case 6:
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice !");
			}
			System.out.println("Press Any Key to continue......");
			String temp = scan.nextLine();
			//scan.close();
		}

	}

	public static void main(String[] args) {
		Main.initialize();
		Main.runProgram();

	}

}
