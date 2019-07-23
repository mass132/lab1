package ex1.com.cg.eis.utils;

public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s1;

	public MyException(String s) {
		s1 = s;

	}

	public String toString() {
		return (s1);
	}

}