package lab4;

import java.util.Scanner;
public class Que1 {
	public static int getCubeSum(int n)
	{
		int sum = 0;
		while(n != 0)
		{
			int rem = n % 10;
			sum += rem * rem * rem;
			n /= 10;
			
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println(Que1.getCubeSum(input));
		scan.close();

	}

}
