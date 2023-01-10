package com.security.spring.springsecurity.impl;

import com.security.spring.springsecurity.model.Role;
import com.security.spring.springsecurity.model.User;
import com.security.spring.springsecurity.repository.UserRepository;
import com.security.spring.springsecurity.service.UserService;
import com.security.spring.springsecurity.web.datatransferobject.UserRegisterationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUserData(UserRegisterationDTO userRegisterationDTO) {
        User user = new User(userRegisterationDTO.getFirstName(), userRegisterationDTO.getLastName(),
                userRegisterationDTO.getEmail(),
                encoder.encode(userRegisterationDTO.getPassword()), Arrays.asList(new Role(userRegisterationDTO.getUserRoles())));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user==null){
            throw new UsernameNotFoundException("Invalid user name or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),
                mapRolesToAuthorities(user.getRoleCollection()  ));
    }

    private List<? extends  GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
            return roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
