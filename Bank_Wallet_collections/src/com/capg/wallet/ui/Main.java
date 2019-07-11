package com.capg.wallet.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.capg.wallet.exceptions.AccountNotFoundException;
import com.capg.wallet.exceptions.IncorrectPasswordException;
import com.capg.wallet.exceptions.InsufficientFundException;
import com.capg.wallet.exceptions.InvalidAmountException;
import com.capg.wallet.exceptions.InvalidDateException;
import com.capg.wallet.exceptions.InvalidMobileNoException;
import com.capg.wallet.exceptions.InvalidPasswordException;
import com.capg.wallet.exceptions.InvalidReceiverException;
import com.capg.wallet.exceptions.NameFormatException;
import com.capg.wallet.services.WalletService;
import com.capg.wallet.services.WalletServiceImpl;

public class Main {
	private void showMenu() {
		System.out.println(
				"***************************************************\n\t\tXYZ Wallet\n***************************************************\n1.\tCreate Account\n2.\tShow Balance\n3.\tDeposit\n4.\tWithdraw\n5.\tFund Transfer\n6.\tPrint Transactions\n7.\tExit\n***************************************************\nPlease enter your choice : ");
	}

	private WalletService getWalletService() {
		return new WalletServiceImpl();
	}

	private void runApp() {
		Scanner scan = new Scanner(System.in);
		WalletService walletService = getWalletService();
		char run = 'y';
		do {
			showMenu();
			int choice;
			try {
				choice = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Something went wrong!");
				System.out.println("Please try again!");
				continue;
			}
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
					String accountNum = walletService.createAccount(name, mobile, dob, password);
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
					String accountNum = scan.next().trim();
					System.out.println("Enter your password :");
					String password = scan.next().trim();
					walletService.showBalance(accountNum, password);
				} catch (AccountNotFoundException | IncorrectPasswordException e) {
					System.out.println(e.getMessage());
				} 
				break;
			case 3:
				try {
					System.out.println("Enter account number : ");
					String accountNum = scan.next().trim();
					System.out.println("Enter amount : ");
					double amount = scan.nextDouble();
					System.out.println("Enter your password :");
					String password = scan.next().trim();
					String tranId = walletService.depositAmount(accountNum, amount, password);
					System.out.println("Deposit successful!");
					System.out.println("Transaction ID : " + tranId);
					break;
				} catch (AccountNotFoundException | InvalidAmountException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Something went Wrong!");
				}
				break;
			case 4:
				try {
					System.out.println("Enter account number : ");
					String accountNum = scan.next().trim();
					System.out.println("Enter amount : ");
					double amount = scan.nextDouble();
					System.out.println("Enter your password :");
					String password = scan.next().trim();
					String tranId = walletService.withdrawAmount(accountNum, amount, password);
					System.out.println("Withdraw successful!");
					System.out.println("Transaction ID : " + tranId);
				} catch (AccountNotFoundException | InvalidAmountException | InsufficientFundException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Something went Wrong!");
				}
				break;
			case 5:
				try {
					System.out.println("Enter account number : ");
					String accountNum = scan.next().trim();
					System.out.println("Enter receiver account number : ");
					String accountNumTo = scan.next().trim();
					System.out.println("Enter amount : ");
					double amount = scan.nextDouble();
					System.out.println("Enter your password :");
					String password = scan.next().trim();
					String tranId = walletService.fundTransfer(accountNum, accountNumTo, amount, password);
					System.out.println("Fund Transfer successful!");
					System.out.println("Transaction ID : " + tranId);
				} catch (AccountNotFoundException | InvalidAmountException | InsufficientFundException | InvalidReceiverException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Something went Wrong!");
				}
				break;
			case 6:
				try {
					System.out.println("Enter account number : ");
					String accountNum = scan.next().trim();
					System.out.println("Enter your password :");
					String password = scan.next().trim();
					walletService.printTransactions(accountNum, password);
				} catch (AccountNotFoundException | IncorrectPasswordException e) {
					System.out.println(e.getMessage());
				} 
				break;
			case 7:
				System.out.println("Exiting...");
				run = 'n';
				break;
			default:
				System.out.println("Invalid Choice !");
			}
			System.out.println("\nDo you want to continue? (y/n)......");
			run = scan.next().charAt(0);

		}while (run == 'y' || run == 'Y');
		scan.close();
		System.out.println("Bye!");
	}
	@SuppressWarnings("unused")
	private void initialize() {
		WalletService walletService = getWalletService();
		try {
			String acc1 = walletService.createAccount("poonam", "6234567890", "12/12/2018", "qwerty12");
			String acc2 = walletService.createAccount("poonamchand", "8034567890", "12/12/1997", "qwerty12");
			walletService.depositAmount(acc1, 50000, "qwerty12");
			walletService.depositAmount(acc2, 10000, "qwerty12");
			walletService.depositAmount(acc2, 1123, "qwerty12");
			walletService.withdrawAmount(acc1, 1500, "qwerty12");
			walletService.withdrawAmount(acc2, 1500, "qwerty12");
			walletService.fundTransfer(acc1, acc2, 2000, "qwerty12");
			walletService.fundTransfer(acc2, acc1, 200, "qwerty12");
			walletService.fundTransfer(acc1, acc2, 3000, "qwerty12");
			System.out.println("Testing account numbers are : "+acc1+" and "+ acc2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Main obj = new Main();
		obj.initialize();
		obj.runApp();
	}

	

}
