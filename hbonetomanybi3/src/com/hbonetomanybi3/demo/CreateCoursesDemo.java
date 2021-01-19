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
public class CreateCoursesDemo {

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
			
			//create some courses
			Course course1 = new Course("Air Guitar - The Ultimate Guide");
			Course course2 = new Course("The Pitball Masterclass");
			 
			//add courses to instructor
			instructor.add(course1);
			instructor.add(course2);
			
			//save courses
			session.save(course1);
			session.save(course2);
			
			// commit TX
			session.getTransaction().commit();
			System.out.println("commit done!");

		} finally {
			
			session.close();
			
			factory.close();
		}
	}

}
