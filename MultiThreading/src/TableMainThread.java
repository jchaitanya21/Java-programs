import java.util.*;

class TableThread extends Thread {
   int num;
   TableThread(int n)
   {
      this.num = n;
   }
   public void run() 
   {
      System.out.println("Printing table of :"+num);
      synchronized(this)
      {
         try{
            for(int i=0;i<=10;i++)
               System.out.println(num+" x "+i+" = "+num*i);
          
         }
         catch(Exception e){
            System.out.println(e);
         }
      }
   }
}

class TableMainThread
{
   public static void main(String args[]) throws InterruptedException
   {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Number for Table1 ");
      int n1 = sc.nextInt();
      
      System.out.println("Enter Number for Table2 ");
      int n2 = sc.nextInt();
      
      System.out.println("Enter Number for Table3 ");
      int n3 = sc.nextInt();
      
      
      TableThread ob1=new TableThread(n1);
      TableThread ob2=new TableThread(n2);
      TableThread ob3=new TableThread(n3);
      
      
      ob1.start(); 
      ob1.join();
      
      ob2.start(); 
      ob2.join();
      
      ob3.start();
      
   }
}
