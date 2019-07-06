package lab3;

import java.util.Arrays;

/* Return the resulting array after reversing the numbers and sorting it */
public class Que3 {
	public static int[] getSorted(int[] myArr) {
		int length = myArr.length;
int[] resArray = new int[length];
	for(int i = 0;i < length;i++)
	{
		StringBuilder num = new StringBuilder(Integer.toString(myArr[i]));
		num.reverse();
		resArray[i] = Integer.valueOf(num.toString());
		
	}
	Arrays.sort(resArray);
	return resArray;
}
	public static void main(String[] args) {
		int[] intArray = {225,25,684,7454,746};
		int[] resArray = Que3.getSorted(intArray);
		for(int num : resArray)
		{
			System.out.println(num);
		}
		
	}
}