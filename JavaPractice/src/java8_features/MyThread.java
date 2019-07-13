package java8_features;

public class MyThread{

	public static void main(String[] args) {
		Runnable r = ()->System.out.println(Thread.currentThread().getName());
		Thread t = new Thread(r);
		t.start();
		System.out.println(Thread.currentThread().getName());
	}

}
