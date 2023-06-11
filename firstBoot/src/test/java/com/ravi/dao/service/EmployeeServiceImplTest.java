package com.ravi.dao.service;


import com.ravi.dao.AddressDao;
import com.ravi.dao.EmployeeDao;
import com.ravi.model.Address;
import com.ravi.model.Employee;
import com.ravi.service.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;


    @Mock
    EmployeeDao employeeDao;


    @Mock
    AddressDao addressDao;


    @Test
    public void findEmployeeByIdTest() {

        Address address = new Address(7, "Mumbai", "kamothe sec 35", "Maharashtra");
        Employee employee = new Employee(5, "Ravi", "Sawant", "sawantravindra2@gmail.com", address);

        Employee employee2 = new Employee(0, "default", null, null, null);


        when(employeeDao.findById(5)).thenReturn(getEmployeeById(employee));

        Optional<Employee> testedEmployee = Optional.of(employeeServiceImpl.findEmployeeById(5).orElse(employee2));

        assertEquals("Ravi", testedEmployee.get().getFirstName(), "name should be Ravi");

    }


    public Optional<Employee> getEmployeeById(Employee employee) {
        return Optional.of(employee);
    }


}
