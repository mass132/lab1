package collections;

import java.util.TreeSet;
public class ComparableTest {

	public static void main(String[] args) {
		MyEmployee e1 = new MyEmployee("poonam", 4);
		MyEmployee e2 = new MyEmployee("suresh", 1);
		MyEmployee e3 = new MyEmployee("ramesh", 5);
		MyEmployee e4 = new MyEmployee("raj", 9);
		TreeSet<MyEmployee> ts = new TreeSet<MyEmployee>();
		ts.add(e1);
		ts.add(e2);
		ts.add(e3);
		ts.add(e4);
		System.out.println(ts);

		TreeSet<MyEmployee> ts1 = new TreeSet<MyEmployee>(new MyNewComparator());
		ts1.add(e1);
		ts1.add(e2);
		ts1.add(e3);
		ts1.add(e4);
		System.out.println(ts1);
		//System.out.println(e1.compareTo(e2));
		
	}

}
