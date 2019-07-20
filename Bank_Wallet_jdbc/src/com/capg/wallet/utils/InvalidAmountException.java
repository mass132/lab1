package com.capg.wallet.utils;

public class InvalidAmountException extends Exception {

	/**
	 * Thrown when the entered amount is invalid such as negative,or other than numerical value. 
	 *
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAmountException(String string) {
		super(string);
	}

}
