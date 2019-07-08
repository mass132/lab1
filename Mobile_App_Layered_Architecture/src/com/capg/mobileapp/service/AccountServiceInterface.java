package com.capg.mobileapp.service;

import com.capg.mobileapp.beans.Account;
import com.capg.mobileapp.beans.AccountNotFoundException;
import com.capg.mobileapp.beans.InvalidMobileNoException;

public interface AccountServiceInterface {

	void validateMobile(String mobile) throws InvalidMobileNoException;
	Account getAccountDetails(String mobile) throws InvalidMobileNoException, AccountNotFoundException;

}
