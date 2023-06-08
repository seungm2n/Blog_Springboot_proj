package com.example.blog.service;

import com.example.blog.Repository.BoardRepository;
import com.example.blog.Repository.ReplyRepository;
import com.example.blog.dto.ReplySaveRequestDto;
import com.example.blog.model.Board;
import com.example.blog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor    // 생성자 만들 때, 초기화 해줌
public class BoardService {

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

//    public BoardService(BoardRepository bRepository, ReplyRepository rRepository) {
//        this.boardRepository = bRepository;
//        this.replyRepository = rRepository;
//    }

    // 작성한 게시글을 저장
    @Transactional
    public void writeBoard(Board board, User user) {
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    // 게시글 리스트를 불러옴
    @Transactional(readOnly = true)
    public Page<Board> getBoards(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    // 글 상세보기
    @Transactional(readOnly = true)
    public Board boardDetail(int id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("존재하지 않는 게시글입니다.");
                });
    }

    // 글 삭제하기
    @Transactional
    public void boardDelete(int id) {
        boardRepository.deleteById(id);
    }

    // 글 수정하기
    @Transactional
    public void updateBoard(int id, Board requestBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("존재하지 않는 게시글입니다.");
                });     // 영속화 완료
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        // 해당 함수 종료 시(Service가 종료될 때) 트랜잭션이 종료 -> 이 때 더티체킹 -> 자동 업데이트 db flush.
    }

    // 댓글 작성
    @Transactional
    public void replyWrite(ReplySaveRequestDto replySaveRequestDto) {

        int result = replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
        System.out.println(result);
    }

    // 댓글 삭제
    @Transactional
    public void replyDelete(int replyId) {
        replyRepository.deleteById(replyId);
    }
}