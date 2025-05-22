abstract class Payment {
     double amount;
     Payment(double amount) {
          this.amount = amount; 
     }
     abstract void makePayment();
}

class CreditCardPayment extends Payment {
     CreditCardPayment(double amount) {
          super(amount);
     }
     void makePayment() {
          System.out.println(amount + " amount paid using credit card.");
     }
}

class UPI extends Payment {
     UPI(double amount) {
          super(amount);
     }
     void makePayment() {
          System.out.println(amount + " amount paid by UPI.");
     }
}

class Main {
     public static void main(String[] args) {
          Payment p = new CreditCardPayment(500);
          p.makePayment();
          Payment P = new UPI(1000);
          P.makePayment();
     }
}