package account_with_jdbc;

import java.util.Date;
import java.util.HashMap;

public class Transaction {
	public static HashMap<Long, Transaction> accountData = new HashMap<Long, Transaction>();
	private static int tempId = 0;
	private int id;
	private Date time;
	private Long toAccount;
	private Long fromAccount;
	private double amount;
	private Double balance;
	private String remark;
	private boolean status;

	public Transaction() {
		this.id = Transaction.tempId++;
		this.time = new Date();
		this.balance = null;
	}

	public int getId() {
		return id;
	}

	public Date getTime() {
		return time;
	}

	public Long getToAccount() {
		return toAccount;
	}


	public Long getFromAccount() {
		return fromAccount;
	}
	public double getAmount() {
		return amount;
	}


	public String getRemark() {
		return remark;
	}

	void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean getStatus() {
		return status;
	}

	void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\nTransaction ID : " + id +"\n---------------------------------"+"\nTransaction Time : " + time + "\nFrom Account : " + fromAccount
				+ "\nTo Account : " + toAccount + "\nAmount : " + amount + "\nBalance : " + balance +"\nRemark : " + remark + "\nCompleted : " + status;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Transaction(Long toAccount, Long fromAccount, double amount, String remark) {
		super();
		this.toAccount = toAccount;
		this.fromAccount = fromAccount;
		this.amount = amount;
		this.remark = remark;
		this.id = Transaction.tempId++;
		this.time = new Date();
		this.balance = null;
	}

}
