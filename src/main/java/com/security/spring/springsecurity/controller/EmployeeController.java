package com.security.spring.springsecurity.controller;

import com.security.spring.springsecurity.model.Employee;
import com.security.spring.springsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/showNewEmployeeForm")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        System.out.println("employeename" + employee);
        model.addAttribute("employee", employee);
        return "new_employee";
    }
}
