package com.capgemini.xyz.util;

public class Util {
	public static boolean validateEmail(String email) {
		String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
		return email.matches(regex);
	}

	public static boolean validateName(String name) {
		String regex = "^[\\p{L} .'-]+$";
		return name.matches(regex);

	}

	public static boolean validateAddress(String address) {

		String regex = "^[.0-9a-zA-Z\\s,-]+$";
		return address.matches(regex);
	}

	public static void main(String[] args) {
		System.out.println(validateName("pooanm"));
	}

	public static long generateCustId() {
		int i = 0;
		long id = 1;
		while (i < 8) {
			int current = (int) Math.random() * 10;
			id = id * 10 + current;
		}
		return id;
	}

	public static long generateLoanId() {
		int i = 0;
		long id = 2;
		while (i < 6) {
			int current = (int) Math.random() * 10;
			id = id * 10 + current;
		}
		return id;
	}

}
