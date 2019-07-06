package collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
class MyTreeMapCom implements Comparator<String>
{
	public int compare(String str1,String str2)
	{
		return -str1.compareTo(str2);
	}
}
public class TreeMapTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		MyEmployee e1 = new MyEmployee("poonam", 4);
		MyEmployee e2 = new MyEmployee("suresh", 1);
		MyEmployee e3 = new MyEmployee("ramesh", 5);
		MyEmployee e4 = new MyEmployee("raj", 9);
		TreeMap<String,MyEmployee> tm = new TreeMap<String,MyEmployee>(new MyTreeMapCom());
		tm.put("new",e1);
		tm.put("new2",e2);
		tm.put("new12",e3);
		tm.put("new1",e4);
		System.out.println(tm);
		Set s = tm.entrySet();
		Iterator itr = s.iterator();
		while(itr.hasNext())
		{
			Entry er = (Entry) itr.next();
			System.out.println(er.getKey() +" : "+ er.getValue());
		}
		System.out.println(s);
		Set s1 = tm.keySet();
		System.out.println(s1);

	}

}
