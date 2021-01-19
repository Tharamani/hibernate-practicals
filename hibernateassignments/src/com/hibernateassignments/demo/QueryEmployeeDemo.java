/**
 * 
 */
package com.hibernateassignments.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateassignments.entity.Employee;

/**
 * @author Thara
 *@creation date & time: 24 Nov 2020 3:06:59 pm
 */
public class QueryEmployeeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
	
		try {
			
			//start Tx
			session.beginTransaction();
			
			//query employee who is working for Amazon
			List<Employee> employees = session.createQuery("from Employee e where e.company='Amazon'").list();
			//display employees
			displayEmployees(employees);
			
			employees = session.createQuery("from Employee e where e.company='Amazon' OR e.company='Google'").list();
			//display employees
			displayEmployees(employees);
			
			employees = session.createQuery("from Employee where firstName LIKE 'Th%'").list();
			//display employees
			displayEmployees(employees);
			
			//commit tx
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

	/**
	 * @param employees
	 */
	private static void displayEmployees(java.util.List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println("\n\n employee is : " + employee.getFirstName());
		}
	}

}
