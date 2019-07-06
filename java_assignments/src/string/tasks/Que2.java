package string.tasks;

public class Que2 {
/*
 * Java program to convert all the words first letter 
 * into capital for given String? (String s=”java standard edition”)
 */
	public static String titleCase(String str)
	{
		String[] strArray = str.split(" ");
		String finalString = "";
		for(String thisString : strArray)
		{
			
			char[] charArray = thisString.toCharArray();
			charArray[0] = Character.toUpperCase(charArray[0]);
			String temp = new String(charArray);
			finalString = String.join(" ", finalString,temp);
			
		}
		return finalString.trim();
	}
	public static void main(String[] args) {
		String input = "hello my name is poonam";
		System.out.println(Que2.titleCase(input));
		

	}

}
