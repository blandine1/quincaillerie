package com.gestqua.gestqua.service.impl;

import com.gestqua.gestqua.Exceptions.EntityNotFoundException;
import com.gestqua.gestqua.Exceptions.ErrorCodes;
import com.gestqua.gestqua.Exceptions.InvalidEntityException;
import com.gestqua.gestqua.dto.CategorieDto;
import com.gestqua.gestqua.entity.Categorie;
import com.gestqua.gestqua.repository.CategoryRepository;
import com.gestqua.gestqua.service.CategorieService;
import com.gestqua.gestqua.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieServiceImpl implements CategorieService {
    CategoryRepository categoryRepository;

    @Autowired
    public CategorieServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    @Override
    public CategorieDto save(CategorieDto categorieDto) {
        List<String> errors = CategorieValidator.validate(categorieDto);

        if (!errors.isEmpty()){
            log.error("verrifier les carracteristiques de votre categorie");
            throw new InvalidEntityException("la categorie n'est pas valid {}", ErrorCodes.CATEGORIE_NOT_VALID);
        }

        Categorie categorie = categoryRepository.findByName(categorieDto.getName());

        if(categorie != null){
            log.error("la categorie : "+ categorie.getName() + " existe deja");
            throw  new InvalidEntityException("Cette Categorie existe deja", ErrorCodes.CATEGORIE_ALREADY_EXIST);
        }

        return CategorieDto.fromEntity(categoryRepository.save(CategorieDto.toEntity(categorieDto)));
    }

    @Override
    public CategorieDto findbyId(Integer id) {

        if (id==null){
            log.error("le id est obligatoire");
            throw new InvalidEntityException("le id est obligatoire", ErrorCodes.CATEGORIE_NOT_VALID);
        }

        Categorie byId = categoryRepository.findById(id).get();

        if (byId.getId()==null){
            log.error("la categorie avce cet Id : " +id +" n'exiate pas");
            throw new EntityNotFoundException("la categporie avec cet Id :" +id +" n'exiate pas", ErrorCodes.CATEGORIE_NOT_FOUND);
        }

        return CategorieDto.fromEntity(byId);
    }

    @Override
    public CategorieDto findByName(String name) {
        if (name.isEmpty()){
            log.error("le nom est obligatoire");
            throw new InvalidEntityException("le nom est obligatoire", ErrorCodes.ARTICLE_NOT_VALID);
        }

        Categorie byId = categoryRepository.findByName(name);

        if (byId.getName().isEmpty()){
            log.error("l'article avce ce nom : " +name +" n'existe pas");
            throw new EntityNotFoundException("l'article avec ce nom :" +name +" n'exiate pas", ErrorCodes.ARTICLE_NOT_FOUND);
        }
        return CategorieDto.fromEntity(byId);
    }

    @Override
    public void delete(Integer id) {
        if(id ==null){
            log.error("le id est obligatoire");
            throw new EntityNotFoundException("la categorie avec cet Id :" +id +" n'existe pas", ErrorCodes.ARTICLE_NOT_FOUND);
        }
        categoryRepository.deleteById(id);
    }
    @Override
    public List<CategorieDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
    }
}
