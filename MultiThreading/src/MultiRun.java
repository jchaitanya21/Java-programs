class MultiRun implements Runnable{  
public void run(){  
System.out.println("thread is running...");  
}  
  
public static void main(String args[]){  
MultiRun m1=new MultiRun();  
Thread t1 =new Thread(m1);  
t1.start();  
 }  
}  
