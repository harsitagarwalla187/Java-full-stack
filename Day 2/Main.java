class BankAccount {
     private int balance = 0;

     void deposit(int amount) {
          balance += amount;
     }

     int getter() {
          return balance;
     }
}

public class Main {
     public static void main(String[] args) {
          BankAccount b = new BankAccount();
          b.deposit(1000);
          int balance = b.getter();
          System.out.println(balance);
     }
}