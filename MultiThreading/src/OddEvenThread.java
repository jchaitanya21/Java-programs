import java.util.*;
public class OddEvenThread extends Thread
{
    public static void main(String args[])
    {
        System.out.println("Enter a Number:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Runnable r = new EvenNumber(n);
        Thread t = new Thread(r);
        Runnable r2 = new OddNumber(n);
        Thread t2 = new Thread(r2);
        
        t.start();
        t2.start();
    }
    
}
class EvenNumber implements Runnable
{
    int n;
    EvenNumber(int num)
    {
        this.n = num;
    }
    
    public void run()
    {
        
        for(int i=0;i<=n;i+=2)
        {
            System.out.print(" "+i);
        }
    }
}
class OddNumber implements Runnable
{
    int n;
    OddNumber(int num)
    {
        this.n = num;
    }
    
    public void run()
    {
        try
        {
            Thread.sleep(1000);
            System.out.println("\n");
            for(int i=1;i<=n;i+=2)
            {
                System.out.print(" "+i);
            }
            System.out.println("\n");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}