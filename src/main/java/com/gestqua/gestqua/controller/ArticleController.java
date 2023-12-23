package com.gestqua.gestqua.controller;


import com.gestqua.gestqua.controller.API.ArticleApi;
import com.gestqua.gestqua.dto.ArticleDto;
import com.gestqua.gestqua.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService=articleService;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    @Override
    public ArticleDto findbyId(Integer id) {
        return articleService.findbyId(id);
    }

    @Override
    public ArticleDto findByName(String name) {
        return articleService.findByName(name);
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }
}
