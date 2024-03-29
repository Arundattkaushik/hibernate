package spring.hqlpagination;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import spring.man2many.Employee;

public class HQLPagination {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("spring/hibernate/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		String query = "from Employee";
		Query<Employee> q = session.createQuery(query);
		/*
		 * q.setFirstResult(0), basically tells us that which index we want to start from to collect data.
		 */
		q.setFirstResult(0);
		
		/*
		 * q.setMaxResults(1), basically tells us that how many results we want per page, in the below case we want 
		 * only 1 result per page.
		 */
		q.setMaxResults(1);
		
		for (Employee e : q.list()) {
			System.out.println(e.getName());
		}
		
		session.close();
		factory.close();	
	}
}
