package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(1);
		List<Future<Integer>> allFutures = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Future<Integer> future = service.submit(new TaskCallable());
			allFutures.add(future);
			
		}
		for (int i = 0; i < 100; i++) {
			Future<Integer> future = allFutures.get(i);
			Integer result = future.get();
			System.out.println(result);
			
		}

	}

}
class TaskCallable implements Callable<Integer>
{
	public Integer call() throws InterruptedException
	{
		
		Thread.sleep(3000);
		return new Random().nextInt();
	}
}
