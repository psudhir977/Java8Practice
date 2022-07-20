package com.sudhir.crudapp.service;

import com.sudhir.crudapp.error.EmployeeDetailsException;
import com.sudhir.crudapp.model.Employee;
import com.sudhir.crudapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// REMEMBER -  Spring @service annotation is a specialization of @component annotation.
// This annotation can only be applied to classes.
//It is used to mark a class as service provider.
//
@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
      Optional<Employee> savedEmployee = employeeRepository.findById(employee.getId());
      if(savedEmployee.isPresent()){
              throw  new EmployeeDetailsException("Already saved employee");
      }else{
          return  employeeRepository.save(employee);
      }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeId(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }
}
