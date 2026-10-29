package com.sabir.model;

import java.math.BigDecimal;

public class Employee {

    private int id;
	private String name;
	private BigDecimal salary;
	private String city;
	
	public Employee(String name, BigDecimal salary, String city) {
		super();
		this.name = name;
		this.salary = salary;
		this.city = city;
	}
	
	public Employee(int id, String name, BigDecimal salary, String city) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.city = city;
	}

	public Employee() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String address) {
		this.city = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", city=" + city + "]";
	}
}
