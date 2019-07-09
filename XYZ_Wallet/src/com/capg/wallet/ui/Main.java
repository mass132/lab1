package com.capg.wallet.ui;

import java.util.Scanner;

import com.capg.wallet.exceptions.AccountNotFoundException;
import com.capg.wallet.exceptions.IncorrectPasswordException;
import com.capg.wallet.exceptions.InvalidAmountException;
import com.capg.wallet.exceptions.InvalidDateException;
import com.capg.wallet.exceptions.InvalidMobileNoException;
import com.capg.wallet.exceptions.InvalidPasswordException;
import com.capg.wallet.exceptions.NameFormatException;
import com.capg.wallet.services.WalletService;
import com.capg.wallet.services.WalletServiceImpl;

public class Main {
	private void showMenu() {
		System.out.println(
				"XYZ Wallet\n***************************************************\n1.\tCreate Account\n2.\tDeposit\n3.\tWithdraw\n4.\tFund Transfer\n5.\tPrint Transaction\n6.\tExit\nPlease enter your choice : ");
	}

	private WalletService getWalletService() {
		return new WalletServiceImpl();
	}

	private void runApp() {
		Scanner scan = new Scanner(System.in);
		WalletService walletService = getWalletService();
		boolean run = true;
		while (run) {
			showMenu();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter your name : ");
					String name = scan.next();
					name += scan.nextLine().trim();
					System.out.println("Enter mobile number : ");
					String mobile = scan.next().trim();
					System.out.println("Enter your Date of Birth eg DD/MM/YYYY : ");
					String dob = scan.next().trim();
					System.out.println(
							"Create new password (Your password must contain 1 Uppercase, 1 Lowercase, 1 number and the length should be minimum 8 characterds long) :");
					String password = scan.next().trim();
					Long accountNum = walletService.createAccount(name, mobile, dob, password);
					if (accountNum != null) {
						System.out.println("Account created !\n");
						System.out.println("Your account number is " + accountNum);
						break;
					}
					System.out.println("Could not create the account !");
				} catch (NameFormatException | InvalidMobileNoException | InvalidDateException
						| InvalidPasswordException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Something went wrong!");
				}
				break;
			case 2:
				try {
					System.out.println("Enter account number : ");
					long accountNum = scan.nextLong();
					System.out.println("Enter amount : ");
					double amount = scan.nextDouble();
					System.out.println("Enter your password :");
					String password = scan.next().trim();
					String tranId = walletService.depositAmount(accountNum, amount, password);
					System.out.println("Deposit successful!");
					System.out.println("Transaction ID : " + tranId);
					break;
				} catch (AccountNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (InvalidAmountException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Something went Wrong!");
				}
				break;
			case 3:
				try {
					System.out.println("Enter account number : ");
					long accountNum = scan.nextLong();
					System.out.println("Enter amount : ");
					double amount = scan.nextDouble();
					System.out.println("Enter your password :");
					String password = scan.next().trim();
					String tranId = walletService.withdrawAmount(accountNum, amount, password);
					System.out.println("Withdraw successful!");
					System.out.println("Transaction ID : " + tranId);
				} catch (AccountNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (InvalidAmountException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Something went Wrong!");
				}
				break;
			case 4:
				try {
					System.out.println("Enter account number : ");
					long accountNum = scan.nextLong();
					System.out.println("Enter receiver account number : ");
					long accountNum_rec = scan.nextLong();
					System.out.println("Enter amount : ");
					double amount = scan.nextDouble();
					System.out.println("Enter your password :");
					String password = scan.next().trim();
					String tranId = walletService.fundTransfer(accountNum, accountNum_rec, amount, password);
					System.out.println("Fund Transfer successful!");
					System.out.println("Transaction ID : " + tranId);
				} catch (AccountNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (InvalidAmountException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					System.out.println("Enter account number : ");
					long accountNum = scan.nextLong();
					System.out.println("Enter your password :");
					String password = scan.next().trim();
					walletService.printTransactions(accountNum, password);
				} catch (AccountNotFoundException | IncorrectPasswordException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Something went wrong!");
				}
				break;
			case 6:
				System.out.println("Exiting...");
				run = false;
				break;
			default:
				System.out.println("Invalid Choice !");
			}
			System.out.println("Press Any Key to continue......");
			scan.nextLine();
		}

		scan.close();
	}

	public static void main(String[] args) {
		new Main().runApp();

	}

}
