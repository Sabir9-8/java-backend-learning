package com.ioi.pw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class WorkingWithExecute {

	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "admin", "adminpassword");
			Statement stmt = con.createStatement();
			Scanner scanner = new Scanner(System.in);
		){
			System.out.println("Enter the query");
			String query = scanner.nextLine();
			boolean flag = stmt.execute(query);
			
			if (flag) {
				ResultSet result = stmt.getResultSet();
				if (result.next()) {
					do {
						System.out.println("example...");
					} while (result.next());
				}
				
			}
			else {
				int count = stmt.getUpdateCount(); 
				System.out.println(count + " rows affected");
			}
			
		}
		catch(SQLException e) {
			 System.err.println("\t" + e.getMessage());
		}

	}

}
