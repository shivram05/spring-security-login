package com.security.spring.springsecurity.service;

import com.security.spring.springsecurity.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> listEmployee();

    void deleteEmployeeById(Long id);
}
