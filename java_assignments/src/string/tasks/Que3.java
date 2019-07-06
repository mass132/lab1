package string.tasks;

public class Que3 {
/*
 * Java program to  test if a given string contains 
 * the specified sequence of char values….match()
 */
	public static boolean checkSubstring(String str,char[] charArray)
	{
		return str.contains(new String(charArray));
	}
	public static void main(String[] args) {
		String myString = "This is a line that contains my name. My name is Poonam Chand Sahu.";
		char[] searchChar = {'P','o','o','n','a','m'};
		System.out.println(Que3.checkSubstring(myString, searchChar));

	}

}
