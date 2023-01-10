package com.security.spring.springsecurity.impl;

import com.security.spring.springsecurity.model.Employee;
import com.security.spring.springsecurity.repository.EmployeeRepository;
import com.security.spring.springsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
