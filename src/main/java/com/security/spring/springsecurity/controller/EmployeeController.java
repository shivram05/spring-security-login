package com.security.spring.springsecurity.controller;

import com.security.spring.springsecurity.model.Employee;
import com.security.spring.springsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/showNewEmployeeForm")
    public String showAddNewForm(Model model){
        Employee employee = new Employee();
        System.out.println("employeename" + employee);
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String addNewEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showUpdateEmployee(@PathVariable(value = "id") long id, Model model){

        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("updateEmployeeModelAttribute", employee);
        return "update_employee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("updateEmployeeModelAttribute") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
}
