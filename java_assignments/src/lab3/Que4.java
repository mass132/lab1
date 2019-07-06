package lab3;
import java.util.Hashtable;

public class Que4 {
	/* return the count of the chars present in the array */
	public static void countChar(char[] charArr)
	{

		 Hashtable<Character, Integer> myHash = new Hashtable<Character, Integer>();
		for(char myChar : charArr)
		{
			if(myHash.containsKey(myChar))
			{
				myHash.put(myChar,myHash.get(myChar) + 1);
			}
			else
			{
				myHash.put(myChar,1);
			}

		}
		System.out.println(myHash);
		
	}
	public static void main(String[] args) {
		char [] charArr = {'a','b','1','b'};
		Que4.countChar(charArr);

	}

}
