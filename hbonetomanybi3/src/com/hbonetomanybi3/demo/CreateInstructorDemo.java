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
public class CreateInstructorDemo {

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

			// create InstructorDetail object
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "video games");

			Instructor instructor = new Instructor("Susen", "public", "suzenpublic@gmail.com");

			// associate the objects
			instructor.setInstructorDetail(instructorDetail);

			// start TX
			System.out.println("beginTransaction...");
			session.beginTransaction();

			// save the instuctor
			// NOTE: this will also save the details object
			// because if CascadeType.ALL(save actual object and aslo save associated
			// object)
			System.out.println("saving instructor..." + instructor);
			session.saveOrUpdate(instructor);

			// commit TX
			session.getTransaction().commit();
			System.out.println("commit done!");

		} finally {
			
			session.close();
			
			factory.close();
		}
	}

}
