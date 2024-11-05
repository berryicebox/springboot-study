package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor // 전체 생성자
@NoArgsConstructor // 기본 생성자
@ToString
// DB에 Article이라는 이름으로 데이터 베이스를 만듦
@Entity
public class Article {

    @Id // PK
    @GeneratedValue // Autoincrement
    private Long id;

    @Column
    private String title;

    @Column
    private String content;



    // 기본 생성자 @AllArgsConstructor
//    public Article(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }

    /* // toString @ToString
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    } */
}
