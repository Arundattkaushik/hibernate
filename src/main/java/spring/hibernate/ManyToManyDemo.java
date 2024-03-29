package spring.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.many2many.Post;
import spring.many2many.PostReply;

public class ManyToManyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("spring/hibernate/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
//		Post post = new Post();
//		PostReply reply1 = new PostReply();
//		PostReply reply2 = new PostReply();
//		PostReply reply3 = new PostReply();
//		PostReply reply4 = new PostReply();
//		List<PostReply> replies = new ArrayList<PostReply>();
//		
//		post.setPostTitle("What is Java");
//		reply1.setReplyContent("Java is a programming language");
//		reply1.setPost(post);
//		reply2.setReplyContent("It works on Oops concept");
//		reply2.setPost(post);
//		reply3.setReplyContent("There are four main pillers of Java");
//		reply3.setPost(post);
//		reply4.setReplyContent("Abstration, Encapsulation, Inheritance and Polymorphisam");
//		reply4.setPost(post);
//		replies.add(reply1);
//		replies.add(reply2);
//		replies.add(reply3);
//		replies.add(reply4);
//		
//		session.save(post);
//		session.save(reply1);
//		session.save(reply2);
//		session.save(reply3);
//		session.save(reply4);
		
		Post post = session.get(Post.class, 1);
		System.out.println(post.getPostTitle());
		for (PostReply postReply : post.getReplies()) {
			System.out.println(postReply.getReplyContent());
		}
		
		session.getTransaction().begin();
		session.getTransaction().commit();
		
	}

}
