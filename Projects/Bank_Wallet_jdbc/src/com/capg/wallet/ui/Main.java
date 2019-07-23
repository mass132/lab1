package com.capg.wallet.ui;

import java.util.Scanner;

import com.capg.wallet.services.WalletService;
import com.capg.wallet.services.WalletServiceImpl;
import com.capg.wallet.utils.AccountNotFoundException;
import com.capg.wallet.utils.IncorrectPasswordException;
import com.capg.wallet.utils.InsufficientFundException;
import com.capg.wallet.utils.InvalidAmountException;
import com.capg.wallet.utils.InvalidDateException;
import com.capg.wallet.utils.InvalidMobileNoException;
import com.capg.wallet.utils.InvalidPasswordException;
import com.capg.wallet.utils.InvalidReceiverException;
import com.capg.wallet.utils.NameFormatException;
import com.capg.wallet.utils.Utils;

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
			String choice = "";
			choice = scan.next().trim();
			switch (choice) {
			case "1":
				try {
					System.out.println("Enter your name : ");
					String name = scan.next();
					name += scan.nextLine().trim();
					Utils.validateName(name);
					System.out.println("Enter mobile number : ");
					String mobile = scan.next().trim();
					Utils.validateMobile(mobile);
					System.out.println("Enter your Date of Birth eg DD/MM/YYYY : ");
					String dob = scan.next().trim();
					Utils.validateDate(dob);
					System.out.println(
							"Create new password (Your password must contain 1 Uppercase, 1 Lowercase, 1 number and the length should be minimum 8 characterds long) :");
					String password = scan.next().trim();
					Utils.validatePassword(password);
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
					//e.printStackTrace();
				}
				break;
			case "2":
				try {
					System.out.println("Enter account number : ");
					String accountNum = scan.next().trim();
					System.out.println("Enter your password :");
					String password = scan.next().trim();
					walletService.showBalance(accountNum, password);
				} catch (AccountNotFoundException | IncorrectPasswordException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "3":
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
					// System.out.println("Something went Wrong!");
					e.printStackTrace();
				}
				break;
			case "4":
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
					// System.out.println("Something went Wrong!");
					e.printStackTrace();
				}
				break;
			case "5":
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
				} catch (AccountNotFoundException | InvalidAmountException | InsufficientFundException
						| InvalidReceiverException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					// System.out.println("Something went Wrong!");
					e.printStackTrace();
				}
				break;
			case "6":
				try {
					System.out.println("Enter account number : ");
					String accountNum = scan.next().trim();
					System.out.println("Enter your password :");
					String password = scan.next().trim();
					walletService.printTransactions(accountNum, password);
				} catch (AccountNotFoundException | IncorrectPasswordException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					// System.out.println("Something went Wrong!");
					e.printStackTrace();
				}
				break;
			case "7":
				System.out.println("Program closed");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice !");
			}
			System.out.println("\nDo you want to continue? (y/n)......");
			run = scan.next().charAt(0);
		} while (run == 'y' || run == 'Y');
		scan.close();
		System.out.println("Bye!");
	}

	public static void main(String[] args) {
		System.out
				.println("Testing account numbers are : SDA1234567890 and SDA1234567891 and password is : Qwerty123_");
		Main obj = new Main();
		obj.runApp();
	}

}
