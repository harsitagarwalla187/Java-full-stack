package com.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
//        Payment credit = new Credit();
//        Payment debit = new Debit();
//        Payment upi = new UPI();
//
//        OrderService order1 = new OrderService(credit);
//        order1.placeOrder(1500.00);
//
//        OrderService order2 = new OrderService(debit);
//        order2.placeOrder(750.00);
//
//        OrderService order3 = new OrderService(upi);
//        order3.placeOrder(300.00);

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService os = (OrderService)context.getBean("orderService");
        os.placeOrder(1500.00);
    }
}
