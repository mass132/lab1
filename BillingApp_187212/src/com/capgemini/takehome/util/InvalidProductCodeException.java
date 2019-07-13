package com.capgemini.takehome.util;

public class InvalidProductCodeException extends Exception {

	/**
	 * This Exception is thrown when Invalid Product Code is entered by the client
	 */
	private static final long serialVersionUID = 1L;

	public InvalidProductCodeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidProductCodeException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InvalidProductCodeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidProductCodeException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidProductCodeException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
