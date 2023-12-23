package com.gestqua.gestqua.controller;

import com.gestqua.gestqua.controller.API.ClientApi;
import com.gestqua.gestqua.dto.ClientDto;
import com.gestqua.gestqua.service.ArticleService;
import com.gestqua.gestqua.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {
     private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @Override
    public ClientDto findbyId(Integer id) {
        return clientService.findbyId(id);
    }

    @Override
    public ClientDto findByPhone(String phone) {
        return clientService.findByPhone(phone);
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }
}
