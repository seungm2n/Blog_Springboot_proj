package com.example.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 빈 등록이란? - 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration      // 빈등록 (IoC관리)
@EnableWebSecurity  // 시큐리티 필터로 등록이 된다
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크 하겠다는 뜻
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean // IoC
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()       // csrf 토큰 비활성화 (테스트 시 걸어두는게 좋음)
            .authorizeRequests()
                .antMatchers("/","/auth/**","/js/**","/css/**","/images/**")
                .permitAll()
                .anyRequest()
                .authenticated()
            .and()
                .formLogin()
                .loginPage("/auth/loginForm");
    }
}
