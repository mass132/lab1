package lab13;

import java.util.Scanner;

interface MyLambda
{
	public int myMethod(int x,int y);
}

public class Excercise2 {

	public static void main(String[] args) {

		MyLambda myLambda = (a,b)->a;//Takes two integer arguments and returns the first argument
		
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");//input format is 'A B' where A and B are integers
		int num1 = Integer.parseInt(input[0]);
		int num2 = Integer.parseInt(input[1]);
		scan.close();
		int result = myLambda.myMethod(num1, num2);//Using the expression
		System.out.println(result);
	}

}