package com.example.blog.Repository;

import com.example.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // JPA Naming 쿼리 전략
    User findByUsernameAndPassword(String username, String password);
    // SELECT * FROM user WHERE username = ? AND password = ?;
}
