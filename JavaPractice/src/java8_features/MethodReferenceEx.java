package java8_features;

import java.util.ArrayList;

interface A1 {
	int add(int a, int b);
}

public class MethodReferenceEx {

	public static int sum(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		A1 a = MethodReferenceEx::sum;
		System.out.println(a.add(5, 10));
		System.out.println("****************");
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(6);
		al.add(344);
		al.add(5);
		al.add(9);
		al.stream().forEach(System.out::println);
	}

}
