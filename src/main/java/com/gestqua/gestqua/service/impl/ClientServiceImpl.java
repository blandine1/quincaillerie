package com.gestqua.gestqua.service.impl;

import com.gestqua.gestqua.Exceptions.EntityNotFoundException;
import com.gestqua.gestqua.Exceptions.ErrorCodes;
import com.gestqua.gestqua.Exceptions.InvalidEntityException;
import com.gestqua.gestqua.dto.ClientDto;
import com.gestqua.gestqua.entity.Client;
import com.gestqua.gestqua.repository.ClientRepository;
import com.gestqua.gestqua.service.ClientService;
import com.gestqua.gestqua.validator.ClientValidatorr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidatorr.validate(clientDto);

        if (!errors.isEmpty()){
            log.error("verrifier les carracteristiques de votre client");
            throw new InvalidEntityException("le client n'est pas valid {}", ErrorCodes.ClIENT_NOT_VALID);
        }

        Client client = clientRepository.findByPhone(clientDto.getPhone());

        if(client != null){
            log.error("le client : "+ client.getName() + " existe deja");
            throw  new InvalidEntityException("Ce Client existe deja", ErrorCodes.ClIENT_ALREADY_EXIST);
        }

        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));
    }

    @Override
    public ClientDto findbyId(Integer id) {

        if (id==null){
            log.error("le id est obligatoire");
            throw new InvalidEntityException("le id est obligatoire", ErrorCodes.ClIENT_NOT_VALID);
        }

        Client byId = clientRepository.findById(id).get();

        if (byId.getId()==null){
            log.error("le client avce cet Id : " +id +" n'existe pas");
            throw new EntityNotFoundException("le client avce cet Id :" +id +" n'exiate pas", ErrorCodes.ClIENT_NOT_FOUND);
        }

        return ClientDto.fromEntity(byId);
    }

    @Override
    public ClientDto findByPhone(String phone) {
        if (phone.isEmpty()){
            log.error("le nom est obligatoire");
            throw new InvalidEntityException("le nom est obligatoire", ErrorCodes.ClIENT_NOT_VALID);
        }

        Client byId = clientRepository.findByPhone(phone);

        if (byId.getName().isEmpty()){
            log.error("le client avec ce nom : " +phone +" n'existe pas");
            throw new EntityNotFoundException("l'article avec ce nom :" +phone +" n'existe pas", ErrorCodes.ClIENT_NOT_FOUND);
        }

        return ClientDto.fromEntity(byId);
    }

    @Override
    public void delete(Integer id) {
        if(id ==null){
            log.error("le id est obligatoire");
            throw new EntityNotFoundException("le client avec cet Id :" +id +" n'existe pas", ErrorCodes.ClIENT_NOT_FOUND);
        }

        clientRepository.deleteById(id);

    }
    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }
}
