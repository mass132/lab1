package string.tasks;

public class Que8 {
/*
 * Convert the word from small letter to capital letter 
 * word in  given  String ?String s =”b.v.raju college”    //convert raju  into capital.
 */
	public static String wordToUpper(String myStr, String word)
	{
		return myStr.replaceAll(word, word.toUpperCase());
	}
	public static void main(String[] args) {
		String myStr = "b.v.raju college";
		String word = "raju";
		System.out.println(Que8.wordToUpper(myStr,word));

	}

}
