package lab9;

import java.util.HashMap;
import java.util.Map;

public class Que3 {
	/*
	 * Accepts a list of numbers and return their squares
	 */
	@SuppressWarnings("rawtypes")
	public static Map getSquares(int[] intArray)
	{
		HashMap<Integer,Integer> myHashMap = new HashMap<Integer,Integer>();
		for(int myInt : intArray)
		{
			int square = myInt * myInt;
			myHashMap.putIfAbsent(myInt, square);
		}
	return myHashMap;
		
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int [] intArray = {1,5,2,6,6};
		HashMap<Integer, Integer> myHashMap = (HashMap<Integer, Integer>) Que3.getSquares(intArray);
		System.out.println(myHashMap);

	}

}
