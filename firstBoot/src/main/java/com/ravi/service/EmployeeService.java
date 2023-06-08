package com.ravi.service;

import java.util.List;
import java.util.Optional;

import com.ravi.model.Address;
import com.ravi.model.Employee;

public interface EmployeeService {

	//public void createEmployee(List<Employee> emp);
	public Integer createEmployee(Employee emp);

	public List<Employee> getAllEmployees();

	public Optional<Employee> findEmployeeById(int id);

	public void updateEmployee(Employee e);

	public void deleteEmployeeById(int id);

	public void deleteAllEmployees();

	Optional<Address> getByAddressId(Integer city);
}
