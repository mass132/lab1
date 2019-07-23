package com.capgemini.contactbook.util;

public interface Util {

	static long generateId() {
		long id = 0;
		for (int i = 0; i < 4; i++) {
			id = (long) (id * 10 + Math.random() * 10);

		}
		return id;
	}

	static void validateName(String name) throws ContactBookException {
		if (!name.matches("^[a-zA-z][ a-zA-z]*"))
			throw new ContactBookException("Please enter a valid First Name! Only alphabets and spaces are allowed.");
	}

	static void validateContactNo(String contactNo) throws ContactBookException {
		if (!contactNo.matches("[6-9][0-9]{9}"))
			throw new ContactBookException("Please enter a valid Contact Number.");
	}

	static void validatePLocation(String pLocation) throws ContactBookException {
		if (!pLocation.matches("^[a-zA-z][ a-zA-z]*"))
			throw new ContactBookException("Please enter a valid Location.");

	}

	static void validatePDomain(String pDomain) throws ContactBookException {
		if (!pDomain.matches("^[a-zA-z][ a-zA-z]*"))
			throw new ContactBookException("Please enter a valid Domain.");

	}
}
