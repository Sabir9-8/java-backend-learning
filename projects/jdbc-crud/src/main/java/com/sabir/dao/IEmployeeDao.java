package com.sabir.dao;

import java.util.List;

import com.sabir.model.Employee;

public interface IEmployeeDao {
    public int saveEmployee(Employee employee);
    public int updateEmployee(Employee employee);
    public int deleteEmployeeById(int id);
    public Employee findEmployeeById(int id);
    public List<Employee> findAllEmployees();
}