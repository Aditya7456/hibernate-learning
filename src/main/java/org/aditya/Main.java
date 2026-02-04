package org.aditya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                            .addAnnotatedClass(Laptop.class)
                            .configure()
                            .buildSessionFactory();
        // now need session object
        Session session = factory.openSession();
        Laptop l1 = session.find(Laptop.class,3);
        System.out.println(l1);
        session.close();
        factory.close();


    }
}

/*
   Transaction transaction = session.beginTransaction();
   we need transaction object, if we are doing any changes in database.
   if we are just reading the data then transaction object is just optional.
 */
