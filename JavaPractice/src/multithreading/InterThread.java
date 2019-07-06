package multithreading;
class Number//contains synchronized methods
{
	boolean flag = true;
	synchronized void even(int n) {
		if(flag)
		{
			try {
				wait();
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
		System.out.println(n);
		flag = true;
		notify();
	}
	synchronized void odd(int n) {
		if(!flag)
		{
			try {
				wait();
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
		System.out.println(n);
		flag = false;
		notify();
	}
}
class Even implements Runnable//contains thread object for even number
{
	Number num;
	Even(Number num)
	{
		this.num = num;
		new Thread(this,"even").start();
		
	}
	public void run()
	{
		for(int i =2;i <= 100;i = i+2)
		{
			num.even(i);
		}
	}
	
}
class Odd implements Runnable
{
	Number num;
	Odd(Number num)
	{
		this.num = num;
		new Thread(this,"odd").start();
		
	}
	public void run()
	{
		for(int i =1;i <= 100;i = i+2)
		{
			num.odd(i);
		}
	}
	
}
public class InterThread {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Number num = new Number();
		Even even = new Even(num);
		Odd odd = new Odd(num);

	}

}
