package com.security.spring.springsecurity.service;

import com.security.spring.springsecurity.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;


public interface EmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> listEmployee();

    void deleteEmployeeById(long id);

    Employee getEmployeeById(long id);

    Page<Employee> findPaginated(int pageNumber, int pageSize);
}
