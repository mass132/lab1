package oopconcept;

public class InterfaceTest implements A,B{

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		System.out.println("Hello from m3()");
		
	}

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("Hello from m1()");
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("Hello from m2()");
	}
public static void main(String[] args) {
	InterfaceTest t = new InterfaceTest();
	t.m1();
	t.m2();
	t.m3();
}
}
