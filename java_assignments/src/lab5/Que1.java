package lab5;

import java.util.Scanner;

public class Que1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your choice : ");
		System.out.println("Red : 1\nYellow : 2\nGreen : 3");
		int input = scan.nextInt();
		switch(input)
		{
		case 1:
			System.out.println("Stop");
			break;
		case 2:
			System.out.println("Ready");
			break;
		case 3:
			System.out.println("Go");
			break;
		default:
			System.out.println("Invalid Input");
		}
		scan.close();
	}

}
