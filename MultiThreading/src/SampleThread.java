
class SampleThread extends Thread{  
public void run(){  
System.out.println("thread is running...");  
}  
public static void main(String args[]){  
SampleThread t1=new SampleThread();  
t1.start();  
 }  
}  