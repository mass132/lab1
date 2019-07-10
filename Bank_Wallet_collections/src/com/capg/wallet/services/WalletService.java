package com.capg.wallet.services;

import com.capg.wallet.exceptions.AccountNotFoundException;
import com.capg.wallet.exceptions.IncorrectPasswordException;
import com.capg.wallet.exceptions.InsufficientFundException;
import com.capg.wallet.exceptions.InvalidAmountException;
import com.capg.wallet.exceptions.InvalidDateException;
import com.capg.wallet.exceptions.InvalidMobileNoException;
import com.capg.wallet.exceptions.InvalidPasswordException;
import com.capg.wallet.exceptions.InvalidReceiverException;
import com.capg.wallet.exceptions.NameFormatException;

public interface WalletService {
	String depositAmount(String accountNum, double amount, String password) throws AccountNotFoundException,
			IncorrectPasswordException, InsufficientFundException, InvalidAmountException;

	String withdrawAmount(String accountNum, double amount, String password) throws InvalidAmountException,
			AccountNotFoundException, IncorrectPasswordException, InsufficientFundException;

	String fundTransfer(String accountNum, String accountNumTo, double amount, String password)
			throws InvalidAmountException, InsufficientFundException, AccountNotFoundException,
			IncorrectPasswordException, InvalidReceiverException;

	String createAccount(String name, String mobile, String dob, String password)
			throws NameFormatException, InvalidMobileNoException, InvalidPasswordException, InvalidDateException;

	void printTransactions(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException;

	void showBalance(String accountNum, String password) throws AccountNotFoundException, IncorrectPasswordException;

}
