package com.capg.wallet.services;

import java.util.Iterator;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;

public class AccountService implements AccountServiceInterface {
	private static Account getAccount(long accNum) {
		if (Account.accountData.containsKey(accNum)) {
			Account tempAccount = Account.accountData.get(accNum);
			return tempAccount;
		}
		return null;
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
