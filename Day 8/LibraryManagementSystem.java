// A library system needs to:
// Track books borrowed without duplication (HashSet)
// Maintain the borrowing order (LinkedHashSet)
// List all borrowed books in alphabetical order (TreeSet)
// Check if a book has already been borrowed.
// Class Name: LibrarySystem

// Fields:
// HashSet<String> hashSet – to ensure no duplicate books.
// LinkedHashSet<String> linkedHashSet – to preserve borrow order.
// TreeSet<String> treeSet – to keep books sorted alphabetically.

// Methods:
// borrowBook(String bookName) – adds the book to all sets.
// hasBorrowed(String bookName) – checks if the book was borrowed.
// printBorrowedInOrder() – prints books in borrowing order.
// printBorrowedSorted() – prints books in alphabetical order.

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

class LibrarySystem {
     private HashSet<String> booksborrowed;
     private LinkedHashSet<String> borrowersOrder;
     private TreeSet<String> sortedBooks;

     LibrarySystem() {
          booksborrowed = new HashSet<>();
          borrowersOrder = new LinkedHashSet<>();
          sortedBooks = new TreeSet<>();
     }

     public void borrowBook(String bookName) {
          if(!booksborrowed.contains(bookName)) {
               booksborrowed.add(bookName);
               borrowersOrder.add(bookName);
               sortedBooks.add(bookName);
          }
     }

     public void hasBorrowed(String bookName) {
          if(booksborrowed.contains(bookName)) 
               System.out.println("Book has been borrowed already!");
          else
               System.out.println("Book has been not borrowed!");
     }

     public void printBorrowedInOrder() {
          System.out.println("Books borrowed inorder: " + this.borrowersOrder);
     }

     public void printBorrowedSorted() {
          System.out.println("Books in sorted order: " + this.sortedBooks);
     }

}

public class LibraryManagementSystem {
     public static void main(String[] args) {
          LibrarySystem ls = new LibrarySystem();
          ls.borrowBook("Head First Java");
          ls.borrowBook("Beginner friendly C++");
          ls.borrowBook("Cracking the Coding Interview");

          ls.hasBorrowed("Head First Java");
          ls.hasBorrowed("Python");

          ls.printBorrowedInOrder();
          ls.printBorrowedSorted();

     }
}