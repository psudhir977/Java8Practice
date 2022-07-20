package com.sudhir.crudapp;


import com.sudhir.crudapp.model.Employee;
import com.sudhir.crudapp.repository.EmployeeRepository;
import com.sudhir.crudapp.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

        @Mock
        private EmployeeRepository employeeRepository;

        @InjectMocks
        private EmployeeServiceImpl employeeService;

        private Employee employee;

        @BeforeEach
        public void setUp(){
                employee = Employee.builder().id(1l).name("Sudhir").dept("Science").salary("1000").build();
        }


        // jUnit test for save employee method
        @DisplayName("Junit test for save employee method")
        @Test
        public void givenEmployeeObj_WhenSaveEmployee_thenReturnEmployeeObj(Employee employee) {
          // given precondition for setup
                given(employeeRepository.findByDept(employee.getDept()));

        }
}
