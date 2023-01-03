package com.security.spring.springsecurity.service;

import com.security.spring.springsecurity.model.User;
import com.security.spring.springsecurity.web.datatransferobject.UserRegisterationDTO;

public interface UserService {

    User saveUserData(UserRegisterationDTO userRegisterationDTO);
}
