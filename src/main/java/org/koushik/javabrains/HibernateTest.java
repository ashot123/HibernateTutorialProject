package org.koushik.javabrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.Address;
import org.koushik.javabrains.dto.UserDetails;

import java.util.Date;


/**
 * Created by Ashot Karakhanyan on 20-09-2014
 */
public class HibernateTest {

    public static void main(String[] args) {

        //user.setUserId(1);
        UserDetails user = new UserDetails();
        user.setUserName("First User");
        //user.setAddress("First user address");
        user.setJoinedDate(new Date());

        Address address = new Address();
        address.setStreet("Moldovakan");
        address.setCity("Yerevan");
        address.setState("Yerevan");
        address.setPincode("0096");
        user.setAddress(address);


        UserDetails user2 = new UserDetails();
        user2.setUserName("Second User");
        //user2.setAddress("Second user address");
        user2.setJoinedDate(new Date());

        Address address2 = new Address();
        address2.setStreet("Isahakyan");
        address2.setCity("Gyumry");
        address2.setState("Shirak");
        address2.setPincode("0011");

        user2.setAddress(address2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // insert the user into DB
        session.beginTransaction();
        session.save(user);
        session.save(user2);
        session.getTransaction().commit();
        session.close();


      /*  // Retrieve user by id
        user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        user  = (UserDetails) session.get(UserDetails.class, 1);// 1 is key value
        System.out.println("user = " + user);
        session.close();*/

        sessionFactory.close();
    }
}
