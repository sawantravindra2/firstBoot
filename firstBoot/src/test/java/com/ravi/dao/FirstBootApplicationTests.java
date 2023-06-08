package com.ravi.dao;

import com.ravi.controller.EmployeeController;
import com.ravi.model.AutoEmployeeMapper;
import com.ravi.model.AutoEmployeeMapperImpl;
import com.ravi.model.Employee;
import com.ravi.model.EmployeeDTO;
import com.ravi.service.EmployeeService;
import com.ravi.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FirstBootApplicationTests {

    private static final String LAST_NAME = "SAWANT";
    private static final String FIRST_NAME = "RAVI";

    @Test
    void contextLoads() {
    }


    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private AutoEmployeeMapperImpl autoEmployeeMapper;

    @Test
    public void should_map_user_to_userDto() {
        //Given
        Employee employee = new Employee();
        employee.setFirstName("RAVI");
        employee.setLastName("SAWANT");
        //When
        EmployeeDTO employeeDTO = autoEmployeeMapper.mapToEmployeeDto(employee);
        //Then

        assertEquals(LAST_NAME, employeeDTO.getLastname());
        assertEquals(FIRST_NAME, employeeDTO.getFirstname());
    }

}
