package concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@SuppressWarnings("unused")
public class COWAS extends Thread{

	@SuppressWarnings("rawtypes")
	public static CopyOnWriteArraySet  as = new CopyOnWriteArraySet<>();
	//public static ArrayList al = new ArrayList<>();
	@SuppressWarnings("unchecked")
	public void run()
	{
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Child thread got the chance.");
		as.add(7);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws InterruptedException {
		as.add(7);
		as.add(8);
	COWAS obj = new COWAS();
		obj.start();
		Iterator itr = as.iterator();
		while(itr.hasNext())
		{
			Integer i = (Integer) itr.next();
			System.out.println("Main thread is iterating...");
			System.out.println(i);
			Thread.sleep(1000);
			
		}
		System.out.println(as);
	}

}
