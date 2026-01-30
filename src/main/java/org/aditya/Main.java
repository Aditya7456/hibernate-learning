package org.aditya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Neelam");
        s1.setRollNo(125);
        s1.setAge(36);

        // first need to create configuration object
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure();


        // now need a object of SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();

        // now need session object
        Session session = sf.openSession();

        // create the object of Transaction
        Transaction transaction = session.beginTransaction();

        session.persist(s1);
        transaction.commit();

        System.out.println(s1);
    }
}
