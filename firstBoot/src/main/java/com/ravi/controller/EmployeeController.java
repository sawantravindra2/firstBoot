package com.ravi.controller;

import com.ravi.exception.EmployeeNotFoundException;
import com.ravi.model.*;
import com.ravi.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/h2/emp")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService, AutoEmployeeMapper autoEmployeeMapper) {
        this.employeeService = employeeService;
        this.modelMapper = autoEmployeeMapper;
    }


    private AutoEmployeeMapper modelMapper;


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method to save employees in the db.
     *
     * @param emp
     * @return
     */
    /*
     * @PostMapping(value = "/create") public String create(@RequestBody
     * List<Employee> emp) { logger.debug("Saving employees.");
     * employeeService.createEmployee(emp); return "Employee records created."; }
     */
    @PostMapping(value = "/create")
    @PreAuthorize(" hasRole('ADMIN')")
    public int create(@RequestBody Employee emp) {
        logger.debug("Saving employees.");
        return employeeService.createEmployee(emp);
        //return "Employee records created.";
    }

    /**
     * Method to fetch all employees from the db.
     *
     * @return
     */
    @GetMapping(value = "/getall")
    public ResponseEntity<List<Employee>> getAll() {
        logger.debug("Getting all employees.");
        List<Employee> employeeList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    /**
     * Method to fetch employee by id.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getbyid/{employee-id}")
    public EmployeeDTO getById(@PathVariable(value = "employee-id") int id) {
        logger.debug("Getting employee with employee-id= {}.", id);
        return employeeService.findEmployeeById(id)
                .map(emp -> convertToDTO(emp))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    /**
     * Method to update employee by id.
     *
     * @param id
     * @param e
     * @return
     */
    @PutMapping(value = "/update/{employee-id}")
    public String update(@PathVariable(value = "employee-id") int id, @RequestBody Employee e) {
        logger.debug("Updating employee with employee-id= {}.", id);
        //e.setId(id);
        employeeService.updateEmployee(e);
        return "Employee record for employee-id= " + id + " updated.";
    }

    /**
     * Method to delete employee by id.
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete/{employee-id}")
    public String delete(@PathVariable(value = "employee-id") int id) {
        logger.debug("Deleting employee with employee-id= {}.", id);
        employeeService.deleteEmployeeById(id);
        return "Employee record for employee-id= " + id + " deleted.";
    }

    /**
     * Method to delete all employees from the db.
     *
     * @return
     */
    @DeleteMapping(value = "/deleteall")
    public String deleteAll() {
        logger.debug("Deleting all employees.");
        employeeService.deleteAllEmployees();
        return "All employee records deleted.";
    }


    @GetMapping(value = "/getbyaddressid")
    public EmployeeAddDTO getAddress(@RequestParam(name = "addressId") Integer addressId) {
        return employeeService.getByAddressId(addressId)
                .map(address -> convertToDTO(address))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }


    private EmployeeDTO convertToDTO(Employee employee) {
        return modelMapper.mapToEmployeeDto(employee);
    }

    private EmployeeAddDTO convertToDTO(Address address) {
        return modelMapper.mapToAddressDto(address);
    }


}