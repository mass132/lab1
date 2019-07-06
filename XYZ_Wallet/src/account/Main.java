package account;

import java.util.Scanner;

public class Main {

	public static void initialize() {
		Account acc1 = new Account();
		acc1.createAccount("poonam", "7897894561");
		acc1.setBalance(5000);
		acc1.withdraw(500);
		acc1.deposit(5000);
		Account acc2 = new Account();
		acc2.createAccount("raj", "7136484655");
		acc2.setBalance(4856);
		acc2.withdraw(1000);
		acc2.deposit(5000);
		acc1.fundTransfer(2, 520);
		acc2.fundTransfer(1, 100);

	}

	@SuppressWarnings({ "unused", "resource" })
	public static void runProgram() {
		long accNum;
		double amount;
		long accNum_second;
		Scanner scan;

		while (true) {
			scan = new Scanner(System.in);
			System.out.println(
					"XYZ Wallet\n***************************************************\n1.\tCreate Account\n2.\tDeposit\n3.\tWithdraw\n4.\tFund Transfer\n5.\tPrint Transaction\n6.\tExit\nPlease enter your choice : ");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your name : ");
				String name = scan.next();
				name += scan.nextLine().trim();
				System.out.println("Enter mobile number : ");
				String mobile = scan.nextLine().trim();
				Account temp_account = new Account();
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
