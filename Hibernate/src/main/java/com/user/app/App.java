package com.user.app;

import com.user.app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

        User user = new User("rahul", "rahul@gmail.com", "chandigarh");
        session.persist(user);

        tx.commit();
        session.close();
        factory.close();
    }
}
