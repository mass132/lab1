package oopconcept;

public class Orange extends Fruit {
	  public static void main(String[] args) { 
	      Orange t = new Orange();
	      if(t instanceof Fruit) System.out.println("Fruit");
	      //if(t instanceof Apple) System.out.println("Apple");//throws exception
	      if(t instanceof Orange) System.out.println("Orange");
	  }
	}
	class Fruit {
	}
	class Apple extends Fruit {
	} 