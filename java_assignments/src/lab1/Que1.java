package lab1;

import java.util.Scanner;

public class Que1 {

	/* Calculate Sum */
	public static int calculateSum(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if ((i % 3 == 0) || (i % 5 == 0)) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println(Que1.calculateSum(input));
		scan.close();

	}

}
