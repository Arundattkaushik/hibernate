package spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.entity.Address;
import spring.entity.Student;

public class GetData {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("spring/hibernate/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Student student = session.get(Student.class, 1);
		Address address = session.get(Address.class, 1);
		System.out.println(student);
		System.out.println(address);
	}

}
