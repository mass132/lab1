package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
	/*
	 * disadvantage : only characters work,newline does not work depends on machine
	 * adv : it creates the file automatically
	 */
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("capg.txt");
		fw.write(98);
		fw.write("\nHello my name is poonam");
		char[] charArray = { 'a', 'b', 'c', 'd' };
		fw.write(charArray);
		fw.write("\n");
		fw.flush();
		fw.close();

	}

}
