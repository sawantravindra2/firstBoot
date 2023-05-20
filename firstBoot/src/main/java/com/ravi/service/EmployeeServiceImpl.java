package com.ravi.service;

import java.util.List;
import java.util.Optional;

import com.ravi.dao.AddressDao;
import com.ravi.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.dao.EmployeeDao;
import com.ravi.model.Employee;

@Service
	public class EmployeeServiceImpl implements EmployeeService {

	// The dao repository will use the H2-Repository to perform the database
	// operations.
	@Autowired
	EmployeeDao employeeDao;


	@Autowired
	AddressDao addressDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.h2.service.Employeeservice#createEmployee(java.
	 * util.List)
	 */
	/*
	 * @Override public void createEmployee(List<Employee> emp) {
	 * employeeDao.saveAll(emp); }
	 */

	//@Transactional
	@Override
	public Integer createEmployee(Employee emp) {
		return employeeDao.save(emp).getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.h2.service.Employeeservice#getAllEmployees()
	 */
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.h2.service.Employeeservice#findEmployeeById(int)
	 */
	@Override
	public Optional<Employee> findEmployeeById(int id) {
		return employeeDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.h2.service.Employeeservice#deleteEmployeeById(
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
	 * com.assignment.springboot.h2.service.Employeeservice#updateEmployee(int)
	 */
	@Override
	public void updateEmployee(Employee emp) {
		employeeDao.save(emp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assignment.springboot.h2.service.Employeeservice#deleteAllEmployees()
	 */
	@Override
	public void deleteAllEmployees() {
		employeeDao.deleteAll();
	}

	@Override
	public Address getByAddressId(Integer id) {
		return addressDao.findById(id).get();
	}
}