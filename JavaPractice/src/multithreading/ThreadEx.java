package multithreading;

public class ThreadEx extends Thread {
	public static int i = 0;
	
@Override
	public void run() {
	for(int i =0;i<10;i++)
	{
		System.out.println(i+" "+Thread.currentThread());
	}
i++;
}

public static void main(String[] args) throws InterruptedException {
	System.out.println(ThreadEx.currentThread());
	ThreadEx t1 = new ThreadEx();
	t1.start();
	t1.join();
	for(int i =0;i<10;i++)
	{
		System.out.println(i+" "+Thread.currentThread());
	}
	
}

}
