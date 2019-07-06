package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamEx {

	public static void main(String[] args) throws IOException {
		FileOutputStream fs = new FileOutputStream("hello.txt");
		DataOutputStream dos = new DataOutputStream(fs);
		dos.writeInt(10);
		dos.writeUTF("poonam");
		DataInputStream dis = new DataInputStream(new FileInputStream("hello.txt"));
		System.out.println("int : "+ dis.readInt());
		System.out.println("int : "+ dis.readUTF());
		dos.close();
		dis.close();

	}

}
