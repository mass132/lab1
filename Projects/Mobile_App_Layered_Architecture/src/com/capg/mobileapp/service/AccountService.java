package com.capg.mobileapp.service;

import com.capg.mobileapp.beans.Account;
import com.capg.mobileapp.beans.AccountNotFoundException;
import com.capg.mobileapp.beans.InvalidMobileNoException;
import com.capg.mobileapp.dao.AccountDAO;

public class AccountService implements AccountServiceInterface {
	private AccountDAO accountDao;

	public AccountService(final AccountDAO accountDao) {
		super();
		this.accountDao = accountDao;
	}

	public AccountDAO getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void validateMobile(final String mobile) throws InvalidMobileNoException {
		if(mobile != null && !mobile.isEmpty() && mobile.matches("[0-9]{10}"))
		{
			
		}
		else
		{
			throw new InvalidMobileNoException("Not a valid mobile number : "+mobile);
		}
		
	}

	@Override
	public Account getAccountDetails(final String mobile) throws InvalidMobileNoException, AccountNotFoundException {
		validateMobile(mobile);
		Account account = getAccountDao().getAccountDetails(mobile);
		return account;
	}

}
