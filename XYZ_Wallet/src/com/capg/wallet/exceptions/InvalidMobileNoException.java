package com.capg.wallet.exceptions;

public class InvalidMobileNoException extends Exception {

	/**
	 * Thrown when entered mobile number is found invalid.
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMobileNoException(String string) {

		super(string);
	}

}
