package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationEx {
	public static void read() throws ClassNotFoundException, IOException {
		Person p1 = null;
		FileInputStream fos = new FileInputStream("person_data.dat");
		ObjectInputStream ois = new ObjectInputStream(fos);

		while (fos.available() > 0) {
			p1 = (Person) ois.readObject();
			System.out.println(p1.getName());
			System.out.println(p1.getHouseNo());
		}
		ois.close();
		fos.close();
	}

	public static void write() throws IOException {
		Person p1 = new Person();
		p1.setName("poonam");
		p1.setHouseNo(10);
		FileOutputStream fos = new FileOutputStream("person_data.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p1);
		System.out.println("success");
		oos.close();
		fos.close();
	}

	public static void main(String[] args) throws IOException {

		try {
			write();
			read();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}

}
