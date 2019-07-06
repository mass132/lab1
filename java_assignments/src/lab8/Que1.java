package lab8;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Que1 {
	/*
	 * Write a Java program that reads a line of integers and then displays each
	 * integer and the sum of all integers. (Use StringTokenizer class)?
	 */
	public static void sumOfInts(String numbers) {
		StringTokenizer strToken = new StringTokenizer(numbers);
		int sum = 0;
		while (strToken.hasMoreTokens()) {
			int num = Integer.parseInt(strToken.nextToken());
			System.out.print(num);
			System.out.print("\t");
			sum += num;
		}
		System.out.print("\nSum of the numbers is : ");
		System.out.print(sum);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Que1.sumOfInts(input);
		scan.close();

	}

}
