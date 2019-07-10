package com.capg.wallet.exceptions;

public class NameFormatException extends Exception {

	/**
	 * Thrown if Name contains any other character than alphabets and spaces.
	 */
	private static final long serialVersionUID = 1L;

	public NameFormatException(String string) {
		super(string);
	}

}
