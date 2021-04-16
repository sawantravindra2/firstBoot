package com.ravi.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.dao.EmployeeDao;
import com.ravi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// The dao repository will use the Mongodb-Repository to perform the database
	// operations.
	@Autowired
	EmployeeDao employeeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#createEmployee(java.
	 * util.List)
	 */
	/*
	 * @Override public void createEmployee(List<Employee> emp) {
	 * employeeDao.saveAll(emp); }
	 */

	@Override
	public void createEmployee(Employee emp) {
		employeeDao.save(emp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#getAllEmployees()
	 */
	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#findEmployeeById(int)
	 */
	@Override
	public Optional<Employee> findEmployeeById(int id) {
		return employeeDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#deleteEmployeeById(
	 * int)
	 */
	@Override
	public void deleteEmployeeById(int id) {
		employeeDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#updateEmployee(int)
	 */
	@Override
	public void updateEmployee(Employee emp) {
		employeeDao.save(emp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.mongo.service.Employeeservice#deleteAllEmployees()
	 */
	@Override
	public void deleteAllEmployees() {
		employeeDao.deleteAll();
	}
}