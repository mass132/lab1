package com.capg.wallet.dao;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.capg.wallet.beans.Account;
import com.capg.wallet.beans.Transaction;
import com.capg.wallet.utils.AccountNotFoundException;
import com.capg.wallet.utils.IncorrectPasswordException;
import com.capg.wallet.utils.InsufficientFundException;
import com.capg.wallet.utils.InvalidAmountException;

@SuppressWarnings("deprecation")
public class WalletDaoImpl implements WalletDao {

	static {
		Connection conn = null;
		PreparedStatement stmt = null;
		String queryTransaction = "INSERT INTO bank_wallet_transaction values(?,?,?,?,?,?,?)";
		String queryAccount = "INSERT INTO bank_wallet_account values(?,?,?,?,?,?)";
		try {
			conn = WalletDB.getConnection();
			stmt = conn.prepareStatement(queryAccount);
			stmt.setString(1, "SDA1234567890");
			stmt.setString(2, "Poonam chand Sahu");
			stmt.setString(3, "8078785645");
			stmt.setDouble(4, 4750.0);
			stmt.setString(5, new Date(1997, 12, 24).toString());
			stmt.setString(6, "Qwerty123_");
			stmt.addBatch();
			stmt.setString(1, "SDA1234567891");
			stmt.setString(2, "Poonam test");
			stmt.setString(3, "8674787906");
			stmt.setDouble(4, 4800.0);
			stmt.setString(5, new Date(2018, 05, 05).toString());
			stmt.setString(6, "Qwerty123_");
			stmt.addBatch();
			stmt.executeBatch();
			stmt = conn.prepareStatement(queryTransaction);
			stmt.setString(1, "9e5d2938");
			stmt.setString(2, new Date().toString());
			stmt.setString(3, "SDA1234567890");
			stmt.setString(4, "SDA1234567891");
			stmt.setDouble(5, 250.0);
			stmt.setDouble(6, 4750.0);
			stmt.setString(7, "fund transfer");
			stmt.addBatch();
			stmt.executeBatch();
			stmt.setString(1, "9e5d2934");
			stmt.setString(2, new Date().toString());
			stmt.setString(3, "SDA1234567891");
			stmt.setNull(4, java.sql.Types.VARCHAR);
			stmt.setDouble(5, 750.0);
			stmt.setDouble(6, 4500.0);
			stmt.setString(7, "withdraw");
			stmt.addBatch();
			stmt.executeBatch();
			stmt.setString(1, "9e5d2904");
			stmt.setString(2, new Date().toString());
			stmt.setString(3, "SDA1234567891");
			stmt.setNull(4, java.sql.Types.VARCHAR);
			stmt.setDouble(5, 300.0);
			stmt.setDouble(6, 4800.0);
			stmt.setString(7, "deposit");
			stmt.addBatch();
			stmt.executeBatch();
			conn.close();
		}
		catch (BatchUpdateException e) {
			
		}catch (Exception e) {
			//e.printStackTrace();

		}

	}

	/*
	 * returns all the transactions for a particular account.
	 */
	public static Map<String, Transaction> getTransactions(String accountNum)
			throws ClassNotFoundException, SQLException, ParseException {
		Connection conn = WalletDB.getConnection();
		Statement stmt = conn.createStatement();
		Map<String, Transaction> trans = new HashMap<String, Transaction>();
		String query = "select * from bank_wallet_transaction where accfrom=\'" + accountNum + "\' OR accto=\'"
				+ accountNum + "\'";
		ResultSet rs = stmt.executeQuery(query);
		
		SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");

		while (rs.next()) {
			Transaction t1 = new Transaction();
			t1.setAccountFrom(rs.getString(3));
			t1.setAccountTo(rs.getString(4));
			t1.setAmount(rs.getDouble(5));
			t1.setId(rs.getString(1));
			t1.setRemark(rs.getString(7));
			t1.setTime(formatter.parse(rs.getString(2)));
			trans.put(rs.getString(1), t1);
		}

		return trans;
	}

	/*
	 * takes account number as input and returns the account object.
	 */
	public static Account getAccountDetails(String accountNum) throws SQLException, ClassNotFoundException {
		Connection conn = WalletDB.getConnection();
		Statement stmt = conn.createStatement();
		Account account = null;
		String query = "select * from bank_wallet_account where accnum=\'" + accountNum + "\'";
		ResultSet rs = stmt.executeQuery(query);

		if (rs.next()) {
			account = new Account();
			account.setAccountNumber(rs.getString(1));
			account.setBalance(rs.getDouble(4));
			account.setDob(rs.getString(5));
			account.setMobile(rs.getString(3));
			account.setName(rs.getString(2));
			account.setPassword(rs.getString(6));
		}

		return account;
	}

	/*
	 * Creates a new account.
	 * 
	 * @param account A variable of Account type
	 * 
	 * @return A String Data type
	 */
	@Override
	public String createAccount(Account account) throws ClassNotFoundException, SQLException {
		int count = 0;
		String accountNum = account.getAccountNumber();
		Connection conn = WalletDB.getConnection();
		Statement stmt = conn.createStatement();
		String query = "select count(*) from bank_wallet_account where accnum=\'" + accountNum + "\'";
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next() && rs.getInt(1) == 0) {
			String insertQuery = "INSERT INTO bank_wallet_account values(?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(insertQuery);
			pStmt.setString(1, account.getAccountNumber());
			pStmt.setString(2, account.getName());
			pStmt.setString(3, account.getMobile());
			pStmt.setDouble(4, account.getBalance());
			pStmt.setString(5, account.getDob());
			pStmt.setString(6, account.getPassword());
			count = pStmt.executeUpdate();

		}
		conn.close();
		if (count > 0)
			return accountNum;
		return null;
	}

	/*
	 * Gets the account details.
	 * 
	 * @param accountNum of type String
	 * 
	 * @return An Account data type
	 */
	@Override
	public Account getAccount(String accountNum) throws AccountNotFoundException, ClassNotFoundException, SQLException {
		Account account = new Account();
		Connection conn = WalletDB.getConnection();
		Statement stmt = conn.createStatement();
		String query = "select * from bank_wallet_account where accnum=\'" + accountNum + "\'";
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			account.setAccountNumber(rs.getString(1));
			account.setName(rs.getString(2));
			account.setMobile(rs.getString(3));
			account.setBalance(rs.getDouble(4));
			account.setDob(rs.getString(5));
			account.setPassword(rs.getString(6));
			conn.close();
			return account;
		}
		throw new AccountNotFoundException("No account found for account number " + accountNum);
	}

	/*
	 * Creates new Transaction
	 */
	@Override
	public String createTransaction(Transaction tran)
			throws ClassNotFoundException, SQLException, ParseException, AccountNotFoundException {

		Connection conn = WalletDB.getConnection();
		Statement stmt = conn.createStatement();
		String accountNum = tran.getAccountFrom();
		int count = 0;
		String query = "select count(*) from bank_wallet_account where accnum=\'" + accountNum + "\'";
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next() && rs.getInt(1) > 0) {
			String insertQuery = "INSERT INTO bank_wallet_transaction values(?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(insertQuery);
			pStmt.setString(1, tran.getId());
			pStmt.setString(2, tran.getTime().toString());
			pStmt.setString(3, tran.getAccountFrom());
			pStmt.setString(4, tran.getAccountTo());
			pStmt.setDouble(5, tran.getAmount());
			pStmt.setDouble(6, tran.getBalance());
			pStmt.setString(7, tran.getRemark());
			count = pStmt.executeUpdate();
			conn.close();
			if (count > 0)
				return tran.getId();

		} else {
			throw new AccountNotFoundException("No account found for account number " + accountNum);
		}
		return null;
	}

	/*
	 * Verifies if the account number and password are correct.
	 */
	private void verifyAccount(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException, ClassNotFoundException, SQLException {
		Account account = getAccount(accountNum);
		if (!account.getPassword().equals(password)) {
			throw new IncorrectPasswordException("You have entered an incorrect passoword!");
		}

	}

	/*
	 * Deposits the amount into the account.
	 */
	@Override
	public double depositAmount(String accountNum, double amount, String password)
			throws AccountNotFoundException, IncorrectPasswordException, InsufficientFundException,
			InvalidAmountException, ClassNotFoundException, SQLException, ParseException {
		if (amount <= 0) {
			throw new InvalidAmountException("Entered Amount is invalid " + amount);
		}

		Connection conn = WalletDB.getConnection();
		Statement stmt = conn.createStatement();
		verifyAccount(accountNum, password);
		Account account = getAccount(accountNum);
		double newBalance = account.getBalance() + amount;
		String query = "update bank_wallet_account set balance=" + newBalance + " where accnum=\'" + accountNum + "\'";
		stmt.executeUpdate(query);
		conn.close();
		return newBalance;
	}

	/*
	 * Withdraws the amount from the account.
	 */
	@Override
	public double withdrawAmount(String accountNum, double amount, String password)
			throws InvalidAmountException, AccountNotFoundException, IncorrectPasswordException,
			InsufficientFundException, ClassNotFoundException, SQLException, ParseException {
		if (amount <= 0) {
			throw new InvalidAmountException("Entered Amount is invalid " + amount);
		}
		Connection conn = WalletDB.getConnection();
		Statement stmt = conn.createStatement();
		verifyAccount(accountNum, password);
		Account account = getAccount(accountNum);
		if (amount > account.getBalance()) {
			throw new InsufficientFundException("You have Insufficient funds in your account.");
		}
		double newBalance = account.getBalance() - amount;
		String query = "update bank_wallet_account set balance=" + newBalance + " where accnum=\'" + accountNum + "\'";
		stmt.executeUpdate(query);
		conn.close();
		return newBalance;
	}

	/*
	 * Transfers the amount from one account to another.
	 */
	@Override
	public double fundTransfer(String accountNum, String password, String accountTo, double amount)
			throws InvalidAmountException, InsufficientFundException, AccountNotFoundException,
			IncorrectPasswordException, ClassNotFoundException, SQLException, ParseException {
		if (amount <= 0) {
			throw new InvalidAmountException("Entered Amount is invalid " + amount);
		}
		verifyAccount(accountNum, password);
		Account account = getAccount(accountNum);
		Account account_rec = getAccount(accountTo);
		if (amount > account.getBalance()) {
			throw new InsufficientFundException("You have Insufficient funds in your account.");
		}

		Connection conn = WalletDB.getConnection();
		Statement stmt = conn.createStatement();
		account_rec.setBalance(account_rec.getBalance() + amount);
		account.setBalance(account.getBalance() - amount);
		String query = "update bank_wallet_account set balance=" + account.getBalance() + " where accnum=\'"
				+ accountNum + "\'";
		stmt.executeUpdate(query);
		String query2 = "update bank_wallet_account set balance=" + account_rec.getBalance() + " where accnum=\'"
				+ accountTo + "\'";
		stmt.executeUpdate(query2);
		conn.close();
		return account.getBalance();
	}

	/*
	 * Prints all the transactions for a particular account
	 */
	@Override
	public void printTransactions(String accountNum, String password) throws AccountNotFoundException,
			IncorrectPasswordException, ClassNotFoundException, SQLException, ParseException {
		verifyAccount(accountNum, password);
		Map<String, Transaction> trans = getTransactions(accountNum);
		Set<Entry<String, Transaction>> s = trans.entrySet();
		Iterator<Entry<String, Transaction>> itr = s.iterator();
		while (itr.hasNext()) {
			Entry<String, Transaction> er = itr.next();
			System.out.println(er.getValue());
		}
	}

	@Override
	public void showBalance(String accountNum, String password)
			throws AccountNotFoundException, IncorrectPasswordException, ClassNotFoundException, SQLException {
		verifyAccount(accountNum, password);
		Account account = getAccount(accountNum);
		System.out
				.println("Current balance in account number " + accountNum + " is Rs. " + account.getBalance() + " .");

	}

}
