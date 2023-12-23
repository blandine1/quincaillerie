package com.gestqua.gestqua.service.impl;

import com.gestqua.gestqua.Exceptions.EntityNotFoundException;
import com.gestqua.gestqua.Exceptions.ErrorCodes;
import com.gestqua.gestqua.Exceptions.InvalidEntityException;
import com.gestqua.gestqua.dto.FournisseurDto;
import com.gestqua.gestqua.entity.Fournisseur;
import com.gestqua.gestqua.repository.FournisseurRepository;
import com.gestqua.gestqua.service.FournisseurService;
import com.gestqua.gestqua.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository){
        this.fournisseurRepository=fournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        List<String> errors = FournisseurValidator.validate(fournisseurDto);

        if (!errors.isEmpty()){
            log.error("verrifier les carracteristiques de votre fournisseur");
            throw new InvalidEntityException("le fournisseur n'est pas valid {}", ErrorCodes.FOURNISSEUR_NOT_VALID);
        }

        Fournisseur fournisseur = fournisseurRepository.findByPhone(fournisseurDto.getPhone());

        if(fournisseur != null){
            log.error("le client : "+ fournisseur.getName() + " existe deja");
            throw  new InvalidEntityException("Ce Fournisseur existe deja", ErrorCodes.FOURNISSEUR_ALREADY_EXIST);
        }

        return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(fournisseurDto)));
    }

    @Override
    public FournisseurDto findbyId(Integer id) {

        if (id==null){
            log.error("le id est obligatoire");
            throw new InvalidEntityException("le id est obligatoire", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        Fournisseur byId = fournisseurRepository.findById(id).get();

        if (byId.getId()==null){
            log.error("le fournissuer avec cet Id : " +id +" n'existe pas");
            throw new EntityNotFoundException("le fournisseur avec cet Id :" +id +" n'existe pas", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        return FournisseurDto.fromEntity(byId);
    }

    @Override
    public FournisseurDto findByPhone(String phone) {
        if (phone.isEmpty()){
            log.error("le numero de telephone est obligatoire");
            throw new InvalidEntityException("le numero de telephone est obligatoire", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        Fournisseur byId = fournisseurRepository.findByPhone(phone);

        if (byId.getName().isEmpty()){
            log.error("le fournisseur avec ce nom : " +phone +" n'existe pas");
            throw new EntityNotFoundException("l'article avec ce nom :" +phone +" n'existe pas", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        return FournisseurDto.fromEntity(byId);
    }

    @Override
    public void delete(Integer id) {
        if(id ==null){
            log.error("le id est obligatoire");
            throw new EntityNotFoundException("le fournisseur avec cet Id :" +id +" n'existe pas", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        fournisseurRepository.deleteById(id);

    }
    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }
}
