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
        Student s2 = null;

        // first need to create configuration object
        //Configuration cfg = new Configuration();
        //cfg.addAnnotatedClass(Student.class);
        //cfg.configure();
        // now need a object of SessionFactory
        //SessionFactory sf = cfg.buildSessionFactory();
        SessionFactory factory = new Configuration()
                            .addAnnotatedClass(Student.class)
                            .configure()
                            .buildSessionFactory();
        // now need session object
        Session session = factory.openSession();
        // create the object of Transaction
        //Transaction transaction = session.beginTransaction();
        s2 = session.find(Student.class,103);

        //session.persist(s1); // to persist the data in the database
        //transaction.commit();
        factory.close();

        System.out.println(s2);
    }
}
