package com.myapp.utility;

import com.myapp.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BookManager {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();
        System.out.println("Book added: " + book);
    }

    public List<Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        List<Book> books = session.createQuery("FROM Book", Book.class).list();
        session.close();
        return books;
    }

    public void updateBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(book);
        tx.commit();
        session.close();
        System.out.println("Book updated: " + book);
    }

    public void deleteBook(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Book book = session.get(Book.class, id);
        if (book != null) {
            session.delete(book);
            System.out.println("Deleted book with ID: " + id);
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
        tx.commit();
        session.close();
    }

    public static void shutdown() {
        sessionFactory.close();
    }

    public static void main(String[] args) {
        BookManager manager = new BookManager();

        Book book1 = new Book("Hibernate Basics", "John Doe", "1234567890", 2020);
        manager.addBook(book1);

        List<Book> books = manager.getAllBooks();
        books.forEach(System.out::println);

        book1.setAuthor("Jane Doe");
        manager.updateBook(book1);

        manager.deleteBook(book1.getId());

        shutdown();
    }
}
