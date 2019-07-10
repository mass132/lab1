package com.capg.wallet.dao;

import java.util.HashMap;
import java.util.Map;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;

/*
 * Stores the Account and Transaction details in Hashmap.
 */
public class WalletData {
	private static Map<String, Account> accounts = new HashMap<String, Account>();
	private static Map<String, HashMap<String, Transaction>> transactions = new HashMap<String, HashMap<String, Transaction>>();

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
	public static Account getAccountDetails(String accountNum)
	{
		return accounts.get(accountNum);
	}

}
