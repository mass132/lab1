package com.capg.mobileapp.beans;

public class Account {
	private String name;
	private double balance;
	private String accountType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(String name, int balance, String accountType) {
		super();
		this.name = name;
		this.balance = balance;
		this.accountType = accountType;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String acctype) {
		this.accountType = acctype;
	}
}
