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
public class DeleteArnavStudentDemo {

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

			//get the student mary from db
			int id = 2;
			//get the student john from db
			//int id = 1;
			Student student = session.get(Student.class, id);
			
			System.out.println("\nLoaded student: " + student);
			System.out.println("courses: " + student.getCourses());
			
			//delete student
			System.out.println("\n deleting student: " +student);
			session.delete(student);
			
			// commit TX
			session.getTransaction().commit();
			System.out.println("commit done!");

		} finally {

			session.close();

			factory.close();
		}
	}

}
