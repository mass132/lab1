package com.capg.wallet.dao;

import java.util.HashMap;
import java.util.Map;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;

public class WalletData {
	private static Map<Long, Account> accounts = new HashMap<Long, Account>();
	private static Map<Long, HashMap<String, Transaction>> transactions = new HashMap<Long, HashMap<String, Transaction>>();

	public static Map<Long, Account> getAccounts() {
		return accounts;
	}

	public static Map<String, Transaction> getTransactions(long accountNum) {
		return transactions.get(accountNum);
	}

	public static Map<Long, HashMap<String, Transaction>> getAllTransactions() {
		return transactions;
	}

}
