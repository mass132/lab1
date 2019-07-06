package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Student s = null;
		FileInputStream fos = new FileInputStream("student");
		ObjectInputStream ois = new ObjectInputStream(fos);

		while (fos.available() > 0) {
			s = (Student) ois.readObject();
			System.out.println(s.getName());
			System.out.println(s.getSno());
			System.out.println(s.getAddr());
		}
		ois.close();
		fos.close();

	}

}
