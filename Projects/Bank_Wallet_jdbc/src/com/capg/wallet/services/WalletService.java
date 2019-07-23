package com.capg.wallet.services;

import java.sql.SQLException;
import java.text.ParseException;

import com.capg.wallet.utils.AccountNotFoundException;
import com.capg.wallet.utils.IncorrectPasswordException;
import com.capg.wallet.utils.InsufficientFundException;
import com.capg.wallet.utils.InvalidAmountException;
import com.capg.wallet.utils.InvalidReceiverException;

public interface WalletService {
	String depositAmount(String accountNum, double amount, String password)
			throws AccountNotFoundException, IncorrectPasswordException, InsufficientFundException,
			InvalidAmountException, ClassNotFoundException, SQLException, ParseException;

	String withdrawAmount(String accountNum, double amount, String password)
			throws InvalidAmountException, AccountNotFoundException, IncorrectPasswordException,
			InsufficientFundException, ClassNotFoundException, SQLException, ParseException;

	String fundTransfer(String accountNum, String accountNumTo, double amount, String password)
			throws InvalidAmountException, InsufficientFundException, AccountNotFoundException,
			IncorrectPasswordException, InvalidReceiverException, ClassNotFoundException, SQLException, ParseException;

	String createAccount(String name, String mobile, String dob, String password)
			throws ClassNotFoundException, SQLException;

	void printTransactions(String accountNum, String password) throws AccountNotFoundException,
			IncorrectPasswordException, ClassNotFoundException, SQLException, ParseException;

	void showBalance(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException, ClassNotFoundException, SQLException;

}
