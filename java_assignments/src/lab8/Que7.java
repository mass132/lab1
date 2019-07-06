package lab8;

import java.util.Scanner;

public class Que7 {
	/*
	 * You are asked to create an application for registering the details of
	 * jobseeker. The requirement is: Username should always end with _job and there
	 * should be at least minimum of 8 characters to the left of _job. Write a
	 * function to validate the same. Return true in case the validation is passed.
	 * In case of validation failure return false.
	 */
	public static boolean validate(String username) {
		String regex = ".{8,}_job$";
		return username.matches(regex);

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		System.out.println(Que7.validate(input));

	}

}
