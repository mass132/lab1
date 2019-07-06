package Package1;

public class A {

	public void m1()
	{
		System.out.println("m1 from Package1.A");
	}
	protected void m2()
	{
		System.out.println("m2 from Package1.A");
	}
	void m3()
	{
		System.out.println("m3 from Package1.A");
	}
	private void m4()
	{
		System.out.println("m4 from Package1.A");
	}
public static void main(String[] args) {
	A a = new A();
	a.m1();
	a.m2();
	a.m3();
	a.m4();
}
}
