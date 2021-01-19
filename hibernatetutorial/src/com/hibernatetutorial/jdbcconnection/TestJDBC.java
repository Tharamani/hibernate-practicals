/**
 * 
 */
package com.hibernatetutorial.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Thara
 *@creation date & time: 20 Nov 2020 2:26:17 pm
 */
public class TestJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String userName ="hbstudent";
		String password ="hbstudent";
		try {
			System.out.println("connecting to dabase: " + jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("connection successful!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
