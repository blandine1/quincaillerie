package com.gestqua.gestqua.controller;

import com.gestqua.gestqua.controller.API.FournisseurApi;
import com.gestqua.gestqua.dto.FournisseurDto;
import com.gestqua.gestqua.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService){
        this.fournisseurService=fournisseurService;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return fournisseurService.save(fournisseurDto);
    }

    @Override
    public FournisseurDto findbyId(Integer id) {
        return fournisseurService.findbyId(id);
    }

    @Override
    public FournisseurDto findByPhone(String phone) {
        return fournisseurService.findByPhone(phone);
    }

    @Override
    public void delete(Integer id) {
         fournisseurService.delete(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }
}
