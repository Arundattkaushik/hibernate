package spring.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import spring.entity.Student;
import spring.man2many.Employee;

public class HQLExample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("spring/hibernate/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		/*
		 * if we want to set the data dynamically in the query as in the below example we use colon (:) after = sign in the query
		 */
		
		String query = "from Employee where id=:x";
		Query q = session.createQuery(query);
		q.setParameter("x", "4");
		
		
		/*'q' will return two types of results
		 * if we are expecting a single result then we call it uniqueResult and we use q.uniqueResult().
		 * but 
		 * if we are expecting multiple result then we call it multiple-list & we use q.list() to get the data.
		 */
		List<Employee> sList = q.list();
		for (Employee student : sList) {
			System.out.println(student.getName());
		}
		
		
		
		
		session.close();
		factory.close();
	}

}
