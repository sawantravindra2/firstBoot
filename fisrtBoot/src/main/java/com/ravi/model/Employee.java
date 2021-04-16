package com.ravi.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {

	private List<Employees> employees;

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	public List<Employees> getEmployees() {
		return this.employees;
	}
}