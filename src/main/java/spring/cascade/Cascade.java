package spring.cascade;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.AbstractAnnotationValueVisitor14;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Cascade {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("spring/hibernate/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Message message = new Message();
		Reply r1 = new Reply();
		Reply r2 = new Reply();
		Reply r3 = new Reply();
		List<Reply> rList = new ArrayList<Reply>();
		
		message.setMessage("Hello");
		r1.setReply("Hi");
		r1.setMessage(message);
		r2.setReply("How are");
		r2.setMessage(message);
		r3.setReply("You?");
		r3.setMessage(message);
		
		rList.add(r1);
		rList.add(r2);
		rList.add(r3);
		
		message.setReplies(rList);
		
		
		session.save(message);
//		session.save(r1);
//		session.save(r2);
//		session.save(r3);
		
//		session.delete(message);
		
		session.getTransaction().begin();
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
}
