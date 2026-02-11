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

        Laptop l1 = session.find(Laptop.class, 2);
        System.out.println(l1);
        session.close();

        Session session2 = factory.openSession();
        Laptop l2 = session2.find(Laptop.class, 2);
        System.out.println(l2);
        session.close();

        factory.close();
    }
}
