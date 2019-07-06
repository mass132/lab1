package lab1;

import java.util.Scanner;

public class Que3 {
	/* Check if a number is an increasing number */
	public static boolean checkNumber(int number) {
		boolean result = true;
		char[] num = Integer.toString(number).toCharArray();
		int numLength = num.length;
		if (numLength == 1) {
			return result;
		}
		for (int i = 1; i < numLength; i++) {
			if (num[i - 1] <= num[i]) {
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println(Que3.checkNumber(input));
		scan.close();

	}

}
