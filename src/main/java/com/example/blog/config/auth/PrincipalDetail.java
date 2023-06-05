package com.example.blog.config.auth;

import com.example.blog.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


// 스프링 시큐리티가 로그인 요청을 가로챔 -> 로그인 진행 후 완료 -> UserDetails 타입의 오브젝트를
// 시큐리티의 고유한 세션저장소에 저장함.
public class PrincipalDetail implements UserDetails {

    private User user;      // 콤포지션

    public PrincipalDetail(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정이 만료되지 않았는지 리턴 ( true = 만료 안됨 )
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있는지 리턴 ( true = 잠기지 않음 )
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호가 만료되지 않았는지 리턴 ( true = 만료 안됨 )
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정활성화 여부 리턴 ( true = 활성화 )
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 계정이 갖고 있는 권한 목록을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(()->{    return "ROLE_" + user.getRole();    });

        return collectors;
    }

}
