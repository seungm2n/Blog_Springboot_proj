package com.example.blog.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class encodeTest {

    @Test
    public void HashTest() {
        String encPassword = new BCryptPasswordEncoder().encode("1234");
        System.out.println("비밀번호 암호화 TEST : " + encPassword);
    }
}
