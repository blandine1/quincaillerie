package com.gestqua.gestqua.service.impl;

import com.gestqua.gestqua.Exceptions.EntityNotFoundException;
import com.gestqua.gestqua.Exceptions.ErrorCodes;
import com.gestqua.gestqua.Exceptions.InvalidEntityException;
import com.gestqua.gestqua.dto.AdministrateurDto;
import com.gestqua.gestqua.entity.Administrateur;
import com.gestqua.gestqua.repository.AdministrateurRepository;
import com.gestqua.gestqua.service.AdministrateurService;
import com.gestqua.gestqua.validator.AdministrateurValidatorr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class AdministrateurServiceImpl implements AdministrateurService {
    private final AdministrateurRepository administrateurRepository;

    @Autowired
    public AdministrateurServiceImpl(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    @Override
    public AdministrateurDto save(AdministrateurDto administrateurDto) {
        List<String> errors = AdministrateurValidatorr.validate(administrateurDto);
        if (!errors.isEmpty()){
            log.error("verrifier les carracteristiques de votre administrateur");
            throw new InvalidEntityException("l'administrateur n'est pas valid {}", ErrorCodes.ADMINISTRATEUR_NOT_VALID);
        }
        Administrateur administrateur = administrateurRepository.findByPhone(administrateurDto.getPhone());
        if(administrateur != null){
            log.error("l'administrateur : "+ administrateur.getPhone() + " existe deja");
            throw  new InvalidEntityException("Ce Administrateur existe deja", ErrorCodes.ADMINISTRATEUR_ALREADY_EXIST);
        }
        return AdministrateurDto.fromEntity(administrateurRepository.save(AdministrateurDto.toEntity(administrateurDto)));
    }

    @Override
    public AdministrateurDto findbyId(Integer id) {
        if (id==null){
            log.error("le id est obligatoire");
            throw new InvalidEntityException("le id est obligatoire", ErrorCodes.ADMINISTRATEUR_NOT_VALID);
        }
        Administrateur byId = administrateurRepository.findById(id).get();
        if (byId.getId()==null){
            log.error("l'administrateur avec cet id : " +id +" n'existe pas");
            throw new EntityNotFoundException("l'administrateur avec cet id :" +id +" n'existe pas", ErrorCodes.ADMINISTRATEUR_NOT_FOUND);
        }
        return AdministrateurDto.fromEntity(byId);
    }

    @Override
    public AdministrateurDto findByPhone(String phone) {
        if (phone.isEmpty()){
            log.error("le numero de telephone  est obligatoire");
            throw new InvalidEntityException("le numero de telephone  est obligatoire", ErrorCodes.ADMINISTRATEUR_NOT_VALID);
        }
        Administrateur byId = administrateurRepository.findByPhone(phone);
        if (byId.getPhone().isEmpty()){
            log.error("l'administrateur avec ce numero de telephone : " +phone +" n'existe pas");
            throw new EntityNotFoundException("l'administrateur avec ce numero de telephone :" +phone +" n'existe pas", ErrorCodes.ADMINISTRATEUR_NOT_FOUND);
        }
        return AdministrateurDto.fromEntity(byId);
    }

    @Override
    public void delete(Integer id) {
        if(id ==null){
            log.error("le id est obligatoire");
            throw new EntityNotFoundException("l'adminstrateur avec cet Id :" +id +" n'existe pas", ErrorCodes.ADMINISTRATEUR_NOT_FOUND);
        }
        administrateurRepository.deleteById(id);
    }
    @Override
    public List<AdministrateurDto> findAll() {
        return administrateurRepository.findAll().stream()
                .map(AdministrateurDto::fromEntity)
                .collect(Collectors.toList());
    }
}
