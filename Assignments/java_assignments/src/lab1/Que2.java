package lab1;

import java.util.Scanner;

public class Que2 {
	/* Calculate the difference */
	public static int calculateDifference(int n) {
		int sumOfSquares = (n * (n + 1) * (2 * n + 1)) / 6;
		int sumOfN = (n * (n + 1)) / 2;
		int squareOfSum = sumOfN * sumOfN;
		int diff = Math.abs(sumOfSquares - squareOfSum);
		return diff;

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println(Que2.calculateDifference(input));
		scan.close();

	}
}
