package oopconcept;

public class D extends C{
	void m4() {
		System.out.println("Hello from D.m4()");
	}
	public static void main(String[] args) {
		D d = new D();
		d.m1();
		d.m2();
		d.m3();
		d.m4();
		System.out.println(D.a);
	}
	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("Hello from D.m1()");
	}
	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("Hello from D.m2()");
		
	}
	@Override
	public void m3() {
		// TODO Auto-generated method stub
		System.out.println("Hello from D.m3()");
	}
}
