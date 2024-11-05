package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j // 롬복에서 지원하는 로깅
@Controller
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/article/new")
    public String newArticleForm() {
        return "article/new";
    }

    @PostMapping("/article/create")
    public String createArticleForm(ArticleForm articleForm){
        // 받은 데이터 확인
        log.info(articleForm.toString());

        // 1. DTO를 엔티티로 변환
        Article article = articleForm.toEntity();
        log.info(article.toString());

        // 2. 레파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        // Article Entity의 id를 가져온다
        return "redirect:/article/" + saved.getId();
    }

    @GetMapping("/article/{id}")
    public String show(@PathVariable Long id, Model model){
        // 로그
        log.info("id = " + id);

        // 들어온 아이디로 엔티티를 찾음 (CRUD 역할 = SELECT * FROM article WHERE id = ?)
        // 객체가 비어있을때 null 반환
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 모델에 데이터 등록
        model.addAttribute("article", articleEntity);

        // 뷰 페이지 반환
        return "article/show";
    }

    // 전체 게시글 조회
    @GetMapping("/articles")
    public String index(Model model){
        List<Article> articleEntityList = articleRepository.findAll();

        model.addAttribute("articleList", articleEntityList);

        return "article/index";
    }

    // 수정 화면
    @GetMapping("/article/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Article articleEntity = articleRepository.findById(id).orElse(null);

        model.addAttribute("article", articleEntity);

        return "article/edit";
    }

    // 실제로 수정 적용
    @PostMapping("/article/update")
    public String update(ArticleForm form){
        // 데이터 정보
        log.info(form.toString());

        // DTO를 엔티티로 변환
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        // 엔티티를 DB로 저장
        // 1. DB에서 기존 데이터 가져오기
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        // 2. 기존 데이터 값을 갱신하기
        if (target != null){
            articleRepository.save(articleEntity);
        }

        // 수정 결과 페이지로 리다이렉트 하기
        return "redirect:/article/" + articleEntity.getId();

    }
}
