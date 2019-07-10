package com.capg.wallet.dao;

import java.util.HashMap;
import java.util.Map;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;

/*
 * Stores the Account and Transaction details in Hashmap.
 */
public class WalletData {
	private static Map<Long, Account> accounts = new HashMap<Long, Account>();
	private static Map<Long, HashMap<String, Transaction>> transactions = new HashMap<Long, HashMap<String, Transaction>>();

	public static Map<Long, Account> getAccounts() {
		return accounts;
	}

	/*
	 * returns all the transactions for a particular account.
	 */
	public static Map<String, Transaction> getTransactions(long accountNum) {
		return transactions.get(accountNum);
	}

	/*
	 * Returns all the transations present in the Hashmap.
	 */
	public static Map<Long, HashMap<String, Transaction>> getAllTransactions() {
		return transactions;
	}
	public static Account getAccountDetails(long accountNum)
	{
		return accounts.get(accountNum);
	}

}
