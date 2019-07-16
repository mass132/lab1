package com.capg.wallet.dao;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;

/*
 * Stores the Account and Transaction details in Hashmap.
 */
public class WalletData{
	private static Map<String, Account> accounts = new HashMap<String, Account>();
	private static Map<String, HashMap<String, Transaction>> transactions = new HashMap<String, HashMap<String, Transaction>>();
	static {
		Account a1 = new Account();
		a1.setAccountNumber("SDA1234567890");
		a1.setBalance(4750.0);
		a1.setDob("25-12-2017");
		a1.setMobile("8078785645");
		a1.setName("Poonam chand Sahu");
		a1.setPassword("Qwerty123_");
		Account a2 = new Account();
		a2.setAccountNumber("SDA1234567891");
		a2.setBalance(4800.0);
		a2.setDob("25-12-2013");
		a2.setMobile("8674787906");
		a2.setName("Poonam test");
		a2.setPassword("Qwerty123_");
		accounts.put(a1.getAccountNumber(), a1);
		accounts.put(a2.getAccountNumber(), a2);
		Transaction t1 = new Transaction();
		t1.setAccountFrom(a1.getAccountNumber());
		t1.setAccountTo(a2.getAccountNumber());
		t1.setAmount(250);
		t1.setBalance(4750.0);
		t1.setTime(new Date());
		t1.setRemark("fund transfer");
		t1.setId("9e5d2938");

		Transaction t2 = new Transaction();
		t2.setAccountFrom(a2.getAccountNumber());
		t2.setAccountTo(null);
		t2.setAmount(750);
		t2.setBalance(4500.0);
		t2.setTime(new Date());
		t2.setRemark("withdraw");
		t2.setId("9e5d2934");
		Transaction t3 = new Transaction();
		t3.setAccountFrom(a2.getAccountNumber());
		t3.setAccountTo(null);
		t3.setAmount(300);
		t3.setBalance(4800.0);
		t3.setTime(new Date());
		t3.setRemark("deposit");
		t3.setId("9e5d2904");
		HashMap<String, Transaction> entry = new HashMap<String, Transaction>();
		entry.put(t1.getId(), t1);
		HashMap<String, Transaction> entry2 = new HashMap<String, Transaction>();
		entry2.put(t1.getId(), t1);
		entry2.put(t2.getId(), t2);
		entry2.put(t3.getId(), t3);
		transactions.put(a1.getAccountNumber(), entry);
		transactions.put(a2.getAccountNumber(), entry2);
		
	}
	public static Map<String, Account> getAccounts() {
		return accounts;
	}

	/*
	 * returns all the transactions for a particular account.
	 */
	public static Map<String, Transaction> getTransactions(String accountNum) {
		return transactions.get(accountNum);
	}

	/*
	 * Returns all the transations present in the Hashmap.
	 */
	public static Map<String, HashMap<String, Transaction>> getAllTransactions() {
		return transactions;
	}
	/*
	 * takes account number as input and returns the account object.
	 */
	public static Account getAccountDetails(String accountNum)
	{
		return accounts.get(accountNum);
	}
}
