package spring.man2many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Man2ManyDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("spring/hibernate/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
//		Employee e1 = new Employee();
//		Employee e2 = new Employee();
//		Employee e3 = new Employee();
//		Employee e4 = new Employee();
//		
//		e1.setName("Ram");
//		e2.setName("Laxman");
//		e3.setName("Bharat");
//		e4.setName("Satrughan");
//		
//		Project p1 = new Project();
//		Project p2 = new Project();
//		Project p3 = new Project();
//		Project p4 = new Project();
//		
//		p1.setProject("ChatBoat");
//		p2.setProject("Ghar Ka Wifi");
//		p3.setProject("Rural Wifi Connect");
//		p4.setProject("Urban Magic");
//		
//		//Allocating projects to employees
//		List<Employee> eList1 = new ArrayList<Employee>();
//		List<Employee> eList2 = new ArrayList<Employee>();
//		List<Project> pList1 = new ArrayList<Project>();
//		List<Project> pList2 = new ArrayList<Project>();
//		List<Project> pList3 = new ArrayList<Project>();
//		List<Project> pList4 = new ArrayList<Project>();
//		
//		//Adding employees to eList 
//		eList1.add(e1);
//		eList1.add(e2);
//		eList2.add(e3);
//		eList2.add(e4);
//		
//		
//		//Adding projects to pList
//		pList1.add(p1);
//		pList1.add(p2);
//		pList2.add(p3);
//		pList2.add(p4);
//		pList3.add(p4);
//		pList3.add(p1);
//		pList4.add(p1);
//		pList4.add(p2);
//		pList4.add(p3);
//		pList4.add(p4);
//		
//		
//		//Allocating projects to the employees
//		e1.setProjects(pList1);
//		e2.setProjects(pList2);
//		e3.setProjects(pList3);
//		e4.setProjects(pList4);
//		p1.setEmployees(eList2);
//		
//		//Saving employee objects
//		session.save(e1);
//		session.save(e2);
//		session.save(e3);
//		session.save(e4);
//		
//		//Saving project objects
//		session.save(p1);
//		session.save(p2);
//		session.save(p3);
//		session.save(p4);
		
		//Printing projects employee wise
		Employee e = session.get(Employee.class, 1);
		System.out.println(e.getName());
		
		System.out.println("You are working ");
		for (Project p : e.getProjects()) {
			System.out.println(" "+p.getProject());
		}
		
		System.out.println("Other employees who are working on this project");
		Project p = session.get(Project.class, 1);
		for (Employee emp : p.getEmployees()) {
			System.out.println(" "+emp.getName());
		}
		
		session.getTransaction().begin();
		session.getTransaction().commit();
		
		session.close();
		factory.close();
		
	}

}
