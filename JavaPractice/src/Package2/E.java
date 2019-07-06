package Package2;

public class E {

	public static void main(String[] args) {
		D a = new D();
		a.m1();
//		a.m2();//Not accessible as method is protected in class A
//		a.m3();//Not Accessible as method is default
//		a.m4();//Not accessible as method is private in class A
	}

}
