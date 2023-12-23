package com.gestqua.gestqua.controller.API;

import com.gestqua.gestqua.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public interface ArticleApi {
    @PostMapping(value = "/article/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto articleDto);

    @GetMapping(value = "/article/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findbyId(@PathVariable Integer id);

    @GetMapping(value = "/article/find/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByName(@PathVariable String name);

    @DeleteMapping(value = "/article/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);

    @GetMapping(value = "/article/findAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();
}
