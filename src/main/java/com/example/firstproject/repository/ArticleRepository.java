package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
// Entity 타입, pk 타입
public interface ArticleRepository extends CrudRepository<Article, Long> {
    // 재사용성이 많을 것 같을 때는 타입변환은 상위에서 해준다
    @Override
    ArrayList<Article> findAll();
}
