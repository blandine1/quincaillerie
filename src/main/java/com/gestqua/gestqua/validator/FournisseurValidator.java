package com.gestqua.gestqua.validator;

import com.gestqua.gestqua.dto.CategorieDto;
import com.gestqua.gestqua.dto.ClientDto;
import com.gestqua.gestqua.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
    public static List<String> validate(FournisseurDto fournisseurDto){
        List<String> errors = new ArrayList<>();
        if (fournisseurDto == null){
            errors.add("le nom du client est necessaire");
            errors.add("le numero de telephone du fournisseur est necessaire");

            return errors;
        }
        if(!StringUtils.hasLength(fournisseurDto.getName())){
            errors.add("le nom du fournisseur est necessaire");
        }
        if(!StringUtils.hasLength(fournisseurDto.getPhone())){
            errors.add("le numero de telephone du fournisseur est necessaire");
        }
        return  errors;
    }
}
