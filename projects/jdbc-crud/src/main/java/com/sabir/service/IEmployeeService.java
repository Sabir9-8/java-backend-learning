package com.sabir.service;

import java.util.List;

import com.sabir.model.Employee;

public interface IEmployeeService {
    public boolean saveEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);
    public boolean deleteEmployeeById(int id);
    public Employee findEmployeeById(int id);
    public List<Employee> findAllEmployees();
}
