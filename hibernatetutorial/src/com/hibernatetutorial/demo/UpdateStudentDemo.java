/**
 * 
 */
package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.entity.Student;

/**
 * @author Thara
 * @creation date & time: 23 Nov 2020 7:00:32 pm
 */
public class UpdateStudentDemo {

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
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrive student based on the id: PK
			System.out.println("\ngetting student with id: " + sId);

			Student student = session.get(Student.class, sId);

			// update student firstName to 'scooby'
			System.out.println("updating student....");
			student.setFirstName("Scooby");
			
			// commit tx
			session.getTransaction().commit();
			
			//NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("update email for all students");
			
			int rowUpdated = session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			System.out.println("update complete " + rowUpdated);
			
			// commit tx
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			// close session factory
			factory.close();
		}
	}

}
