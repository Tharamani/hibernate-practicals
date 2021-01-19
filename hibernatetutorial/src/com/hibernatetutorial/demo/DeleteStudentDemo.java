/**
 * 
 */
package com.hibernatetutorial.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Student;

/**
 * @author Thara
 * @creation date & time: 23 Nov 2020 7:00:32 pm
 */
public class DeleteStudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int sId = 1;

			// now get current session and start tx
			/*
			 * session = factory.getCurrentSession(); session.beginTransaction();
			 * 
			 * // retrive student based on the id: PK
			 * System.out.println("\ngetting student with id: " + sId);
			 * 
			 * Student student = session.get(Student.class, sId);
			 * 
			 * // delete student 
			 * System.out.println("deleting student...."); session.delete(student);
			 * 
			 * // commit tx session.getTransaction().commit();
			 */
			
			//OR can do other way ALTERNATIVE APPROACH
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//delete student 2
			System.out.println("deleting student id=2");
			int rowUpdated = session.createQuery("delete Student where id=2").executeUpdate();
			System.out.println("delete complete " + rowUpdated);
			
			// commit tx
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			// close session factory
			factory.close();
		}
	}

}
