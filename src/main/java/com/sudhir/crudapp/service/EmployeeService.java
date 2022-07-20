package com.sudhir.crudapp.service;

import com.sudhir.crudapp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeId(long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(long id);
    void deleteAllEmployee();

}
