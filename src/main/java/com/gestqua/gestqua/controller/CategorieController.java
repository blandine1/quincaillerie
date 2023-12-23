package com.gestqua.gestqua.controller;

import com.gestqua.gestqua.controller.API.CategorieApi;
import com.gestqua.gestqua.dto.CategorieDto;
import com.gestqua.gestqua.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController implements CategorieApi {

    private CategorieService categorieService;

    @Autowired
    public CategorieController (CategorieService categorieService){
        this.categorieService=categorieService;
    }

    @Override
    public CategorieDto save(CategorieDto categorieDto) {
        return categorieService.save(categorieDto);
    }

    @Override
    public CategorieDto findbyId(Integer id) {
        return categorieService.findbyId(id);
    }

    @Override
    public CategorieDto findByName(String name) {
        return categorieService.findByName(name);
    }

    @Override
    public void delete(Integer id) {
         categorieService.delete(id);
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieService.findAll();
    }
}
