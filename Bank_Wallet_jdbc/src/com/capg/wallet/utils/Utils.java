package com.capg.wallet.utils;

public class Utils {
	/*
	 * Returns true if mobile number contains 10 digit,else false.
	 */
	public static void validateMobile(String mobile) throws InvalidMobileNoException {
		if (!mobile.matches("^[6-9][0-9]{9}$")) {
			throw new InvalidMobileNoException("Invalid Mobile Number ");
		}
	}

	/*
	 * Returns true if date is in accepted format,else false.
	 */
	public static void validateDate(String date) throws InvalidDateException {
		String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
		if (!date.matches(regex)) {
			throw new InvalidDateException("Entered date is invalid ");
		}
	}

	/*
	 * Returns true if password is in correct format.
	 */
	public static void validatePassword(String password) throws InvalidPasswordException {
		String regex = "[1-9a-zA-Z_@]{8,}";
		if (!password.matches(regex)) {
			throw new InvalidPasswordException(
					"Entered password is invalid (Your password must contain 1 Uppercase, 1 Lowercase, 1 number and the length should be minimum 8 characterds long) ");
		}
	}

	/*
	 * Returns true if name is in accepted format,else false.
	 */
	public static void validateName(String name) throws NameFormatException {
		String regex = "[a-zA-Z ]{3,}";
		if (!name.matches(regex)) {
			throw new NameFormatException("Please enter a valid name (Only alphabets are allowed in name) ");
		}
	}

	/*
	 * Generates random String of given length.
	 */
	public static String randomString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

}
