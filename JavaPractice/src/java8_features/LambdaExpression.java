package java8_features;

import java.util.Scanner;

/*
 * functional interface -which contains only one abstract method.
 */
@FunctionalInterface
interface Favourite
{
	public int length(String s);
}
public class LambdaExpression {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		String string = scan.next().trim();
		Favourite f = s->s.length();
		System.out.println(f.length(string));
		scan.close();
		//System.out.println(f.add(5,6));

	}

}
