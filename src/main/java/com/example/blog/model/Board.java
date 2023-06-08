package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 100)
    private String title;

    @Lob    // 대용량 데이터
    private String content; // 섬머노트 라이브러리 사용 <html>태그가 섞여 디자인 됨

    private int count;  // 조회수

    @ManyToOne(fetch = FetchType.EAGER)  // Many = Board, User = One
    @JoinColumn(name="userId")
    private User user;  // DB는 오브젝트를 저장할 수 없음. FK, 자바는 오브젝트를 저장할 수 있음.

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)  // mappedBy 연관관계의 주인이 아니다. FK 가 아니니까 DB에 칼럼을 만들지 X,
    @JsonIgnoreProperties({"board"})
    private List<Reply> replys;

    @CreationTimestamp
    private Timestamp createDate;
}
