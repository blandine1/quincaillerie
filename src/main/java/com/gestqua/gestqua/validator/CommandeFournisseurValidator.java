package com.gestqua.gestqua.validator;

import com.gestqua.gestqua.dto.CommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {

    public List<String> validate(CommandeFournisseurDto commandeFournisseurDto){
        List<String> errors= new ArrayList();

        if(commandeFournisseurDto  == null){
            errors.add("le fournisseur est necessaire");
        }

        if(commandeFournisseurDto.getFournisseurDto() == null){
            errors.add("le fournisseur est necessaire");
        }
        return errors;
    }
}
