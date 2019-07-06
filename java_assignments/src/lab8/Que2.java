package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Que2 {
	/*
	 * Write a Java program that reads a file and displays the file on the screen,
	 * with a line number before each line?
	 */
	public static void printWithLineNum(String filepath) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line;
		int count = 0;
		while((line = br.readLine()) != null)
		{
			System.out.print(count++);
			System.out.print("\t");
			System.out.println(line);
		}
		br.close();
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String filepath = scan.nextLine();
		Que2.printWithLineNum(filepath);
		scan.close();

	}

}
