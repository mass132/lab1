package collections;

import java.util.Enumeration;
import java.util.Stack;
import java.util.Vector;

/* 
 *synchronized,capacity is doubled ,duplicates are allowed,insertion order is preserved
 */
public class VectorEx {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Vector v = new Vector();
		v.addElement(5);
		v.addElement(6);
		v.addElement(7);
		System.out.println(v.size());
		System.out.println(v.capacity());
		System.out.println(v.elementAt(0));
		v.setSize(10);
		v.addElement(345);
		v.removeElementAt(9);
		System.out.println(v);
		System.out.println(v.elementAt(5));
		System.out.println(v.firstElement());
		System.out.println(v.lastElement());
		Enumeration values = v.elements();
		while(values.hasMoreElements())
		{
			System.out.println(values.nextElement());
		}
		Stack st = new Stack();
		st.push(8);
		System.out.println(st.peek());
		System.out.println(st);
		System.out.println(st.get(0));
		System.out.println(st.search(8));
	}

}
