package com.capg.wallet.dao;

import java.util.HashMap;
import java.util.Map;

import com.capg.wallet.beans.Account;

public class AccountDAO implements AccountDaoInterface {
	private Map<Long, Account> accounts = new HashMap<Long, Account>();

}
