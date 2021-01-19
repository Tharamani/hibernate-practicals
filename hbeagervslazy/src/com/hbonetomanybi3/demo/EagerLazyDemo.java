/**
 * 
 */
package com.hbonetomanybi3.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hbonetomanybi3.entity.Course;
import com.hbonetomanybi3.entity.Instructor;
import com.hbonetomanybi3.entity.InstructorDetail;

/**
 * @author Thara
 * @creation date & time: 25 Nov 2020 1:49:54 pm
 */
public class EagerLazyDemo {

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
			// get instructor from db
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("getting instructor... " + instructor);
			
			//get course for instructor using onetomany mapping
			//System.out.println("get course for instructor using 'onetomany' mapping..." + instructor.getCourses());
			
			//get course for instructor using "eager" fetchtype 
			//System.out.println("get course for instructor using 'eager' fetchtype ..." + instructor.getCourses());
			
			//get course for instructor using "lazy" fetchtype 
			System.out.println("get course for instructor using 'lazy' fetchtype ..." + instructor.getCourses());
			
			// commit TX
			session.getTransaction().commit();
			
			//close session before accessing lazy data
			session.close(); 
			System.out.println("option 1 used to resolve lazy data load, closing session");
			
			//session closed before accessing the lazy data(test lazy loading)
			System.out.println("get course for session closed before accessing the lazy data ..." + instructor.getCourses());
			
			System.out.println("commit done!");

		} finally {
			
			session.close(); 
			
			factory.close();
		}
	}

}
