package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterEx {
	/*
	 * disadvantage : Does not create file Automatically needs to pass the filewriter object,\n does not work,only characters work
	 * adv: newLine() method for new line,
	 */
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("capgbuff.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(100);
		bw.write("\nHello my name is poonam");
		bw.newLine();
		char[] charArray = { 'a', 'b', 'c', 'd' };
		bw.write(charArray);
		bw.flush();
		bw.close();
		fw.close();

	}

}
