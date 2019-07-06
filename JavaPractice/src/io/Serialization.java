package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) throws IOException {
		Student s = new Student();
		s.setSno(1);
		s.setName("Poonam");
		s.setAddr("Chennai");
		Student s1 = new Student();
		s1.setSno(2);
		s1.setName("Poonam1");
		s1.setAddr("Chennai1");
		FileOutputStream fos = new FileOutputStream("student");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.writeObject(s1);
		System.out.println("success");
		oos.close();
		fos.close();

	}

}
