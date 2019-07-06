package oopconcept;

public class ChildEx extends ParentEx {
	static int a =6;

	@SuppressWarnings("static-access")
	public ChildEx() {
		super(a);
		System.out.println("Default constructor from ChildEx");
		System.out.println(this.a);
		System.out.println(super.a);
		super.m1();
		this.m1();
	}


	public ChildEx(int a) {
		System.out.println("Parameterized constructor from ChildEx");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildEx c = new ChildEx(12);
		@SuppressWarnings("unused")
		ChildEx c1 = new ChildEx();
		c.m1();
		System.out.println(c1);

	}
	void m1()
	{
		System.out.println("m1 method from ChildEx");
	}


}
