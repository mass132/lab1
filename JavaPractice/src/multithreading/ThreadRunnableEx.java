package multithreading;

public class ThreadRunnableEx implements Runnable {
	

	@Override
	public void run() {
		System.out.println("Hello from new thread");
		
	}

	public static void main(String[] args) {
		ThreadRunnableEx tr = new ThreadRunnableEx();
		Thread t = new Thread(tr);
		t.start();

	}

}
