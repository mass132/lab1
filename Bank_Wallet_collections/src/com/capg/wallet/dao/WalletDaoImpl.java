package com.capg.wallet.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;
import com.capg.wallet.utils.AccountNotFoundException;
import com.capg.wallet.utils.IncorrectPasswordException;
import com.capg.wallet.utils.InsufficientFundException;
import com.capg.wallet.utils.InvalidAmountException;

public class WalletDaoImpl implements WalletDao {

	/*
	 * Creates a new account.
	 * @param account A variable of Account type
	 * @return A String Data type
	 */
	@Override
	public String createAccount(Account account) {
		String accountNum = account.getAccountNumber();
		WalletData.getAccounts().put(accountNum, account);
		return accountNum;
	}

	/*
	 * Gets the account details.
	 * @param accountNum of type String
	 * @return An Account data type
	 */
	@Override
	public Account getAccount(String accountNum) throws AccountNotFoundException {
		if (WalletData.getAccounts().containsKey(accountNum)) {
			return WalletData.getAccounts().get(accountNum);
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
		boolean isExists = WalletData.getAllTransactions().containsKey(accountNum);
		if (isExists) {
			Map<String, Transaction> var = WalletData.getTransactions(accountNum);
			var.put(tranId, tran);
		} else {
			Map<String, Transaction> currentTranMap = new HashMap<String, Transaction>();
			currentTranMap.put(tranId, tran);
			WalletData.getAllTransactions().put(accountNum, (HashMap<String, Transaction>) currentTranMap);
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
		Map<String, Transaction> trans = WalletData.getTransactions(accountNum);
		Set<Entry<String, Transaction>> s = trans.entrySet();
		Iterator<Entry<String, Transaction>> itr = s.iterator();
		while (itr.hasNext()) {
			Entry<String, Transaction> er = itr.next();
			System.out.println(er.getValue());
		}
	}

	@Override
	public void showBalance(String accountNum, String password) throws AccountNotFoundException, IncorrectPasswordException {
		verifyAccount(accountNum, password);
		Account account = getAccount(accountNum);
		System.out.println("Current balance in account number "+ accountNum + " is Rs. "+ account.getBalance()  +" .");
		
	}

}
