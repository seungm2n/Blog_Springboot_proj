package com.example.blog.controller.api;

import com.example.blog.config.auth.PrincipalDetail;
import com.example.blog.dto.ResponseDto;
import com.example.blog.model.Board;
import com.example.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    // 게시글 작성
    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
            boardService.writeBoard(board, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    // 게시글 삭제
    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id){
        boardService.boardDelete(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    // 게시글 수정
    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board) {
//        System.out.println("Content : "+ board.getContent());
//        System.out.println("Title : " + board.getTitle());
        boardService.updateBoard(id, board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}

/*  // 전통적인 방식
    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
        System.out.println("UserApiController : Login 호출");
        User principal = userService.login(user);

        if(principal != null) {
            session.setAttribute("principal", principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
*/
