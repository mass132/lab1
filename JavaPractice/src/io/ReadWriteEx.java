package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteEx {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter username : ");
		String username = scan.nextLine();
		System.out.println("Enter your password : ");

		String password = scan.nextLine();

		FileReader fr = new FileReader("user.txt");
		BufferedReader fr1 = new BufferedReader(fr);
		String username1 = fr1.readLine();
		String password1 = fr1.readLine();
		while((username1 != null) || (password1 != null))
		{
		
		if (username.equals(username1) && password.equals(password1)) {
			System.out.println("Successful");
			System.exit(1);
		}
		username1 = fr1.readLine();
		password1 = fr1.readLine();
		}
		System.out.println("Failed");
		scan.close();
		fr1.close();
		fr.close();
	}

}
