package oopconcept;

class Test {}
class Super extends Test {
 public static void main (String[] args) {
  Super ano = new Super();
  Test t = new Test();
  //System.out.println(ano.super.getClass());//throws exception
  System.out.println(t.getClass());
  System.out.println(ano.getClass());
 }
}