package java8_features;

interface A{
	void m1();

	default void m2() {
		System.out.println("Default Method");
	}
	public static void printHello() {
		System.out.println("Hello Ji");
				}
}

public class DefaultAndStatic implements A {
	public void m1() {
		System.out.println("Abstract method Impl");
	}

	public static void main(String[] args) {
		DefaultAndStatic d = new DefaultAndStatic();
		d.m2();
		d.m1();
		A.printHello();
	}

}
