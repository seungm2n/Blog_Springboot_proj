package com.example.blog.config.auth;

import com.example.blog.Repository.UserRepository;
import com.example.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service    // Bean 등록
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    // 스프링이 로그인 요청을 가로챌 떄, username과 password 변수를 가로채는데
    // password 부분 처리는 알아서 한다.
    // 그래서 username이 DB에 있는지만 확인해주면 됨.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
                .orElseThrow(
                    ()->{
                        return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. username: " + username);
                    });
        return new PrincipalDetail(principal);    // 시큐리티의 세션에 유저 정보가 저장됨.
    }
}
