package com.capg.wallet.dao;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;
import com.capg.wallet.utils.AccountNotFoundException;
import com.capg.wallet.utils.IncorrectPasswordException;
import com.capg.wallet.utils.InsufficientFundException;
import com.capg.wallet.utils.InvalidAmountException;
/*
 * interface for WalletDaoImpl,contains the methods that must be implemented in the child class.
 */
public interface WalletDao {
	String createAccount(Account account);

	Account getAccount(String accountNum) throws AccountNotFoundException;

	String createTransaction(Transaction tran);

	double depositAmount(String accountNum, double amount, String password) throws AccountNotFoundException,
			IncorrectPasswordException, InsufficientFundException, InvalidAmountException;

	double withdrawAmount(String accountNum, double amount, String password) throws InvalidAmountException,
			AccountNotFoundException, IncorrectPasswordException, InsufficientFundException;

	double fundTransfer(String accountNum, String password, String accountTo, double amount) throws InvalidAmountException,
			InsufficientFundException, AccountNotFoundException, IncorrectPasswordException;

	void printTransactions(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException;

	void showBalance(String accountNum, String password) throws AccountNotFoundException, IncorrectPasswordException;
}
