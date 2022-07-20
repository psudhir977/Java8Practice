package com.sudhir.crudapp.repository;

import com.sudhir.crudapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Optional<Employee> findByEmployeeId(long id);
    List<Employee> findByDept(String dept);
}
