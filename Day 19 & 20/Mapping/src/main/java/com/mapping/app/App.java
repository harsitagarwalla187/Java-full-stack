package com.mapping.app;

import com.mapping.app.entity.Product;
import com.mapping.app.entity.Role;
import com.mapping.app.entity.User;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.util.Arrays;

public class App  {
    public static void main( String[] args )
    {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Product p1 = new Product("Milk", 16.0);
        Product p2 = new Product("Surf", 10.0);
        Product p3 = new Product("Coke", 20.0);
        Product p4 = new Product("Rice", 70.0);
        Product p5 = new Product("Shirt", 700.0);
        Product p6 = new Product("Jeans", 1500.0);
        Product p7 = new Product("Perfume", 600.0);
        Product p8 = new Product("Pizza", 900.0);

        Transaction tx = session.beginTransaction();
        session.persist(p1);
        session.persist(p2);
        session.persist(p3);
        session.persist(p4);
        session.persist(p5);
        session.persist(p6);
        session.persist(p7);
        session.persist(p8);
        tx.commit();

        HibernateCriteriaBuilder builder  = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);

        List<String> productNames = new ArrayList<>(Arrays.asList("Jeans", "Shirt", "Pizza"));
        Predicate p = root.get("name").in(productNames);
        query.select(root).where(p);
        List<Product> products = session.createQuery(query).getResultList();
        System.out.println(products);

//        Predicate isBetween = builder.between(root.get("price"), 500, 1000);
//        Predicate startsWithS = builder.like(root.get("name"), "s%");
//
//        query.select(root).where(builder.and(isBetween, startsWithS));
//        List<Product> products = session.createQuery(query).getResultList();
//        System.out.println(products);


//        User u1 = new User();
//        u1.setName("Harsit");
//        User u2 = new User();
//        u2.setName("Amit");
//        User u3 = new User();
//        u3.setName("Aman");
//
//        Role r1 = new Role();
//        r1.setDesignation("Admin");
//        Role r2 = new Role();
//        r2.setDesignation("Normal");
//        Role r3 = new Role();
//        r3.setDesignation("Staff");
//
//        r1.setUsers(Arrays.asList(u1));
//        r2.setUsers(Arrays.asList(u2, u3));
//        r3.setUsers(Arrays.asList(u2));
//
//        session.persist(r1);
//        session.persist(r2);
//        session.persist(r3);
//
//        User u4 = new User();
//        u4.setName("Ankit");
//        Role r4 = new Role();
//        r4.setDesignation("HR");
//        u4.setRoles(Arrays.asList(r4));
//
//        session.persist(u4);
//
//        tx.commit();

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
