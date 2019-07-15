package java8_features;

import java.util.function.IntPredicate;

public class IntPredicateEx {

	public static void main(String[] args) {
		IntPredicate p = i -> i % 2 == 0;
		System.out.println(p.test(19));
		System.out.println(p.test(10));

	}

}
