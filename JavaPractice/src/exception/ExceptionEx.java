package exception;

import java.util.Scanner;

public class ExceptionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
	int num1 = scan.nextInt();
	int num2 = scan.nextInt();
	try {
		int result = num1 / num2;
		System.out.println(result);
		
	}
	catch(ArithmeticException e)
	{
		System.out.println("do not enter zero as denominator");

		e.printStackTrace();
		System.out.println(e);
		System.out.println("]]]]]]]]]]]]]]]]]]");
		System.out.println(e.getLocalizedMessage());
		System.out.println("===");
		System.out.println(e.getMessage());
		System.out.println("===");
		System.out.println("===");
		System.out.println(e.getCause());
		
	}
	finally {
		scan.close();
	}
	System.out.println("Remaining lines of code");

	}

}
