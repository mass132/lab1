package com.cg.frs.exception;

public class RealEstateAppException extends Exception {

	/**
	 * It is thrown when an error occur in the appplication
	 */
	private static final long serialVersionUID = 1L;

	public RealEstateAppException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RealEstateAppException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public RealEstateAppException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public RealEstateAppException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public RealEstateAppException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
