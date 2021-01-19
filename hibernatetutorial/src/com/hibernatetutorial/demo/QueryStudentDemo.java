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
public class QueryStudentDemo {

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
			// start tx
			session.beginTransaction();

			// use list() for hibernate above 5.2  
			// query students
//			List<Student> students = session.createQuery("from Student").getResultList();
			List<Student> students = session.createQuery("from Student").list();
			
			displayStudents(students);
			
			//query students : lastname is M P
			students = session.createQuery("from Student s where s.lastName='M P'").list();
			
			System.out.println("\n\n students who's lastname is M P");
			//display the students
			displayStudents(students);
			
			//query students lastName: 'D V' or firstName='Arnav'
			students = session.createQuery("from Student s where s.lastName='D K' OR firstName='Arnav'").list();
			
			System.out.println("\n\n students who's lastname starts with D K OR firstName starts with 'Arnav'");
			//display the students
			displayStudents(students);
			
			System.out.println("\n\n students who's email ends with 619@gmail.com");
			// query students where email LIKE '%619@gmail.com'
			students = session.createQuery("from Student s where s.email LIKE '%619@gmail.com'").list();
			//display the students
			displayStudents(students);
			
			// commit tx
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			// close session factory
			factory.close();
		}
	}

	/**
	 * @param students
	 */
	private static void displayStudents(List<Student> students) {
		System.out.println("Display students from db");
		// display the students
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
