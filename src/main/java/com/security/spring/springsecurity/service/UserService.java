package com.security.spring.springsecurity.service;

import com.security.spring.springsecurity.model.User;
import com.security.spring.springsecurity.web.datatransferobject.UserRegisterationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User saveUserData(UserRegisterationDTO userRegisterationDTO);


}
