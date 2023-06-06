package com.example.blog.Repository;

import com.example.blog.model.Board;
import com.example.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}


