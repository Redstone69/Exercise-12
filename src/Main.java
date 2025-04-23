public class Main {
    public static void main(String[] args) {
        Account account = new Account(100);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                String simga = Thread.currentThread().getName();
                for (int i = 0; i < 10; i++) {
                    System.out.println(simga + " tries withdrawing $10       Balance: " + account.withdraw(10));

                }
            }
        };

        Thread person1 = new Thread(r);
        person1.setName("beavis");

        Thread person2 = new Thread(r);
        person2.setName("butthead");

        person1.start();
        person2.start();
    }
}

class Account
{
    private int balance;

    public Account(int BalanceX)
    {
        balance = BalanceX;
    }

    synchronized public int withdraw(int amount)
    {
        if (amount <= balance)
        {
            balance -= amount;
        }
        return balance;
    }
}
