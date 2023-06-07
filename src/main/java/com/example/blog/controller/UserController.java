package com.example.blog.controller;

import com.example.blog.config.auth.PrincipalDetail;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;

// 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
// 그냥 주소가 / 이면 index.jsp 허용
// static 이하에 있는 /js/**, /css/**, /images/**

@Controller
public class UserController {

    // 회원가입
    @GetMapping("/auth/joinForm")
    public String joinForm() {

        return "user/joinForm";
    }

    // 로그인
    @GetMapping("/auth/loginForm")
    public String loginForm() {

        return "user/loginForm";
    }

    // 카카오 로그인
    @GetMapping("/auth/kakao/callback")
    public @ResponseBody String kakaoCallback(String code){

        // POST 방식으로 key=value 데이터를 요청 (카카오에게)
        // Retrofit2
        // OkHttp
        // RestTemplate
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        // MIME 타입
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "456c1872f8d2d15779d10abf7ab796dd");
        params.add("redirect_uri", "http://localhost:8080/auth/kakao/callback");
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        // POST 방식으로 Http 요청하기 - response 변수의 응답 받음
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token"
                    , HttpMethod.POST
                    , kakaoTokenRequest
                    , String.class
        );

        return "카카오 인증 완료. 토큰 요청에 대한 응답  : " + response;
    }

    // 회원정보 수정
    @GetMapping("/user/updateForm")
    public String updateForm(@AuthenticationPrincipal PrincipalDetail principal) {
        return "user/updateForm";
    }
}
