package java8_features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(6);
		al.add(344);
		al.add(5);
		al.add(9);
		List<Integer> l1 = al.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(l1);
		long count = al.stream().map(i -> i * i).filter(i -> i > 60).count();
		System.out.println(count);
		List<Integer> l3 = al.stream().sorted((i1, i2) -> (i1 < i2) ? 1 : (i1 > i2) ? -1 : 0)
				.collect(Collectors.toList());

		System.out.println(l3);
		int i = al.stream().min((i1,i2) -> i1.compareTo(i2)).get();
		System.out.println(i);
		int n = al.stream().max((i1,i2) -> i1.compareTo(i2)).get();
		System.out.println(n);
		System.out.println("************************");
		al.stream().forEach(elem -> System.out.println(elem));

	}

}
