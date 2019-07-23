package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Que3 {
/*
 * Write a Java program that displays the number of characters, lines and words in a text?
 */
	public static void printCount(String filepath) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line;
		int wordCount = 0;
		int charCount = 0;
		int lineCount = 0;
		while((line = br.readLine()) != null)
		{
			
			String[] words = line.split(" ");
			String sentence = String.join("", words);
			charCount += sentence.length();
			wordCount += words.length;
			lineCount++;
		}
		br.close();
		System.out.println("Number of Lines : "+lineCount);
		System.out.println("Number of Words : "+wordCount);
		System.out.println("Number of Characters : "+charCount);
	}
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		String filepath = scan.nextLine();
		Que3.printCount(filepath);
		scan.close();
	}

}
