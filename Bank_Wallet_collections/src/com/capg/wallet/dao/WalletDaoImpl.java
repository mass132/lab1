package com.capg.wallet.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;
import com.capg.wallet.utils.AccountNotFoundException;
import com.capg.wallet.utils.IncorrectPasswordException;
import com.capg.wallet.utils.InsufficientFundException;
import com.capg.wallet.utils.InvalidAmountException;

public class WalletDaoImpl implements WalletDao {
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
	public static Account getAccountDetails(String accountNum) {
		return getAccounts().get(accountNum);
	}

	/*
	 * Creates a new account.
	 * 
	 * @param account A variable of Account type
	 * 
	 * @return A String Data type
	 */
	@Override
	public String createAccount(Account account) {
		String accountNum = account.getAccountNumber();
		getAccounts().put(accountNum, account);
		return accountNum;
	}

	/*
	 * Gets the account details.
	 * 
	 * @param accountNum of type String
	 * 
	 * @return An Account data type
	 */
	@Override
	public Account getAccount(String accountNum) throws AccountNotFoundException {
		if (getAccounts().containsKey(accountNum)) {
			return getAccounts().get(accountNum);
		}
		throw new AccountNotFoundException("No account found for account number " + accountNum);
	}

	/*
	 * Creates new Transaction
	 */
	@Override
	public String createTransaction(Transaction tran) {
		String tranId = tran.getId();
		String accountNum = tran.getAccountFrom();
		boolean isExists = getAllTransactions().containsKey(accountNum);
		if (isExists) {
			Map<String, Transaction> var = getTransactions(accountNum);
			var.put(tranId, tran);
		} else {
			Map<String, Transaction> currentTranMap = new HashMap<String, Transaction>();
			currentTranMap.put(tranId, tran);
			getAllTransactions().put(accountNum, (HashMap<String, Transaction>) currentTranMap);
		}
		return tranId;
	}

	/*
	 * Verifies if the account number and password are correct.
	 */
	private void verifyAccount(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException {
		Account account = getAccount(accountNum);
		if (!account.getPassword().equals(password)) {
			throw new IncorrectPasswordException("You have entered an incorrect passoword!");
		}

	}

	/*
	 * Deposits the amount into the account.
	 */
	@Override
	public double depositAmount(String accountNum, double amount, String password) throws AccountNotFoundException,
			IncorrectPasswordException, InsufficientFundException, InvalidAmountException {
		if (amount <= 0) {
			throw new InvalidAmountException("Entered Amount is invalid " + amount);
		}
		verifyAccount(accountNum, password);
		Account account = getAccount(accountNum);
		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
		return account.getBalance();
	}

	/*
	 * Withdraws the amount from the account.
	 */
	@Override
	public double withdrawAmount(String accountNum, double amount, String password) throws InvalidAmountException,
			AccountNotFoundException, IncorrectPasswordException, InsufficientFundException {
		if (amount <= 0) {
			throw new InvalidAmountException("Entered Amount is invalid " + amount);
		}
		verifyAccount(accountNum, password);
		Account account = getAccount(accountNum);
		if (amount > account.getBalance()) {
			throw new InsufficientFundException("You have Insufficient funds in your account.");
		}
		double newBalance = account.getBalance() - amount;
		account.setBalance(newBalance);
		return account.getBalance();
	}

	/*
	 * Transfers the amount from one account to another.
	 */
	@Override
	public double fundTransfer(String accountNum, String password, String accountTo, double amount)
			throws InvalidAmountException, InsufficientFundException, AccountNotFoundException,
			IncorrectPasswordException {
		if (amount <= 0) {
			throw new InvalidAmountException("Entered Amount is invalid " + amount);
		}
		verifyAccount(accountNum, password);
		Account account = getAccount(accountNum);
		Account account_rec = getAccount(accountTo);
		if (amount > account.getBalance()) {
			throw new InsufficientFundException("You have Insufficient funds in your account.");
		}
		account_rec.setBalance(account_rec.getBalance() + amount);
		account.setBalance(account.getBalance() - amount);
		return account.getBalance();
	}

	/*
	 * Prints all the transactions for a particular account
	 */
	@Override
	public void printTransactions(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException {
		verifyAccount(accountNum, password);
		Map<String, Transaction> trans = getTransactions(accountNum);
		Set<Entry<String, Transaction>> s = trans.entrySet();
		Iterator<Entry<String, Transaction>> itr = s.iterator();
		while (itr.hasNext()) {
			Entry<String, Transaction> er = itr.next();
			System.out.println(er.getValue());
		}
	}

	@Override
	public void showBalance(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException {
		verifyAccount(accountNum, password);
		Account account = getAccount(accountNum);
		System.out
				.println("Current balance in account number " + accountNum + " is Rs. " + account.getBalance() + " .");

	}

}
