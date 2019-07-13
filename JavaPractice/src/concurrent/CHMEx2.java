package concurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unused")
public class CHMEx2 extends Thread{

	@SuppressWarnings("rawtypes")
	public static ConcurrentHashMap chm = new ConcurrentHashMap<>();
	//public static HashMap chm = new HashMap<>();
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
		//System.out.println(chm.get(1));
		chm.put(5, 6);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws InterruptedException {
		chm.put(1,2);
		chm.put(2, 3);
		chm.put(3, 4);
		CHMEx2 obj = new CHMEx2();
		obj.start();
		Set s = chm.keySet();
		Iterator itr = s.iterator();
		while(itr.hasNext())
		{
			Integer i = (Integer) itr.next();
			System.out.println("Main thread is iterating...");
			System.out.println(i +" : "+chm.get(i));
			Thread.sleep(1000);
			
		}
		System.out.println(chm);
	}

}
