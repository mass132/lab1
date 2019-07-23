package string.tasks;

public class Que5 {
/*
 * Count the number of words present in the given string.
 */
	public static int countWords(String myString)
	{
		String strArray[] = myString.split(" ");
		return strArray.length;
	}
	public static void main(String[] args) {
		String myString = "hello I'm a sentence.";
		System.out.println(Que5.countWords(myString));

	}

}
