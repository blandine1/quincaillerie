package com.gestqua.gestqua.repository;

import com.gestqua.gestqua.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Article findByName(String name);
}
