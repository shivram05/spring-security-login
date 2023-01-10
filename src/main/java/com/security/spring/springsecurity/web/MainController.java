package com.security.spring.springsecurity.web;

import com.security.spring.springsecurity.model.Employee;
import com.security.spring.springsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/")
    public String viewHomePage(Model model){
        return findPaginated(1,model);
    }
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model){
        int pageSize = 5;
        Page<Employee> page = employeeService.findPaginated(pageNo,pageSize);
        List<Employee> employeeList = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("listEmployee",employeeList);

        return "index";
    }
}

