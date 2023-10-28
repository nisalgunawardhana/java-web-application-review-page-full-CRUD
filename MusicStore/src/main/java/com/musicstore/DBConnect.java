package com.musicstore;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
	//encapsulate the database connection details
	private static String url = "jdbc:mysql://localhost:3306/Music_store";
	private static String userName = "root";
	private static String password = "NISAL2018";
	private static Connection con;
	
	//static method for connection
	public static Connection getConnection() {
		
		// try-catch block for handle to error(ClassNotFoundException,SQL Exception) 
		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,userName,password);
			return con;// Return the connection if successful
			
		}catch(Exception e){
			System.out.println("Database connection unsuccessful");// Print an error message 
			return null;//Return the null if unsuccessful
		}
		
		
		
	}
	

}
