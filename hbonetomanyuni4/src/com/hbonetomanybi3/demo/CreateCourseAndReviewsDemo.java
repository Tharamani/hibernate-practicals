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

/**
 * @author Thara
 * @creation date & time: 25 Nov 2020 1:49:54 pm
 */
public class CreateCourseAndReviewsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start TX
			System.out.println("beginTransaction...");
			session.beginTransaction();

			//create a course
			Course course = new Course("Pacman - How to score one million points");
			
			//add some reviews
			course.addReview(new Review("Great course.. loved it!"));
			course.addReview(new Review("cool course.. job well done!"));
			course.addReview(new Review("what a course.. you are an idiot!"));
			
			//save the course and add leverage the cascade all : )
			System.out.println("saving course..");
			System.out.println(course);
			System.out.println(course.getReviews());
			session.save(course);
			
			// commit TX
			session.getTransaction().commit();
			System.out.println("commit done!");

		} finally {
			
			session.close();
			
			factory.close();
		}
	}

}
