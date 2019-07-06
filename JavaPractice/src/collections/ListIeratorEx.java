package collections;
import java.util.ArrayList;
import java.util.ListIterator;

public class ListIeratorEx {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("ab");
		ar.add("bc");
		ar.add("cd");
		ar.add("de");
		ListIterator litr = ar.listIterator();
		while(litr.hasNext())
		{
			String s = (String) litr.next();
			System.out.println(s+" ");
			if(s.equals("cd"))
			{
				litr.set("capgemini");
			}
		}

		litr.add("helllo");
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		while(litr.hasPrevious())
		{
			System.out.println(litr.previousIndex()+" "+ litr.previous());
		}
		}

}
