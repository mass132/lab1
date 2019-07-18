package com.cg.frs.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.exception.RealEstateAppException;
import com.cg.frs.service.FlatRegistrationServiceImpl;
import com.cg.frs.service.IFlatRegistrationService;

public class Client {
	private static Scanner scan = new Scanner(System.in);
	private static IFlatRegistrationService frService = new FlatRegistrationServiceImpl();

	/*
	 * @return FlatRegistrationService object
	 */
	static IFlatRegistrationService getFrService() {
		return frService;
	}

	public static void showMenu() { // Prints the menu
		System.out.println(
				"*********************XYZ Real Estate*****************\n1. Register Flat\n2. Display flat Registration Details\n3. Exit\n\n******************************************************\nPlease enter a choice:\n");
	}

	/*
	 * Takes the details and registers the flat
	 */
	public static void regFlat() throws RealEstateAppException {
		System.out.print("Existing Owner IDs are :-  ");
		System.out.println(getFrService().getAllOwnerIds());
		System.out.print("Please enter your owner id from above list: ");
		int ownerId = 0;
		try {
			ownerId = Integer.parseInt(scan.next().trim());// getting the owner id from client
		} catch (NumberFormatException e) {
			throw new RealEstateAppException("Please enter valid Owner Id from the list. ");
		}
		System.out.print("Select Flat Type (1-1BHK,2-2BHK) : ");
		int flatTypeId = 0;
		try {
			flatTypeId = Integer.parseInt(scan.next().trim());// getting the flat type from client
		} catch (NumberFormatException e) {
			throw new RealEstateAppException("Please enter valid Flat Type from the list. ");
		}
		String flatType = "";
		if (flatTypeId == 2)
			flatType = "2BHK";
		else if (flatTypeId == 1)
			flatType = "1BHK";
		System.out.print("Enter Flat area in sq. ft.  : ");
		double area = 0.0;
		try {
			area = Double.parseDouble(scan.next().trim());// getting the flat area from client
		} catch (NumberFormatException e) {
			throw new RealEstateAppException("Please enter valid Flat Area. ");
		}

		System.out.print("Enter desired rent amount : ");
		double rent = 0.0;
		try {
			rent = Double.parseDouble(scan.next().trim());// getting the desired rent from client
		} catch (NumberFormatException e) {
			throw new RealEstateAppException("Please enter valid amount. ");
		}
		System.out.print("Enter desired deposit amount : ");
		double deposit = 0.0;
		try {
			deposit = Double.parseDouble(scan.next().trim());// getting the desired deposit from client
		} catch (NumberFormatException e) {
			throw new RealEstateAppException("Please enter valid amount. ");
		}
		((FlatRegistrationServiceImpl) getFrService()).validateDetails(ownerId, flatType, deposit, rent, area);
		FlatRegistrationDTO flat = new FlatRegistrationDTO(ownerId, flatType, area, rent, deposit);
		FlatRegistrationDTO flatDetails = getFrService().registerFlat(flat);

		if (flatDetails != null) {
			System.out.println("Flat successfully registered.Registration id: " + flatDetails.getRegId());
			System.out.println(flatDetails);
		}

	}

	/*
	 * prints all the flat details
	 */
	public static void printFlatDetails() {
		ArrayList<FlatRegistrationDTO> details = getFrService().getFlatDetails();
		if (details.isEmpty()) {
			System.out.println("No records found!");
		}
		for (FlatRegistrationDTO detail : getFrService().getFlatDetails()) {
			System.out.println(detail);
		}

	}

	/*
	 * entry point for the application
	 */
	public static void run() {
		char run = 'y';
		do {
			showMenu();
			String choice = scan.next().trim(); // getting user choice for menu
			switch (choice) {
			case "1":// Register Flat
				try {
					regFlat();
				} catch (RealEstateAppException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Something went wrong!");
				}
				break;
			case "2":// View flat Registration Details
				try {
					printFlatDetails();
				} catch (Exception e) {
					System.out.println("Something went wrong!");
				}
				break;
			case "3":// Exit
				System.out.println("Thank You for using our service!");
				System.exit(0);
				break;
			default:
				System.out.println("Please select a valid option!");
			}
			System.out.println("\nDo you want to continue? (y/n)......");
			run = scan.next().charAt(0);
		} while (run == 'y' || run == 'Y');
		scan.close();
	}

	public static void main(String[] args) {
		run();
	}

}
