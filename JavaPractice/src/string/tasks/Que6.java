package string.tasks;

public class Que6 {
/*
 * Print the capital letters from string
 */
	public static void printCaps(String myString)
	{
		char[] charArray = myString.toCharArray();
		for(char myChar : charArray)
		{
			if((myChar >= 65) && (myChar <= 90))
			{
				System.out.print(myChar);
				System.out.print("\t");
			}
		}
	}
	public static void main(String[] args) {
		String str = "This is a Capital Word HELLO";
		Que6.printCaps(str);

	}

}
