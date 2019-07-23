package lab10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileProgram {

	public static void main(String[] args) {
		FileReader fReader = null;
		FileWriter fWriter = null;
		try {
			fReader = new FileReader("source.txt");
			fWriter = new FileWriter("target.txt");
		} catch (FileNotFoundException e) {//Caught when file does not exist
			System.out.println("File does not exist!");
		}catch (Exception e) {
			System.out.println("Something went wrong!");
		}
		CopyDataThread t = new CopyDataThread(fReader,fWriter);//Passing FileReader amd FileWriter objects to CopyDataThread object
		t.start();
	}

}
