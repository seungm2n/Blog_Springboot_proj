package com.example.blog.controller;

import com.example.blog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping({"","/"})
    public String index(Model model , @PageableDefault(size = 5, sort = "createDate", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.getBoards(pageable));
        return "index";     // view
    }

    // 글 수정하기
    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model) {
            model.addAttribute("board", boardService.boardDetail(id));
        return "board/updateForm";
    }

    // 글 상세보기
    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.boardDetail(id));
        return "board/detail";
    }

    // 작성한 게시글을 저장
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

}
