package com.capg.wallet.beans;

import java.util.Date;

/*
 * contains all the properties related to a transaction.
 */
public class Transaction {
	private String id;
	private Date time;
	private String accountFrom;
	private String accountTo;
	private double amount;
	private double balance;
	private String remark;
	@Override
	public String toString() {
		return String.format("%-15s\t%-15s\t%-15s\t%-15.3f\t%-15tc\t%-15s", id,accountFrom,accountTo,amount,time,remark);
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}

	public String getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(String accountTo) {
		this.accountTo = accountTo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Transaction() {
		id = null;
		time = new Date();
		balance = 0.0f;
		accountFrom = null;
		accountTo = null;
		amount = 0.0f;
		remark = "";

	}
}
