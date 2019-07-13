package com.capgemini.takehome.ui;

import java.util.Scanner;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.service.IProductService;
import com.capgemini.takehome.service.ProductService;
import com.capgemini.takehome.util.InvalidProductCodeException;
import com.capgemini.takehome.util.InvalidQuantityException;
import com.capgemini.takehome.util.ProductNotFoundException;
import com.capgemini.takehome.util.Util;

public class Client {
	private static Scanner scan = new Scanner(System.in);
	private static IProductService productService = new ProductService();

	/*
	 * @return productService
	 */
	static IProductService getProductService() {
		return productService;
	}

	public static void showMenu() { // Prints the menu
		System.out.print(
				"1)\tGenerate Bill by entering Product code and quantity\n2)\tExit\nPlease enter your choice : ");
	}

	public static void productProcessing() throws Exception {
		System.out.println("Enter the product code : ");
		String input = scan.next().trim();//input product code from the client
		int pCode = Integer.parseInt(input);
		Util.validateProductCode(pCode); //validate product code
		System.out.println("Enter the quantity : ");
		input = scan.next().trim(); //Input Quantity of the  product
		int quantity = Util.validateQuantity(input); //Validate the quantity
		Product product = null;
		product = getProductService().getProductDetails(pCode); //Get the product code from the ProductService
		double totalCost = product.getProductPrice() * quantity; //Calculating the total cost
		
		System.out.println("Product Name\t\t:\t" + product.getProductName()); //Printing the product name
		System.out.println("Product Category\t:\t" + product.getProductCategory()); //Printing the product category
		System.out.println("Product Price(Rs.)\t:\t" + product.getProductPrice()); //Printing the product price
		System.out.println("Quantity\t\t:\t" + quantity); //Printing the product quantity
		System.out.println("Line Cost(Rs.)\t\t:\t" + totalCost); //Printing the total cost

	}

	public static void run() {
		char run = 'y';
		do {
			showMenu();
			String choice = scan.next().trim(); //getting user choice for menu
			switch (choice) {
			case "1"://Start the product Processing
				try {
					productProcessing();
				} catch (ProductNotFoundException | InvalidProductCodeException | InvalidQuantityException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Something went wrong!");
				}
				break;
			case "2"://Exit
				System.out.println("Program closed!");
				System.exit(0);
				break;
			default:
				System.out.println("Please select a valid option!");
			}
			System.out.println("\nDo you want to continue? (y/n)......");
			run = scan.next().charAt(0);
		} while (run == 'y' || run == 'Y');
		scan.close();
		System.out.println("Bye!");
	}

	public static void main(String[] args) {
		run();
	}

}
