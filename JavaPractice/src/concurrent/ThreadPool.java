package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	public static void main(String[] args) {
		// create the pool
		//ExecutorService service = Executors.newFixedThreadPool(20);
		//ExecutorService service = Executors.newCachedThreadPool();
		//ExecutorService service = Executors.newSingleThreadExecutor();
		//submit tasks for execution
		/*
		for (int i = 0; i < 50; i++) {
			service.execute(new Task());
		}
		System.out.println("Thread Name : "+ Thread.currentThread().getName());
		*/

		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		//task to run after 5 seconds delay
		//service.schedule(new Task(),5, TimeUnit.SECONDS);
		//task to run repeatedly for every 5 seconds
		//service.scheduleAtFixedRate(new Task(),10,5, TimeUnit.SECONDS);
		service.scheduleWithFixedDelay(new Task(),10,5, TimeUnit.SECONDS);
		System.out.println("Thread Name : "+ Thread.currentThread().getName());
	}

}
class Task implements Runnable
{
	public void run()
	{
		System.out.println("Thread Name : "+ Thread.currentThread().getName());
	}
}
