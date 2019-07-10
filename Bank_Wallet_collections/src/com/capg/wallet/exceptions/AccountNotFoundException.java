package com.capg.wallet.exceptions;

public class AccountNotFoundException extends Exception {

	/**
	 * Thrown when no account is found for a particular account number.
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String string) {
		super(string);
	}

}
