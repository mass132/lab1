package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("cap.txt");
		BufferedReader fr1 = new BufferedReader(fr);
		String line = fr1.readLine();
		while (line != null) {
			System.out.println(line);
			line = fr1.readLine();
		}
		fr1.close();
		fr.close();


	}

}
