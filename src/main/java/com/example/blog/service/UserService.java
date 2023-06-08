package com.example.blog.service;

import com.example.blog.Repository.UserRepository;
import com.example.blog.model.RoleType;
import com.example.blog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encode;

    @Transactional(readOnly = true)
    public User findByUser(String username) {

        User user = userRepository.findByUsername(username).orElseGet(() -> {
         return new User();
        });

        return user;
    }
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

        // Validation 체크 - 간편회원가입 여부 => oauth필드에 값이 없으면 수정 가능
        if(persistance.getOauth() == null || persistance.getOauth().equals("")) {
            // 비밀번호 암호화 저장
            String rawPassword = user.getPassword();    // password 원문
            String encPassword = encode.encode(rawPassword);     // password 해쉬
            persistance.setPassword(encPassword);
            persistance.setEmail(user.getEmail());
        }
        // 회원수정 함수 종료 시(서비스 종료 시) 트랜잭션이 끝나며, Auto Commit.
    }
}