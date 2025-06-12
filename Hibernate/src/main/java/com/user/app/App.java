package com.user.app;

import com.user.app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
//        Configuration config = new Configuration();
//        Configuration cfg = config.configure();
//        SessionFactory factory = cfg.buildSessionFactory();
//        OR ->
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        User user1 = new User("rahul", "rahul@gmail.com", "chandigarh");
        session.persist(user1);
        User user2 = new User("amit", "amit@gmail.com", "Delhi");
        session.persist(user2);
        User user3 = new User("ayush", "ayush@gmail.com", "karol bagh");
        session.persist(user3);
        User user4 = new User("Raman", "raman@gmail.com", "gurgaon");
        session.persist(user4);
        User user5 = new User("akash", "akash@gmail.com", "bangalore");
        session.persist(user5);

        User usr = session.get(User.class, 1);
        System.out.println(usr);
        if(usr != null) {
            usr.setAddress("Patiala");
        }

        Query<User> users = session.createQuery("FROM User", User.class);
        List<User> usrs = users.list();
        System.out.println(usrs);

        tx.commit();
        session.close();
        factory.close();
    }
}
