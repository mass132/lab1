package com.capg.wallet.beans;

/*
 * Account.java - Class for Account related details.
 */
public class Account {
	private String accountNumber;
	private String name;
	private String mobile;
	private double balance;
	private String dob;
	private String password;

	public Account() {
		super();
		accountNumber = null;
		name = "";
		mobile = "";
		balance = 0.0f;
		dob = "";
	}

	public String toString() {
		return String.format(
				"Account Details for Account No.\t:\t%d\nCustomer Name\t:\t%s\nMobile\t\t:\t%s\nBalance\t\t:\t%.3f",
				accountNumber, name, mobile, balance);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
}
