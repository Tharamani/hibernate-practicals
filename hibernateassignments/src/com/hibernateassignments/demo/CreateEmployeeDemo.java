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
public class CreateEmployeeDemo {

	public static void main(String[] args) {

		System.out.println("Inside main");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// save single employee
			// create employee object
			Employee employee = new Employee("Thara", "M P", "H P");

			// Add few more employees
			Employee employee1 = new Employee("Annie", "M", "Dell");

			Employee employee2 = new Employee("Bennie", "D", "Amazon");

			Employee employee3 = new Employee("Mary", "Math", "Google");

			// start tx 
			session.beginTransaction();

			// save employee System.out.println("saving employee....");
			session.save(employee);
			System.out.println("\n Employee: saved employee.... id is " + employee.getId());
			
			session.save(employee1);
			System.out.println("\n Employee: saved employee1.... id is " + employee1.getId());
			
			session.save(employee2);
			System.out.println("\n Employee: saved employee2.... id is " + employee2.getId());
			
			session.save(employee3);
			System.out.println("\n Employee: saved employee3.... id is " + employee3.getId());
			
			// commit tx
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
