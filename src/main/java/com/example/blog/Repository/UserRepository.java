package com.example.blog.Repository;

import com.example.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // SELECT * FROM user WHERE username = ?;
    Optional<User> findByUsername(String username);
}

// JPA Naming 쿼리 전략
// User findByUsernameAndPassword(String username, String password);
// SELECT * FROM user WHERE username = ? AND password = ?;
