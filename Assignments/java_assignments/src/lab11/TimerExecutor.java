package lab11;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerExecutor {
	public static long timer = 1;

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService services = Executors.newScheduledThreadPool(1);

		services.scheduleWithFixedDelay(new DisplayTimer(), 5, 10, TimeUnit.SECONDS);
		while (true)// prints the value of timer after every seconds
		{
			System.out.println(timer);
			Thread.sleep(1000);
			timer++;// increments the value of timer by 1
		}
	}
}

class DisplayTimer implements Runnable {

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(10000);
				System.out.println("Resetting timer.....");
				TimerExecutor.timer = 0;// Resetting the value of timer after 10 seconds
			}
		} catch (InterruptedException e) {
			System.out.println("Stopped!");
		}

	}
}