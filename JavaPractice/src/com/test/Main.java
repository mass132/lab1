package com.test;

public class Main {
	public static void checkInput(String input) throws MyNewException {
		if (!input.equals("poonam")) {
			throw new MyNewException("Not a valid username");
		} else {
			System.out.println("Welcome");
		}
	}

	public static void main(String[] args) throws MyNewException {
		try {
			checkInput("poonam");
			checkInput("hello");
		} catch (MyNewException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Something Went wrong!");
		}
	}
}
