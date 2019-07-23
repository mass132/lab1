package string.tasks;

public class Que7 {
/*
 * 1)	Convert the second occurrence of ‘ l ’ 
 * into  capital from “bvrit college”.
 */
	
	public static void main(String[] args) {
		String myStr = "bvrit college";
		int index = myStr.indexOf('l');
		index = myStr.indexOf('l',index + 1);
		char[] charArray = myStr.toCharArray();
		charArray[index] = Character.toUpperCase(charArray[index]);
		String result = new String(charArray);
		System.out.println(result);

	}

}
