package com.capg.wallet.exceptions;

public class InvalidPasswordException extends Exception {

	/**
	 * Thrown when password contains invalid or unaccepted characters or symbols.
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(String string) {

		super(string);
	}
}
