import java.lang.*;
class Producer extends Thread
{
    StringBuffer buffer;
    Producer()
    {
        buffer = new StringBuffer(10);
        
    }
    public void run()
    {
        synchronized(buffer)
        {
            for(int i=0;i<10;i++)
            {
                try
                {
                    buffer.append(i);
                    System.out.println("Produced item:"+ i);
                }
                catch(Exception E)
                {
                    System.out.println(E);
                }
            }
                System.out.println("Buffer is Full !");
                buffer.notify();
        }
    }
}

class Consumer extends Thread
{
    Producer p;
    Consumer(Producer t)
    {
        p = t;
    }
    public void run()
    {
        synchronized(p.buffer)
        {
            try
            {
                p.buffer.wait();
            }
            catch(Exception E)
            {
                System.out.println(E);
            }
        }
        for(int i=0;i<10;i++)
        {
            System.out.println(p.buffer.charAt(i)+"  Product is consumed");
        }
        System.out.println("Buffer is Empty !");
    }
}
public class ProducerConsumer {
    public static void main(String args[])
    {
        Producer p = new Producer();
        Consumer c = new Consumer(p);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t2.start();
        t1.start();
    }
}
