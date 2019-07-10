package com.capg.wallet.beans;

import java.util.Date;

/*
 * contains all the properties related to a transaction.
 */
public class Transaction {
	private String id;
	private Date time;
	private long accountFrom;
	private Long accountTo;
	private double amount;
	private double balance;
	private String remark;
	@Override
	public String toString() {
		return String.format("%14s\t%12d\t%10d\t%6.3f\t%14tc\t%s", id,accountFrom,accountTo,amount,time,remark);
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

	public long getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(long accountFrom) {
		this.accountFrom = accountFrom;
	}

	public Long getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(Long accountTo) {
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
		accountFrom = 0;
		accountTo = null;
		amount = 0.0f;
		remark = "";

	}
}
