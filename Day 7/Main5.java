class ShoppingCart<T> {

     private static int size = 3;
     private static int pointer = 0;
     private static Object[] products = new Object[size];

     ShoppingCart() {
          // products = new Object[size];
     } 

     public void addProduct(T product) {
          this.products[pointer++] = product;
     }

     // THis defies the law of Generic as its shared across all instances
     public void showProducts() {
          for(int i=0; i<pointer; i++) {
               System.out.println(this.products[i]);
          }
     }
}

class Book {
     public String toString() {
          return "Book added!";
     }
}

class Clothes {
     public String toString() {
          return "Clothes added!";
     }
}

class Electronics {
     public String toString() {
          return "Electronics added!";
     }
}

public class Main5 {
     public static void main(String[] args) {
          
          ShoppingCart<Book> b = new ShoppingCart<>();
          b.addProduct(new Book());
          ShoppingCart<Clothes> c = new ShoppingCart<>();
          c.addProduct(new Clothes());
          ShoppingCart<Electronics> e = new ShoppingCart<>();
          e.addProduct(new Electronics());

          e.showProducts();

     }
}