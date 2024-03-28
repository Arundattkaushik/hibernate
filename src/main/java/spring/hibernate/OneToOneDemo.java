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
		answers.setQuestions(questions);
		questions.setAnswers(answers);
		
		session.save(questions);
		session.save(answers);
		
		session.getTransaction().begin();
		session.getTransaction().commit();
		
		Questions q1 = session.get(Questions.class, 1);
		Answers a1 = session.get(Answers.class, 1);
		
		System.out.println(q1.getQuestion()+" = "+a1.getQuestions().getAnswers().getAnswer());
		
		session.close();
		factory.close();
	}
}
