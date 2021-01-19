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
 *@creation date & time: 23 Nov 2020 9:20:45 pm
 */
public class PrimaryKeyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create session factory 
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("Creating new student object....");
			Student student1 = new Student("Vish", "D K", "vishu619@gmail.com");
			Student student2 = new Student("Arnav", "N V", "arnavnihaar@gmail.com");
			Student student3 = new Student("Divya", "M P", "divya1986@gmail.com");
			
			//use session object to save java objects
			//start tx
			session.beginTransaction();
			
			//save student object
			System.out.println("Saving the student....");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//commit tx
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			//close session factory
			factory.close();
		}
	}

}
