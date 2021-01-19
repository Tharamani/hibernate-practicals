/**
 * 
 */
package com.hbonetomanybi3.jdbcconnection;

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

		//test connection for schema hb-01-one-to-one-uni
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
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
