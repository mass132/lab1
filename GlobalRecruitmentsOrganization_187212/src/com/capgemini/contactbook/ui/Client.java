package com.capgemini.contactbook.ui;

import java.util.Scanner;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.service.ContactBookService;
import com.capgemini.contactbook.service.ContactBookServiceImpl;
import com.capgemini.contactbook.util.ContactBookException;
import com.capgemini.contactbook.util.Util;
public class Client {
	private static Scanner scan = new Scanner(System.in);
	private static ContactBookService cbService = new ContactBookServiceImpl();

	/*
	 * @return ContactBookService
	 */
	static ContactBookService getCbService() {
		return cbService;
	}

	public static void showMenu() { // Prints the menu
		System.out.println(
				"*********************Global Recruitments*****************\nChoose an operation\r\n1. Enter Enquiry Details\n2. View Enquiry Details on Id\n3. Exit\n\n******************************************************\nPlease enter a choice:\n");
	}
	

	public static void addEnquiry() throws Exception {
		System.out.print("Enter First Name : ");
		String fName = scan.next();
		fName +=scan.nextLine().trim();//input the first name from the client
		Util.validateName(fName);
		System.out.print("Enter Last Name : ");
		String lName = scan.nextLine().trim();//input the last name from the client
		System.out.print("Enter Contact Number : ");
		String contact = scan.next().trim();//input the contact number from the client
		Util.validateContactNo(contact);
		long contactNo = Long.parseLong(contact);
		System.out.print("Enter Preferred Domain : ");
		String pDomain = scan.next();
		pDomain += scan.nextLine().trim();//input the preferred domain from the client
		Util.validatePDomain(pDomain);
		System.out.print("Enter Preferred Location   : ");
		String pLocation = scan.next();
		pLocation += scan.nextLine().trim();//input the preferred domain from the client
		Util.validatePLocation(pLocation);
		EnquiryBean bean = new EnquiryBean(fName, lName, contactNo, pLocation, pDomain);
		if(getCbService().isValidEnquiry(bean))
		{
		long enquiryId = getCbService().addEnquiry(bean);
		System.out.println("Thank you "+fName +" "+lName+" your Unique Id is "+enquiryId+" we will contact you shortly.");
		}
		
	}
	public static void getEnquiryDetails() throws ContactBookException
	{
		System.out.print("Enter the Enquiry No. : ");
		long enquiryId = Long.parseLong(scan.next());//input the Enquiry Id from the client
		EnquiryBean bean = getCbService().getEnquiryDetails(enquiryId);
		String output = String.format("%-15s%-15s%-15s%-15s%-15s\t%-15s","Id","First Name","Last Name","Contact No.","Preferred Domain","Preferred Location");
		String result = String.format("\n%-15d%-15s%-15s%-15d%-15s\t%-15s",bean.getEnqryId(),bean.getfName(),bean.getlName(),bean.getContactNo(),bean.getpLocation(),bean.getpDomain());
		System.out.println(output+result);
		
	}

	public static void run() {
		char run = 'y';
		do {
			showMenu();
			String choice = scan.next().trim(); //getting user choice for menu
			switch (choice) {
			case "1"://Add Enquiry
				try {
					addEnquiry();
				} catch (ContactBookException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Something went wrong!");
				}
				break;
			case "2"://View Enquiry
				try {
					getEnquiryDetails();
				} catch (ContactBookException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Something went wrong!");
				}
				break;
			case "3"://Exit
				System.out.println("Thank You for Selecting us!");
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

	public static void main(String[] args) throws ContactBookException {
		run();
	}

}
