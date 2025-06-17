package com.myapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String author;
    private String isbn;
    private int publishedYear;

    public Book() {}

    public Book(String title, String author, String isbn, int publishedYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
    }

    // Getters and Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getPublishedYear() { return publishedYear; }

    public void setPublishedYear(int publishedYear) { this.publishedYear = publishedYear; }

    @Override
    public String toString() {
        return "Book {id=" + id + ", title='" + title + "', author='" + author +
                "', isbn='" + isbn + "', publishedYear=" + publishedYear + "}";
    }
}
