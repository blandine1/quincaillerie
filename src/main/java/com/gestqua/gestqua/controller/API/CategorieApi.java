package com.gestqua.gestqua.controller.API;

import com.gestqua.gestqua.dto.CategorieDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public interface CategorieApi {

    @PostMapping(value = "/categorie/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto save(CategorieDto categorieDto);

    @GetMapping(value = "/categorie/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto findbyId(@PathVariable Integer id);

    @GetMapping(value = "/categorie/find/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto findByName(@PathVariable String name);

    @DeleteMapping(value = "/categorie/delete/{namide}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);

    @GetMapping(value = "/categorie/findAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategorieDto> findAll();
}
