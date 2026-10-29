package com.sabir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

import com.sabir.model.Employee;
import com.sabir.service.EmployeeServiceImpl;
import com.sabir.service.IEmployeeService;
import com.sabir.util.DbUtil;

public class Main {
    public static void main(String[] args) {
        IEmployeeService service = new EmployeeServiceImpl();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			
			while (true) {
			
				System.out.println("*********************************************");
				System.out.println("Services offered by jdbc");
				System.out.println("*********************************************");
				
				System.out.println("1. INSERT");
				System.out.println("2. UPDATE");
				System.out.println("3. SELECT ON ID");
				System.out.println("4. SELECT ALL");
				System.out.println("5. DELETE");
				System.out.println("6. EXIT THE APPLICATION");
				
				System.out.println("Enter your choice:");
				int choice = Integer.parseInt(reader.readLine());
				String input;
				boolean flag;
				switch(choice) {
				case 1 : {
					
					Employee employee = new Employee();
					System.out.print("Enter the name of the Employee:");
					input = reader.readLine();
					employee.setName(input);
					
					System.out.print("Enter the Salary of the Employee:");
					input = reader.readLine();
					employee.setSalary(new BigDecimal(input));
					
					System.out.print("Enter the City of the Employee:");
					input = reader.readLine();
					employee.setCity(input);
					
					flag = service.saveEmployee(employee);
					
					if (flag) System.out.println("Record inserted successfully...");
					else System.out.println("Something went wrong, pease try again...");
					break;
				}
				case 2 : {
					
					System.out.println("Enter the id for which data to be updated: ");
					int id = Integer.parseInt(reader.readLine());
					Employee employee = service.findEmployeeById(id);
					if (employee == null) {
						System.out.println("Record not found with this id: " + id);
						break;
					}
					System.out.println(employee);
					System.out.println("Select What to Update[name(1), salary(2), city(3)]");
					int update_choice = Integer.parseInt(reader.readLine());
					switch(update_choice) {
					case 1 : {
						System.out.print("Enter the new name of the Employee:");
						input = reader.readLine();
						employee.setName(input);
						flag = service.updateEmployee(employee);
						if (flag) System.out.println("Record updated successfully...");
						else System.out.println("Something went wrong, pease try again...");
						break;
					}
					case 2 : {
						System.out.print("Enter the new Salary of the Employee:");
						input = reader.readLine();
						employee.setSalary(new BigDecimal(input));
						flag = service.updateEmployee(employee);
						if (flag) System.out.println("Record updated successfully...");
						else System.out.println("Something went wrong, pease try again...");
						break;
					}
					case 3 : {
						System.out.print("Enter the new City of the Employee:");
						input = reader.readLine();
						employee.setCity(input);
						flag = service.updateEmployee(employee);
						if (flag) System.out.println("Record updated successfully...");
						else System.out.println("Something went wrong, pease try again...");
						break;
					}
					default : {
						System.out.println("Invalid Choice, please try again");
						break;
					}
					}
					break;
				}
				case 3 : {
					
					System.out.print("Enter the Id of the Employee:");
					int id = Integer.parseInt(reader.readLine());
					Employee employee = service.findEmployeeById(id);
					if (employee == null) {
						System.out.println("Record not found with this id: " + id);
					}
					else {
						System.out.println("Employee name: " + employee.getName());
						System.out.println("Salary: " + employee.getSalary());
						System.out.println("City: " + employee.getCity());
					}
					
					break;
				}
				case 4 : {
					
					List<Employee> list = service.findAllEmployees();
					
					if (list.isEmpty()) System.out.println("No Record found in the Employee Dataset");
					else {
						System.out.println("All the records are listed below:");
						for (Employee emp : list) {
							System.out.println(emp);
						}
					}
					
					break;
				}
				case 5 : {
					
					System.out.print("Enter the Id of the Employee:");
					int id = Integer.parseInt(reader.readLine()); 
					flag = service.deleteEmployeeById(id);
					if (flag) System.out.println("Record deleted successfully...");
					else System.out.println("Record not found with the id: " + id );
					break;
				}
				case 6 : {
					
					System.out.println("Application closed...");
					DbUtil.closeDataSource();
					return;
				}
				default : 
					
					System.out.println("Invalid Choice, please try again...");
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
    }
}