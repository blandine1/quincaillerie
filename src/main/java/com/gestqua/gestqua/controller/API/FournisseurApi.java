package com.gestqua.gestqua.controller.API;

import com.gestqua.gestqua.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public interface FournisseurApi {
    @PostMapping(value = "/fournisseur/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);

    @GetMapping(value = "/fournisseur/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findbyId(@PathVariable Integer id);

    @GetMapping(value = "/fournisseur/find/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findByPhone(@PathVariable String phone);

    @DeleteMapping(value = "/fournisseur/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);

    @GetMapping(value = "/fournisseur/findAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();
}
