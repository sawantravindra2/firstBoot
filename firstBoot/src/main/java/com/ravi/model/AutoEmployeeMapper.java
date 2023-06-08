package com.ravi.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AutoEmployeeMapper {

    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    @Mapping(source = "firstName", target = "firstname")
    @Mapping(source = "lastName", target = "lastname")
    @Mapping(source = "address", target = "userAddress")
    EmployeeDTO mapToEmployeeDto(Employee employee);

    @Mapping(source = "firstname", target = "firstName")
    @Mapping(source = "lastname", target = "lastName")
    Employee mapToEmployee(EmployeeDTO employeeDTO);


    @Mapping(source = "employee.firstName", target = "firstname")
    @Mapping(source = "employee.lastName", target = "lastname")
    @Mapping(source = "address", target = "userAddress")
    EmployeeAddDTO mapToAddressDto(Address address);

}
