/**
 * 
 */
package com.hbonetooneuni01.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hbonetooneuni01.entity.Instructor;
import com.hbonetooneuni01.entity.InstructorDetail;
import com.hbonetooneuni01.entity.Student;

/**
 * @author Thara
 * @creation date & time: 25 Nov 2020 1:49:54 pm
 */
public class CreateDemo {

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

			//create InstructorDetail object
			/*
			 * InstructorDetail instructorDetail = new
			 * InstructorDetail("http://www.youtube.com/dance", "dancing");
			 * 
			 * Instructor instructor = new Instructor("Thara", "M P", "thara@gmail.com");
			 */
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.javatpoint.com", "coding");
			
			Instructor instructor = new Instructor("Arnav", "N V", "anv@gmail.com");
			
			//associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			//start TX
			System.out.println("beginTransaction...");
			session.beginTransaction();
			
			//save the instuctor
			//NOTE: this will also save the details object
			//because if CascadeType.ALL(save actual object and aslo save associated object)
			System.out.println("saving instructor..." + instructor);
			session.saveOrUpdate(instructor);
			
			//commit TX
			session.getTransaction().commit();
			System.out.println("commit done!");
			 
		} finally {
			factory.close();
		}
	}

}
