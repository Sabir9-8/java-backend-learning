package com.ioi.pw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SQLInjectionUsingPreparedStatement {

	public static void main(String[] args) {
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "admin", "adminpassword");
				PreparedStatement pstmt = con.prepareStatement("select count(*) from userinfo where username = ? and password = ?");
				Scanner scanner = new Scanner(System.in);
		){
			System.out.println("Connection Established " + con);
			System.out.println("enter username:");
			String user = scanner.nextLine();
			System.out.println("enter password:");
			String pwd = scanner.nextLine();
			
			//user can't pollute the data
			pstmt.setString(1, user);
			pstmt.setString(2, pwd);
			ResultSet result =  pstmt.executeQuery();
			
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
