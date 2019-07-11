package com.capg.wallet.services;

import com.capg.wallet.utils.AccountNotFoundException;
import com.capg.wallet.utils.IncorrectPasswordException;
import com.capg.wallet.utils.InsufficientFundException;
import com.capg.wallet.utils.InvalidAmountException;
import com.capg.wallet.utils.InvalidReceiverException;

public interface WalletService {
	String depositAmount(String accountNum, double amount, String password) throws AccountNotFoundException,
			IncorrectPasswordException, InsufficientFundException, InvalidAmountException;

	String withdrawAmount(String accountNum, double amount, String password) throws InvalidAmountException,
			AccountNotFoundException, IncorrectPasswordException, InsufficientFundException;

	String fundTransfer(String accountNum, String accountNumTo, double amount, String password)
			throws InvalidAmountException, InsufficientFundException, AccountNotFoundException,
			IncorrectPasswordException, InvalidReceiverException;

	String createAccount(String name, String mobile, String dob, String password);

	void printTransactions(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException;

	void showBalance(String accountNum, String password) throws AccountNotFoundException, IncorrectPasswordException;

}
