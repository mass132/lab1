package lab10;

public class Excercise2 implements Runnable {
	/*
	 * Thread program to display timer where timer will get refresh after every 10
	 * seconds.
	 */
	public static long timer = 1;

	public void run() {
		try {
			while (true) {
				Thread.sleep(10000);
				System.out.println("Resetting timer.....");
				timer = 0;// Resetting the value of timer after 10 seconds
			}
		} catch (InterruptedException e) {
			System.out.println("Stopped!");
		}

	}

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(new Excercise2());
		t.start();
		while (true)// prints the value of timer after every seconds
		{
			System.out.println(timer);
			Thread.sleep(1000);
			timer++;// increments the value of timer by 1
		}

	}

}
