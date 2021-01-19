/**
 * 
 */
package com.hibernateassignments.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateassignments.entity.Employee;

/**
 * @author Thara
 * @creation date & time: 24 Nov 2020 2:34:24 pm
 */
public class DeleteEmployeeDemo {

	public static void main(String[] args) {

		System.out.println("Inside main");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int id = 3;
			// start tx
			session.beginTransaction();

			// save employee System.out.println("saving employee....");
			System.out.println("Deleting employee....");
			//directly delete employee without querying
			// session.delete(session.get(Employee.class, id));

			//using query to delete employee
			int rowCount = session.createQuery("delete Employee where id='2'").executeUpdate();
			System.out.println("deleted employee: " + rowCount);
			// commit tx
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
