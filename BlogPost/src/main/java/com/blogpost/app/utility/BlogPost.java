package com.blogpost.app.utility;

import com.blogpost.app.entity.Blog;
import com.blogpost.app.entity.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class BlogPost {
    Session session;
    Scanner scan;

    public BlogPost(Session s) {
        session = s;
        scan = new Scanner(System.in);
    }

    public void addBlog() {

        Blog newBlog = new Blog();
        Transaction tx = session.beginTransaction();

        System.out.println("Add new Blog...");
        System.out.print("Enter Blog Title: ");
        newBlog.setTitle(scan.nextLine());
        System.out.println("Write Blog Content: ");
        newBlog.setContent(scan.nextLine());

        session.persist(newBlog);
        tx.commit();
    }

    public void addComment() {

        System.out.print("Enter Blog Id to comment on: ");
        int blogId = scan.nextInt();
        scan.nextLine();

        Blog blog = session.get(Blog.class, blogId);
        if (blog == null) {
            System.out.println("Blog with ID " + blogId + " not found.");
            return;
        }

        Comment comment = new Comment();
        System.out.print("Enter your name: ");
        comment.setName(scan.nextLine());
        System.out.print("Enter your comment message: ");
        comment.setMessage(scan.nextLine());
        blog.addComment(comment);

        Transaction tx = session.beginTransaction();
        session.persist(blog);
        tx.commit();

        System.out.println("Comment added successfully!");
    }

    public void  removeBlog() {
        System.out.print("Enter blog id to remove: ");
        int blogId = scan.nextInt();
        scan.nextLine();

        Transaction tx = session.beginTransaction();
        Blog blog = session.get(Blog.class, blogId);
        session.remove(blog);
        tx.commit();
    }

    public void removeComment() {
        System.out.print("Enter Blog Id of comment to remove: ");
        int blogId = scan.nextInt();
        System.out.println("Enter comment Id: ");
        int commentId = scan.nextInt();

        Blog blog = session.get(Blog.class, blogId);
        if(blog != null) {
            Comment comment = session.get(Comment.class, commentId);
            if(comment != null) {
                Transaction tx = session.beginTransaction();
                blog.getComments().remove(comment);
                session.remove(comment);
                tx.commit();
            }
        }
    }

    public void showBlog() {
        System.out.print("Enter Blog id to see: ");
        int id = scan.nextInt();
        scan.nextLine();

        Blog blog = session.get(Blog.class, id);
        if(blog != null) {
            System.out.println("Blog Title: " + blog.getTitle());
            System.out.println("Blog Content:\n" + blog.getContent());
            System.out.println("Comments: ");
            blog.getComments().stream().forEach(comment -> {
                System.out.println(comment.getId() + " " + comment.getName() + " " + comment.getMessage());
            });
        }
    }
}
