package spring.many2one;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("spring/hibernate/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.openSession();
//		Ans a1 = new Ans();
//		Ans a2 = new Ans();
//		Ans a3 = new Ans();
//		Ques q1 = new Ques();
//		q1.setQuestion("Name some programming languages");
//		a1.setAnswers("Java");
//		a1.setQues(q1);
//		a2.setAnswers("Python");
//		a2.setQues(q1);
//		a3.setAnswers("JavaScript");
//		a3.setQues(q1);
//		
//		List<Ans> list = new ArrayList<Ans>();	
//		list.add(a1);
//		list.add(a2);
//		list.add(a3);
//		
//		q1.setAnswers(list);
//		
//		session.save(q1);
//		session.save(a1);
//		session.save(a2);
//		session.save(a3);
//		
//		session.getTransaction().begin();
//		session.getTransaction().commit();
		
		
		//Printing question and all its answers on the console
		//Use case these features works when we create a blog
		Ques ques = session.get(Ques.class, 1);
		System.out.println(ques.getQuestion());
		
		for (Ans a : ques.getAnswers()) {
			System.out.println(a.getAnswers());
		}
		
		session.close();
		factory.close();
		
	}

}
