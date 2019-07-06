package Package2;

import Package1.A;

public class D extends A {

	public static void main(String[] args) {
		D a = new D();
		a.m1();
		a.m2();
//		a.m3();//Not Accessible as method is default
//		a.m4();//Not accessible as method is private in the parent class
	}

}
