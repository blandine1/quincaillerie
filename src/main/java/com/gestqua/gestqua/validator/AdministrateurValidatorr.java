package com.gestqua.gestqua.validator;

import com.gestqua.gestqua.dto.AdministrateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdministrateurValidatorr {

    public static List<String> validate(AdministrateurDto administrateurDto){
        List<String> errors = new ArrayList<>();
        if (administrateurDto == null){
            errors.add("le nom de l'administrateur est necessaire");
            errors.add("le numero de telephone de l'administrateur est necessaire");
            errors.add("le mail de l'administrateur est necessaire");
            errors.add("le mot de passe de l'administrateur est necessaire");
            return  errors;
        }
        if(!StringUtils.hasLength(administrateurDto.getFirstname())){
            errors.add("le nom du l'administrateur est necessaire");
        }
        if(!StringUtils.hasLength(administrateurDto.getPhone())){
            errors.add("le numero de telephone de l'administrateur est necessaire");
        }
        if(!StringUtils.hasLength(administrateurDto.getEmail())){
            errors.add("le mail de l'administrateur est necessaire");
        }
        if(!StringUtils.hasLength(administrateurDto.getPassword())){
            errors.add("le mot de passe de l'administrateur est necessaire");
        }
        return  errors;
    }
}
