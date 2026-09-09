package com.ioi.pw;

import java.sql.*;

public class NonSelectQuery {
	public static void main(String [] args) {
		
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "admin";
		String password = "adminpassword";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established " + con);
			
			Statement stmt = con.createStatement();
			
			String nonSelectQuery = String.format("insert into student values(%d, '%s', %d, '%s', '%s')", 112, "shivansh", 67, "B", "ranchi");
			
			int rowsAffected = stmt.executeUpdate(nonSelectQuery);
			System.out.println("\nAfter Execution");
			System.out.println(rowsAffected + " Rows Affected");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
