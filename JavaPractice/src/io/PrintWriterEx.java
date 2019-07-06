package io;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterEx {
	/*
	 * disadvantage :\n does not work
	 *  adv: works with all data type,creates the fiel
	 * automatically
	 */
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter("capgprint.txt");
		out.println("\nhello");
		out.println(1000);
		out.println('s');
		out.println(false);
		out.println("ibm");
		out.flush();
		out.close();
	}

}