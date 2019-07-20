package com.capg.wallet.services;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;
import com.capg.wallet.dao.WalletDao;
import com.capg.wallet.dao.WalletDaoImpl;
import com.capg.wallet.utils.AccountNotFoundException;
import com.capg.wallet.utils.IncorrectPasswordException;
import com.capg.wallet.utils.InsufficientFundException;
import com.capg.wallet.utils.InvalidAmountException;
import com.capg.wallet.utils.InvalidReceiverException;
import com.capg.wallet.utils.Utils;

/*
 * Implements abstract methods from WalletService Interface.
 */
public class WalletServiceImpl implements WalletService {

	/*
	 * returns WalletDao object.
	 */
	private WalletDao getWalletDao() {
		return new WalletDaoImpl();
	}

	/*
	 * Creates a transaction object with the given details and passes it to
	 * createTransaction() method of WalletDao Interface.
	 */
	private String createTransaction(String accountFrom, String accountTo, double amount, String remark)
			throws ClassNotFoundException, SQLException, ParseException, AccountNotFoundException {
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
		System.out.println(tran);
		tranId = walletDao.createTransaction(tran);
		return tranId;
	}

	/*
	 * creates new account
	 */
	@Override
	public String createAccount(String name, String mobile, String dob, String password)
			throws ClassNotFoundException, SQLException {

		String accountNumber = Utils.randomString(3) + mobile;
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

	/*
	 * Deposits the amount into the account.
	 */
	@Override
	public String depositAmount(String accountNum, double amount, String password)
			throws AccountNotFoundException, IncorrectPasswordException, InsufficientFundException,
			InvalidAmountException, ClassNotFoundException, SQLException, ParseException {
		WalletDao walletDao = getWalletDao();
		String tranId = null;
		walletDao.depositAmount(accountNum, amount, password);
		tranId = createTransaction(accountNum, null, amount, "deposit");
		return tranId;
	}

	/*
	 * Withdraws the amount from the account.
	 */
	@Override
	public String withdrawAmount(String accountNum, double amount, String password)
			throws InvalidAmountException, AccountNotFoundException, IncorrectPasswordException,
			InsufficientFundException, ClassNotFoundException, SQLException, ParseException {
		WalletDao walletDao = getWalletDao();
		String tranId = null;
		walletDao.withdrawAmount(accountNum, amount, password);
		tranId = createTransaction(accountNum, null, amount, "withdraw");
		return tranId;
	}

	/*
	 * Transfers the amount from one account to another.
	 */
	@Override
	public String fundTransfer(String accountNum, String accountNumTo, double amount, String password)
			throws InvalidAmountException, InsufficientFundException, AccountNotFoundException,
			IncorrectPasswordException, InvalidReceiverException, ClassNotFoundException, SQLException, ParseException {
		if (accountNum.equals(accountNumTo)) {
			throw new InvalidReceiverException("You cannot transfer funds to your own account.");
		}
		WalletDao walletDao = getWalletDao();
		String tranId = null;
		walletDao.fundTransfer(accountNum, password, accountNumTo, amount);
		tranId = createTransaction(accountNum, accountNumTo, amount, "fund transfer");
		return tranId;
	}

	/*
	 * Prints all the transactions for a particular account
	 */
	@Override
	public void printTransactions(String accountNum, String password) throws AccountNotFoundException,
			IncorrectPasswordException, ClassNotFoundException, SQLException, ParseException {
		WalletDao walletDao = getWalletDao();
		System.out.println("\nTransaction details for account number " + accountNum + " :");
		System.out.printf("%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t\t\t%-15s\n", "Transaction Id", "From Account",
				"To Account", "Amount", "Time", "Remark");
		walletDao.printTransactions(accountNum, password);

	}

	/*
	 * prints current balance in the account
	 */
	@Override
	public void showBalance(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException, ClassNotFoundException, SQLException {
		WalletDao walletDao = getWalletDao();
		walletDao.showBalance(accountNum, password);

	}
}
