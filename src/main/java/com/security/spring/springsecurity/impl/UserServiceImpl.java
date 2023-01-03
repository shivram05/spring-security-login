package com.security.spring.springsecurity.impl;

import com.security.spring.springsecurity.model.Role;
import com.security.spring.springsecurity.model.User;
import com.security.spring.springsecurity.repository.UserRepository;
import com.security.spring.springsecurity.service.UserService;
import com.security.spring.springsecurity.web.datatransferobject.UserRegisterationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUserData(UserRegisterationDTO userRegisterationDTO) {
        User user = new User(userRegisterationDTO.getFirstName(), userRegisterationDTO.getLastName(),
                userRegisterationDTO.getEmail(),
                userRegisterationDTO.getPassword(), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }
}
