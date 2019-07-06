package lab8;

import java.io.File;
import java.util.Scanner;

public class Que4 {
/*
 * Write a Java program that reads on file name from the user,
 * then displays information about whether the file exists,
 * whether the file is readable, whether the file is writable,
 * the type of file and the length of the file in bytes?
 */
	public static void fileDetails(String filepath) {
		File f = new File(filepath);
		System.out.println("File exists : " + f.exists());
		System.out.println("File readable : " + f.canRead());
		System.out.println("File writable : " + f.canWrite());
		//System.out.println("\"" +filepath + "\"" );
		String[] s = "sample.txt".split(".");
		for(String s1 : s)
		{
			System.out.println(s1);
		}
		System.out.println(s.length);
		//System.out.println("File type : " + s[s.length]);
		System.out.println("File size : " + f.length() + "bytes");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String filepath = scan.nextLine();
		Que4.fileDetails(filepath);
		scan.close();
	}

}
