package oopconcept;

public class Overloading {
	static void add()
	{
		System.out.println("Default Add Method");
	}
	static void add(int a,int b)
	{
		System.out.println("Addition of "+a+ "and "+b+ " is : "+(a+b));
	}

	static void add(float a,float b)
	{
		System.out.println("Addition of "+a+ "and "+b+ " is : "+(a+b));
	}
	static void add(int a,float b)
	{
		System.out.println("Addition of "+a+ "and "+b+ " is : "+(a+b));
	}
	static void add(float a,int b)
	{
		System.out.println("Addition of "+a+ "and "+b+ " is : "+(a+b));
	}
	public static void main(String[] args) {
		Overloading.add();
		Overloading.add('a', 'b');
		Overloading.add(5.6f,5);
		Overloading.add(5.6f,3.4f);
		Overloading.add(4,5.3f);
	}

}
