/**
 * 
 */
package com.hbonetoonebi02.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hbonetoonebi02.entity.Instructor;
import com.hbonetoonebi02.entity.InstructorDetail;

/**
 * @author Thara
 * @creation date & time: 25 Nov 2020 1:49:54 pm
 */
public class GetInstructorDetailDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {

			// start TX
			System.out.println("beginTransaction...");
			session.beginTransaction();

			// int id = 2;

			// Memoryleak and null pointer exception
			int id = 222;

			// get the instructor object
			InstructorDetail detail = session.get(InstructorDetail.class, id);

			// print the Instructor detail
			System.out.println("InstructorDeatil: " + detail);

			// print associated instructor
			System.out.println("the associated instructor: " + detail.getInstructor());
 
			// commit TX
			session.getTransaction().commit();
			System.out.println("commit done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
