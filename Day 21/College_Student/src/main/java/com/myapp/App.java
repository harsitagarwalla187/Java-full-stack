package com.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
//        Student s =(Student)context.getBean("student");
//        System.out.println(s);

//        ManyStudents ms = (ManyStudents) context.getBean("manyStudents");
//        System.out.println(ms);

//        Teacher t = (Teacher) context.getBean("teacher");
//        System.out.println(t);

        Library l = (Library) context.getBean("library");
        System.out.println(l);
    }
}
