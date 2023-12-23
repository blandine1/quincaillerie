package com.gestqua.gestqua.controller.API;

import com.gestqua.gestqua.dto.AdministrateurDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public interface AdministrateurApi {
    @PostMapping(value = "/administrateur/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AdministrateurDto save(@RequestBody AdministrateurDto administrateurDto);

    @GetMapping(value = "/administrateur/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    AdministrateurDto findbyId(@PathVariable Integer id);

    @GetMapping(value = "/administrateur/find/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    AdministrateurDto findByPhone(@PathVariable String phone);

    @DeleteMapping(value = "/administrateur/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);

    @GetMapping(value = "/administrateur/findAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<AdministrateurDto> findAll();
}
