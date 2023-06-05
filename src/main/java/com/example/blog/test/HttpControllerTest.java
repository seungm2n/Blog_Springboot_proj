package com.example.blog.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(HTML) 일 경우, @Controller
// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    // 인터넷 브라우저는 GET요청만 할 수 있음.
    @GetMapping("/http/get")
    public String getTest() {
        return "get 요청";
    }

    @PostMapping("/http/post")
    public String postTest() {
        return "post 요청";
    }

    @PutMapping("/http/put")
    public String putTest() {
        return "put 요청";
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
