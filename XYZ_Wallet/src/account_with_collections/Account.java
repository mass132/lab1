package account_with_collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Account {
	

	public static HashMap<Long, Account> accountData = new HashMap<Long, Account>();
	private static long tempAccNum = 1;//1123456;
	private boolean isActive;
	private Long accountNumber;
	private String name;
	private String mobile;
	private double balance;
	private ArrayList<Transaction> transData;

	public Account() {
		super();
		this.isActive = false;
		this.accountNumber = null;
		this.name = null;
		this.mobile = null;
		this.balance = 0.0;
		this.transData = new ArrayList<Transaction>();
		
	}
	@Override
	public String toString() {
		return "Account Details \n---------------------------------------------------------------\nName : " + name +"\nAccount Number : " + accountNumber + "\nActive : " + isActive + "\nMobile : "
				+ mobile +  "\nTransactions : " + transData;
	}

	private static Account getAccount(long accNum) {
		if (Account.accountData.containsKey(accNum)) {
			Account tempAccount = Account.accountData.get(accNum);
			return tempAccount;
		}
		return null;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public ArrayList<Transaction> getTrans() {
		return transData;
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}

	public boolean createAccount(String name, String mobile) {

		if(!name.isEmpty() && !mobile.isEmpty())
		{
		this.name = name;
		this.mobile = mobile;
		this.accountNumber = tempAccNum++;
		this.isActive = true;
		Account.accountData.put(this.accountNumber,this);
		return true;
		}
		return false;
	}
	public double showBalance() {
		return this.balance;
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			Transaction trans = new Transaction(this.accountNumber,null,amount,"deposit");
			this.balance += amount;
			trans.setRemark("deposit");
			trans.setStatus(true);
			trans.setBalance(this.balance);
			this.transData.add(trans);
			return true;
		}
		return false;
	}

	public boolean withdraw(double amount) {
		if ((amount > 0) && (this.balance - amount) >= 0) {
			Transaction trans = new Transaction(null,this.accountNumber,amount,"withdraw");
			this.balance -= amount;
			trans.setStatus(true);
			trans.setBalance(this.balance);
			this.transData.add(trans);
			return true;
		}
		return false;
	}

	public boolean fundTransfer(long accNum, double amount) {
		Account toAccount;
		if ((toAccount = Account.getAccount(accNum)) != null && this.isActive && amount > 0 && this.balance >= amount) {
			Transaction trans = new Transaction(accNum,this.accountNumber,amount,"fund transfer");
			this.balance -= amount;
			toAccount.balance += amount;
			trans.setBalance(this.balance);
			trans.setStatus(true);
			return true;
		}
		return false;
	}
	
	public void printTransactions() {
		System.out.println("Transaction details for account number "+ this.accountNumber +" : \n");
		Iterator<Transaction> it = transData.iterator(); 
        while (it.hasNext()) 
            System.out.println(it.next() + "\n--------------------------------------------------");

	}

}
