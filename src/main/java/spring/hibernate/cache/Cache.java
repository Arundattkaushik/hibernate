package spring.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.man2many.Employee;

public class Cache {
	/*
	 * In Hibernate cache is a concept which reduces the number of Dao calls by
	 * checking every time whether the same object is already present in cache
	 * memory if it is already present then a new Dao call is not placed instead
	 * previous stored object is returned to the user until or unless details asked
	 * by the user are different from the existing object.
	 * 
	 * Hence cache concept boosts our application performance. Basically there are
	 * two types of cache memory found in Hibernate i.e., First Level Hibernate
	 * cache & Second Level Hibernate cache there one more cache memory which is
	 * called Query Level cache.
	 * 
	 * First Level Cache:: this is associated with session object, once the session
	 * object is destroyed we can not get data lied in session object before its
	 * destruction *Note:: session cache is enabled by default that is we don't have
	 * to do any configuration to enable it.
	 * 
	 * Second Level Cache: this is associated with SessionFactory object, it is not
	 * enabled by default to use this we have to do configuration manually. Even
	 * though the session object is destroyed/cleared, we still can use any data
	 * attached with SessionFactory.
	 */
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("spring/hibernate/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session1 = factory.openSession();

		// First Cache Level.
//		Employee employee = new Employee();
//		employee.setName("Arun");
//		session.save(employee);

		Employee emp = session1.get(Employee.class, 1);
		System.out.println(emp.getName());
//		System.out.println("Working ...........");
//		Employee emp1 = session.get(Employee.class, 1);
//		System.out.println(emp1.getName() + " " + emp1.getId());
//		System.out.println(session.contains(emp1));

		session1.close();
		
//		Session session2 = factory.openSession();
//		Employee emp2 = session1.get(Employee.class, 1);
//		System.out.println(emp2.getName());
//		
//		session2.close();

		factory.close();
		
	}

}
