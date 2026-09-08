package com.ioi.pw;

import java.sql.*;

public class ConnectionApp {

	public static void main(String[] args){
		//Establish the connection
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "admin";
		String password = "adminpassword";
		
		ResultSet result = null;
		Statement stmt = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established " + con);
			
			//create a statement object to carry the query
			stmt = con.createStatement();
			
			String sqlSelectQuery = "select * from employee";
			
			//send and execute the query at DBside
			result = stmt.executeQuery(sqlSelectQuery);
			
			System.out.println("====Getting data from the table====");
			
			while(result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				int salary = result.getInt(3);
				
				System.out.println(id + "\t" + name + "\t" + salary);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
