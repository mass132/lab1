package Package1;

public class B extends A{

	public static void main(String[] args) {
		B a = new B();
		a.m1();
		a.m2();
		a.m3();
//		a.m4();//Private method so not accessible
	}

}
