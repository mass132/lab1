package com.capgemini.takehome.util;

public class Util {
	/*
	 * Validates the product Id Throws InvalidProductCodeException if product code
	 * is not valid
	 */
	public static void validateProductCode(int productCode) throws InvalidProductCodeException {
		String pCode = Integer.toString(productCode);
		String regex = "[1-9][0-9]{3}";
		if (!pCode.matches(regex)) {
			throw new InvalidProductCodeException("Entered Product Code is invalid!");
		}
	}

	/*
	 * Validates the quantity throws InvalidQuantityException if quantity entered is
	 * less than or equal to zero or other than a number
	 */
	public static int validateQuantity(String quantity) throws InvalidQuantityException {
		int quantityNum = 0;
		try {
		quantityNum = Integer.parseInt(quantity);
		}catch(NumberFormatException e)
		{
			throw new InvalidQuantityException("Please enter a valid number as quantity!");
		}
		if (quantityNum <= 0) {
			throw new InvalidQuantityException("Please enter a valid number as quantity!");
		}
		return quantityNum;
	}
	

}
