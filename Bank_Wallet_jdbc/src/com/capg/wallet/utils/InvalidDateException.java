package com.capg.wallet.utils;

public class InvalidDateException extends Exception {

	/**
	 * Thrown when date is entered in an invalid or not acceptable format or syntax.
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDateException(String string) {
		super(string);
	}

}
