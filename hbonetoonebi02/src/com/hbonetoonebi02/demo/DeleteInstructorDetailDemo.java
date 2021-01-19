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
public class DeleteInstructorDetailDemo {

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

			//delete both instructor detail and instructor(use cascadetype.ALL)
			//int id = 2;
			
			//delete only Instructor 
			int id = 3;
			
			// get the instructor object
			InstructorDetail detail = session.get(InstructorDetail.class, id);

			// print the Instructor detail
			System.out.println("InstructorDeatil: " + detail);

			// print associated instructor
			System.out.println("the associated instructor: " + detail.getInstructor());

			//remove the associated object reference
			//break bi-directional link
			detail.getInstructor().setInstructorDetail(null);
			
			// now let's delete instructor detail
			System.out.println("Deleting instructor detail while deletes asociated instructor also...");
			session.delete(detail);

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
