package java8_features;

import java.util.function.Predicate;

public class TestPredicate {

	public static void main(String[] args) {
		Predicate<Integer> p = a -> a%2 == 0;
		Predicate<Integer> p1 = a ->a > 10;
		int[] list = {1,2,3,4,5,6,71,3,24,623,62,627,66};
		for(int i : list)
		{
			if(p.and(p1).test(i))//p and p1
				System.out.println(i);
				
		}

		System.out.println("**********************************");
		//print those number which are not divided by 2
		for(int i : list)
		{
			if(p.negate().test(i)) // !p
				System.out.println(i);
		}
		System.out.println("**********************************");
		for(int i :list)
		{
			if(p.or(p1).test(i)) // p or p1
			System.out.println(i);
		}

		System.out.println("**********************************");

	}

}
