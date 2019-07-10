package com.capg.wallet.exceptions;

public class IncorrectPasswordException extends Exception {

	/**
	 * Thrown when a wrong password is entered.
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectPasswordException(String string) {
		super(string);
	}

}
