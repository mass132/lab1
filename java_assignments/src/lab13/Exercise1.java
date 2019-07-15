package lab13;

import java.util.Scanner;
import java.util.function.BiFunction;



public class Exercise1 {
	public static int pow(int a,int b)// Takes two integer arguments and returns the a ^ b;
	{
		BiFunction<Integer, Integer, Integer> f = (x,y) -> (int)Math.pow(x, y);
		return f.apply(a, b);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");// input format is 'A B' where A and B are integers
		int num1 = Integer.parseInt(input[0]);
		int num2 = Integer.parseInt(input[1]);
		scan.close();
		int result = Exercise1.pow(num1, num2);// Using the expression
		System.out.println(result);
	}

}