class InterThreadDemo //This is main Thread
{
    public static void main(String arg[])
    {
        final Customer c = new Customer();
        new Thread()
        {
            public void run()
            {
                c.withdraw(25000);
            }
        }.start();
        new Thread()
        {
            public void run()
            {
                c.deposit(10000);
            }
        }.start();
        new Thread()
        {
            public void run()
            {
                c.deposit(10000);
            }
        }.start();    
    }
}

class Customer //this is second Thread
{
    int amt = 20000;

    synchronized void withdraw(int amt)
    {
        System.out.println("Available Balance " + this.amt);
        System.out.println("Going to withdraw." + amt);

        if (this.amt < amt)
        {
            System.out.println("Insufficient Balance Waiting for deposit.");
            try
            {
                wait();
            } catch (Exception e)
            {
                System.out.println("Interruption Occured");
            }
        }
        this.amt -= amt;
        System.out.println("Detected amaount: " + amt);
        System.out.println("Balance amount : " + this.amt);
    }

    synchronized void deposit(int amt)
    {
        System.out.println("Going to deposit " + amt);
        this.amt += amt;
        System.out.println("Available Balance " + this.amt);
        System.out.println("Transaction completed.\n");
        notify();
    }
}