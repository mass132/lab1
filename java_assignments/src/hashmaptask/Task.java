package hashmaptask;

import java.util.HashMap;
import java.util.Scanner;

public class Task {
	private static String takeMobile(Scanner scan) {
		System.out.println("Enter mobile number : ");
		String mobile = scan.next().trim();
		return mobile;

	}

	private static void start() {
		HashMap<String, Account> data = new HashMap<String, Account>();
		Account ac1 = new Account("raj", 100, "prepaid");
		Account ac2 = new Account("rythem", 10, "prepaid");
		Account ac3 = new Account("poonam", 250, "prepaid");
		Account ac4 = new Account("rajesh", 1000, "prepaid");
		Account ac5 = new Account("naresh", 1534, "prepaid");
		data.put("8468456789", ac1);
		data.put("4565645646", ac2);
		data.put("8468456745", ac3);
		data.put("9058473434", ac4);
		data.put("7899646467", ac5);
		String mobile;
		Account curAccount = null;
		while (true) {
			System.out.println("Enter you choice : ");
			System.out.println("1.\tShow Details\n2.\tRecharge\n3.\tExit");
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			switch (input) {
			case 1:
				if(curAccount != null)
				{
				mobile = Task.takeMobile(scan);
				curAccount = data.get(mobile);
				System.out.println(curAccount);
				}
				else
				{
					System.out.println("No data found for this mobile number.");
				}
				break;
			case 2:
				mobile = Task.takeMobile(scan);
				System.out.println("Enter the recharge amount : ");
				int amount = scan.nextInt();
				curAccount = data.get(mobile);
				if(curAccount != null)
				{
				if (curAccount.recharge(amount)) {
					System.out.println("Recharge Done!");
				} else {
					System.out.println("Recharge Failed!");
				}
				}
				else
				{
					System.out.println("No data found for this mobile number.");
				}
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Invalid Input");

			}
		}
	}

	public static void main(String[] args) {
		Task.start();

	}

}
