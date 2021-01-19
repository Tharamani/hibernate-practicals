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
public class CreateCourseAndStudentDemo {

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

			// create a course
			Course course = new Course("Pacman - How to score one million points");

			// save course
			System.out.println("\n save course....");
			session.save(course);
			System.out.println("saved the course: " + course);

			// create student
			Student student1 = new Student("Thara", "M P", "thara@gmail.com");
			Student student2 = new Student("Arnav", "D V", "arnav@gmail.com");

			// add student to course
			course.addStudent(student1);
			course.addStudent(student2);

			// save the students
			session.save(student1);
			session.save(student2);

			// commit TX
			session.getTransaction().commit();
			System.out.println("commit done!");

		} finally {

			session.close();

			factory.close();
		}
	}

}
