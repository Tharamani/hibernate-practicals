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
import com.hbonetomanybi3.entity.Review;
import com.hbonetomanybi3.entity.Student;

/**
 * @author Thara
 * @creation date & time: 25 Nov 2020 1:49:54 pm
 */
public class DeletePacmanCoursesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start TX
			System.out.println("beginTransaction...");
			session.beginTransaction();

			// get the Pacman course from db
			int id = 10;
			Course course = session.get(Course.class, id);

			System.out.println("\nLoaded course: " + course);
			System.out.println("deleting course: " + course);

			// delete course
			session.delete(course);

			// commit TX
			session.getTransaction().commit();
			System.out.println("commit done!");

		} finally {

			session.close();

			factory.close();
		}
	}

}
