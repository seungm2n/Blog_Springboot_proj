package com.example.blog.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder    // 빌더 패턴
// @DynamicInsert Insert할 때 Null인 필드 제외
@Entity
public class User {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // auto_increment

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, length = 100)     // 넉넉하게 주는 이유는 비밀번호 암호화 때문.
    private String password;

    @Column(nullable = false, length = 100)     // 암호화 때문
    private String email;

    // DB는 RoleType이라는게 없음
    // @ColumnDefault("USER")
    @Enumerated(EnumType.STRING)
    private RoleType role;    // Enum을 쓰는게 좋음. 나중에 도메인 생성 이유

    private String oauth;   // 간편회원가입 체크
    
    @CreationTimestamp      // 시간 자동 입력
    private Timestamp createDate;
}
