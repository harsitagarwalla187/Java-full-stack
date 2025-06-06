class Account {
    int balance;

    Account() {
        balance = 10_000;
    }

    public synchronized void withdraw() {
        balance -= 1000;
        System.out.println(balance);
    }
}

class User extends Thread {
    Account account;

    User(Account account) {
        this.account = account;
    }

    public void run() {
        account.withdraw();
    }
}

public class SynchronizationExample {
    public static void main(String[] args) {

        Account ac = new Account(); 
        User u1 = new User(ac);
        User u2 = new User(ac);

        u1.start();
        u2.start();
    }
}
