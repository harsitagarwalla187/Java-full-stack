package com.employeemanagement.app.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Sessions {

    SessionFactory factory;

    public Sessions() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public Session getSession() {
        return factory.openSession();
    }

    public void closeFactory() {
        factory.close();
    }
}
