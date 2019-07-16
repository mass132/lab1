package com.capg.wallet.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capg.wallet.utils.AccountNotFoundException;
import com.capg.wallet.utils.IncorrectPasswordException;
import com.capg.wallet.utils.InsufficientFundException;
import com.capg.wallet.utils.InvalidAmountException;

public class WalletDaoImplTest {
	WalletDaoImpl walletDao = new WalletDaoImpl();
	
	@Test
	public void depositAmountTest_1() throws AccountNotFoundException, IncorrectPasswordException, InsufficientFundException, InvalidAmountException
	{
		String accountNum = "SDA1234567890";
		String password = "Qwerty123_";
		double amount = 500.0;
		double actual_balance = walletDao.depositAmount(accountNum, amount, password);
		double expected_balance = 5250.0;
		System.out.println("Actual balance : "+actual_balance+" Expected balance : "+expected_balance);
		assertEquals(expected_balance, actual_balance,3);
		
	}
	@Test
	public void withdrawAmountTest_1() throws InvalidAmountException, AccountNotFoundException, IncorrectPasswordException, InsufficientFundException
	{
		String accountNum = "SDA1234567891";
		String password = "Qwerty123_";
		double amount = 600.0;
		double actual_balance = walletDao.withdrawAmount(accountNum, amount, password);
		double expected_balance = 4200.0;
		System.out.println("Actual balance : "+actual_balance+" Expected balance : "+expected_balance);
		assertEquals(expected_balance, actual_balance,3);
	}
	@Test
	public void fundTransferTest_1() throws InvalidAmountException, InsufficientFundException, AccountNotFoundException, IncorrectPasswordException
	{
		String accountNum = "SDA1234567890";
		String accountTo = "SDA1234567891";
		String password = "Qwerty123_";
		double amount = 10;
		double actual_balance = walletDao.fundTransfer(accountNum, password, accountTo, amount);
		double expected_balance = 5240.0;
		System.out.println("Actual balance : "+actual_balance+" Expected balance : "+expected_balance);
		assertEquals(expected_balance, actual_balance,3);
	}

}
