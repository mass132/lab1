package com.capg.wallet.exceptions;

public class InvalidReceiverException extends Exception {

	/**
	 * Thrown when sender and receiver account numbers are same.
	 */
	private static final long serialVersionUID = 1L;

	public InvalidReceiverException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidReceiverException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InvalidReceiverException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidReceiverException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidReceiverException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
