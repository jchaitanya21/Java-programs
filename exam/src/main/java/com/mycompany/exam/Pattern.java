package com.mycompany.exam;


import java.util.*;
 class PatternThread extends Thread {

    int num;

    PatternThread(int n) {
        this.num = n;
    }

    public void run() {
        System.out.println("Printing Pattern of :" + num);
        synchronized (this) {
            try {
                for (int i = num; i >= 1; --i) {
                    for (int space = 1; space <= num - i; ++space) {
                        System.out.print("  ");
                    }

                    for (int j = i; j <= 2 * i - 1; ++j) {
                        System.out.print("* ");
                    }

                    for (int j = 0; j < i - 1; ++j) {
                        System.out.print("* ");
                    }

                    System.out.println();

                }
            } 
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
   
class Pattern
{
   public static void main(String args[]) throws InterruptedException
   {
       Random rand = new Random();
       int upper = 10;
       int int_rand1 = rand.nextInt(upper);
       int int_rand2 = rand.nextInt(upper);
       int int_rand3 = rand.nextInt(upper);
      
      
      
      PatternThread ob1=new PatternThread(int_rand1);
      PatternThread ob2=new PatternThread(int_rand2);
      PatternThread ob3=new PatternThread(int_rand3);
      
      
      ob1.start(); 
      ob1.join();
      
      ob2.start(); 
      ob2.join();
      
      ob3.start();
      
   }
}