package multithreading;

class First {
	public synchronized void display(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("]");
	}
}
class Second extends Thread
{
	First fobj;
	String msg;
	Second(String msg,First fobj)
	{
		this.fobj = fobj;
		this.msg = msg;
		this.start();
	}
	public void run() {
		fobj.display(msg);
	}
}
public class ThreadWithSync {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		First obj = new First();
Second s1 = new Second("hello from s1",obj);
Second s2 = new Second("hello from s2",obj);
Second s3 = new Second("hello from s3",obj);
Second s4 = new Second("hello from s4",obj);
System.out.println("hello from main thread");
	}

}
