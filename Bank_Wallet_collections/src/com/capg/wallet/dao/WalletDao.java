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

	Account getAccount(String accountNum) throws AccountNotFoundException;

	String createTransaction(Transaction tran);

	void depositAmount(String accountNum, double amount, String password) throws AccountNotFoundException,
			IncorrectPasswordException, InsufficientFundException, InvalidAmountException;

	void withdrawAmount(String accountNum, double amount, String password) throws InvalidAmountException,
			AccountNotFoundException, IncorrectPasswordException, InsufficientFundException;

	void fundTransfer(String accountNum, String password, String accountTo, double amount) throws InvalidAmountException,
			InsufficientFundException, AccountNotFoundException, IncorrectPasswordException;

	void printTransactions(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException;

	void showBalance(String accountNum, String password) throws AccountNotFoundException, IncorrectPasswordException;
}
