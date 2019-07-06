package oopconcept;

public class Overriding extends Parent{
static void marriage() {
	System.out.println("Marry girl B");
}
public static void main(String[] args) {
	Overriding.property();
	Overriding.marriage();
	Overriding o = new Overriding();
	o.m2();
	
	
}
}
