package java8_features;

import java.util.function.Function;

public class TestFunction {
	public static void main(String[] args) {
		Function<String,Integer> f = str -> str.length();
		System.out.println(f.apply("hello"));
		
		Function<Integer, Integer> f1 = i -> 2 * i;
		Function<Integer,Integer> f2 = i -> i * i * i;
		//Function chaining
		System.out.println(f1.andThen(f2).apply(2)); //first f1 then f2
		System.out.println(f1.compose(f2).apply(2)); //first f2 then f1
	}

}
