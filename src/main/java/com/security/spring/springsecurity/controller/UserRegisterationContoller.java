package com.security.spring.springsecurity.controller;

import com.security.spring.springsecurity.service.UserService;
import com.security.spring.springsecurity.web.datatransferobject.UserRegisterationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegisterationContoller {

    private UserService userService;

    public UserRegisterationContoller(UserService userService) {
        this.userService = userService;

    }

//    to hold the user data receiving "user" from the registration.html form
    @ModelAttribute("user")
    public UserRegisterationDTO userRegisterationDTO(){
        return new UserRegisterationDTO();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") UserRegisterationDTO userRegisterationDTO) {
        userService.saveUserData(userRegisterationDTO);
        return "redirect:/registration?success";
    }


}
