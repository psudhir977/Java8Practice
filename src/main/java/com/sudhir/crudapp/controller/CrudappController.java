package com.sudhir.crudapp.controller;

import com.sudhir.crudapp.error.EmployeeDetailsException;
import com.sudhir.crudapp.model.Employee;
import com.sudhir.crudapp.repository.EmployeeRepository;
import com.sudhir.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin // this annotation enables cross-origin resource sharing only for specific method
@RestController // this annotation is used to define a controller and to indicate the return value of the
                // methods should be bound to the web response body
@RequestMapping("/api") // declares that all apis in the controller will start with /api

public class CrudappController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/Employees")
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false)  String dept){
        try {
            List<Employee> employeeList ;
              employeeList=  employeeService.getAllEmployees();
            // Response entity is a fine grained wrapper class of HTTP response object.
            // it provides control to specify HTTP status codes, Http headers and response body
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable("id")  long id){
        Optional<Employee> employeeList = employeeService.getEmployeeId(id);
        if(employeeList.isPresent()){
            return new ResponseEntity<>(employeeService.getEmployeeId(id),HttpStatus.OK);
        }else{
            throw new EmployeeDetailsException("Invalid Employee Id");
        }
    }

    @PostMapping(value="/employees/save", consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        try{
            Employee emp = new Employee();
            emp.setDept(employee.getDept());
            emp.setName(employee.getName());
            emp.setSalary(employee.getSalary());
            employeeService.saveEmployee(employee);
            return new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee) {
        Optional<Employee> employeeData = employeeService.getEmployeeId(id);
             if (employeeData.isPresent()) {
                Employee employee2 = employeeData.get(); // not creating a new object
                employee2.setName(employee.getName());
                employee2.setDept(employee.getDept());
                employee2.setSalary(employee.getSalary());
                return new ResponseEntity<>(employeeService.saveEmployee(employee2), HttpStatus.OK);
            }else{
                 throw new EmployeeDetailsException("Employee Not found");
            }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id){
        try{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employees")
    public ResponseEntity<Employee> deleteAllEmployees(){
        try{
            employeeService.deleteAllEmployee();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
