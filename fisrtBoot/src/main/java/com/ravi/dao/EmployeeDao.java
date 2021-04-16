package com.ravi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ravi.model.Employee;
 
@Repository
public interface EmployeeDao extends MongoRepository<Employee, Integer> {
 
}