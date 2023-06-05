package com.example.blog.service;

import com.example.blog.Repository.UserRepository;
import com.example.blog.model.RoleType;
import com.example.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encode;

    @Transactional
    public void signUp(User user) {
        String rawPassword = user.getPassword();    // password 원문
        String encPassword = encode.encode(user.getPassword());     // password 해쉬
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

}

/*
    @Transactional(readOnly = true)
    public User login(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
*/