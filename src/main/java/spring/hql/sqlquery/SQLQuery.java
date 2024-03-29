package spring.hql.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import spring.man2many.Employee;

public class SQLQuery {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("spring/hibernate/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		String query = "select * from Employee";
		/*
		 * if we want to use a SQL query in our project then unlike using 'Query' interface in Hibernate
		 * we will use another interface called NativeQuery<> which will help us frame native SQL queries easily
		 */
		NativeQuery q = session.createNativeQuery(query);
		List<Object[]> eList = q.list();
		for (Object[] e : eList) {
			System.out.println(Arrays.deepToString(e));
		}
		
		session.close();
		factory.close();

	}

}
