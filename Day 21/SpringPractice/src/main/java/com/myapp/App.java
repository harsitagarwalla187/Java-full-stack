package com.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User u = (User)context.getBean("user");
        u.setId("1");
        u.setName("Aman");
        u.setPassword("12345678");
        System.out.println(u);

        Customer c = (Customer)context.getBean("customer");
        System.out.println(c);


    }
}
