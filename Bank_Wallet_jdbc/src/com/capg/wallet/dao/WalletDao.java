package com.capg.wallet.dao;

import java.sql.SQLException;
import java.text.ParseException;

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
	String createAccount(Account account) throws ClassNotFoundException, SQLException;

	Account getAccount(String accountNum) throws AccountNotFoundException, ClassNotFoundException, SQLException;

	String createTransaction(Transaction tran)
			throws ClassNotFoundException, SQLException, ParseException, AccountNotFoundException;

	double depositAmount(String accountNum, double amount, String password)
			throws AccountNotFoundException, IncorrectPasswordException, InsufficientFundException,
			InvalidAmountException, ClassNotFoundException, SQLException, ParseException;

	double withdrawAmount(String accountNum, double amount, String password)
			throws InvalidAmountException, AccountNotFoundException, IncorrectPasswordException,
			InsufficientFundException, ClassNotFoundException, SQLException, ParseException;

	double fundTransfer(String accountNum, String password, String accountTo, double amount)
			throws InvalidAmountException, InsufficientFundException, AccountNotFoundException,
			IncorrectPasswordException, ClassNotFoundException, SQLException, ParseException;

	void printTransactions(String accountNum, String password) throws AccountNotFoundException,
			IncorrectPasswordException, ClassNotFoundException, SQLException, ParseException;

	void showBalance(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException, ClassNotFoundException, SQLException;
}
