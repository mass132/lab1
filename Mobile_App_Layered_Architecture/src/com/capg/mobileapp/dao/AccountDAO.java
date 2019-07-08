package com.capg.mobileapp.dao;

import java.util.HashMap;
import java.util.Map;

import com.capg.mobileapp.beans.Account;
import com.capg.mobileapp.beans.AccountNotFoundException;

public class AccountDAO implements AccountDaoInterface {

	private Map<String,Account> accounts;
	public Account getAccountDetails(final String mobile) throws AccountNotFoundException {
		validateMobile(mobile);
		Account account = getAccount(mobile);
		return account;
	}
	private void validateMobile(final String mobile) throws AccountNotFoundException {
		boolean exists = getAccounts().containsKey(mobile);
		if(!exists)
		{
			throw new AccountNotFoundException("No account found for this number :"+mobile);
		}
		
	}
	public Map<String, Account> getAccounts() {
		return accounts;
	}
	public AccountDAO() {
		accounts = new HashMap<String,Account>();
		Account account1 = new Account("poonam",5000,"prepaid");
		accounts.put("7489846458", account1);
		Account account2 = new Account("rythem",5532,"prepaid");
		accounts.put("7489346356", account2);
		Account account3 = new Account("raj",7023,"prepaid");
		accounts.put("8087644978", account3);
		Account account4 = new Account("harry",5600,"prepaid");
		accounts.put("4779158798", account4);
		Account account5 = new Account("aadi",500,"prepaid");
		accounts.put("7825246785", account5);
	}
	public Account getAccount(final String mobile)
	{
		return getAccounts().get(mobile);
	}
	

}
