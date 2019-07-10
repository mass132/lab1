package com.test;

public class Test implements Runnable
{public void run(){
    System.out.println("r1 ");
    System.out.println("r2 ");  }
 public static void main( String[] args ) throws InterruptedException
 { Thread t = new Thread(new Test()); 
    t.start();
    System.out.println("m1 ");
    t.join();
    System.out.println("m2 "); }}
