package com.gestqua.gestqua.controller.API;

import com.gestqua.gestqua.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public interface ClientApi {
    @PostMapping(value = "/client/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto clientDto);

    @GetMapping(value = "/client/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findbyId(@PathVariable Integer id);

    @GetMapping(value = "/client/find/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findByPhone(@PathVariable String phone);

    @DeleteMapping(value = "/client/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);

    @GetMapping(value = "/client/findAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();
}
