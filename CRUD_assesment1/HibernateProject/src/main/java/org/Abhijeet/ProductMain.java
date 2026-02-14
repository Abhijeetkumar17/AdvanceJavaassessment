package org.Abhijeet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductMain {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Product product = new Product(
                "Dell Laptop",
                "Business Laptop",
                "Electronics",
                5,
                65000,
                "SKU500",
                true
        );

        session.persist(product);


        transaction.commit();
        session.close();

        System.out.println("Product Inserted Successfully!");

        sessionFactory.close();
    }
}
