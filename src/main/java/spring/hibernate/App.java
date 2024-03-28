package spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        Student student = new Student(102, "Vrun", "Noida Sector 62");
        
        //Here we are opening a transaction
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(student);
        
        //Here we get current-transaction and commit it to save data at db
        session.getTransaction().commit();
        session.close();
    }
}
