package org.aditya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                            .addAnnotatedClass(Laptop.class)
                            .configure()
                            .buildSessionFactory();
        Session session = factory.openSession();
        //Laptop laptop = session.find(Laptop.class, 2);
        //session.load(Laptop.class,2);
        Laptop laptop = session.getReference(Laptop.class,1);
        System.out.println(laptop);
        session.close();
        factory.close();
    }
}
