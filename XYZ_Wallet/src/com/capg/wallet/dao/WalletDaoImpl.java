package com.capg.wallet.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;
import com.capg.wallet.exceptions.AccountNotFoundException;
import com.capg.wallet.exceptions.IncorrectPasswordException;
import com.capg.wallet.exceptions.InsufficientFundException;
import com.capg.wallet.exceptions.InvalidAmountException;

public class WalletDaoImpl implements WalletDao {

	@Override
	public int createAccount(Account account) {
		WalletData.getAccounts().put(account.getAccountNumber(), account);
		return 1;
	}

	@Override
	public Account getAccount(long accountNumber) throws AccountNotFoundException {
		if (WalletData.getAccounts().containsKey(accountNumber)) {
			return WalletData.getAccounts().get(accountNumber);
		}
		throw new AccountNotFoundException("No account found for account number " + accountNumber);
	}

	@Override
	public String createTransaction(Transaction tran) {
		String tranId = tran.getId();
		long accountNum = tran.getAccountFrom();
		Map<String, Transaction> currentTranMap = new HashMap<String, Transaction>();
		currentTranMap.put(tranId, tran);
		WalletData.getAllTransactions().put(accountNum, (HashMap<String, Transaction>) currentTranMap);
		return tranId;
	}

	private void verifyAccount(long accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException {
		Account account = getAccount(accountNum);
		if (!account.getPassword().equals(password)) {
			throw new IncorrectPasswordException("You have entered an incorrect passoword!");
		}

	}

	@Override
	public void depositAmount(long accountNum, double amount, String password) throws AccountNotFoundException,
			IncorrectPasswordException, InsufficientFundException, InvalidAmountException {
		if (amount <= 0) {
			throw new InvalidAmountException("Entered Amount is invalid " + amount);
		}
		verifyAccount(accountNum, password);
		Account account = getAccount(accountNum);
		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
	}

	@Override
	public void withdrawAmount(long accountNum, double amount, String password) throws InvalidAmountException,
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

	}

	@Override
	public void fundTransfer(long accountNum, String password, long accountTo, double amount)
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

	}

	@Override
	public void printTransactions(long accountNum, String password)
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

}
