package lab9;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Que2 {
	@SuppressWarnings("rawtypes")
	private static Map countCharacter(char[] charArray) {
		HashMap<Character, Integer> myHashMap = new HashMap<Character,Integer>();
		for(char myChar : charArray)
		{
			if(myHashMap.containsKey(myChar))
			{
				myHashMap.replace(myChar, myHashMap.get(myChar) + 1);
				
			}
			else
			{
				myHashMap.putIfAbsent(myChar, 1);
			}
		}
		return myHashMap;

	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		char [] charArray = input.toCharArray();
		HashMap<Character, Integer> myHashMap = (HashMap<Character, Integer>) Que2.countCharacter(charArray);
		System.out.println(myHashMap);

	}

}
