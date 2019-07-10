package com.capg.wallet.dao;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;
import com.capg.wallet.exceptions.AccountNotFoundException;
import com.capg.wallet.exceptions.IncorrectPasswordException;
import com.capg.wallet.exceptions.InsufficientFundException;
import com.capg.wallet.exceptions.InvalidAmountException;
/*
 * interface for WalletDaoImpl,contains the methods that must be implemented in the child class.
 */
public interface WalletDao {
	int createAccount(Account account);

	Account getAccount(long accountNumber) throws AccountNotFoundException;

	String createTransaction(Transaction tran);

	void depositAmount(long accountNum, double amount, String password) throws AccountNotFoundException,
			IncorrectPasswordException, InsufficientFundException, InvalidAmountException;

	void withdrawAmount(long accountNum, double amount, String password) throws InvalidAmountException,
			AccountNotFoundException, IncorrectPasswordException, InsufficientFundException;

	void fundTransfer(long accountNum, String password, long accountTo, double amount) throws InvalidAmountException,
			InsufficientFundException, AccountNotFoundException, IncorrectPasswordException;

	void printTransactions(long accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException;
}
