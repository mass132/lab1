package lab5;

import java.util.Scanner;

public class Que3 {
	/* prints all the prime numbers upto a given range */
	public static void primeNumbers(int n) {
		/*
		 * Using Sieve of Eratosthenes
		 */
		boolean isPrime[] = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i] == true) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (isPrime[i] == true)
				System.out.println(i);
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		Que3.primeNumbers(input);
		scan.close();

	}

}
