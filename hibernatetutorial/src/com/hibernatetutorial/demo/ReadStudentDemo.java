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
public class ReadStudentDemo {

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
			//****************** CODE to SAVE student object to db using HB
			// create a student object
			System.out.println("Creating new student object....");
			Student student = new Student("Daffy", "Duck", "daffy@gmail.com");

			// use session object to save java objects
			// start tx
			session.beginTransaction();

			// save student object
			System.out.println("Saving the student....");
			System.out.println(student);
			session.save(student);

			// commit  the transaction
			session.getTransaction().commit();
			
			//****************** NEW CODE to READ student object from db using HB
			
			// find out the students id: PK
			System.out.println("saved student.Generated id: " + student.getId());

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: PK
			System.out.println("\nGetting student with id: " + student.getId());

			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Get Complete!" + myStudent); 
			
			//	commit  the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			// close session factory
			factory.close();
		}
	}

}
