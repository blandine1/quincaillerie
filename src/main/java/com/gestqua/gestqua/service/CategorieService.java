package com.gestqua.gestqua.service;

import com.gestqua.gestqua.dto.CategorieDto;

import java.util.List;

public interface CategorieService {
    CategorieDto save(CategorieDto categorieDto);
    CategorieDto findbyId(Integer id);

    CategorieDto findByName(String name);
    void delete(Integer id);

    List<CategorieDto> findAll();
}
