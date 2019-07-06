package io;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BuffOutStream {

	public static void main(String[] args) throws IOException {
		String path = "tmp.txt";
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
String s = "Hello";
byte [] byteArray = s.getBytes();
bos.write(byteArray);
bos.flush();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
		int i;
		while((i = bis.read()) != -1)
		{
			System.out.print((char)i);
		}
		bos.close();
		bis.close();

	}

}
