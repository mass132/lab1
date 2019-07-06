package io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
	/*
	 * works with file object or file name
	 */
	public static void main(String[] args) throws IOException {
		File f = new File("cap.txt");
		FileReader fr = new FileReader(f);
		char[] charArray = new char[(int) f.length()];
		fr.read(charArray);
		for (char myChar : charArray) {
			System.out.print(myChar);
		}
		fr.close();
		System.out.println("\n++++++++++++++++++++++++++");

		FileReader fr1 = new FileReader("cap.txt");
		int i = fr1.read();
		while (i != -1) {
			System.out.print((char) i);
			i = fr1.read();
		}
		fr1.close();

	}

}
