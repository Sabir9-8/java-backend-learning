package com.sabir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sabir.model.Employee;
import com.sabir.util.DbUtil;

public class EmployeeDaoImpl implements IEmployeeDao{

    @Override
    public int saveEmployee(Employee employee) {
        String sql = "insert into Employee (name, salary, city) values (?, ?, ?)";
		
		try (Connection con = DbUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, employee.getName());
			pstmt.setBigDecimal(2, employee.getSalary());
			pstmt.setString(3, employee.getCity());
			
			return pstmt.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println("\t" + e.getMessage());
			e.printStackTrace();
		}
		return 0;
    }

    @Override
    public int updateEmployee(Employee employee) {
        String sql = "update Employee set name = ?, salary = ?, city = ? where id = ?";

		try (Connection con = DbUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, employee.getName());
			pstmt.setBigDecimal(2, employee.getSalary());
			pstmt.setString(3, employee.getCity());
			pstmt.setInt(4, employee.getId());
			
			return pstmt.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println("\t" + e.getMessage());
			e.printStackTrace();
		}
		return 0;
    }

    @Override
    public int deleteEmployeeById(int id) {
        String sql = "delete from Employee where id = ?";
		
		try (Connection con = DbUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println("\t" + e.getMessage());
			e.printStackTrace();
		}
		return 0;
    }

    @Override
    public Employee findEmployeeById(int id) {
        String sql = "select id, name, salary, city from Employee where id = ?";

		try (Connection con = DbUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, id);
			try (ResultSet resultSet = pstmt.executeQuery();) {
			
				if (resultSet.next()) {
					return new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getBigDecimal(3), resultSet.getString(4));
				}
			}
		}
		catch (SQLException e) {
			System.err.println("\t" + e.getMessage());
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public List<Employee> findAllEmployees() {
        String sql = "select id, name, salary, city from Employee";
		List<Employee> list = new ArrayList<>();
		
		try (Connection con = DbUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet resultSet = pstmt.executeQuery();){
			
			while(resultSet.next()) {
				list.add(new Employee(resultSet.getInt(1) ,resultSet.getString(2), resultSet.getBigDecimal(3), resultSet.getString(4)));
			}
			return list;
		}
		catch (SQLException e) {
			System.err.println("\t" + e.getMessage());
			e.printStackTrace();
		}
		return list;
    }

}
