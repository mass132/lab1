package com.gmail.ui;

import java.util.Scanner;
import com.gmail.services.GmailService;

public class GmailUI {

	public static void main(String[] args) {
		String username = "";
		String password = "";
		String mobile = "";
		int age = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter username : ");
		username = scan.next();
		System.out.println("Enter new password : ");
		password = scan.next();
		System.out.println("Enter mobile number : ");
		mobile = scan.next();
		System.out.println("Enter your age: ");
		age = scan.nextInt();
		scan.close();
		GmailService gmailService = new GmailService();
		int result = gmailService.addUser(username, password, mobile, age);
		if (result > 0) {
			System.out.println("User Account created!");
		} else {
			System.out.println("Failed to create User Account!");
		}

	}

}
