package com.capg.wallet.utils;

public class InsufficientFundException extends Exception {

	/**
	 * Thrown when there is not sufficient balance in account to complete the transaction.
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientFundException(String string) {
		super(string);
	}

}
