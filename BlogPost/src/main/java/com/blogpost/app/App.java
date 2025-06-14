package com.blogpost.app;

import com.blogpost.app.utility.BlogPost;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Scanner scan = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("Welcome to Blog Post!");
            System.out.println("Select one option: ");
            System.out.println("1. Add Blog");
            System.out.println("2. Add Comment");
            System.out.println("3. Delete Blog");
            System.out.println("4. Delete Comment");
            System.out.println("5. Show Blog");
            System.out.println("6. Exit");
            int option = scan.nextInt();
            scan.nextLine();

            BlogPost bp = new BlogPost(session);

            switch (option) {
                case 1:
                    bp.addBlog();
                    break;
                case 2:
                    bp.addComment();
                    break;
                case 3:
                    bp.removeBlog();
                    break;
                case 4:
                    bp.removeComment();
                    break;
                case 5:
                    bp.showBlog();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Do you want to continue? (Y/N)");
                    char c = scan.nextLine().charAt(0);
                    flag = (c == 'Y' || c == 'y' );
            }
        } while(flag);

        System.out.println("Exited.");
    }
}
