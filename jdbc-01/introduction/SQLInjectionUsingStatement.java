package com.ioi.pw;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SQLInjectionUsingStatement {

	public static void main(String[] args) {
		
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "admin", "adminpassword");
				Statement stmt = con.createStatement();
				Scanner scanner = new Scanner(System.in);
		){
			System.out.println("Connection Established " + con);
			System.out.println("enter username:");
			String user = scanner.nextLine();
			System.out.println("enter password:");
			String pwd = scanner.nextLine();
			
			String sqlSelectQuery = String.format("select count(*) from userinfo where username = '%s' and password = '%s'", user, pwd);
			//user can pollute the data
			System.out.println(sqlSelectQuery);
			ResultSet result =  stmt.executeQuery(sqlSelectQuery);
			
			if (result.next()) {
				if (result.getInt(1) == 0) {
					System.out.println("Invalid Credentials...");
				}
				else System.out.println("Logged in successfully");
			}
			else System.out.println("no user found");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
		
	}

}
