package io;

import java.io.File;
import java.io.IOException;

public class FileEx {

	public static void main(String[] args){
		File f = new File("hello.txt");
		File file1 = new File("capgemini");
		try {
			System.out.println(f.exists());
			System.out.println(f.createNewFile());
			System.out.println(f.exists());
			System.out.println(f.isDirectory());
			System.out.println(f.isFile());
			file1.mkdir();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		

	}

}
