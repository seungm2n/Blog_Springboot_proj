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

    // 암호화된 비밀번호를 저장하여 회원가입
    @Transactional
    public void signUp(User user) {
        String rawPassword = user.getPassword();    // password 원문
        String encPassword = encode.encode(rawPassword);     // password 해쉬
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

    // 회원수정
    @Transactional
    public void update(User user) {
        // 수정 시에 JPA 영속성 컨텍스트 User 오브젝트를 영속화시키고, 영속화된 User 오브젝트를 수정
        User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException("해당 유저를 찾을 수 없습니다.");
        });
        // 비밀번호 암호화 저장
        String rawPassword = user.getPassword();    // password 원문
        String encPassword = encode.encode(rawPassword);     // password 해쉬
        persistance.setPassword(encPassword);
        persistance.setEmail(user.getEmail());
        // 회원수정 함수 종료 시(서비스 종료 시) 트랜잭션이 끝나며, Auto Commit.

    }
}