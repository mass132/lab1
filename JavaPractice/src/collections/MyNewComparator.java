package collections;
import java.util.Comparator;

public class MyNewComparator implements Comparator<MyEmployee>
{
	/*
	 * It will compare the Employee name
	 */
	public int compare(MyEmployee e1, MyEmployee e2)
	{
		return e1.eName.compareTo(e2.eName);
	}
}