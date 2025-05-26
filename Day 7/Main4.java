class ShoppingCart<T> {

     // T products[];

     // ShoppingCart(int size) {
     //      products = (T[]) new Object[size];
     // } 

     private T product;

     public void addProduct(T product) {
          this.product = product;
     }

     public T showProduct() {
          return this.product;
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

public class Main4 {
     public static void main(String[] args) {
          
          ShoppingCart<Book> b = new ShoppingCart<>();
          b.addProduct(new Book());
          ShoppingCart<Clothes> c = new ShoppingCart<>();
          c.addProduct(new Clothes());
          ShoppingCart<Electronics> e = new ShoppingCart<>();
          e.addProduct(new Electronics());

          // System.out.println(b.showProduct());
          // System.out.println(c.showProduct());
          // System.out.println(e.showProduct());

          Object[] products = {b, c, e};
          for(Object i:products) {
               ShoppingCart<?> cart = (ShoppingCart<?>) i;
               System.out.println(cart.showProduct());
          }

     }
}


// Experiment that doesn't work

// class ShoppingCart<T> {

//      private T[] products;
//      private int size = 3;
//      private int pointer = 0;

//      ShoppingCart() {
//           products = (T[]) new Object[size];
//      } 

//      public void addProduct(T product) {
//           this.products[pointer++] = product;
//      }

//      public void showProducts() {
//           for(int i=0; i<pointer; i++) {
//                System.out.println(this.products[i]);
//           }
//      }

// }

// class Book {
//      public String toString() {
//           return "Book added!";
//      }
// }

// class Clothes {
//      public String toString() {
//           return "Clothes added!";
//      }
// }

// class Electronics {
//      public String toString() {
//           return "Electronics added!";
//      }
// }

// public class Main5 {
//      public static void main(String[] args) {
          
//           ShoppingCart<Book> b = new ShoppingCart<>();
//           b.addProduct(new Book());
//           ShoppingCart<Clothes> c = new ShoppingCart<>();
//           c.addProduct(new Clothes());
//           ShoppingCart<Electronics> e = new ShoppingCart<>();
//           e.addProduct(new Electronics());

//           e.showProducts();

//      }
// }