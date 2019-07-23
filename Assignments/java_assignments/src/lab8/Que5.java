package lab8;

import java.util.Scanner;

public class Que5 {
/*
 * Create a method that accepts a String and checks if it is a positive string.
 * A string is considered a positive string, 
 * if on moving from left to right each character in the String comes after the previous characters 
 * in the Alphabetical order. For Example: ANT is a positive String (Since T comes after N and N comes after A).
 *  The method should return true if the entered string is positive.
 */
	public static boolean checkPositiveString(String str) {
		char[] charArray = str.toCharArray();
		char currentChar = 'A';
		for(char myChar : charArray)
		{
			if(currentChar > myChar)
			{
				return false;
			}
			currentChar = myChar;
			
		}
		return true;

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		System.out.println(Que5.checkPositiveString(input));

	}

}
