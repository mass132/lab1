package java8_features;

import java.util.function.Predicate;

public class FunctionalInterface1 {

	public static void main(String[] args) {
		Predicate<Integer> p = i -> i%2 == 0;
		System.out.println(p.test(25));
		Predicate<String> p1 = str -> str.length() == 5;
		System.out.println(p1.test("poonam"));
		

	}

}
