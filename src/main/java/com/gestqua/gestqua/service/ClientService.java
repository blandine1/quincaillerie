package com.gestqua.gestqua.service;

import com.gestqua.gestqua.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto clientDto);
    ClientDto findbyId(Integer id);

    ClientDto findByPhone(String phone);
    void delete(Integer id);

    List<ClientDto> findAll();
}
