package com.capg.wallet.services;

import com.capg.wallet.exceptions.AccountNotFoundException;
import com.capg.wallet.exceptions.IncorrectPasswordException;
import com.capg.wallet.exceptions.InsufficientFundException;
import com.capg.wallet.exceptions.InvalidAmountException;
import com.capg.wallet.exceptions.InvalidDateException;
import com.capg.wallet.exceptions.InvalidMobileNoException;
import com.capg.wallet.exceptions.InvalidPasswordException;
import com.capg.wallet.exceptions.NameFormatException;

public interface WalletService {
	String depositAmount(long accountNum, double amount, String password) throws AccountNotFoundException,
			IncorrectPasswordException, InsufficientFundException, InvalidAmountException;

	String withdrawAmount(long accountNum, double amount, String password) throws InvalidAmountException,
			AccountNotFoundException, IncorrectPasswordException, InsufficientFundException;

	String fundTransfer(long accountNum, long accountNum_rec, double amount, String password)
			throws InvalidAmountException, InsufficientFundException, AccountNotFoundException,
			IncorrectPasswordException;

	Long createAccount(String name, String mobile, String dob, String password)
			throws NameFormatException, InvalidMobileNoException, InvalidPasswordException, InvalidDateException;

	void printTransactions(long accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException;

}
