package lab3;

import java.util.Scanner;

public class Que2 {
	/* Sort the array and convert first half to Upper Case and the other half to Upper Case and return */
	public static String[] getSorted(String[] strArr) {
		int size = strArr.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (strArr[i].compareTo(strArr[j]) > 0) {//Compares the two strings alphabetically
					String temp = strArr[i];
					strArr[i] = strArr[j];
					strArr[j] = temp;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			if (i <= (size / 2) -1) {
				strArr[i] = strArr[i].toLowerCase();
			} else {
				strArr[i] = strArr[i].toUpperCase();
			}
		}
		return strArr;

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] myArr = scan.nextLine().split(" ");
		String[] result = Que2.getSorted(myArr);//Calling getSorted
		for(String str : result)
		{
			System.out.println(str);
		}
		scan.close();
			
	}

}
