package lab1;

import java.util.Scanner;

public class Que4 {
	/* Checks if the entered number is a power of two or not */
	public static boolean checkNumber(int n) {
		while (n != 1) {
			if (n % 2 != 0) {
				return false;
			}

			n /= 2;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println(Que4.checkNumber(input));
		scan.close();

	}

}
