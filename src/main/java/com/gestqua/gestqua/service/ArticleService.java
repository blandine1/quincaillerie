package com.gestqua.gestqua.service;

import com.gestqua.gestqua.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto articleDto);
    ArticleDto findbyId(Integer id);

    ArticleDto findByName(String name);
    void delete(Integer id);

    List<ArticleDto> findAll();
}
