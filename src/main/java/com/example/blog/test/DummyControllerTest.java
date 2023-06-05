package com.example.blog.test;

import com.example.blog.Repository.UserRepository;
import com.example.blog.model.RoleType;
import com.example.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            return "삭제에 실패하였습니다. 해당 ID는 DB에 없습니다.";
        }

        return "삭제되었습니다. ID : " + id;
    }

    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){
        // @RequestBody : JSON 데이터 요청 -> Java Object(Message Converter의 Jackson라이브러리가 변환해서 받아줌)
        System.out.println("ID : " + id);
        System.out.println("PASSWORD : " + requestUser.getPassword());
        System.out.println("EMAIL : " + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        // userRepository.save(user);
        return user;
    }

    // 한 페이지당 2건에 데이터를 리턴
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pagingUser = userRepository.findAll(pageable);

        List<User> users = pagingUser.getContent();
        return users;
    }

    // {id} 주소로 파라미터를 전달 받을 수 있음
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {

        // 데이터를 가져오는데 가져올 수 없을 경우, 예외처리
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 사용자가 없습니다.");
            }
        });

        // (람다식)
//      // 데이터를 가져오는데 가져올 수 없을 경우, 예외처리
//      User user = userRepository.findById(id).orElseThrow(() ->{
//          return new IllegalArgumentException("해당 유저는 없습니다. ID : " + id);
//      });

        return user;
    }

    // 유저 Insert
    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("ID : " + user.getId());
        System.out.println("USERNAME : " + user.getUsername());
        System.out.println("PASSWORD : " + user.getPassword());
        System.out.println("EMAIL : " + user.getEmail());
        System.out.println("ROLE : " + user.getRole());
        System.out.println("CREATEDATE : " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다";

    }
}
