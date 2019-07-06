package string.tasks;

public class Que1 {
	/*
	 * Java program to get the character at the given index within the String.
	 */
	public static char getCharAt(String str,int index)
	{
		return str.charAt(index);
	}
	public static void main(String[] args) {
		char myChar = Que1.getCharAt("hello", 3);
		System.out.println(myChar);

	}

}
