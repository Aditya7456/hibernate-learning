package org.aditya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        //Student s1 = null;
//        Student s1 = new Student();
//        s1.setName("Poonam");
//        s1.setRollNo(201);
//        s1.setAge(46);
        //Student s2 = null;

        /* persist()  -> to save the data
           find()   -> to find the data
           merge()  -> to update and save both
           remove()  -> to remove the data from the database
         */



        // first need to create configuration object
        //Configuration cfg = new Configuration();
        //cfg.addAnnotatedClass(Student.class);
        //cfg.configure();
        // now need a object of SessionFactory
        //SessionFactory sf = cfg.buildSessionFactory();
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("hp");
        l1.setModel("probook");
        l1.setRam(16);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Rahul");
        a1.setTech("Java");
        a1.setLaptop(l1);

        SessionFactory factory = new Configuration()
                            .addAnnotatedClass(Alien.class)
                            .addAnnotatedClass(Laptop.class)
                            .configure()
                            .buildSessionFactory();
        // now need session object
        Session session = factory.openSession();

        //s1 = session.find(Student.class,119);
        // create the object of Transaction
        Transaction transaction = session.beginTransaction();
        //s2 = session.find(Student.class,103);
        //session.merge(s1); it will update and save based on if data is there or not
        // to update the data save() is depricated.
        // now deleting the studen from the database;
        //session.remove(s1);
        session.persist(l1);
        session.persist(a1);


        //session.persist(s1); // to persist the data in the database
        transaction.commit();
        factory.close();
        session.close();

        System.out.println(a1);
    }
}

/*
   Transaction transaction = session.beginTransaction();
   we need transaction object, if we are doing any changes in database.
   if we are just reading the data then transaction object is just optional.
 */
