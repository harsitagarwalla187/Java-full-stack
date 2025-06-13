package com.mapping.app;


import com.mapping.app.entity.Passport;
import com.mapping.app.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App  {
    public static void main( String[] args )
    {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Passport passport = new Passport();
        passport.number = "A987654321";

        Person person = new Person();
        person.name = "John Doe";
        person.passport = passport; // Set one-to-one relationship

        // Step 4: Begin transaction
        session.beginTransaction();

        // Step 5: Save the person (cascade will save passport too)
        session.persist(person);

        // Step 6: Commit transaction
        session.getTransaction().commit();

        System.out.println("Person and Passport saved successfully!");

    }
}
