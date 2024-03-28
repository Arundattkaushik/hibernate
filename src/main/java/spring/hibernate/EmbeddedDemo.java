package spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.entity.CourseCertificate;
import spring.entity.Student;

public class EmbeddedDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("spring/hibernate/hibernate.cfg.xml").buildSessionFactory();
		Student student = new Student();
		student.setCity("Noida");
		student.setName("Arun");
		
		CourseCertificate certificate = new CourseCertificate();
		certificate.setCourse("Java");
		certificate.setCourseDuration("6 Months");
		student.setCertificate(certificate);
		
		
		Session session = factory.openSession();
		session.save(student);
		session.getTransaction().begin();
		session.getTransaction().commit();
		session.close();
		factory.close();
		
	}

}
