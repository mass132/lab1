package lab10;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyDataThread extends Thread {

	FileReader fReader = null;
	FileWriter fWriter = null;

	public CopyDataThread(FileReader fReader, FileWriter fWriter) {
		super();
		this.fReader = fReader;
		this.fWriter = fWriter;
	}

	public void run() {
		try {
			fileCopy();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}

	}

	private synchronized void fileCopy() throws IOException {
		int i = -1;
		int count = 0;
		try {
			i = fReader.read();//Reading the character from the input stream
			while (i != -1) {
				fWriter.write((char) i); //Write character to the output stream
				fWriter.flush();
				i = fReader.read();
				count++;
				if (count % 10 == 0) {//Checks whether 10 characters copied or not
					System.out.println(count + " characters are copied");
					wait(5000); 
				}

			}
			System.out.println("Content copy successful!");
		} catch (InterruptedException e) {
			System.out.println("Program Interrupted!");
		}
	}

}
