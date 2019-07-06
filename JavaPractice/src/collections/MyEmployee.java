package collections;

public class MyEmployee implements Comparable<MyEmployee>{
	String eName;
	int eId;
	MyEmployee(String eName,int eId)
	{
		this.eName = eName;
		this.eId = eId;
	}
	public String toString() {
		return eName+" --> "+eId;
	}
	/*
	 * It will compare the Employee id
	 */
	public int compareTo(MyEmployee e)
	{
		int eId1 = this.eId;
		int eId2 = e.eId;
		return eId1 - eId2;
	}
}