package lab3;

import java.util.Arrays;

public class Que1 {
	/* Get the second smallest element in the array */
	public static int getSecondSmallest(int[] arr) {
		Arrays.sort(arr);
		int secondSmallest = 0, smallest = arr[0];
		for (int num : arr) {
			if (num > smallest) {
				secondSmallest = num;
				break;
			}
		}
		return secondSmallest;
	}

	public static void main(String[] args) {
		int[] numArray = { 2, 7, 3, 7, 8 };
		System.out.println(Que1.getSecondSmallest(numArray));

	}

}
