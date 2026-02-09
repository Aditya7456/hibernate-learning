package org.aditya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                            .addAnnotatedClass(Laptop.class)
                            .configure()
                            .buildSessionFactory();
        // now need session object
        Session session = factory.openSession();
        // in sql use tableName
        // if we sql then we have to write "select * from laptop where ram=32";
        // if hql then "from Laptop where ram=32"; // use className
        String brand = "Asus";
        int ram = 32    ;
        Query query = session.createQuery("select brand,model from Laptop where brand like ?1");
        query.setParameter(1, brand);
        //query.setParameter(2, ram);
        List<Object[]> laptops = query.getResultList();

        // Laptop l1 = session.find(Laptop.class,3);
        //System.out.println(laptops);
        for(Object []data: laptops){
            System.out.println(data[0] + " "  + data[1]);
        }
        session.close();
        factory.close();
    }
}

/*
   Transaction transaction = session.beginTransaction();
   we need transaction object, if we are doing any changes in database.
   if we are just reading the data then transaction object is just optional.
 */
