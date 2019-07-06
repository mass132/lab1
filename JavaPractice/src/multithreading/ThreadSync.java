package multithreading;

class Account {
	public int balance;

	public Account() {
		balance = 5000;
	}

	public synchronized void withdraw(int bal) {
		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			System.out.println(e);
		}
		balance -= bal;
		System.out.println("Amount Withdrawn : " + bal);
		System.out.println("Remaining balance : " + balance);
	}

	public synchronized void deposit(int bal) {

		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			System.out.println(e);
		}
		balance += bal;
		System.out.println("Amount deposited: " + bal);
		System.out.println("New balance : " + balance);
	}

	public synchronized void enquiry() {

		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Available balance : " + balance);
	}
}

class Transaction implements Runnable {
	Account acc;

	public void run() {
		acc.withdraw(500);
		acc.deposit(1000);
		acc.enquiry();
	}

	Transaction(Account acc) {
		this.acc = acc;
	}
}

public class ThreadSync {

	public static void main(String[] args) throws InterruptedException {
		Account acc = new Account();
		Transaction t1 = new Transaction(acc);
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t1);
		th1.start();
		//System.out.println(th1.getState());
		//System.out.println(th1.isAlive());
		//System.out.println(th2.getState());
		//System.out.println(th2.isAlive());
		th1.join(0);
		th2.start();
	}

}
