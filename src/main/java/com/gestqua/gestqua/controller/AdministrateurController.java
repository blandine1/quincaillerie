package com.gestqua.gestqua.controller;

import com.gestqua.gestqua.controller.API.AdministrateurApi;
import com.gestqua.gestqua.dto.AdministrateurDto;
import com.gestqua.gestqua.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class AdministrateurController implements AdministrateurApi {
    private AdministrateurService administrateurService;

    @Autowired
    public AdministrateurController(AdministrateurService administrateurService){
        this.administrateurService=administrateurService;
    }

    @Override
    public AdministrateurDto save(AdministrateurDto administrateurDto) {
        return administrateurService.save(administrateurDto);
    }

    @Override
    public AdministrateurDto findbyId(Integer id) {
        return administrateurService.findbyId(id);
    }

    @Override
    public AdministrateurDto findByPhone(@PathVariable String phone) {
        return administrateurService.findByPhone(phone);
    }

    @Override
    public void delete(Integer id) {
        administrateurService.delete(id);
    }

    @Override
    public List<AdministrateurDto> findAll() {
        return administrateurService.findAll();
    }

}
