package com.mapping.app;

import com.mapping.app.entity.Role;
import com.mapping.app.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class App  {
    public static void main( String[] args )
    {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        User u1 = new User();
        u1.setName("Harsit");
        User u2 = new User();
        u2.setName("Amit");
        User u3 = new User();
        u3.setName("Aman");

        Role r1 = new Role();
        r1.setDesignation("Admin");
        Role r2 = new Role();
        r2.setDesignation("Normal");
        Role r3 = new Role();
        r3.setDesignation("Staff");

        r1.setUsers(Arrays.asList(u1));
        r2.setUsers(Arrays.asList(u2, u3));
        r3.setUsers(Arrays.asList(u2));

        session.persist(r1);
        session.persist(r2);
        session.persist(r3);

        User u4 = new User();
        u4.setName("Ankit");
        Role r4 = new Role();
        r4.setDesignation("HR");
        u4.setRoles(Arrays.asList(r4));

        session.persist(u4);

        tx.commit();

//        Passport passport = new Passport();
//        passport.number = "A987654321";
//
//        Person person = new Person();
//        person.name = "John Doe";
//        person.passport = passport; // Set one-to-one relationship
//
//        Transaction tx = session.beginTransaction();

        // Step 5: Save the person (cascade will save passport too)
//        session.persist(person);
//
//        tx.commit();
//        System.out.println("Person and Passport saved successfully!");
        session.close();
        factory.close();
    }
}
