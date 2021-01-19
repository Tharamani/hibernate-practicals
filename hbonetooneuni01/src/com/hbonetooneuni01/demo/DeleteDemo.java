/**
 * 
 */
package com.hbonetooneuni01.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hbonetooneuni01.entity.Instructor;
import com.hbonetooneuni01.entity.InstructorDetail;

/**
 * @author Thara
 * @creation date & time: 25 Nov 2020 1:49:54 pm
 */
public class DeleteDemo {

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

			//id to delete the record
			int id = 1;
			
			//start TX
			System.out.println("beginTransaction...");
			session.beginTransaction();
			
			//get instructor by PK/id
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("\n found the instructor....");
		
			//delete the instructor
			if(instructor != null) {
				System.out.println("Deleting...." + instructor);
				
				//NOTE: will ALso delete associated "instructor details" object
				//because of CascadeType.ALLA
				session.delete(instructor);
			}
			//commit TX
			session.getTransaction().commit();
			System.out.println("commit done!");
			 
		} finally {
			factory.close();
		}
	}

}
