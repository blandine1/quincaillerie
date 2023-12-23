package com.gestqua.gestqua.service;

import com.gestqua.gestqua.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {
    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);
    CommandeFournisseurDto update(CommandeFournisseurDto commandeFournisseurDto);
    CommandeFournisseurDto findByid(Integer id);

    CommandeFournisseurDto findByPhone(String phone);

    List<CommandeFournisseurDto> findAll();

    CommandeFournisseurDto delete(Integer id);
}