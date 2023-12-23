package com.gestqua.gestqua.service;

import com.gestqua.gestqua.dto.AdministrateurDto;
import java.util.List;

public interface AdministrateurService {
    AdministrateurDto save(AdministrateurDto administrateurDto);

    AdministrateurDto findbyId(Integer id);

    AdministrateurDto findByPhone(String phone);

    void delete(Integer id);

    List<AdministrateurDto> findAll();
}
