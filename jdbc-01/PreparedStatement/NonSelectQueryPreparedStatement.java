package com.ioi.pw;

import java.sql.*;

public class NonSelectQueryPreparedStatement {

	public static void main(String[] args) {
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "admin", "adminpassword");
			System.out.println("Connection Established " + con);
			Statement stmt = con.createStatement();
			
			ResultSet result = stmt.executeQuery("select * from employee");
			while(result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				int salary = result.getInt(3);
				
				System.out.println(id + "\t" + name + "\t" + salary);
			}
			
			PreparedStatement pstmt = con.prepareStatement("insert into employee values(?, ?, ?)");
			
			pstmt.setInt(1, 5);
			pstmt.setString(2, "ANUJ");
			pstmt.setInt(3, 34000);
			
			int rowAffected = pstmt.executeUpdate();
			
			System.out.println(rowAffected + "rows affected");
			result = stmt.executeQuery("select * from employee");
			while(result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				int salary = result.getInt(3);
				System.out.println(id + "\t" + name + "\t" + salary);
			}
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
