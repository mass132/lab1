package com.capg.wallet.services;

import java.util.Date;
import java.util.UUID;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;
import com.capg.wallet.dao.WalletDao;
import com.capg.wallet.dao.WalletDaoImpl;
import com.capg.wallet.exceptions.AccountNotFoundException;
import com.capg.wallet.exceptions.IncorrectPasswordException;
import com.capg.wallet.exceptions.InsufficientFundException;
import com.capg.wallet.exceptions.InvalidAmountException;
import com.capg.wallet.exceptions.InvalidDateException;
import com.capg.wallet.exceptions.InvalidMobileNoException;
import com.capg.wallet.exceptions.InvalidPasswordException;
import com.capg.wallet.exceptions.InvalidReceiverException;
import com.capg.wallet.exceptions.NameFormatException;

/*
 * Implements abstract methods from WalletService Interface.
 */
public class WalletServiceImpl implements WalletService {

	/*
	 * Returns true if mobile number contains 10 digit,else false.
	 */
	private boolean validateMobile(String mobile) {
		return mobile.matches("^[1-9][0-9]{9}$");
	}

	/*
	 * Returns true if date is in accepted format,else false.
	 */
	private boolean validateDate(String date) {
		String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
		return date.matches(regex);
	}

	private boolean validatePassword(String password) {
		String regex = "[1-9a-zA-Z]{8,}";
		return password.matches(regex);
	}

	private boolean validateName(String name) {
		String regex = "[a-zA-Z ]{3,}";
		return name.matches(regex);
	}

	private WalletDao getWalletDao() {
		return new WalletDaoImpl();
	}
/*
 * Creates a transaction object with the given details and passes it to createTransaction() method of WalletDao Interface. 
 */
	private String createTransaction(long accountFrom, Long accountTo, double amount, String remark) {
		WalletDao walletDao = getWalletDao();
		Transaction tran = new Transaction();
		String uniqueKey = UUID.randomUUID().toString();
		String tranId = uniqueKey.split("-")[0];
		tran.setAccountFrom(accountFrom);
		tran.setAmount(amount);
		tran.setTime(new Date());
		tran.setRemark(remark);
		tran.setId(tranId);
		tran.setAccountTo(accountTo);
		tranId = walletDao.createTransaction(tran);
		return tranId;
	}

	@Override
	public Long createAccount(String name, String mobile, String dob, String password)
			throws NameFormatException, InvalidMobileNoException, InvalidPasswordException, InvalidDateException {
		name = name.trim();
		if (!validateName(name)) {
			throw new NameFormatException("Please enter a valid name (Only alphabets are allowed in name) ");
		}
		mobile = mobile.trim();
		if (!validateMobile(mobile)) {
			throw new InvalidMobileNoException("Invalid Mobile Number ");
		}
		dob = dob.trim();
		if (!validateDate(dob)) {
			throw new InvalidDateException("Entered date is invalid ");
		}
		password = password.trim();
		if (!validatePassword(password)) {
			throw new InvalidPasswordException("Entered password is invalid (Your password must contain 1 Uppercase, 1 Lowercase, 1 number and the length should be minimum 8 characterds long) ");
		}
		long accountNumber = Long.parseLong(mobile);
		Account account = new Account();
		account.setName(name);
		account.setBalance(0);
		account.setDob(dob);
		account.setMobile(mobile);
		account.setAccountNumber(accountNumber);
		account.setPassword(password);
		WalletDao walletDao = getWalletDao();
		walletDao.createAccount(account);
		return accountNumber;
	}

	@Override
	public String depositAmount(long accountNum, double amount, String password) throws AccountNotFoundException,
			IncorrectPasswordException, InsufficientFundException, InvalidAmountException {
		WalletDao walletDao = getWalletDao();
		String tranId = null;
		walletDao.depositAmount(accountNum, amount, password);
		tranId = createTransaction(accountNum, null, amount, "deposit");
		return tranId;
	}

	@Override
	public String withdrawAmount(long accountNum, double amount, String password) throws InvalidAmountException,
			AccountNotFoundException, IncorrectPasswordException, InsufficientFundException {
		WalletDao walletDao = getWalletDao();
		String tranId = null;
		walletDao.withdrawAmount(accountNum, amount, password);
		tranId = createTransaction(accountNum, null, amount, "withdraw");
		return tranId;
	}

	@Override
	public String fundTransfer(long accountNum, long accountNumTo, double amount, String password)
			throws InvalidAmountException, InsufficientFundException, AccountNotFoundException,
			IncorrectPasswordException, InvalidReceiverException {
		if(accountNum == accountNumTo)
		{
			throw new InvalidReceiverException("You cannot transfer funds to your own account.");
		}
		WalletDao walletDao = getWalletDao();
		String tranId = null;
		walletDao.fundTransfer(accountNum, password, accountNumTo, amount);
		tranId = createTransaction(accountNum, accountNumTo, amount, "fund transfer");
		return tranId;
	}

	@Override
	public void printTransactions(long accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException {
		WalletDao walletDao = getWalletDao();
		System.out.println("\nTransaction details for account number " + accountNum + " :");
		System.out.printf("%14s\t%12s\t%10s\t%6s\t%14s\t\t\t\t%s\n", "Transaction Id","From Account","To Account","Amount","Time","Remark");
		walletDao.printTransactions(accountNum, password);

	}
}
