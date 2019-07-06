package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("poonam");
		al.add("manu");
		al.add("poonam");
		System.out.println(al);
		Iterator itr1 = al.iterator();
		while (itr1.hasNext()) {
			String name = (String) itr1.next();
			if (name.equals("poonam")) {
				itr1.remove();
			} else {
				System.out.println(name);

			}
		}
	}
}
