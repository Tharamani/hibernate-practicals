/**
 * 
 */
package com.hbonetomanybi3.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hbonetomanybi3.entity.Course;
import com.hbonetomanybi3.entity.Instructor;
import com.hbonetomanybi3.entity.InstructorDetail;
import com.mysql.cj.interceptors.QueryInterceptor;

/**
 * @author Thara
 * @creation date & time: 25 Nov 2020 1:49:54 pm
 */
public class FetchJoinDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start TX
			System.out.println("beginTransaction...");
			session.beginTransaction();

			int id = 1;
			//NOTE : OPTION 2 :  using HQL query to fetch data
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:theid",Instructor.class);
			
			//set parameter on query
			query.setParameter("theid", id);
			
			//execute query and get instructor
			Instructor instructor = query.getSingleResult();
			
			System.out.println("getting instructor... " + instructor);

			// commit TX
			session.getTransaction().commit();
			System.out.println("commit done!");

		} finally {

			session.close();

			factory.close();
		}
	}

}
