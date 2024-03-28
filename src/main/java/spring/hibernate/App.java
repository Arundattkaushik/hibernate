package spring.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.entity.Address;
import spring.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        System.out.println( "Program Started.........." );
        SessionFactory factory = new Configuration().configure("spring/hibernate/hibernate.cfg.xml").buildSessionFactory();
        Student student = new Student("Vrun", "Noida Sector 62");
        Address address = new Address();
        address.setAddedDate(new Date());
        address.setCity("Noida");
        address.setIsOpen(true);
        address.setStreet("B Block RN 32");
        address.setX(43.25);
        
        //Here we are opening a transaction
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(student);
        session.save(address);
        //Here we get current-transaction and commit it to save data at db
        session.getTransaction().commit();
        session.close();
    }
}
