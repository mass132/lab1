package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream {

	public static void main(String[] args) throws IOException {
String path = "tmp.txt";
FileOutputStream fos = new FileOutputStream(path);
for(int i = 0;i < 10;i++)
{
	fos.write(i);
}
FileInputStream fis = new FileInputStream(path);
int i;
while((i = fis.read()) != -1)
{
	System.out.println(i);
}
fos.close();
fis.close();

	}

}

