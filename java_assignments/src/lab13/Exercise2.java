package lab13;

import java.util.Scanner;
import java.util.function.Function;
public class Exercise2 {
	public static String formatString(String string)//Takes a string and returns String with joined character with spaces
	{
		Function<String, String> f = str ->{return String.join(" ",str.split(""));};
		return f.apply(string);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next().trim();//String as input
		scan.close();
		String result = Exercise2.formatString(input);//Using the expression
		System.out.println(result);
	}

}