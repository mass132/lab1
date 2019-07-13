package concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressWarnings("unused")
public class COWAL extends Thread{

	@SuppressWarnings("rawtypes")
	public static CopyOnWriteArrayList  al = new CopyOnWriteArrayList<>();
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
		al.add(5);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws InterruptedException {
		al.add(7);
		al.add(8);
		al.addIfAbsent(9);
		al.addIfAbsent(8);
		al.addAllAbsent(al);
	COWAL obj = new COWAL();
		obj.start();
		Iterator itr = al.listIterator();
		while(itr.hasNext())
		{
			Integer i = (Integer) itr.next();
			System.out.println("Main thread is iterating...");
			System.out.println(i);
			Thread.sleep(1000);
			
		}
		System.out.println(al);
	}

}
