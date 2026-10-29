package com.sabir.service;

import java.util.List;

import com.sabir.dao.EmployeeDaoImpl;
import com.sabir.dao.IEmployeeDao;
import com.sabir.model.Employee;

public class EmployeeServiceImpl implements IEmployeeService{

    IEmployeeDao dao = new EmployeeDaoImpl();

    @Override
    public boolean saveEmployee(Employee employee) {
        return (dao.saveEmployee(employee) > 0);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return (dao.updateEmployee(employee) > 0);
    }

    @Override
    public boolean deleteEmployeeById(int id) {
        return (dao.deleteEmployeeById(id) > 0);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return dao.findEmployeeById(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }

}
