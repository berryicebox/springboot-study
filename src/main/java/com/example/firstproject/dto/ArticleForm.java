package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 전체 생성자
@ToString
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    /* // 기본 생성자 @AllArgsConstructor
    public ArticleForm(String content, String title) {
        this.content = content;
        this.title = title;
    } */

    /* // 객체를 설명해주는 메서드 @ToString
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    } */

    // DTO를 엔티티에 집어 넣기 위해 필요한 메서드
    public Article toEntity() {
        return new Article(id, title, content);
    }
}
