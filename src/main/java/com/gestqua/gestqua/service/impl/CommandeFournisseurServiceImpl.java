package com.gestqua.gestqua.service.impl;

import com.gestqua.gestqua.Exceptions.EntityNotFoundException;
import com.gestqua.gestqua.Exceptions.ErrorCodes;
import com.gestqua.gestqua.Exceptions.InvalidEntityException;
import com.gestqua.gestqua.dto.CommandeFournisseurDto;
import com.gestqua.gestqua.entity.CommandeFournisseur;
import com.gestqua.gestqua.entity.Fournisseur;
import com.gestqua.gestqua.repository.*;
import com.gestqua.gestqua.service.CommandeFournisseurService;
import com.gestqua.gestqua.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private final CommandeFournisseurRepository commandeFournisseurRepository;
    private final FournisseurRepository fournisseurRepository;
    private final StockcourantRepository stockcourantRepository;
    private final LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    private final AdministrateurRepository administrateurRepository;

    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository,
                                          FournisseurRepository fournisseurRepository,
                                          StockcourantRepository stockcourantRepository,
                                          LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,
                                          AdministrateurRepository administrateurRepository){
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.stockcourantRepository = stockcourantRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.administrateurRepository = administrateurRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        CommandeFournisseurValidator validator = new CommandeFournisseurValidator();
        List<String> errors = validator.validate(commandeFournisseurDto);
        if(!errors.isEmpty()){
           log.error("commandeFournisseur n'est pas valide");
           throw  new InvalidEntityException("la commande fournisseur n'est pas valide", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(commandeFournisseurDto.getFournisseurDto().getId());
        if(!fournisseur.isPresent()){
            throw new EntityNotFoundException("Aucun fournisseur avec cet Id "+commandeFournisseurDto.getFournisseurDto().getId()+" n'existe", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        CommandeFournisseur savedCommande = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntiy(commandeFournisseurDto));

        

        return null;
    }

    @Override
    public CommandeFournisseurDto update(CommandeFournisseurDto commandeFournisseurDto) {
        return null;
    }

    @Override
    public CommandeFournisseurDto findByid(Integer id) {
        return null;
    }

    @Override
    public CommandeFournisseurDto findByPhone(String phone) {
        return null;
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return null;
    }

    @Override
    public CommandeFournisseurDto delete(Integer id) {
        return null;
    }
}
