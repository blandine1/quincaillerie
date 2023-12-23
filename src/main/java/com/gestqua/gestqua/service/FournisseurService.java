package com.gestqua.gestqua.service;

import com.gestqua.gestqua.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    FournisseurDto save(FournisseurDto fournisseurDto);
    FournisseurDto findbyId(Integer id);

    FournisseurDto findByPhone(String phone);
    void delete(Integer id);

    List<FournisseurDto> findAll();
}
