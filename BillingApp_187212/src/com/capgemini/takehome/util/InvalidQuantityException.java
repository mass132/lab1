package com.capgemini.takehome.util;

public class InvalidQuantityException extends Exception {

	/**
	 * this Exception is thrown when quantity entered is invalid
	 */
	private static final long serialVersionUID = 1L;

	public InvalidQuantityException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidQuantityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidQuantityException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidQuantityException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidQuantityException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
