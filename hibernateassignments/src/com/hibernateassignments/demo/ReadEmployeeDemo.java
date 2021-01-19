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
 *@creation date & time: 24 Nov 2020 3:06:59 pm
 */
public class ReadEmployeeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
	
		try {
			
			int empId = 1;
			System.out.println("employee id " + empId);
			
			//start Tx
			session.beginTransaction();
			
			//read employee using PK
			System.out.println("reading employee using pk...");
			Employee employee = session.get(Employee.class,empId);
			
			System.out.println("Employee object using pk 1: " +employee);
			
			//commit tx
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
