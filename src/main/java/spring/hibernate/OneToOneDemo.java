package spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.one2onemapping.Answers;
import spring.one2onemapping.Questions;

public class OneToOneDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("spring/hibernate/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		// Questions objects
		Questions questions = new Questions();
		Answers answers = new Answers();
		
		questions.setQuestion("What is java");
		answers.setAnswer("Java is a programming language");
		questions.setAnswers(answers);
		
		session.save(questions);
		session.save(answers);
		
		session.getTransaction().begin();
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
