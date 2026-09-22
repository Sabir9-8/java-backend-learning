package com.ioi.pw;

import java.sql.*;

public class IntroPreparedStatement {

	public static void main(String[] args) {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "admin", "adminpassword");
			System.out.println("Connection Established " + con);
			
			PreparedStatement pstmt = con.prepareStatement("select * from Student where marks = ?");
			
			pstmt.setInt(1, 88);
			
			ResultSet result = pstmt.executeQuery();
			
			System.out.println("====Getting data from the table====");
			
			if (result.next()) {
				do {
					int rollno = result.getInt(1);
					String name = result.getString(2);
					int marks = result.getInt(3);
					String grade = result.getString(4);
					String city = result.getString(5);
					
					System.out.println(rollno + "\t" + name + "\t" + marks + "\t" + grade + "\t" + city);
				} while(result.next());
			}
			else {
				System.out.println("Record not available");
			}
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
